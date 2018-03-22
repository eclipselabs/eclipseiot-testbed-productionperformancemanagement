package org.eclipse.iot.unide.integrators;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.eclipse.iot.unide.ppmp.commons.Device;
import org.eclipse.iot.unide.ppmp.commons.MetaData;
import org.eclipse.iot.unide.ppmp.measurements.MeasurementsWrapper;
import org.eclipse.iot.unide.ppmp.process.Process;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;

import com.fasterxml.jackson.core.JsonProcessingException;

public class PSI6000 implements Processor {

	public PSI6000() {}

	private org.eclipse.iot.unide.ppmp.measurements.SeriesMap addMeasurementPoint(
			org.eclipse.iot.unide.ppmp.measurements.SeriesMap map, String name, Number value) {
		if (value != null) {
			map.setSeriesValue(name, Arrays.asList(value));
		}
		return map;
	}

	@Override
	public void process(Exchange exchange) throws JsonProcessingException, Exception {
		Message msg = exchange.getIn();
		PSI6000DataType doc = msg.getBody(PSI6000DataType.class);

		Object []bundle = new Object[2];
		bundle[0] = transformMeasurement(doc);
		bundle[1] = transformProcess(doc);
		msg.setBody(bundle);
		exchange.setOut(msg);
	}

	private void setSpotName(Device device, WeldLog wl) {
		String spotName = wl.getSpotName();
		if (spotName != null && spotName.length() > 0) {
			MetaData md = new MetaData();
			md.setMetaDataValue("spotName", wl.getSpotName());
			device.setMetaData(md);
		}
	}

	private ProcessWrapper transformProcess(PSI6000DataType doc) {
		ProcessWrapper wrapper = new ProcessWrapper();
		WeldLog wl = doc.getMessage().getWeldLog();
		OffsetDateTime odt = OffsetDateTime.of(wl.getDateTime(), ZoneOffset.UTC);

		// device
		Device device = new Device();
		device.setDeviceID(doc.getMessage().getWeldLog().getTimerName());
		setSpotName(device, wl);
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

		//values
		org.eclipse.iot.unide.ppmp.process.SeriesMap seriesMap = new org.eclipse.iot.unide.ppmp.process.SeriesMap();
		seriesMap.setSeriesValue("curentCurve", wl.getCurrentCurve());
		seriesMap.setSeriesValue("voltageCurve", wl.getVoltageCurve());
		seriesMap.setSeriesValue("forceCurve", wl.getForceCurve());
		
		measurement.setSeriesMap(seriesMap);
		measurements.add(measurement);
		wrapper.setMeasurements(measurements);
		
		return wrapper;
	}

