package org.eclipse.iot.unide.integrators;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.eclipse.iot.unide.ppmp.commons.Device;
import org.eclipse.iot.unide.ppmp.commons.MetaData;
import org.eclipse.iot.unide.ppmp.measurements.MeasurementsWrapper;
import org.eclipse.iot.unide.ppmp.process.Process;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;
import org.eclipse.iot.unide.ppmp.messages.Message.MessageType;
import org.eclipse.iot.unide.ppmp.messages.MessagesWrapper;

import com.fasterxml.jackson.core.JsonProcessingException;

public class PSI6000 implements Processor {

	private ZoneOffset localTimezoneOffset;
	
	public PSI6000() {
		OffsetDateTime odt = OffsetDateTime.now();
		this.localTimezoneOffset = odt.getOffset();
	}

	private List<org.eclipse.iot.unide.ppmp.measurements.Measurements> addMeasurementPoint(List<org.eclipse.iot.unide.ppmp.measurements.Measurements> measurements, OffsetDateTime ts, String name, Number value) {
		if (value == null) {
			return measurements;
		}
		org.eclipse.iot.unide.ppmp.measurements.Measurements measurement = new org.eclipse.iot.unide.ppmp.measurements.Measurements();
		measurement.setTimestamp(ts);

		org.eclipse.iot.unide.ppmp.measurements.SeriesMap seriesMap = new org.eclipse.iot.unide.ppmp.measurements.SeriesMap();
		seriesMap.setSeriesValue("$_time", Arrays.asList(0));
		seriesMap.setSeriesValue(name, Arrays.asList(value));

		measurement.setSeriesMap(seriesMap);
		measurements.add(measurement);
		
		return measurements;
	}

	private org.eclipse.iot.unide.ppmp.process.SeriesMap addProcessCurve(
			org.eclipse.iot.unide.ppmp.process.SeriesMap map, String name, List<Number> value) {
		if (value != null) {
			map.setSeriesValue(name, value);
		}
		return map;
	}

	@Override
	public void process(Exchange exchange) throws JsonProcessingException, Exception {
		Message msg = exchange.getIn();
		PSI6000DataType doc = msg.getBody(PSI6000DataType.class);

		Object []bundle = new Object[3];
		bundle[0] = transformMeasurement(doc);
		bundle[1] = transformProcess(doc);
		bundle[2] = transformMessage(doc);
		msg.setBody(bundle);
		exchange.setOut(msg);
	}

	private void setSpotName(Device device, String spotName) {
		if (spotName != null && spotName.length() > 0) {
			MetaData md = new MetaData();
			md.setMetaDataValue("spotName", spotName);
			device.setMetaData(md);
		}
	}

	private ProcessWrapper transformProcess(PSI6000DataType doc) {
		WeldLog wl = doc.getMessage().getWeldLog();
		if(wl == null) {
			return null;
		}

		//values
		org.eclipse.iot.unide.ppmp.process.SeriesMap seriesMap = new org.eclipse.iot.unide.ppmp.process.SeriesMap();
		addProcessCurve(seriesMap, "curentCurve", wl.getCurrentCurve());
		addProcessCurve(seriesMap, "voltageCurve", wl.getVoltageCurve());
		addProcessCurve(seriesMap, "forceCurve", wl.getForceCurve());
		
		if(((HashMap<String, List<Number>>) seriesMap.getSeries()).size() == 0) {
			return null;
		}
		
		ProcessWrapper wrapper = new ProcessWrapper();		
		OffsetDateTime odt = OffsetDateTime.of(wl.getDateTime(), this.localTimezoneOffset);

		// device
		Device device = new Device();
		device.setDeviceID(wl.getTimerName());
		setSpotName(device, wl.getSpotName());
		wrapper.setDevice(device);

		// part
		String partId = wl.getPartIdentString();
		if (partId != null && partId.length() > 0) {
			org.eclipse.iot.unide.ppmp.process.Part part = new org.eclipse.iot.unide.ppmp.process.Part();
			part.setPartID(partId);
			wrapper.setPart(part);
		}

		// process
		Process process = new Process();
		process.setTimestamp(odt);
		process.setExternalProcessId(String.valueOf(wl.getProtRecordID()));
		wrapper.setProcess(process);

		// measurements
		List<org.eclipse.iot.unide.ppmp.process.Measurements> measurements = new LinkedList<org.eclipse.iot.unide.ppmp.process.Measurements>();
		org.eclipse.iot.unide.ppmp.process.Measurements measurement = new org.eclipse.iot.unide.ppmp.process.Measurements();
		
		measurement.setTimestamp(odt);
		
		measurement.setSeriesMap(seriesMap);
		measurements.add(measurement);
		wrapper.setMeasurements(measurements);
		
		return wrapper;
	}

