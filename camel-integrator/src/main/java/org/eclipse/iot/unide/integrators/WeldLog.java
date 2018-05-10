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

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "protRecord_ID",
    "dateTime",
    "timerName",
    "progNo",
    "spotName",
    "wear",
    "wearPerCent",
    "monitorState",
    "regulationState",
    "measureState",
    "powerState",
    "sequenceState",
    "sequenceStateAdd",
    "sequenceRepeat",
    "monitorMode",
    "iDemandStd",
    "ilsts",
    "regulationStd",
    "iDemand1",
    "iActual1",
    "regulation1",
    "iDemand2",
    "iActual2",
    "regulation2",
    "iDemand3",
    "iActual3",
    "regulation3",
    "phaStd",
    "pha1",
    "pha2",
    "pha3",
    "t_iDemandStd",
    "tActualStd",
    "partIdentString",
    "tipDressCounter",
    "electrodeNo",
    "sgForceSetPoint",
    "sgSheetThicknessSetPoint",
    "sgSagGpSetPoint",
    "sgSpotWithSg",
    "sgMotorCurrent",
    "sgMotorTemp",
    "sgForce",
    "sgSheetThickness",
    "sgSagGp",
    "sgSagGc",
    "regUsrUspJunction",
    "regUsrUspMax",
    "regSpotDiaActual",
    "regSpotDiaMinDemand",
    "regSplashTime",
    "nuggetDiameter",
    "usp",
    "normingTime",
    "regulationStartTime",
    "returnToConstantCurrent",
    "declineUsp",
    "offsetUsp",
    "currentFactor",
    "triggerTime",
    "xqrMeasuringActive",
    "xqrRegulationActive",
    "xqrMonitoringActive",
    "xqrWeldTimeProlongationActive",
    "voltageActualValue",
    "voltageRefValue",
    "currentActualValue",
    "currentReferenceValue",
    "weldTimeActualValue",
    "weldTimeRefValue",
    "energyActualValue",
    "energyRefValue",
    "powerActualValue",
    "powerRefValue",
    "resistanceActualValue",
    "resistanceRefValue",
    "pulseWidthActualValue",
    "pulseWidthRefValue",
    "stabilisationFactorActValue",
    "stabilisationFactorRefValue",
    "thresholdStabilisationFactor",
    "wldEffectStabilisationFactor",
    "uipActualValue",
    "uipRefValue",
    "uirExpulsionTime",
    "uirMeasuringActive",
    "uirRegulationActive",
    "uirMonitoringActive",
    "uirWeldTimeProlongationActive",
    "uirQStoppRefCntValue",
    "uirQStoppActCntValue",
    "uirUipUpperTol",
    "uirUipLowerTol",
    "uirUipCondTol",
    "uirPsfLowerTol",
    "uirPsfCondTol",
    "weldSpotCustDataP16_1",
    "weldSpotCustDataP16_2",
    "weldSpotCustDataP16_3",
    "weldSpotCustDataP16_4",
    "weldSpotCustDataP16_5",
    "weldSpotCustDataP32_6",
    "weldSpotCustDataP16_7",
    "weldSpotCustDataP16_8",
    "weldSpotCustDataP16_9",
    "weldSpotCustDataP16_10",
    "weldSpotCustDataP16_11",
    "weldSpotCustDataP32_12",
    "weldSpotCustDataP16_13",
    "weldSpotCustDataP16_14",
    "weldSpotCustDataP16_15",
    "weldSpotCustDataP16_16",
    "weldSpotCustDataP16_17",
    "weldSpotCustDataP32_18",
    "uipMonCondUpperTol",
    "fqfActualValue",
    "fqfRefValue",
    "fqfMonUpperTol",
    "fqfMonLowerTol",
    "fqfMonCondUpperTol",
    "fqfMonCondLowerTol",
    "fqfMeasuringActive",
    "xqrModeOff",
    "reweldActive",
    "weldspotRefIdent",
    "sg_Torque_Gp",
    "sg_Force_Corr",
    "sg_Weldspot_Geo_Wear",
    "sg_Wear_Length",
    "sg_Beam_UpArching",
    "CurrentCurve",
    "VoltageCurve",
    "ForceCurve"
})
public class WeldLog {

