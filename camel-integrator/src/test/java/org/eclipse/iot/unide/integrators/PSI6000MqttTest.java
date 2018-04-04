package org.eclipse.iot.unide.integrators;

import java.io.FileInputStream;
import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;

import org.apache.camel.EndpointInject;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.camel.util.IOHelper;
import org.apache.camel.util.ResourceHelper;
import org.eclipse.iot.unide.ppmp.measurements.MeasurementsWrapper;
import org.eclipse.iot.unide.ppmp.messages.MessagesWrapper;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PSI6000MqttTest extends CamelSpringTestSupport {

	private ObjectMapper mapper;

	private JsonSchema measurementSchema;
	private JsonSchema processSchema;
	private JsonSchema messageSchema;

	@EndpointInject(uri = "mock:measurement")
	protected MockEndpoint mockMeasurement;

	@EndpointInject(uri = "mock:process")
	protected MockEndpoint mockProcess;

	@EndpointInject(uri = "mock:message")
	protected MockEndpoint mockMessage;

	/*
	@Override
	public boolean isUseDebugger() {
		return true;
	}
	 */

	@Before
	public void setupObjectMapper() throws Exception {
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.setSerializationInclusion(Include.NON_NULL);

		InputStream schemaStream;
		schemaStream = ResourceHelper.resolveMandatoryResourceAsInputStream(context,
				"/org/eclipse/iot/unide/ppmp/v2/process_schema.json");
		processSchema = JsonSchemaFactory.getInstance().getSchema(schemaStream);

		schemaStream = ResourceHelper.resolveMandatoryResourceAsInputStream(context,
				"/org/eclipse/iot/unide/ppmp/v2/measurement_schema.json");
		measurementSchema = JsonSchemaFactory.getInstance().getSchema(schemaStream);

		schemaStream = ResourceHelper.resolveMandatoryResourceAsInputStream(context,
				"/org/eclipse/iot/unide/ppmp/v2/message_schema.json");
		messageSchema = JsonSchemaFactory.getInstance().getSchema(schemaStream);
	}

	@Test
	public void testTransformWeldLog() throws Exception {

		String inputPayload = IOHelper.loadText(new FileInputStream("src/test/data/WL.json")).trim();
		sendBody("direct:mqtt", inputPayload);

		String deviceId;
		JsonNode node;

		mockMeasurement.expectedMessageCount(1);
		mockMeasurement.assertIsSatisfied();
		MeasurementsWrapper measurementsWrapper = mockMeasurement.getExchanges().get(0).getMessage()
				.getBody(MeasurementsWrapper.class);
		deviceId = measurementsWrapper.getDevice().getDeviceID();
		assertEquals("UIR Testrack 24", deviceId);
		node = mapper.readTree(mapper.writeValueAsString(measurementsWrapper));
		assertEquals(0, measurementSchema.validate(node).size());

		mockProcess.expectedMessageCount(1);
		mockProcess.assertIsSatisfied();
		ProcessWrapper processWrapper = mockProcess.getExchanges().get(0).getMessage().getBody(ProcessWrapper.class);
		deviceId = processWrapper.getDevice().getDeviceID();
		assertEquals("UIR Testrack 24", deviceId);
		node = mapper.readTree(mapper.writeValueAsString(processWrapper));
		assertEquals(0, processSchema.validate(node).size());

		mockMessage.expectedMessageCount(0);
		mockMessage.assertIsSatisfied();
	}

	@Test
	public void testTransformDataChangeLog() throws Exception {

		String inputPayload = IOHelper.loadText(new FileInputStream("src/test/data/DCP.json")).trim();
		sendBody("direct:mqtt", inputPayload);

		String deviceId;
		JsonNode node;

		mockMeasurement.expectedMessageCount(0);
		mockMeasurement.assertIsSatisfied();

		mockProcess.expectedMessageCount(0);
		mockProcess.assertIsSatisfied();

		mockMessage.expectedMessageCount(1);
		mockMessage.assertIsSatisfied();
		MessagesWrapper messagesWrapper = mockMessage.getExchanges().get(0).getMessage().getBody(MessagesWrapper.class);
		deviceId = messagesWrapper.getDevice().getDeviceID();
		assertEquals("UIR Testrack 21", deviceId);
		node = mapper.readTree(mapper.writeValueAsString(messagesWrapper));
		assertEquals(0, messageSchema.validate(node).size());
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("psi6000-mqtt.xml");
	}
}