	private MeasurementsWrapper transformMeasurement(PSI6000DataType doc) {
		WeldLog wl = doc.getMessage().getWeldLog();
		
		if(wl == null) {
			return null;
		}

		// measurements
		List<org.eclipse.iot.unide.ppmp.measurements.Measurements> measurements = new LinkedList<org.eclipse.iot.unide.ppmp.measurements.Measurements>();
		OffsetDateTime ts = OffsetDateTime.of(wl.getDateTime(), this.localTimezoneOffset);

		addMeasurementPoint(measurements, ts, "wear", wl.getWear());
		addMeasurementPoint(measurements, ts, "wearPerCent", wl.getWearPerCent());
		addMeasurementPoint(measurements, ts, "monitorState", wl.getMonitorState());
		addMeasurementPoint(measurements, ts, "regulationState", wl.getRegulationState());
		addMeasurementPoint(measurements, ts, "measureState", wl.getMeasureState());
		addMeasurementPoint(measurements, ts, "powerState", wl.getPowerState());
		addMeasurementPoint(measurements, ts, "sequenceState", wl.getSequenceState());
		addMeasurementPoint(measurements, ts, "sequenceStateAdd", wl.getSequenceStateAdd());
		addMeasurementPoint(measurements, ts, "sequenceRepeat", wl.getSequenceRepeat());
		addMeasurementPoint(measurements, ts, "monitorMode", wl.getMonitorMode());
		addMeasurementPoint(measurements, ts, "iDemandStd", wl.getIDemandStd());
		addMeasurementPoint(measurements, ts, "ilsts", wl.getIlsts());
		addMeasurementPoint(measurements, ts, "regulationStd", wl.getRegulationStd());
		addMeasurementPoint(measurements, ts, "iDemand1", wl.getIDemand1());
		addMeasurementPoint(measurements, ts, "iActual1", wl.getIActual1());
		addMeasurementPoint(measurements, ts, "regulation1", wl.getRegulation1());
		addMeasurementPoint(measurements, ts, "iDemand2", wl.getIDemand2());
		addMeasurementPoint(measurements, ts, "iActual2", wl.getIActual2());
		addMeasurementPoint(measurements, ts, "regulation2", wl.getRegulation2());
		addMeasurementPoint(measurements, ts, "iDemand3", wl.getIDemand3());
		addMeasurementPoint(measurements, ts, "iActual3", wl.getIActual3());
		addMeasurementPoint(measurements, ts, "regulation3", wl.getRegulation3());
		addMeasurementPoint(measurements, ts, "phaStd", wl.getPhaStd());
		addMeasurementPoint(measurements, ts, "pha1", wl.getPha1());
		addMeasurementPoint(measurements, ts, "pha2", wl.getPha2());
		addMeasurementPoint(measurements, ts, "pha3", wl.getPha3());
		addMeasurementPoint(measurements, ts, "t_iDemandStd", wl.getIDemandStd());
		addMeasurementPoint(measurements, ts, "tActualStd", wl.getTActualStd());
		// addMeasurementPoint(measurements, ts, "partIdentString",
		// wl.getPartIdentString());
		addMeasurementPoint(measurements, ts, "tipDressCounter", wl.getTipDressCounter());
		addMeasurementPoint(measurements, ts, "electrodeNo", wl.getElectrodeNo());
		addMeasurementPoint(measurements, ts, "sgForceSetPoint", wl.getSgForceSetPoint());
		addMeasurementPoint(measurements, ts, "sgSheetThicknessSetPoint", wl.getSgSheetThicknessSetPoint());
		addMeasurementPoint(measurements, ts, "sgSagGpSetPoint", wl.getSgSagGpSetPoint());
		addMeasurementPoint(measurements, ts, "sgSpotWithSg", wl.getSgSpotWithSg());
		addMeasurementPoint(measurements, ts, "sgMotorCurrent", wl.getSgMotorCurrent());
		addMeasurementPoint(measurements, ts, "sgMotorTemp", wl.getSgMotorTemp());
		addMeasurementPoint(measurements, ts, "sgForce", wl.getSgForce());
		addMeasurementPoint(measurements, ts, "sgSheetThickness", wl.getSgSheetThickness());
		addMeasurementPoint(measurements, ts, "sgSagGp", wl.getSgSagGp());
		addMeasurementPoint(measurements, ts, "sgSagGc", wl.getSgSagGc());
		addMeasurementPoint(measurements, ts, "regUsrUspJunction", wl.getRegUsrUspJunction());
		addMeasurementPoint(measurements, ts, "regUsrUspMax", wl.getRegUsrUspMax());
		addMeasurementPoint(measurements, ts, "regSpotDiaActual", wl.getRegSpotDiaActual());
		addMeasurementPoint(measurements, ts, "regSpotDiaMinDemand", wl.getRegSpotDiaMinDemand());
		addMeasurementPoint(measurements, ts, "regSplashTime", wl.getRegSplashTime());
		addMeasurementPoint(measurements, ts, "nuggetDiameter", wl.getNuggetDiameter());
		addMeasurementPoint(measurements, ts, "usp", wl.getUsp());
		addMeasurementPoint(measurements, ts, "normingTime", wl.getNormingTime());
		addMeasurementPoint(measurements, ts, "regulationStartTime", wl.getRegulationStartTime());
		addMeasurementPoint(measurements, ts, "returnToConstantCurrent", wl.getReturnToConstantCurrent());
		addMeasurementPoint(measurements, ts, "declineUsp", wl.getDeclineUsp());
		addMeasurementPoint(measurements, ts, "offsetUsp", wl.getOffsetUsp());
		addMeasurementPoint(measurements, ts, "currentFactor", wl.getCurrentFactor());
		addMeasurementPoint(measurements, ts, "triggerTime", wl.getTriggerTime());
		addMeasurementPoint(measurements, ts, "xqrMeasuringActive", wl.getXqrMeasuringActive());
		addMeasurementPoint(measurements, ts, "xqrRegulationActive", wl.getXqrRegulationActive());
		addMeasurementPoint(measurements, ts, "xqrMonitoringActive", wl.getXqrMonitoringActive());
		addMeasurementPoint(measurements, ts, "xqrWeldTimeProlongationActive", wl.getXqrWeldTimeProlongationActive());
		addMeasurementPoint(measurements, ts, "voltageActualValue", wl.getVoltageActualValue());
		addMeasurementPoint(measurements, ts, "voltageRefValue", wl.getVoltageRefValue());
		addMeasurementPoint(measurements, ts, "currentActualValue", wl.getCurrentActualValue());
		addMeasurementPoint(measurements, ts, "currentReferenceValue", wl.getCurrentReferenceValue());
		addMeasurementPoint(measurements, ts, "weldTimeActualValue", wl.getWeldTimeActualValue());
		addMeasurementPoint(measurements, ts, "weldTimeRefValue", wl.getWeldTimeRefValue());
		addMeasurementPoint(measurements, ts, "energyActualValue", wl.getEnergyActualValue());
		addMeasurementPoint(measurements, ts, "energyRefValue", wl.getEnergyRefValue());
		addMeasurementPoint(measurements, ts, "powerActualValue", wl.getPowerActualValue());
		addMeasurementPoint(measurements, ts, "powerRefValue", wl.getPowerRefValue());
		addMeasurementPoint(measurements, ts, "resistanceActualValue", wl.getResistanceActualValue());
		addMeasurementPoint(measurements, ts, "resistanceRefValue", wl.getResistanceRefValue());
		addMeasurementPoint(measurements, ts, "pulseWidthActualValue", wl.getPulseWidthActualValue());
		addMeasurementPoint(measurements, ts, "pulseWidthRefValue", wl.getPulseWidthRefValue());
		addMeasurementPoint(measurements, ts, "stabilisationFactorActValue", wl.getStabilisationFactorActValue());
		addMeasurementPoint(measurements, ts, "stabilisationFactorRefValue", wl.getStabilisationFactorRefValue());
		addMeasurementPoint(measurements, ts, "thresholdStabilisationFactor", wl.getThresholdStabilisationFactor());
		addMeasurementPoint(measurements, ts, "wldEffectStabilisationFactor", wl.getWldEffectStabilisationFactor());
		addMeasurementPoint(measurements, ts, "uipActualValue", wl.getUipActualValue());
		addMeasurementPoint(measurements, ts, "uipRefValue", wl.getUipRefValue());
		addMeasurementPoint(measurements, ts, "uirExpulsionTime", wl.getUirExpulsionTime());
		addMeasurementPoint(measurements, ts, "uirMeasuringActive", wl.getUirMeasuringActive());
		addMeasurementPoint(measurements, ts, "uirRegulationActive", wl.getUirRegulationActive());
		addMeasurementPoint(measurements, ts, "uirMonitoringActive", wl.getUirMonitoringActive());
		addMeasurementPoint(measurements, ts, "uirWeldTimeProlongationActive", wl.getUirWeldTimeProlongationActive());
		addMeasurementPoint(measurements, ts, "uirQStoppRefCntValue", wl.getUirQStoppRefCntValue());
		addMeasurementPoint(measurements, ts, "uirQStoppActCntValue", wl.getUirQStoppActCntValue());
		addMeasurementPoint(measurements, ts, "uirUipUpperTol", wl.getUirUipUpperTol());
		addMeasurementPoint(measurements, ts, "uirUipLowerTol", wl.getUirUipLowerTol());
		addMeasurementPoint(measurements, ts, "uirUipCondTol", wl.getUirUipCondTol());
		addMeasurementPoint(measurements, ts, "uirPsfLowerTol", wl.getUirPsfLowerTol());
		addMeasurementPoint(measurements, ts, "uirPsfCondTol", wl.getUirPsfCondTol());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_1", wl.getWeldSpotCustDataP161());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_2", wl.getWeldSpotCustDataP162());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_3", wl.getWeldSpotCustDataP163());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_4", wl.getWeldSpotCustDataP164());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_5", wl.getWeldSpotCustDataP165());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP32_6", wl.getWeldSpotCustDataP326());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_7", wl.getWeldSpotCustDataP167());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_8", wl.getWeldSpotCustDataP168());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_9", wl.getWeldSpotCustDataP169());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_10", wl.getWeldSpotCustDataP1610());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_11", wl.getWeldSpotCustDataP1611());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP32_12", wl.getWeldSpotCustDataP3212());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_13", wl.getWeldSpotCustDataP1613());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_14", wl.getWeldSpotCustDataP1614());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_15", wl.getWeldSpotCustDataP1615());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_16", wl.getWeldSpotCustDataP1616());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP16_17", wl.getWeldSpotCustDataP1617());
		addMeasurementPoint(measurements, ts, "weldSpotCustDataP32_18", wl.getWeldSpotCustDataP3218());
		addMeasurementPoint(measurements, ts, "uipMonCondUpperTol", wl.getUipMonCondUpperTol());
		addMeasurementPoint(measurements, ts, "fqfActualValue", wl.getFqfActualValue());
		addMeasurementPoint(measurements, ts, "fqfRefValue", wl.getFqfRefValue());
		addMeasurementPoint(measurements, ts, "fqfMonUpperTol", wl.getFqfMonUpperTol());
		addMeasurementPoint(measurements, ts, "fqfMonLowerTol", wl.getFqfMonLowerTol());
		addMeasurementPoint(measurements, ts, "fqfMonCondUpperTol", wl.getFqfMonCondUpperTol());
		addMeasurementPoint(measurements, ts, "fqfMonCondLowerTol", wl.getFqfMonCondLowerTol());
		addMeasurementPoint(measurements, ts, "fqfMeasuringActive", wl.getFqfMeasuringActive());
		addMeasurementPoint(measurements, ts, "xqrModeOff", wl.getXqrModeOff());
		addMeasurementPoint(measurements, ts, "reweldActive", wl.getReweldActive());
		// addMeasurementPoint(measurements, ts, "weldspotRefIdent",
		// wl.getWeldspotRefIdent());
		addMeasurementPoint(measurements, ts, "sg_Torque_Gp", wl.getSgTorqueGp());
		addMeasurementPoint(measurements, ts, "sg_Force_Corr", wl.getSgForceCorr());
		addMeasurementPoint(measurements, ts, "sg_Weldspot_Geo_Wear", wl.getSgWeldspotGeoWear());
		addMeasurementPoint(measurements, ts, "sg_Wear_Length", wl.getSgWearLength());
		addMeasurementPoint(measurements, ts, "sg_Beam_UpArching", wl.getSgBeamUpArching());

		if(measurements.size() == 0) {
			return null;
		}
				
		MeasurementsWrapper wrapper = new MeasurementsWrapper();
		wrapper.setMeasurements(measurements);

		// device
		Device device = new Device();
		device.setDeviceID(wl.getTimerName());
		setSpotName(device, wl.getSpotName());
		wrapper.setDevice(device);

		// part
		String partId = wl.getPartIdentString();
		if (partId != null && partId.length() > 0) {
			org.eclipse.iot.unide.ppmp.measurements.Part part = new org.eclipse.iot.unide.ppmp.measurements.Part();
			part.setPartID(partId);
			wrapper.setPart(part);
		}
		return wrapper;
	}
	
	private MessagesWrapper transformMessage(PSI6000DataType doc) {
		DataChangeLog dcl = doc.getMessage().getDataChangeLog();
		
		if(dcl == null) {
			return null;
		}
		
		MessagesWrapper wrapper = new MessagesWrapper();
		
		// device
		Device device = new Device();
		device.setDeviceID(dcl.getTimerName());
		wrapper.setDevice(device);

		org.eclipse.iot.unide.ppmp.messages.Message msg = new org.eclipse.iot.unide.ppmp.messages.Message();
		msg.setCode(dcl.getProtRecordID().toString());
		msg.setTimestamp(OffsetDateTime.of(dcl.getDateTime(), this.localTimezoneOffset));
		msg.setType(MessageType.DEVICE);
		msg.setTitle("Param #" + dcl.getParamID() + " changed");
		msg.setDescription("changed from " + dcl.getOldValue() + " to " + dcl.getNewValue() + " at unit #" + dcl.getPhysicalUnitId() + " by " + dcl.getUserName());
		
		List<org.eclipse.iot.unide.ppmp.messages.Message> msgs = new LinkedList<org.eclipse.iot.unide.ppmp.messages.Message>();
		msgs.add(msg);
		wrapper.setMessages(msgs);
		
		return wrapper;
	}
}