    @JsonProperty("protRecord_ID")
    private Number protRecordID;
    @JsonProperty("dateTime")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;
    @JsonProperty("timerName")
    private String timerName;
    @JsonProperty("progNo")
    private Number progNo;
    @JsonProperty("spotName")
    private String spotName;
    @JsonProperty("wear")
    private Number wear;
    @JsonProperty("wearPerCent")
    private Number wearPerCent;
    @JsonProperty("monitorState")
    private Number monitorState;
    @JsonProperty("regulationState")
    private Number regulationState;
    @JsonProperty("measureState")
    private Number measureState;
    @JsonProperty("powerState")
    private Number powerState;
    @JsonProperty("sequenceState")
    private Number sequenceState;
    @JsonProperty("sequenceStateAdd")
    private Number sequenceStateAdd;
    @JsonProperty("sequenceRepeat")
    private Number sequenceRepeat;
    @JsonProperty("monitorMode")
    private Number monitorMode;
    @JsonProperty("iDemandStd")
    private Number iDemandStd;
    @JsonProperty("ilsts")
    private Double ilsts;
    @JsonProperty("regulationStd")
    private Number regulationStd;
    @JsonProperty("iDemand1")
    private Number iDemand1;
    @JsonProperty("iActual1")
    private Number iActual1;
    @JsonProperty("regulation1")
    private Number regulation1;
    @JsonProperty("iDemand2")
    private Number iDemand2;
    @JsonProperty("iActual2")
    private Double iActual2;
    @JsonProperty("regulation2")
    private Number regulation2;
    @JsonProperty("iDemand3")
    private Number iDemand3;
    @JsonProperty("iActual3")
    private Number iActual3;
    @JsonProperty("regulation3")
    private Number regulation3;
    @JsonProperty("phaStd")
    private Double phaStd;
    @JsonProperty("pha1")
    private Number pha1;
    @JsonProperty("pha2")
    private Double pha2;
    @JsonProperty("pha3")
    private Number pha3;
    @JsonProperty("t_iDemandStd")
    private Number tIDemandStd;
    @JsonProperty("tActualStd")
    private Number tActualStd;
    @JsonProperty("partIdentString")
    private String partIdentString;
    @JsonProperty("tipDressCounter")
    private Number tipDressCounter;
    @JsonProperty("electrodeNo")
    private Number electrodeNo;
    @JsonProperty("sgForceSetPoint")
    private Number sgForceSetPoint;
    @JsonProperty("sgSheetThicknessSetPoint")
    private Number sgSheetThicknessSetPoint;
    @JsonProperty("sgSagGpSetPoint")
    private Number sgSagGpSetPoint;
    @JsonProperty("sgSpotWithSg")
    private Number sgSpotWithSg;
    @JsonProperty("sgMotorCurrent")
    private Number sgMotorCurrent;
    @JsonProperty("sgMotorTemp")
    private Number sgMotorTemp;
    @JsonProperty("sgForce")
    private Number sgForce;
    @JsonProperty("sgSheetThickness")
    private Number sgSheetThickness;
    @JsonProperty("sgSagGp")
    private Number sgSagGp;
    @JsonProperty("sgSagGc")
    private Number sgSagGc;
    @JsonProperty("regUsrUspJunction")
    private Number regUsrUspJunction;
    @JsonProperty("regUsrUspMax")
    private Number regUsrUspMax;
    @JsonProperty("regSpotDiaActual")
    private Number regSpotDiaActual;
    @JsonProperty("regSpotDiaMinDemand")
    private Number regSpotDiaMinDemand;
    @JsonProperty("regSplashTime")
    private Number regSplashTime;
    @JsonProperty("nuggetDiameter")
    private Number nuggetDiameter;
    @JsonProperty("usp")
    private Number usp;
    @JsonProperty("normingTime")
    private Number normingTime;
    @JsonProperty("regulationStartTime")
    private Number regulationStartTime;
    @JsonProperty("returnToConstantCurrent")
    private Number returnToConstantCurrent;
    @JsonProperty("declineUsp")
    private Number declineUsp;
    @JsonProperty("offsetUsp")
    private Number offsetUsp;
    @JsonProperty("currentFactor")
    private Number currentFactor;
    @JsonProperty("triggerTime")
    private Number triggerTime;
    @JsonProperty("xqrMeasuringActive")
    private Number xqrMeasuringActive;
    @JsonProperty("xqrRegulationActive")
    private Number xqrRegulationActive;
    @JsonProperty("xqrMonitoringActive")
    private Number xqrMonitoringActive;
    @JsonProperty("xqrWeldTimeProlongationActive")
    private Number xqrWeldTimeProlongationActive;
    @JsonProperty("voltageActualValue")
    private Double voltageActualValue;
    @JsonProperty("voltageRefValue")
    private Double voltageRefValue;
    @JsonProperty("currentActualValue")
    private Double currentActualValue;
    @JsonProperty("currentReferenceValue")
    private Double currentReferenceValue;
    @JsonProperty("weldTimeActualValue")
    private Number weldTimeActualValue;
    @JsonProperty("weldTimeRefValue")
    private Number weldTimeRefValue;
    @JsonProperty("energyActualValue")
    private Double energyActualValue;
    @JsonProperty("energyRefValue")
    private Number energyRefValue;
    @JsonProperty("powerActualValue")
    private Double powerActualValue;
    @JsonProperty("powerRefValue")
    private Double powerRefValue;
    @JsonProperty("resistanceActualValue")
    private Number resistanceActualValue;
    @JsonProperty("resistanceRefValue")
    private Number resistanceRefValue;
    @JsonProperty("pulseWidthActualValue")
    private Double pulseWidthActualValue;
    @JsonProperty("pulseWidthRefValue")
    private Double pulseWidthRefValue;
    @JsonProperty("stabilisationFactorActValue")
    private Number stabilisationFactorActValue;
    @JsonProperty("stabilisationFactorRefValue")
    private Number stabilisationFactorRefValue;
    @JsonProperty("thresholdStabilisationFactor")
    private Number thresholdStabilisationFactor;
    @JsonProperty("wldEffectStabilisationFactor")
    private Number wldEffectStabilisationFactor;
    @JsonProperty("uipActualValue")
    private Number uipActualValue;
    @JsonProperty("uipRefValue")
    private Number uipRefValue;
    @JsonProperty("uirExpulsionTime")
    private Number uirExpulsionTime;
    @JsonProperty("uirMeasuringActive")
    private Number uirMeasuringActive;
    @JsonProperty("uirRegulationActive")
    private Number uirRegulationActive;
    @JsonProperty("uirMonitoringActive")
    private Number uirMonitoringActive;
    @JsonProperty("uirWeldTimeProlongationActive")
    private Number uirWeldTimeProlongationActive;
    @JsonProperty("uirQStoppRefCntValue")
    private Number uirQStoppRefCntValue;
    @JsonProperty("uirQStoppActCntValue")
    private Number uirQStoppActCntValue;
    @JsonProperty("uirUipUpperTol")
    private Number uirUipUpperTol;
    @JsonProperty("uirUipLowerTol")
    private Number uirUipLowerTol;
    @JsonProperty("uirUipCondTol")
    private Number uirUipCondTol;
    @JsonProperty("uirPsfLowerTol")
    private Number uirPsfLowerTol;
    @JsonProperty("uirPsfCondTol")
    private Number uirPsfCondTol;
    @JsonProperty("weldSpotCustDataP16_1")
    private Number weldSpotCustDataP161;
    @JsonProperty("weldSpotCustDataP16_2")
    private Number weldSpotCustDataP162;
    @JsonProperty("weldSpotCustDataP16_3")
    private Number weldSpotCustDataP163;
    @JsonProperty("weldSpotCustDataP16_4")
    private Number weldSpotCustDataP164;
    @JsonProperty("weldSpotCustDataP16_5")
    private Number weldSpotCustDataP165;
    @JsonProperty("weldSpotCustDataP32_6")
    private Number weldSpotCustDataP326;
    @JsonProperty("weldSpotCustDataP16_7")
    private Number weldSpotCustDataP167;
    @JsonProperty("weldSpotCustDataP16_8")
    private Number weldSpotCustDataP168;
    @JsonProperty("weldSpotCustDataP16_9")
    private Number weldSpotCustDataP169;
    @JsonProperty("weldSpotCustDataP16_10")
    private Number weldSpotCustDataP1610;
    @JsonProperty("weldSpotCustDataP16_11")
    private Number weldSpotCustDataP1611;
    @JsonProperty("weldSpotCustDataP32_12")
    private Number weldSpotCustDataP3212;
    @JsonProperty("weldSpotCustDataP16_13")
    private Number weldSpotCustDataP1613;
    @JsonProperty("weldSpotCustDataP16_14")
    private Number weldSpotCustDataP1614;
    @JsonProperty("weldSpotCustDataP16_15")
    private Number weldSpotCustDataP1615;
    @JsonProperty("weldSpotCustDataP16_16")
    private Number weldSpotCustDataP1616;
    @JsonProperty("weldSpotCustDataP16_17")
    private Number weldSpotCustDataP1617;
    @JsonProperty("weldSpotCustDataP32_18")
    private Number weldSpotCustDataP3218;
    @JsonProperty("uipMonCondUpperTol")
    private Number uipMonCondUpperTol;
    @JsonProperty("fqfActualValue")
    private Number fqfActualValue;
    @JsonProperty("fqfRefValue")
    private Number fqfRefValue;
    @JsonProperty("fqfMonUpperTol")
    private Number fqfMonUpperTol;
    @JsonProperty("fqfMonLowerTol")
    private Number fqfMonLowerTol;
    @JsonProperty("fqfMonCondUpperTol")
    private Number fqfMonCondUpperTol;
    @JsonProperty("fqfMonCondLowerTol")
    private Number fqfMonCondLowerTol;
    @JsonProperty("fqfMeasuringActive")
    private Number fqfMeasuringActive;
    @JsonProperty("xqrModeOff")
    private Number xqrModeOff;
    @JsonProperty("reweldActive")
    private Number reweldActive;
    @JsonProperty("weldspotRefIdent")
    private String weldspotRefIdent;
    @JsonProperty("sg_Torque_Gp")
    private Number sgTorqueGp;
    @JsonProperty("sg_Force_Corr")
    private Number sgForceCorr;
    @JsonProperty("sg_Weldspot_Geo_Wear")
    private Number sgWeldspotGeoWear;
    @JsonProperty("sg_Wear_Length")
    private Number sgWearLength;
    @JsonProperty("sg_Beam_UpArching")
    private Number sgBeamUpArching;
    @JsonProperty("CurrentCurve")
    private List<Number> currentCurve = null;
    @JsonProperty("VoltageCurve")
    private List<Number> voltageCurve = null;
    @JsonProperty("ForceCurve")
    private List<Number> forceCurve = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public WeldLog() {
    }

