/*******************************************************************************
 * Copyright (c) 2018 Bosch Software Innovations GmbH
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

 package org.eclipse.iot.unide.integrators;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.eclipse.iot.unide.ppmp.commons.Device;
import org.eclipse.iot.unide.ppmp.process.Process;
import org.eclipse.iot.unide.ppmp.process.Process.Result;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class KistlerLog implements Processor {

	private XPath xpath;
	private String measurementPath;
	private String deviceNamePath;
	private String resultPath;
	private ZoneOffset localTimezoneOffset;

	public KistlerLog() {
		this("/html/body/span[2]/text()", "/html/body/p[2]/table[@bgcolor='lime']/tbody/tr/td/table/tbody/tr",
				"/html/body/p[2]/table[@bgcolor='aqua' and position() = 1]/tbody/tr[position() = last()]/td[2]/span/text()");
	}

	public KistlerLog(String deviceNamePath, String measurementPath, String resultPath) {
		XPathFactory factory = XPathFactory.newInstance();
		this.xpath = factory.newXPath();
		this.measurementPath = measurementPath;
		this.deviceNamePath = deviceNamePath;
		this.resultPath = resultPath;

		OffsetDateTime odt = OffsetDateTime.now();
		this.localTimezoneOffset = odt.getOffset();
	}

	@Override
	public void process(Exchange exchange) throws JsonProcessingException, Exception {
		Message msg = exchange.getIn();
		Document doc = msg.getBody(Document.class);
		OffsetDateTime currentTs = OffsetDateTime.now();

		Date d = msg.getHeader("CamelFileLastModified", Date.class);
		if (d != null) {
			currentTs = OffsetDateTime.ofInstant(d.toInstant(), this.localTimezoneOffset);
		}

		ProcessWrapper wrapper = new ProcessWrapper();

		// device
		Device device = new Device();
		String deviceId = (String) xpath.evaluate(this.deviceNamePath, doc, XPathConstants.STRING);
		device.setDeviceID(deviceId);
		wrapper.setDevice(device);

		// process
		Process process = new Process();
		String result = (String) xpath.evaluate(this.resultPath, doc, XPathConstants.STRING);
		process.setTimestamp(currentTs);
		switch (result) {
		case "0":
			process.setResult(Result.NOK);
			break;
		case "1":
			process.setResult(Result.OK);
			break;
		default:
			process.setResult(Result.UNKNOWN);
		}
		wrapper.setProcess(process);

		// measurements
		List<org.eclipse.iot.unide.ppmp.process.Measurements> measurements = new LinkedList<org.eclipse.iot.unide.ppmp.process.Measurements>();
		org.eclipse.iot.unide.ppmp.process.Measurements measurement = new org.eclipse.iot.unide.ppmp.process.Measurements();

		measurement.setTimestamp(currentTs);

		NodeList rows = (NodeList) xpath.evaluate(this.measurementPath, doc, XPathConstants.NODESET);
		List<Number> x = new LinkedList<Number>();
		List<Number> y = new LinkedList<Number>();
		for (int i = 0; i < rows.getLength(); i++) {
			Node row = rows.item(i);
			NodeList columns = (NodeList) xpath.evaluate("td", row, XPathConstants.NODESET);
			Node cx = columns.item(0);
			Node cy = columns.item(1);
			if (cx.getNodeType() == Node.ELEMENT_NODE && cy.getNodeType() == Node.ELEMENT_NODE) {
				x.add(Float.parseFloat(cx.getTextContent()));
				y.add(Float.parseFloat(cy.getTextContent()));
			}
		}
		org.eclipse.iot.unide.ppmp.process.SeriesMap seriesMap = new org.eclipse.iot.unide.ppmp.process.SeriesMap();
		seriesMap.setSeriesValue("x", x);
		seriesMap.setSeriesValue("y", y);

		measurement.setSeriesMap(seriesMap);
		measurements.add(measurement);
		wrapper.setMeasurements(measurements);

		msg.setBody(wrapper);
		exchange.setOut(msg);
	}
}