	private MeasurementsWrapper transformMeasurement(PSI6000DataType doc) {
		MeasurementsWrapper wrapper = new MeasurementsWrapper();
		WeldLog wl = doc.getMessage().getWeldLog();

		// device
		Device device = new Device();
		device.setDeviceID(doc.getMessage().getWeldLog().getTimerName());
		setSpotName(device, wl);
		wrapper.setDevice(device);

		// part
		String partId = wl.getPartIdentString();
		if (partId != null && partId.length() > 0) {
			org.eclipse.iot.unide.ppmp.measurements.Part part = new org.eclipse.iot.unide.ppmp.measurements.Part();
			part.setPartID(partId);
			wrapper.setPart(part);
		}

		// measurements
		List<org.eclipse.iot.unide.ppmp.measurements.Measurements> measurements = new LinkedList<org.eclipse.iot.unide.ppmp.measurements.Measurements>();
		org.eclipse.iot.unide.ppmp.measurements.Measurements measurement = new org.eclipse.iot.unide.ppmp.measurements.Measurements();

		measurement.setTimestamp(OffsetDateTime.of(wl.getDateTime(), ZoneOffset.UTC));

		// values
		org.eclipse.iot.unide.ppmp.measurements.SeriesMap seriesMap = new org.eclipse.iot.unide.ppmp.measurements.SeriesMap();
		seriesMap.setSeriesValue("$_time", Arrays.asList(0));

		addMeasurementPoint(seriesMap, "wear", wl.getWear());
		addMeasurementPoint(seriesMap, "wearPerCent", wl.getWearPerCent());
		addMeasurementPoint(seriesMap, "monitorState", wl.getMonitorState());
		addMeasurementPoint(seriesMap, "regulationState", wl.getRegulationState());
		addMeasurementPoint(seriesMap, "measureState", wl.getMeasureState());
		addMeasurementPoint(seriesMap, "powerState", wl.getPowerState());
		addMeasurementPoint(seriesMap, "sequenceState", wl.getSequenceState());
		addMeasurementPoint(seriesMap, "sequenceStateAdd", wl.getSequenceStateAdd());
		addMeasurementPoint(seriesMap, "sequenceRepeat", wl.getSequenceRepeat());
		addMeasurementPoint(seriesMap, "monitorMode", wl.getMonitorMode());
		addMeasurementPoint(seriesMap, "iDemandStd", wl.getIDemandStd());
		addMeasurementPoint(seriesMap, "ilsts", wl.getIlsts());
		addMeasurementPoint(seriesMap, "regulationStd", wl.getRegulationStd());
		addMeasurementPoint(seriesMap, "iDemand1", wl.getIDemand1());
		addMeasurementPoint(seriesMap, "iActual1", wl.getIActual1());
		addMeasurementPoint(seriesMap, "regulation1", wl.getRegulation1());
		addMeasurementPoint(seriesMap, "iDemand2", wl.getIDemand2());
		addMeasurementPoint(seriesMap, "iActual2", wl.getIActual2());
		addMeasurementPoint(seriesMap, "regulation2", wl.getRegulation2());
		addMeasurementPoint(seriesMap, "iDemand3", wl.getIDemand3());
		addMeasurementPoint(seriesMap, "iActual3", wl.getIActual3());
		addMeasurementPoint(seriesMap, "regulation3", wl.getRegulation3());
		addMeasurementPoint(seriesMap, "phaStd", wl.getPhaStd());
		addMeasurementPoint(seriesMap, "pha1", wl.getPha1());
		addMeasurementPoint(seriesMap, "pha2", wl.getPha2());
		addMeasurementPoint(seriesMap, "pha3", wl.getPha3());
		addMeasurementPoint(seriesMap, "t_iDemandStd", wl.getIDemandStd());
		addMeasurementPoint(seriesMap, "tActualStd", wl.getTActualStd());
		// addMeasurementPoint(seriesMap, "partIdentString",
		// wl.getPartIdentString());
		addMeasurementPoint(seriesMap, "tipDressCounter", wl.getTipDressCounter());
		addMeasurementPoint(seriesMap, "electrodeNo", wl.getElectrodeNo());
		addMeasurementPoint(seriesMap, "sgForceSetPoint", wl.getSgForceSetPoint());
		addMeasurementPoint(seriesMap, "sgSheetThicknessSetPoint", wl.getSgSheetThicknessSetPoint());
		addMeasurementPoint(seriesMap, "sgSagGpSetPoint", wl.getSgSagGpSetPoint());
		addMeasurementPoint(seriesMap, "sgSpotWithSg", wl.getSgSpotWithSg());
		addMeasurementPoint(seriesMap, "sgMotorCurrent", wl.getSgMotorCurrent());
		addMeasurementPoint(seriesMap, "sgMotorTemp", wl.getSgMotorTemp());
		addMeasurementPoint(seriesMap, "sgForce", wl.getSgForce());
		addMeasurementPoint(seriesMap, "sgSheetThickness", wl.getSgSheetThickness());
		addMeasurementPoint(seriesMap, "sgSagGp", wl.getSgSagGp());
		addMeasurementPoint(seriesMap, "sgSagGc", wl.getSgSagGc());
		addMeasurementPoint(seriesMap, "regUsrUspJunction", wl.getRegUsrUspJunction());
		addMeasurementPoint(seriesMap, "regUsrUspMax", wl.getRegUsrUspMax());
		addMeasurementPoint(seriesMap, "regSpotDiaActual", wl.getRegSpotDiaActual());
		addMeasurementPoint(seriesMap, "regSpotDiaMinDemand", wl.getRegSpotDiaMinDemand());
		addMeasurementPoint(seriesMap, "regSplashTime", wl.getRegSplashTime());
		addMeasurementPoint(seriesMap, "nuggetDiameter", wl.getNuggetDiameter());
		addMeasurementPoint(seriesMap, "usp", wl.getUsp());
		addMeasurementPoint(seriesMap, "normingTime", wl.getNormingTime());
		addMeasurementPoint(seriesMap, "regulationStartTime", wl.getRegulationStartTime());
		addMeasurementPoint(seriesMap, "returnToConstantCurrent", wl.getReturnToConstantCurrent());
		addMeasurementPoint(seriesMap, "declineUsp", wl.getDeclineUsp());
		addMeasurementPoint(seriesMap, "offsetUsp", wl.getOffsetUsp());
		addMeasurementPoint(seriesMap, "currentFactor", wl.getCurrentFactor());
		addMeasurementPoint(seriesMap, "triggerTime", wl.getTriggerTime());
		addMeasurementPoint(seriesMap, "xqrMeasuringActive", wl.getXqrMeasuringActive());
		addMeasurementPoint(seriesMap, "xqrRegulationActive", wl.getXqrRegulationActive());
		addMeasurementPoint(seriesMap, "xqrMonitoringActive", wl.getXqrMonitoringActive());
		addMeasurementPoint(seriesMap, "xqrWeldTimeProlongationActive", wl.getXqrWeldTimeProlongationActive());
		addMeasurementPoint(seriesMap, "voltageActualValue", wl.getVoltageActualValue());
		addMeasurementPoint(seriesMap, "voltageRefValue", wl.getVoltageRefValue());
		addMeasurementPoint(seriesMap, "currentActualValue", wl.getCurrentActualValue());
		addMeasurementPoint(seriesMap, "currentReferenceValue", wl.getCurrentReferenceValue());
		addMeasurementPoint(seriesMap, "weldTimeActualValue", wl.getWeldTimeActualValue());
		addMeasurementPoint(seriesMap, "weldTimeRefValue", wl.getWeldTimeRefValue());
		addMeasurementPoint(seriesMap, "energyActualValue", wl.getEnergyActualValue());
		addMeasurementPoint(seriesMap, "energyRefValue", wl.getEnergyRefValue());
		addMeasurementPoint(seriesMap, "powerActualValue", wl.getPowerActualValue());
		addMeasurementPoint(seriesMap, "powerRefValue", wl.getPowerRefValue());
		addMeasurementPoint(seriesMap, "resistanceActualValue", wl.getResistanceActualValue());
		addMeasurementPoint(seriesMap, "resistanceRefValue", wl.getResistanceRefValue());
		addMeasurementPoint(seriesMap, "pulseWidthActualValue", wl.getPulseWidthActualValue());
		addMeasurementPoint(seriesMap, "pulseWidthRefValue", wl.getPulseWidthRefValue());
		addMeasurementPoint(seriesMap, "stabilisationFactorActValue", wl.getStabilisationFactorActValue());
		addMeasurementPoint(seriesMap, "stabilisationFactorRefValue", wl.getStabilisationFactorRefValue());
		addMeasurementPoint(seriesMap, "thresholdStabilisationFactor", wl.getThresholdStabilisationFactor());
		addMeasurementPoint(seriesMap, "wldEffectStabilisationFactor", wl.getWldEffectStabilisationFactor());
		addMeasurementPoint(seriesMap, "uipActualValue", wl.getUipActualValue());
		addMeasurementPoint(seriesMap, "uipRefValue", wl.getUipRefValue());
		addMeasurementPoint(seriesMap, "uirExpulsionTime", wl.getUirExpulsionTime());
		addMeasurementPoint(seriesMap, "uirMeasuringActive", wl.getUirMeasuringActive());
		addMeasurementPoint(seriesMap, "uirRegulationActive", wl.getUirRegulationActive());
		addMeasurementPoint(seriesMap, "uirMonitoringActive", wl.getUirMonitoringActive());
		addMeasurementPoint(seriesMap, "uirWeldTimeProlongationActive", wl.getUirWeldTimeProlongationActive());
		addMeasurementPoint(seriesMap, "uirQStoppRefCntValue", wl.getUirQStoppRefCntValue());
		addMeasurementPoint(seriesMap, "uirQStoppActCntValue", wl.getUirQStoppActCntValue());
		addMeasurementPoint(seriesMap, "uirUipUpperTol", wl.getUirUipUpperTol());
		addMeasurementPoint(seriesMap, "uirUipLowerTol", wl.getUirUipLowerTol());
		addMeasurementPoint(seriesMap, "uirUipCondTol", wl.getUirUipCondTol());
		addMeasurementPoint(seriesMap, "uirPsfLowerTol", wl.getUirPsfLowerTol());
		addMeasurementPoint(seriesMap, "uirPsfCondTol", wl.getUirPsfCondTol());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_1", wl.getWeldSpotCustDataP161());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_2", wl.getWeldSpotCustDataP162());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_3", wl.getWeldSpotCustDataP163());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_4", wl.getWeldSpotCustDataP164());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_5", wl.getWeldSpotCustDataP165());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP32_6", wl.getWeldSpotCustDataP326());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_7", wl.getWeldSpotCustDataP167());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_8", wl.getWeldSpotCustDataP168());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_9", wl.getWeldSpotCustDataP169());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_10", wl.getWeldSpotCustDataP1610());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_11", wl.getWeldSpotCustDataP1611());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP32_12", wl.getWeldSpotCustDataP3212());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_13", wl.getWeldSpotCustDataP1613());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_14", wl.getWeldSpotCustDataP1614());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_15", wl.getWeldSpotCustDataP1615());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_16", wl.getWeldSpotCustDataP1616());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP16_17", wl.getWeldSpotCustDataP1617());
		addMeasurementPoint(seriesMap, "weldSpotCustDataP32_18", wl.getWeldSpotCustDataP3218());
		addMeasurementPoint(seriesMap, "uipMonCondUpperTol", wl.getUipMonCondUpperTol());
		addMeasurementPoint(seriesMap, "fqfActualValue", wl.getFqfActualValue());
		addMeasurementPoint(seriesMap, "fqfRefValue", wl.getFqfRefValue());
		addMeasurementPoint(seriesMap, "fqfMonUpperTol", wl.getFqfMonUpperTol());
		addMeasurementPoint(seriesMap, "fqfMonLowerTol", wl.getFqfMonLowerTol());
		addMeasurementPoint(seriesMap, "fqfMonCondUpperTol", wl.getFqfMonCondUpperTol());
		addMeasurementPoint(seriesMap, "fqfMonCondLowerTol", wl.getFqfMonCondLowerTol());
		addMeasurementPoint(seriesMap, "fqfMeasuringActive", wl.getFqfMeasuringActive());
		addMeasurementPoint(seriesMap, "xqrModeOff", wl.getXqrModeOff());
		addMeasurementPoint(seriesMap, "reweldActive", wl.getReweldActive());
		// addMeasurementPoint(seriesMap, "weldspotRefIdent",
		// wl.getWeldspotRefIdent());
		addMeasurementPoint(seriesMap, "sg_Torque_Gp", wl.getSgTorqueGp());
		addMeasurementPoint(seriesMap, "sg_Force_Corr", wl.getSgForceCorr());
		addMeasurementPoint(seriesMap, "sg_Weldspot_Geo_Wear", wl.getSgWeldspotGeoWear());
		addMeasurementPoint(seriesMap, "sg_Wear_Length", wl.getSgWearLength());
		addMeasurementPoint(seriesMap, "sg_Beam_UpArching", wl.getSgBeamUpArching());

		measurement.setSeriesMap(seriesMap);
		measurements.add(measurement);
		wrapper.setMeasurements(measurements);

		return wrapper;
	}
}