    /**
     * 
     * @param sgSheetThicknessSetPoint
     * @param xqrRegulationActive
     * @param weldSpotCustDataP168
     * @param weldSpotCustDataP169
     * @param sequenceRepeat
     * @param weldSpotCustDataP167
     * @param triggerTime
     * @param powerRefValue
     * @param weldSpotCustDataP164
     * @param regulationState
     * @param weldSpotCustDataP165
     * @param weldSpotCustDataP162
     * @param sgForce
     * @param weldSpotCustDataP163
     * @param weldSpotCustDataP161
     * @param progNo
     * @param uirExpulsionTime
     * @param electrodeNo
     * @param weldTimeActualValue
     * @param iActual3
     * @param iActual2
     * @param iActual1
     * @param phaStd
     * @param weldspotRefIdent
     * @param weldTimeRefValue
     * @param regSpotDiaMinDemand
     * @param voltageCurve
     * @param sgSpotWithSg
     * @param uirPsfCondTol
     * @param sgTorqueGp
     * @param uirPsfLowerTol
     * @param tipDressCounter
     * @param uirMonitoringActive
     * @param uirMeasuringActive
     * @param uirUipCondTol
     * @param iDemandStd
     * @param fqfMeasuringActive
     * @param fqfMonUpperTol
     * @param xqrWeldTimeProlongationActive
     * @param wearPerCent
     * @param nuggetDiameter
     * @param normingTime
     * @param uipMonCondUpperTol
     * @param sgForceCorr
     * @param sgMotorTemp
     * @param thresholdStabilisationFactor
     * @param declineUsp
     * @param usp
     * @param uirRegulationActive
     * @param returnToConstantCurrent
     * @param uirWeldTimeProlongationActive
     * @param regulationStd
     * @param fqfActualValue
     * @param regulation1
     * @param powerState
     * @param partIdentString
     * @param offsetUsp
     * @param xqrMonitoringActive
     * @param regulation3
     * @param regulation2
     * @param stabilisationFactorActValue
     * @param weldSpotCustDataP326
     * @param protRecordID
     * @param fqfMonLowerTol
     * @param pulseWidthActualValue
     * @param sgWearLength
     * @param sgWeldspotGeoWear
     * @param sgMotorCurrent
     * @param sgBeamUpArching
     * @param regUsrUspMax
     * @param weldSpotCustDataP1610
     * @param fqfRefValue
     * @param fqfMonCondUpperTol
     * @param sequenceStateAdd
     * @param timerName
     * @param powerActualValue
     * @param forceCurve
     * @param resistanceActualValue
     * @param measureState
     * @param uirQStoppActCntValue
     * @param fqfMonCondLowerTol
     * @param voltageActualValue
     * @param weldSpotCustDataP1614
     * @param weldSpotCustDataP1613
     * @param sgSagGpSetPoint
     * @param weldSpotCustDataP1611
     * @param currentReferenceValue
     * @param tIDemandStd
     * @param weldSpotCustDataP1617
     * @param voltageRefValue
     * @param pulseWidthRefValue
     * @param uipRefValue
     * @param weldSpotCustDataP1616
     * @param weldSpotCustDataP1615
     * @param regSplashTime
     * @param monitorState
     * @param ilsts
     * @param monitorMode
     * @param uipActualValue
     * @param dateTime
     * @param regSpotDiaActual
     * @param stabilisationFactorRefValue
     * @param sgSagGp
     * @param currentFactor
     * @param regUsrUspJunction
     * @param pha3
     * @param pha2
     * @param pha1
     * @param tActualStd
     * @param xqrMeasuringActive
     * @param energyRefValue
     * @param sgSagGc
     * @param currentActualValue
     * @param reweldActive
     * @param uirQStoppRefCntValue
     * @param weldSpotCustDataP3218
     * @param energyActualValue
     * @param iDemand2
     * @param sgSheetThickness
     * @param iDemand3
     * @param spotName
     * @param iDemand1
     * @param wldEffectStabilisationFactor
     * @param sequenceState
     * @param resistanceRefValue
     * @param uirUipUpperTol
     * @param uirUipLowerTol
     * @param regulationStartTime
     * @param sgForceSetPoint
     * @param currentCurve
     * @param xqrModeOff
     * @param weldSpotCustDataP3212
     * @param wear
     */
    public WeldLog(Number protRecordID, LocalDateTime dateTime, String timerName, Number progNo, String spotName, Number wear, Number wearPerCent, Number monitorState, Number regulationState, Number measureState, Number powerState, Number sequenceState, Number sequenceStateAdd, Number sequenceRepeat, Number monitorMode, Number iDemandStd, Double ilsts, Number regulationStd, Number iDemand1, Number iActual1, Number regulation1, Number iDemand2, Double iActual2, Number regulation2, Number iDemand3, Number iActual3, Number regulation3, Double phaStd, Number pha1, Double pha2, Number pha3, Number tIDemandStd, Number tActualStd, String partIdentString, Number tipDressCounter, Number electrodeNo, Number sgForceSetPoint, Number sgSheetThicknessSetPoint, Number sgSagGpSetPoint, Number sgSpotWithSg, Number sgMotorCurrent, Number sgMotorTemp, Number sgForce, Number sgSheetThickness, Number sgSagGp, Number sgSagGc, Number regUsrUspJunction, Number regUsrUspMax, Number regSpotDiaActual, Number regSpotDiaMinDemand, Number regSplashTime, Number nuggetDiameter, Number usp, Number normingTime, Number regulationStartTime, Number returnToConstantCurrent, Number declineUsp, Number offsetUsp, Number currentFactor, Number triggerTime, Number xqrMeasuringActive, Number xqrRegulationActive, Number xqrMonitoringActive, Number xqrWeldTimeProlongationActive, Double voltageActualValue, Double voltageRefValue, Double currentActualValue, Double currentReferenceValue, Number weldTimeActualValue, Number weldTimeRefValue, Double energyActualValue, Number energyRefValue, Double powerActualValue, Double powerRefValue, Number resistanceActualValue, Number resistanceRefValue, Double pulseWidthActualValue, Double pulseWidthRefValue, Number stabilisationFactorActValue, Number stabilisationFactorRefValue, Number thresholdStabilisationFactor, Number wldEffectStabilisationFactor, Number uipActualValue, Number uipRefValue, Number uirExpulsionTime, Number uirMeasuringActive, Number uirRegulationActive, Number uirMonitoringActive, Number uirWeldTimeProlongationActive, Number uirQStoppRefCntValue, Number uirQStoppActCntValue, Number uirUipUpperTol, Number uirUipLowerTol, Number uirUipCondTol, Number uirPsfLowerTol, Number uirPsfCondTol, Number weldSpotCustDataP161, Number weldSpotCustDataP162, Number weldSpotCustDataP163, Number weldSpotCustDataP164, Number weldSpotCustDataP165, Number weldSpotCustDataP326, Number weldSpotCustDataP167, Number weldSpotCustDataP168, Number weldSpotCustDataP169, Number weldSpotCustDataP1610, Number weldSpotCustDataP1611, Number weldSpotCustDataP3212, Number weldSpotCustDataP1613, Number weldSpotCustDataP1614, Number weldSpotCustDataP1615, Number weldSpotCustDataP1616, Number weldSpotCustDataP1617, Number weldSpotCustDataP3218, Number uipMonCondUpperTol, Number fqfActualValue, Number fqfRefValue, Number fqfMonUpperTol, Number fqfMonLowerTol, Number fqfMonCondUpperTol, Number fqfMonCondLowerTol, Number fqfMeasuringActive, Number xqrModeOff, Number reweldActive, String weldspotRefIdent, Number sgTorqueGp, Number sgForceCorr, Number sgWeldspotGeoWear, Number sgWearLength, Number sgBeamUpArching, List<Number> currentCurve, List<Number> voltageCurve, List<Number> forceCurve) {
        super();
        this.protRecordID = protRecordID;
        this.dateTime = dateTime;
        this.timerName = timerName;
        this.progNo = progNo;
        this.spotName = spotName;
        this.wear = wear;
        this.wearPerCent = wearPerCent;
        this.monitorState = monitorState;
        this.regulationState = regulationState;
        this.measureState = measureState;
        this.powerState = powerState;
        this.sequenceState = sequenceState;
        this.sequenceStateAdd = sequenceStateAdd;
        this.sequenceRepeat = sequenceRepeat;
        this.monitorMode = monitorMode;
        this.iDemandStd = iDemandStd;
        this.ilsts = ilsts;
        this.regulationStd = regulationStd;
        this.iDemand1 = iDemand1;
        this.iActual1 = iActual1;
        this.regulation1 = regulation1;
        this.iDemand2 = iDemand2;
        this.iActual2 = iActual2;
        this.regulation2 = regulation2;
        this.iDemand3 = iDemand3;
        this.iActual3 = iActual3;
        this.regulation3 = regulation3;
        this.phaStd = phaStd;
        this.pha1 = pha1;
        this.pha2 = pha2;
        this.pha3 = pha3;
        this.tIDemandStd = tIDemandStd;
        this.tActualStd = tActualStd;
        this.partIdentString = partIdentString;
        this.tipDressCounter = tipDressCounter;
        this.electrodeNo = electrodeNo;
        this.sgForceSetPoint = sgForceSetPoint;
        this.sgSheetThicknessSetPoint = sgSheetThicknessSetPoint;
        this.sgSagGpSetPoint = sgSagGpSetPoint;
        this.sgSpotWithSg = sgSpotWithSg;
        this.sgMotorCurrent = sgMotorCurrent;
        this.sgMotorTemp = sgMotorTemp;
        this.sgForce = sgForce;
        this.sgSheetThickness = sgSheetThickness;
        this.sgSagGp = sgSagGp;
        this.sgSagGc = sgSagGc;
        this.regUsrUspJunction = regUsrUspJunction;
        this.regUsrUspMax = regUsrUspMax;
        this.regSpotDiaActual = regSpotDiaActual;
        this.regSpotDiaMinDemand = regSpotDiaMinDemand;
        this.regSplashTime = regSplashTime;
        this.nuggetDiameter = nuggetDiameter;
        this.usp = usp;
        this.normingTime = normingTime;
        this.regulationStartTime = regulationStartTime;
        this.returnToConstantCurrent = returnToConstantCurrent;
        this.declineUsp = declineUsp;
        this.offsetUsp = offsetUsp;
        this.currentFactor = currentFactor;
        this.triggerTime = triggerTime;
        this.xqrMeasuringActive = xqrMeasuringActive;
        this.xqrRegulationActive = xqrRegulationActive;
        this.xqrMonitoringActive = xqrMonitoringActive;
        this.xqrWeldTimeProlongationActive = xqrWeldTimeProlongationActive;
        this.voltageActualValue = voltageActualValue;
        this.voltageRefValue = voltageRefValue;
        this.currentActualValue = currentActualValue;
        this.currentReferenceValue = currentReferenceValue;
        this.weldTimeActualValue = weldTimeActualValue;
        this.weldTimeRefValue = weldTimeRefValue;
        this.energyActualValue = energyActualValue;
        this.energyRefValue = energyRefValue;
        this.powerActualValue = powerActualValue;
        this.powerRefValue = powerRefValue;
        this.resistanceActualValue = resistanceActualValue;
        this.resistanceRefValue = resistanceRefValue;
        this.pulseWidthActualValue = pulseWidthActualValue;
        this.pulseWidthRefValue = pulseWidthRefValue;
        this.stabilisationFactorActValue = stabilisationFactorActValue;
        this.stabilisationFactorRefValue = stabilisationFactorRefValue;
        this.thresholdStabilisationFactor = thresholdStabilisationFactor;
        this.wldEffectStabilisationFactor = wldEffectStabilisationFactor;
        this.uipActualValue = uipActualValue;
        this.uipRefValue = uipRefValue;
        this.uirExpulsionTime = uirExpulsionTime;
        this.uirMeasuringActive = uirMeasuringActive;
        this.uirRegulationActive = uirRegulationActive;
        this.uirMonitoringActive = uirMonitoringActive;
        this.uirWeldTimeProlongationActive = uirWeldTimeProlongationActive;
        this.uirQStoppRefCntValue = uirQStoppRefCntValue;
        this.uirQStoppActCntValue = uirQStoppActCntValue;
        this.uirUipUpperTol = uirUipUpperTol;
        this.uirUipLowerTol = uirUipLowerTol;
        this.uirUipCondTol = uirUipCondTol;
        this.uirPsfLowerTol = uirPsfLowerTol;
        this.uirPsfCondTol = uirPsfCondTol;
        this.weldSpotCustDataP161 = weldSpotCustDataP161;
        this.weldSpotCustDataP162 = weldSpotCustDataP162;
        this.weldSpotCustDataP163 = weldSpotCustDataP163;
        this.weldSpotCustDataP164 = weldSpotCustDataP164;
        this.weldSpotCustDataP165 = weldSpotCustDataP165;
        this.weldSpotCustDataP326 = weldSpotCustDataP326;
        this.weldSpotCustDataP167 = weldSpotCustDataP167;
        this.weldSpotCustDataP168 = weldSpotCustDataP168;
        this.weldSpotCustDataP169 = weldSpotCustDataP169;
        this.weldSpotCustDataP1610 = weldSpotCustDataP1610;
        this.weldSpotCustDataP1611 = weldSpotCustDataP1611;
        this.weldSpotCustDataP3212 = weldSpotCustDataP3212;
        this.weldSpotCustDataP1613 = weldSpotCustDataP1613;
        this.weldSpotCustDataP1614 = weldSpotCustDataP1614;
        this.weldSpotCustDataP1615 = weldSpotCustDataP1615;
        this.weldSpotCustDataP1616 = weldSpotCustDataP1616;
        this.weldSpotCustDataP1617 = weldSpotCustDataP1617;
        this.weldSpotCustDataP3218 = weldSpotCustDataP3218;
        this.uipMonCondUpperTol = uipMonCondUpperTol;
        this.fqfActualValue = fqfActualValue;
        this.fqfRefValue = fqfRefValue;
        this.fqfMonUpperTol = fqfMonUpperTol;
        this.fqfMonLowerTol = fqfMonLowerTol;
        this.fqfMonCondUpperTol = fqfMonCondUpperTol;
        this.fqfMonCondLowerTol = fqfMonCondLowerTol;
        this.fqfMeasuringActive = fqfMeasuringActive;
        this.xqrModeOff = xqrModeOff;
        this.reweldActive = reweldActive;
        this.weldspotRefIdent = weldspotRefIdent;
        this.sgTorqueGp = sgTorqueGp;
        this.sgForceCorr = sgForceCorr;
        this.sgWeldspotGeoWear = sgWeldspotGeoWear;
        this.sgWearLength = sgWearLength;
        this.sgBeamUpArching = sgBeamUpArching;
        this.currentCurve = currentCurve;
        this.voltageCurve = voltageCurve;
        this.forceCurve = forceCurve;
    }

    @JsonProperty("protRecord_ID")
    public Number getProtRecordID() {
        return protRecordID;
    }

    @JsonProperty("protRecord_ID")
    public void setProtRecordID(Number protRecordID) {
        this.protRecordID = protRecordID;
    }

    @JsonProperty("dateTime")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("timerName")
    public String getTimerName() {
        return timerName;
    }

    @JsonProperty("timerName")
    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }

    @JsonProperty("progNo")
    public Number getProgNo() {
        return progNo;
    }

    @JsonProperty("progNo")
    public void setProgNo(Number progNo) {
        this.progNo = progNo;
    }

    @JsonProperty("spotName")
    public String getSpotName() {
        return spotName;
    }

    @JsonProperty("spotName")
    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    @JsonProperty("wear")
    public Number getWear() {
        return wear;
    }

    @JsonProperty("wear")
    public void setWear(Number wear) {
        this.wear = wear;
    }

    @JsonProperty("wearPerCent")
    public Number getWearPerCent() {
        return wearPerCent;
    }

    @JsonProperty("wearPerCent")
    public void setWearPerCent(Number wearPerCent) {
        this.wearPerCent = wearPerCent;
    }

    @JsonProperty("monitorState")
    public Number getMonitorState() {
        return monitorState;
    }

    @JsonProperty("monitorState")
    public void setMonitorState(Number monitorState) {
        this.monitorState = monitorState;
    }

    @JsonProperty("regulationState")
    public Number getRegulationState() {
        return regulationState;
    }

    @JsonProperty("regulationState")
    public void setRegulationState(Number regulationState) {
        this.regulationState = regulationState;
    }

    @JsonProperty("measureState")
    public Number getMeasureState() {
        return measureState;
    }

    @JsonProperty("measureState")
    public void setMeasureState(Number measureState) {
        this.measureState = measureState;
    }

    @JsonProperty("powerState")
    public Number getPowerState() {
        return powerState;
    }

    @JsonProperty("powerState")
    public void setPowerState(Number powerState) {
        this.powerState = powerState;
    }

    @JsonProperty("sequenceState")
    public Number getSequenceState() {
        return sequenceState;
    }

    @JsonProperty("sequenceState")
    public void setSequenceState(Number sequenceState) {
        this.sequenceState = sequenceState;
    }

    @JsonProperty("sequenceStateAdd")
    public Number getSequenceStateAdd() {
        return sequenceStateAdd;
    }

    @JsonProperty("sequenceStateAdd")
    public void setSequenceStateAdd(Number sequenceStateAdd) {
        this.sequenceStateAdd = sequenceStateAdd;
    }

    @JsonProperty("sequenceRepeat")
    public Number getSequenceRepeat() {
        return sequenceRepeat;
    }

    @JsonProperty("sequenceRepeat")
    public void setSequenceRepeat(Number sequenceRepeat) {
        this.sequenceRepeat = sequenceRepeat;
    }

    @JsonProperty("monitorMode")
    public Number getMonitorMode() {
        return monitorMode;
    }

    @JsonProperty("monitorMode")
    public void setMonitorMode(Number monitorMode) {
        this.monitorMode = monitorMode;
    }

    @JsonProperty("iDemandStd")
    public Number getIDemandStd() {
        return iDemandStd;
    }

    @JsonProperty("iDemandStd")
    public void setIDemandStd(Number iDemandStd) {
        this.iDemandStd = iDemandStd;
    }

    @JsonProperty("ilsts")
    public Double getIlsts() {
        return ilsts;
    }

    @JsonProperty("ilsts")
    public void setIlsts(Double ilsts) {
        this.ilsts = ilsts;
    }

    @JsonProperty("regulationStd")
    public Number getRegulationStd() {
        return regulationStd;
    }

    @JsonProperty("regulationStd")
    public void setRegulationStd(Number regulationStd) {
        this.regulationStd = regulationStd;
    }

    @JsonProperty("iDemand1")
    public Number getIDemand1() {
        return iDemand1;
    }

    @JsonProperty("iDemand1")
    public void setIDemand1(Number iDemand1) {
        this.iDemand1 = iDemand1;
    }

    @JsonProperty("iActual1")
    public Number getIActual1() {
        return iActual1;
    }

    @JsonProperty("iActual1")
    public void setIActual1(Number iActual1) {
        this.iActual1 = iActual1;
    }

    @JsonProperty("regulation1")
    public Number getRegulation1() {
        return regulation1;
    }

    @JsonProperty("regulation1")
    public void setRegulation1(Number regulation1) {
        this.regulation1 = regulation1;
    }

    @JsonProperty("iDemand2")
    public Number getIDemand2() {
        return iDemand2;
    }

    @JsonProperty("iDemand2")
    public void setIDemand2(Number iDemand2) {
        this.iDemand2 = iDemand2;
    }

    @JsonProperty("iActual2")
    public Double getIActual2() {
        return iActual2;
    }

    @JsonProperty("iActual2")
    public void setIActual2(Double iActual2) {
        this.iActual2 = iActual2;
    }

    @JsonProperty("regulation2")
    public Number getRegulation2() {
        return regulation2;
    }

    @JsonProperty("regulation2")
    public void setRegulation2(Number regulation2) {
        this.regulation2 = regulation2;
    }

    @JsonProperty("iDemand3")
    public Number getIDemand3() {
        return iDemand3;
    }

    @JsonProperty("iDemand3")
    public void setIDemand3(Number iDemand3) {
        this.iDemand3 = iDemand3;
    }

    @JsonProperty("iActual3")
    public Number getIActual3() {
        return iActual3;
    }

    @JsonProperty("iActual3")
    public void setIActual3(Number iActual3) {
        this.iActual3 = iActual3;
    }

    @JsonProperty("regulation3")
    public Number getRegulation3() {
        return regulation3;
    }

    @JsonProperty("regulation3")
    public void setRegulation3(Number regulation3) {
        this.regulation3 = regulation3;
    }

    @JsonProperty("phaStd")
    public Double getPhaStd() {
        return phaStd;
    }

    @JsonProperty("phaStd")
    public void setPhaStd(Double phaStd) {
        this.phaStd = phaStd;
    }

    @JsonProperty("pha1")
    public Number getPha1() {
        return pha1;
    }

    @JsonProperty("pha1")
    public void setPha1(Number pha1) {
        this.pha1 = pha1;
    }

    @JsonProperty("pha2")
    public Double getPha2() {
        return pha2;
    }

    @JsonProperty("pha2")
    public void setPha2(Double pha2) {
        this.pha2 = pha2;
    }

    @JsonProperty("pha3")
    public Number getPha3() {
        return pha3;
    }

    @JsonProperty("pha3")
    public void setPha3(Number pha3) {
        this.pha3 = pha3;
    }

    @JsonProperty("t_iDemandStd")
    public Number getTIDemandStd() {
        return tIDemandStd;
    }

    @JsonProperty("t_iDemandStd")
    public void setTIDemandStd(Number tIDemandStd) {
        this.tIDemandStd = tIDemandStd;
    }

    @JsonProperty("tActualStd")
    public Number getTActualStd() {
        return tActualStd;
    }

    @JsonProperty("tActualStd")
    public void setTActualStd(Number tActualStd) {
        this.tActualStd = tActualStd;
    }

    @JsonProperty("partIdentString")
    public String getPartIdentString() {
        return partIdentString;
    }

    @JsonProperty("partIdentString")
    public void setPartIdentString(String partIdentString) {
        this.partIdentString = partIdentString;
    }

    @JsonProperty("tipDressCounter")
    public Number getTipDressCounter() {
        return tipDressCounter;
    }

    @JsonProperty("tipDressCounter")
    public void setTipDressCounter(Number tipDressCounter) {
        this.tipDressCounter = tipDressCounter;
    }

    @JsonProperty("electrodeNo")
    public Number getElectrodeNo() {
        return electrodeNo;
    }

    @JsonProperty("electrodeNo")
    public void setElectrodeNo(Number electrodeNo) {
        this.electrodeNo = electrodeNo;
    }

    @JsonProperty("sgForceSetPoint")
    public Number getSgForceSetPoint() {
        return sgForceSetPoint;
    }

    @JsonProperty("sgForceSetPoint")
    public void setSgForceSetPoint(Number sgForceSetPoint) {
        this.sgForceSetPoint = sgForceSetPoint;
    }

    @JsonProperty("sgSheetThicknessSetPoint")
    public Number getSgSheetThicknessSetPoint() {
        return sgSheetThicknessSetPoint;
    }

    @JsonProperty("sgSheetThicknessSetPoint")
    public void setSgSheetThicknessSetPoint(Number sgSheetThicknessSetPoint) {
        this.sgSheetThicknessSetPoint = sgSheetThicknessSetPoint;
    }

    @JsonProperty("sgSagGpSetPoint")
    public Number getSgSagGpSetPoint() {
        return sgSagGpSetPoint;
    }

    @JsonProperty("sgSagGpSetPoint")
    public void setSgSagGpSetPoint(Number sgSagGpSetPoint) {
        this.sgSagGpSetPoint = sgSagGpSetPoint;
    }

    @JsonProperty("sgSpotWithSg")
    public Number getSgSpotWithSg() {
        return sgSpotWithSg;
    }

    @JsonProperty("sgSpotWithSg")
    public void setSgSpotWithSg(Number sgSpotWithSg) {
        this.sgSpotWithSg = sgSpotWithSg;
    }

    @JsonProperty("sgMotorCurrent")
    public Number getSgMotorCurrent() {
        return sgMotorCurrent;
    }

    @JsonProperty("sgMotorCurrent")
    public void setSgMotorCurrent(Number sgMotorCurrent) {
        this.sgMotorCurrent = sgMotorCurrent;
    }

    @JsonProperty("sgMotorTemp")
    public Number getSgMotorTemp() {
        return sgMotorTemp;
    }

    @JsonProperty("sgMotorTemp")
    public void setSgMotorTemp(Number sgMotorTemp) {
        this.sgMotorTemp = sgMotorTemp;
    }

    @JsonProperty("sgForce")
    public Number getSgForce() {
        return sgForce;
    }

    @JsonProperty("sgForce")
    public void setSgForce(Number sgForce) {
        this.sgForce = sgForce;
    }

    @JsonProperty("sgSheetThickness")
    public Number getSgSheetThickness() {
        return sgSheetThickness;
    }

    @JsonProperty("sgSheetThickness")
    public void setSgSheetThickness(Number sgSheetThickness) {
        this.sgSheetThickness = sgSheetThickness;
    }

    @JsonProperty("sgSagGp")
    public Number getSgSagGp() {
        return sgSagGp;
    }

    @JsonProperty("sgSagGp")
    public void setSgSagGp(Number sgSagGp) {
        this.sgSagGp = sgSagGp;
    }

    @JsonProperty("sgSagGc")
    public Number getSgSagGc() {
        return sgSagGc;
    }

    @JsonProperty("sgSagGc")
    public void setSgSagGc(Number sgSagGc) {
        this.sgSagGc = sgSagGc;
    }

    @JsonProperty("regUsrUspJunction")
    public Number getRegUsrUspJunction() {
        return regUsrUspJunction;
    }

    @JsonProperty("regUsrUspJunction")
    public void setRegUsrUspJunction(Number regUsrUspJunction) {
        this.regUsrUspJunction = regUsrUspJunction;
    }

    @JsonProperty("regUsrUspMax")
    public Number getRegUsrUspMax() {
        return regUsrUspMax;
    }

    @JsonProperty("regUsrUspMax")
    public void setRegUsrUspMax(Number regUsrUspMax) {
        this.regUsrUspMax = regUsrUspMax;
    }

    @JsonProperty("regSpotDiaActual")
    public Number getRegSpotDiaActual() {
        return regSpotDiaActual;
    }

    @JsonProperty("regSpotDiaActual")
    public void setRegSpotDiaActual(Number regSpotDiaActual) {
        this.regSpotDiaActual = regSpotDiaActual;
    }

    @JsonProperty("regSpotDiaMinDemand")
    public Number getRegSpotDiaMinDemand() {
        return regSpotDiaMinDemand;
    }

    @JsonProperty("regSpotDiaMinDemand")
    public void setRegSpotDiaMinDemand(Number regSpotDiaMinDemand) {
        this.regSpotDiaMinDemand = regSpotDiaMinDemand;
    }

    @JsonProperty("regSplashTime")
    public Number getRegSplashTime() {
        return regSplashTime;
    }

    @JsonProperty("regSplashTime")
    public void setRegSplashTime(Number regSplashTime) {
        this.regSplashTime = regSplashTime;
    }

    @JsonProperty("nuggetDiameter")
    public Number getNuggetDiameter() {
        return nuggetDiameter;
    }

    @JsonProperty("nuggetDiameter")
    public void setNuggetDiameter(Number nuggetDiameter) {
        this.nuggetDiameter = nuggetDiameter;
    }

    @JsonProperty("usp")
    public Number getUsp() {
        return usp;
    }

    @JsonProperty("usp")
    public void setUsp(Number usp) {
        this.usp = usp;
    }

    @JsonProperty("normingTime")
    public Number getNormingTime() {
        return normingTime;
    }

    @JsonProperty("normingTime")
    public void setNormingTime(Number normingTime) {
        this.normingTime = normingTime;
    }

    @JsonProperty("regulationStartTime")
    public Number getRegulationStartTime() {
        return regulationStartTime;
    }

    @JsonProperty("regulationStartTime")
    public void setRegulationStartTime(Number regulationStartTime) {
        this.regulationStartTime = regulationStartTime;
    }

    @JsonProperty("returnToConstantCurrent")
    public Number getReturnToConstantCurrent() {
        return returnToConstantCurrent;
    }

    @JsonProperty("returnToConstantCurrent")
    public void setReturnToConstantCurrent(Number returnToConstantCurrent) {
        this.returnToConstantCurrent = returnToConstantCurrent;
    }

    @JsonProperty("declineUsp")
    public Number getDeclineUsp() {
        return declineUsp;
    }

    @JsonProperty("declineUsp")
    public void setDeclineUsp(Number declineUsp) {
        this.declineUsp = declineUsp;
    }

    @JsonProperty("offsetUsp")
    public Number getOffsetUsp() {
        return offsetUsp;
    }

    @JsonProperty("offsetUsp")
    public void setOffsetUsp(Number offsetUsp) {
        this.offsetUsp = offsetUsp;
    }

    @JsonProperty("currentFactor")
    public Number getCurrentFactor() {
        return currentFactor;
    }

    @JsonProperty("currentFactor")
    public void setCurrentFactor(Number currentFactor) {
        this.currentFactor = currentFactor;
    }

    @JsonProperty("triggerTime")
    public Number getTriggerTime() {
        return triggerTime;
    }

    @JsonProperty("triggerTime")
    public void setTriggerTime(Number triggerTime) {
        this.triggerTime = triggerTime;
    }

    @JsonProperty("xqrMeasuringActive")
    public Number getXqrMeasuringActive() {
        return xqrMeasuringActive;
    }

    @JsonProperty("xqrMeasuringActive")
    public void setXqrMeasuringActive(Number xqrMeasuringActive) {
        this.xqrMeasuringActive = xqrMeasuringActive;
    }

    @JsonProperty("xqrRegulationActive")
    public Number getXqrRegulationActive() {
        return xqrRegulationActive;
    }

    @JsonProperty("xqrRegulationActive")
    public void setXqrRegulationActive(Number xqrRegulationActive) {
        this.xqrRegulationActive = xqrRegulationActive;
    }

    @JsonProperty("xqrMonitoringActive")
    public Number getXqrMonitoringActive() {
        return xqrMonitoringActive;
    }

    @JsonProperty("xqrMonitoringActive")
    public void setXqrMonitoringActive(Number xqrMonitoringActive) {
        this.xqrMonitoringActive = xqrMonitoringActive;
    }

    @JsonProperty("xqrWeldTimeProlongationActive")
    public Number getXqrWeldTimeProlongationActive() {
        return xqrWeldTimeProlongationActive;
    }

    @JsonProperty("xqrWeldTimeProlongationActive")
    public void setXqrWeldTimeProlongationActive(Number xqrWeldTimeProlongationActive) {
        this.xqrWeldTimeProlongationActive = xqrWeldTimeProlongationActive;
    }

    @JsonProperty("voltageActualValue")
    public Double getVoltageActualValue() {
        return voltageActualValue;
    }

    @JsonProperty("voltageActualValue")
    public void setVoltageActualValue(Double voltageActualValue) {
        this.voltageActualValue = voltageActualValue;
    }

    @JsonProperty("voltageRefValue")
    public Double getVoltageRefValue() {
        return voltageRefValue;
    }

    @JsonProperty("voltageRefValue")
    public void setVoltageRefValue(Double voltageRefValue) {
        this.voltageRefValue = voltageRefValue;
    }

    @JsonProperty("currentActualValue")
    public Double getCurrentActualValue() {
        return currentActualValue;
    }

    @JsonProperty("currentActualValue")
    public void setCurrentActualValue(Double currentActualValue) {
        this.currentActualValue = currentActualValue;
    }

    @JsonProperty("currentReferenceValue")
    public Double getCurrentReferenceValue() {
        return currentReferenceValue;
    }

    @JsonProperty("currentReferenceValue")
    public void setCurrentReferenceValue(Double currentReferenceValue) {
        this.currentReferenceValue = currentReferenceValue;
    }

    @JsonProperty("weldTimeActualValue")
    public Number getWeldTimeActualValue() {
        return weldTimeActualValue;
    }

    @JsonProperty("weldTimeActualValue")
    public void setWeldTimeActualValue(Number weldTimeActualValue) {
        this.weldTimeActualValue = weldTimeActualValue;
    }

    @JsonProperty("weldTimeRefValue")
    public Number getWeldTimeRefValue() {
        return weldTimeRefValue;
    }

    @JsonProperty("weldTimeRefValue")
    public void setWeldTimeRefValue(Number weldTimeRefValue) {
        this.weldTimeRefValue = weldTimeRefValue;
    }

    @JsonProperty("energyActualValue")
    public Double getEnergyActualValue() {
        return energyActualValue;
    }

    @JsonProperty("energyActualValue")
    public void setEnergyActualValue(Double energyActualValue) {
        this.energyActualValue = energyActualValue;
    }

    @JsonProperty("energyRefValue")
    public Number getEnergyRefValue() {
        return energyRefValue;
    }

    @JsonProperty("energyRefValue")
    public void setEnergyRefValue(Number energyRefValue) {
        this.energyRefValue = energyRefValue;
    }

    @JsonProperty("powerActualValue")
    public Double getPowerActualValue() {
        return powerActualValue;
    }

    @JsonProperty("powerActualValue")
    public void setPowerActualValue(Double powerActualValue) {
        this.powerActualValue = powerActualValue;
    }

    @JsonProperty("powerRefValue")
    public Double getPowerRefValue() {
        return powerRefValue;
    }

    @JsonProperty("powerRefValue")
    public void setPowerRefValue(Double powerRefValue) {
        this.powerRefValue = powerRefValue;
    }

    @JsonProperty("resistanceActualValue")
    public Number getResistanceActualValue() {
        return resistanceActualValue;
    }

    @JsonProperty("resistanceActualValue")
    public void setResistanceActualValue(Number resistanceActualValue) {
        this.resistanceActualValue = resistanceActualValue;
    }

    @JsonProperty("resistanceRefValue")
    public Number getResistanceRefValue() {
        return resistanceRefValue;
    }

    @JsonProperty("resistanceRefValue")
    public void setResistanceRefValue(Number resistanceRefValue) {
        this.resistanceRefValue = resistanceRefValue;
    }

    @JsonProperty("pulseWidthActualValue")
    public Double getPulseWidthActualValue() {
        return pulseWidthActualValue;
    }

    @JsonProperty("pulseWidthActualValue")
    public void setPulseWidthActualValue(Double pulseWidthActualValue) {
        this.pulseWidthActualValue = pulseWidthActualValue;
    }

    @JsonProperty("pulseWidthRefValue")
    public Double getPulseWidthRefValue() {
        return pulseWidthRefValue;
    }

    @JsonProperty("pulseWidthRefValue")
    public void setPulseWidthRefValue(Double pulseWidthRefValue) {
        this.pulseWidthRefValue = pulseWidthRefValue;
    }

    @JsonProperty("stabilisationFactorActValue")
    public Number getStabilisationFactorActValue() {
        return stabilisationFactorActValue;
    }

    @JsonProperty("stabilisationFactorActValue")
    public void setStabilisationFactorActValue(Number stabilisationFactorActValue) {
        this.stabilisationFactorActValue = stabilisationFactorActValue;
    }

    @JsonProperty("stabilisationFactorRefValue")
    public Number getStabilisationFactorRefValue() {
        return stabilisationFactorRefValue;
    }

    @JsonProperty("stabilisationFactorRefValue")
    public void setStabilisationFactorRefValue(Number stabilisationFactorRefValue) {
        this.stabilisationFactorRefValue = stabilisationFactorRefValue;
    }

    @JsonProperty("thresholdStabilisationFactor")
    public Number getThresholdStabilisationFactor() {
        return thresholdStabilisationFactor;
    }

    @JsonProperty("thresholdStabilisationFactor")
    public void setThresholdStabilisationFactor(Number thresholdStabilisationFactor) {
        this.thresholdStabilisationFactor = thresholdStabilisationFactor;
    }

    @JsonProperty("wldEffectStabilisationFactor")
    public Number getWldEffectStabilisationFactor() {
        return wldEffectStabilisationFactor;
    }

    @JsonProperty("wldEffectStabilisationFactor")
    public void setWldEffectStabilisationFactor(Number wldEffectStabilisationFactor) {
        this.wldEffectStabilisationFactor = wldEffectStabilisationFactor;
    }

    @JsonProperty("uipActualValue")
    public Number getUipActualValue() {
        return uipActualValue;
    }

    @JsonProperty("uipActualValue")
    public void setUipActualValue(Number uipActualValue) {
        this.uipActualValue = uipActualValue;
    }

    @JsonProperty("uipRefValue")
    public Number getUipRefValue() {
        return uipRefValue;
    }

    @JsonProperty("uipRefValue")
    public void setUipRefValue(Number uipRefValue) {
        this.uipRefValue = uipRefValue;
    }

    @JsonProperty("uirExpulsionTime")
    public Number getUirExpulsionTime() {
        return uirExpulsionTime;
    }

    @JsonProperty("uirExpulsionTime")
    public void setUirExpulsionTime(Number uirExpulsionTime) {
        this.uirExpulsionTime = uirExpulsionTime;
    }

    @JsonProperty("uirMeasuringActive")
    public Number getUirMeasuringActive() {
        return uirMeasuringActive;
    }

    @JsonProperty("uirMeasuringActive")
    public void setUirMeasuringActive(Number uirMeasuringActive) {
        this.uirMeasuringActive = uirMeasuringActive;
    }

    @JsonProperty("uirRegulationActive")
    public Number getUirRegulationActive() {
        return uirRegulationActive;
    }

    @JsonProperty("uirRegulationActive")
    public void setUirRegulationActive(Number uirRegulationActive) {
        this.uirRegulationActive = uirRegulationActive;
    }

    @JsonProperty("uirMonitoringActive")
    public Number getUirMonitoringActive() {
        return uirMonitoringActive;
    }

    @JsonProperty("uirMonitoringActive")
    public void setUirMonitoringActive(Number uirMonitoringActive) {
        this.uirMonitoringActive = uirMonitoringActive;
    }

    @JsonProperty("uirWeldTimeProlongationActive")
    public Number getUirWeldTimeProlongationActive() {
        return uirWeldTimeProlongationActive;
    }

    @JsonProperty("uirWeldTimeProlongationActive")
    public void setUirWeldTimeProlongationActive(Number uirWeldTimeProlongationActive) {
        this.uirWeldTimeProlongationActive = uirWeldTimeProlongationActive;
    }

    @JsonProperty("uirQStoppRefCntValue")
    public Number getUirQStoppRefCntValue() {
        return uirQStoppRefCntValue;
    }

    @JsonProperty("uirQStoppRefCntValue")
    public void setUirQStoppRefCntValue(Number uirQStoppRefCntValue) {
        this.uirQStoppRefCntValue = uirQStoppRefCntValue;
    }

    @JsonProperty("uirQStoppActCntValue")
    public Number getUirQStoppActCntValue() {
        return uirQStoppActCntValue;
    }

    @JsonProperty("uirQStoppActCntValue")
    public void setUirQStoppActCntValue(Number uirQStoppActCntValue) {
        this.uirQStoppActCntValue = uirQStoppActCntValue;
    }

    @JsonProperty("uirUipUpperTol")
    public Number getUirUipUpperTol() {
        return uirUipUpperTol;
    }

    @JsonProperty("uirUipUpperTol")
    public void setUirUipUpperTol(Number uirUipUpperTol) {
        this.uirUipUpperTol = uirUipUpperTol;
    }

    @JsonProperty("uirUipLowerTol")
    public Number getUirUipLowerTol() {
        return uirUipLowerTol;
    }

    @JsonProperty("uirUipLowerTol")
    public void setUirUipLowerTol(Number uirUipLowerTol) {
        this.uirUipLowerTol = uirUipLowerTol;
    }

    @JsonProperty("uirUipCondTol")
    public Number getUirUipCondTol() {
        return uirUipCondTol;
    }

    @JsonProperty("uirUipCondTol")
    public void setUirUipCondTol(Number uirUipCondTol) {
        this.uirUipCondTol = uirUipCondTol;
    }

    @JsonProperty("uirPsfLowerTol")
    public Number getUirPsfLowerTol() {
        return uirPsfLowerTol;
    }

    @JsonProperty("uirPsfLowerTol")
    public void setUirPsfLowerTol(Number uirPsfLowerTol) {
        this.uirPsfLowerTol = uirPsfLowerTol;
    }

    @JsonProperty("uirPsfCondTol")
    public Number getUirPsfCondTol() {
        return uirPsfCondTol;
    }

    @JsonProperty("uirPsfCondTol")
    public void setUirPsfCondTol(Number uirPsfCondTol) {
        this.uirPsfCondTol = uirPsfCondTol;
    }

    @JsonProperty("weldSpotCustDataP16_1")
    public Number getWeldSpotCustDataP161() {
        return weldSpotCustDataP161;
    }

    @JsonProperty("weldSpotCustDataP16_1")
    public void setWeldSpotCustDataP161(Number weldSpotCustDataP161) {
        this.weldSpotCustDataP161 = weldSpotCustDataP161;
    }

    @JsonProperty("weldSpotCustDataP16_2")
    public Number getWeldSpotCustDataP162() {
        return weldSpotCustDataP162;
    }

    @JsonProperty("weldSpotCustDataP16_2")
    public void setWeldSpotCustDataP162(Number weldSpotCustDataP162) {
        this.weldSpotCustDataP162 = weldSpotCustDataP162;
    }

    @JsonProperty("weldSpotCustDataP16_3")
    public Number getWeldSpotCustDataP163() {
        return weldSpotCustDataP163;
    }

    @JsonProperty("weldSpotCustDataP16_3")
    public void setWeldSpotCustDataP163(Number weldSpotCustDataP163) {
        this.weldSpotCustDataP163 = weldSpotCustDataP163;
    }

    @JsonProperty("weldSpotCustDataP16_4")
    public Number getWeldSpotCustDataP164() {
        return weldSpotCustDataP164;
    }

    @JsonProperty("weldSpotCustDataP16_4")
    public void setWeldSpotCustDataP164(Number weldSpotCustDataP164) {
        this.weldSpotCustDataP164 = weldSpotCustDataP164;
    }

    @JsonProperty("weldSpotCustDataP16_5")
    public Number getWeldSpotCustDataP165() {
        return weldSpotCustDataP165;
    }

    @JsonProperty("weldSpotCustDataP16_5")
    public void setWeldSpotCustDataP165(Number weldSpotCustDataP165) {
        this.weldSpotCustDataP165 = weldSpotCustDataP165;
    }

    @JsonProperty("weldSpotCustDataP32_6")
    public Number getWeldSpotCustDataP326() {
        return weldSpotCustDataP326;
    }

    @JsonProperty("weldSpotCustDataP32_6")
    public void setWeldSpotCustDataP326(Number weldSpotCustDataP326) {
        this.weldSpotCustDataP326 = weldSpotCustDataP326;
    }

    @JsonProperty("weldSpotCustDataP16_7")
    public Number getWeldSpotCustDataP167() {
        return weldSpotCustDataP167;
    }

    @JsonProperty("weldSpotCustDataP16_7")
    public void setWeldSpotCustDataP167(Number weldSpotCustDataP167) {
        this.weldSpotCustDataP167 = weldSpotCustDataP167;
    }

    @JsonProperty("weldSpotCustDataP16_8")
    public Number getWeldSpotCustDataP168() {
        return weldSpotCustDataP168;
    }

    @JsonProperty("weldSpotCustDataP16_8")
    public void setWeldSpotCustDataP168(Number weldSpotCustDataP168) {
        this.weldSpotCustDataP168 = weldSpotCustDataP168;
    }

    @JsonProperty("weldSpotCustDataP16_9")
    public Number getWeldSpotCustDataP169() {
        return weldSpotCustDataP169;
    }

    @JsonProperty("weldSpotCustDataP16_9")
    public void setWeldSpotCustDataP169(Number weldSpotCustDataP169) {
        this.weldSpotCustDataP169 = weldSpotCustDataP169;
    }

    @JsonProperty("weldSpotCustDataP16_10")
    public Number getWeldSpotCustDataP1610() {
        return weldSpotCustDataP1610;
    }

    @JsonProperty("weldSpotCustDataP16_10")
    public void setWeldSpotCustDataP1610(Number weldSpotCustDataP1610) {
        this.weldSpotCustDataP1610 = weldSpotCustDataP1610;
    }

    @JsonProperty("weldSpotCustDataP16_11")
    public Number getWeldSpotCustDataP1611() {
        return weldSpotCustDataP1611;
    }

    @JsonProperty("weldSpotCustDataP16_11")
    public void setWeldSpotCustDataP1611(Number weldSpotCustDataP1611) {
        this.weldSpotCustDataP1611 = weldSpotCustDataP1611;
    }

    @JsonProperty("weldSpotCustDataP32_12")
    public Number getWeldSpotCustDataP3212() {
        return weldSpotCustDataP3212;
    }

    @JsonProperty("weldSpotCustDataP32_12")
    public void setWeldSpotCustDataP3212(Number weldSpotCustDataP3212) {
        this.weldSpotCustDataP3212 = weldSpotCustDataP3212;
    }

    @JsonProperty("weldSpotCustDataP16_13")
    public Number getWeldSpotCustDataP1613() {
        return weldSpotCustDataP1613;
    }

    @JsonProperty("weldSpotCustDataP16_13")
    public void setWeldSpotCustDataP1613(Number weldSpotCustDataP1613) {
        this.weldSpotCustDataP1613 = weldSpotCustDataP1613;
    }

    @JsonProperty("weldSpotCustDataP16_14")
    public Number getWeldSpotCustDataP1614() {
        return weldSpotCustDataP1614;
    }

    @JsonProperty("weldSpotCustDataP16_14")
    public void setWeldSpotCustDataP1614(Number weldSpotCustDataP1614) {
        this.weldSpotCustDataP1614 = weldSpotCustDataP1614;
    }

    @JsonProperty("weldSpotCustDataP16_15")
    public Number getWeldSpotCustDataP1615() {
        return weldSpotCustDataP1615;
    }

    @JsonProperty("weldSpotCustDataP16_15")
    public void setWeldSpotCustDataP1615(Number weldSpotCustDataP1615) {
        this.weldSpotCustDataP1615 = weldSpotCustDataP1615;
    }

    @JsonProperty("weldSpotCustDataP16_16")
    public Number getWeldSpotCustDataP1616() {
        return weldSpotCustDataP1616;
    }

    @JsonProperty("weldSpotCustDataP16_16")
    public void setWeldSpotCustDataP1616(Number weldSpotCustDataP1616) {
        this.weldSpotCustDataP1616 = weldSpotCustDataP1616;
    }

    @JsonProperty("weldSpotCustDataP16_17")
    public Number getWeldSpotCustDataP1617() {
        return weldSpotCustDataP1617;
    }

    @JsonProperty("weldSpotCustDataP16_17")
    public void setWeldSpotCustDataP1617(Number weldSpotCustDataP1617) {
        this.weldSpotCustDataP1617 = weldSpotCustDataP1617;
    }

    @JsonProperty("weldSpotCustDataP32_18")
    public Number getWeldSpotCustDataP3218() {
        return weldSpotCustDataP3218;
    }

    @JsonProperty("weldSpotCustDataP32_18")
    public void setWeldSpotCustDataP3218(Number weldSpotCustDataP3218) {
        this.weldSpotCustDataP3218 = weldSpotCustDataP3218;
    }

    @JsonProperty("uipMonCondUpperTol")
    public Number getUipMonCondUpperTol() {
        return uipMonCondUpperTol;
    }

    @JsonProperty("uipMonCondUpperTol")
    public void setUipMonCondUpperTol(Number uipMonCondUpperTol) {
        this.uipMonCondUpperTol = uipMonCondUpperTol;
    }

    @JsonProperty("fqfActualValue")
    public Number getFqfActualValue() {
        return fqfActualValue;
    }

    @JsonProperty("fqfActualValue")
    public void setFqfActualValue(Number fqfActualValue) {
        this.fqfActualValue = fqfActualValue;
    }

    @JsonProperty("fqfRefValue")
    public Number getFqfRefValue() {
        return fqfRefValue;
    }

    @JsonProperty("fqfRefValue")
    public void setFqfRefValue(Number fqfRefValue) {
        this.fqfRefValue = fqfRefValue;
    }

    @JsonProperty("fqfMonUpperTol")
    public Number getFqfMonUpperTol() {
        return fqfMonUpperTol;
    }

    @JsonProperty("fqfMonUpperTol")
    public void setFqfMonUpperTol(Number fqfMonUpperTol) {
        this.fqfMonUpperTol = fqfMonUpperTol;
    }

    @JsonProperty("fqfMonLowerTol")
    public Number getFqfMonLowerTol() {
        return fqfMonLowerTol;
    }

    @JsonProperty("fqfMonLowerTol")
    public void setFqfMonLowerTol(Number fqfMonLowerTol) {
        this.fqfMonLowerTol = fqfMonLowerTol;
    }

    @JsonProperty("fqfMonCondUpperTol")
    public Number getFqfMonCondUpperTol() {
        return fqfMonCondUpperTol;
    }

    @JsonProperty("fqfMonCondUpperTol")
    public void setFqfMonCondUpperTol(Number fqfMonCondUpperTol) {
        this.fqfMonCondUpperTol = fqfMonCondUpperTol;
    }

    @JsonProperty("fqfMonCondLowerTol")
    public Number getFqfMonCondLowerTol() {
        return fqfMonCondLowerTol;
    }

    @JsonProperty("fqfMonCondLowerTol")
    public void setFqfMonCondLowerTol(Number fqfMonCondLowerTol) {
        this.fqfMonCondLowerTol = fqfMonCondLowerTol;
    }

    @JsonProperty("fqfMeasuringActive")
    public Number getFqfMeasuringActive() {
        return fqfMeasuringActive;
    }

    @JsonProperty("fqfMeasuringActive")
    public void setFqfMeasuringActive(Number fqfMeasuringActive) {
        this.fqfMeasuringActive = fqfMeasuringActive;
    }

    @JsonProperty("xqrModeOff")
    public Number getXqrModeOff() {
        return xqrModeOff;
    }

    @JsonProperty("xqrModeOff")
    public void setXqrModeOff(Number xqrModeOff) {
        this.xqrModeOff = xqrModeOff;
    }

    @JsonProperty("reweldActive")
    public Number getReweldActive() {
        return reweldActive;
    }

    @JsonProperty("reweldActive")
    public void setReweldActive(Number reweldActive) {
        this.reweldActive = reweldActive;
    }

    @JsonProperty("weldspotRefIdent")
    public String getWeldspotRefIdent() {
        return weldspotRefIdent;
    }

    @JsonProperty("weldspotRefIdent")
    public void setWeldspotRefIdent(String weldspotRefIdent) {
        this.weldspotRefIdent = weldspotRefIdent;
    }

    @JsonProperty("sg_Torque_Gp")
    public Number getSgTorqueGp() {
        return sgTorqueGp;
    }

    @JsonProperty("sg_Torque_Gp")
    public void setSgTorqueGp(Number sgTorqueGp) {
        this.sgTorqueGp = sgTorqueGp;
    }

    @JsonProperty("sg_Force_Corr")
    public Number getSgForceCorr() {
        return sgForceCorr;
    }

    @JsonProperty("sg_Force_Corr")
    public void setSgForceCorr(Number sgForceCorr) {
        this.sgForceCorr = sgForceCorr;
    }

    @JsonProperty("sg_Weldspot_Geo_Wear")
    public Number getSgWeldspotGeoWear() {
        return sgWeldspotGeoWear;
    }

    @JsonProperty("sg_Weldspot_Geo_Wear")
    public void setSgWeldspotGeoWear(Number sgWeldspotGeoWear) {
        this.sgWeldspotGeoWear = sgWeldspotGeoWear;
    }

    @JsonProperty("sg_Wear_Length")
    public Number getSgWearLength() {
        return sgWearLength;
    }

    @JsonProperty("sg_Wear_Length")
    public void setSgWearLength(Number sgWearLength) {
        this.sgWearLength = sgWearLength;
    }

    @JsonProperty("sg_Beam_UpArching")
    public Number getSgBeamUpArching() {
        return sgBeamUpArching;
    }

    @JsonProperty("sg_Beam_UpArching")
    public void setSgBeamUpArching(Number sgBeamUpArching) {
        this.sgBeamUpArching = sgBeamUpArching;
    }

    @JsonProperty("CurrentCurve")
    public List<Number> getCurrentCurve() {
        return currentCurve;
    }

    @JsonProperty("CurrentCurve")
    public void setCurrentCurve(List<Number> currentCurve) {
        this.currentCurve = currentCurve;
    }

    @JsonProperty("VoltageCurve")
    public List<Number> getVoltageCurve() {
        return voltageCurve;
    }

    @JsonProperty("VoltageCurve")
    public void setVoltageCurve(List<Number> voltageCurve) {
        this.voltageCurve = voltageCurve;
    }

    @JsonProperty("ForceCurve")
    public List<Number> getForceCurve() {
        return forceCurve;
    }

    @JsonProperty("ForceCurve")
    public void setForceCurve(List<Number> forceCurve) {
        this.forceCurve = forceCurve;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Number value) {
        this.additionalProperties.put(name, value);
    }

}
