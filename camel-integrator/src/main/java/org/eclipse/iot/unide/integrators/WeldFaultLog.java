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
@JsonPropertyOrder({ "dateTime", "protRecord_ID", "timerName", "progNo", "monitorState", "regulationState",
        "measureState", "weldProgValue", "weldActualValue", "timeProgValue", "timeActualValue", "wear", "spotName",
        "isError", "spotDiaDemand", "spotDiaActual", "uspDemand", "uspActual", "stzvDemand", "stzvActual",
        "partIdentString" })
public class WeldFaultLog {

    @JsonProperty("dateTime")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateTime;
    @JsonProperty("protRecord_ID")
    private Integer protRecordID;
    @JsonProperty("timerName")
    private String timerName;
    @JsonProperty("progNo")
    private Integer progNo;
    @JsonProperty("monitorState")
    private Integer monitorState;
    @JsonProperty("regulationState")
    private Integer regulationState;
    @JsonProperty("measureState")
    private Integer measureState;
    @JsonProperty("weldProgValue")
    private Double weldProgValue;
    @JsonProperty("weldActualValue")
    private Double weldActualValue;
    @JsonProperty("timeProgValue")
    private Double timeProgValue;
    @JsonProperty("timeActualValue")
    private Double timeActualValue;
    @JsonProperty("wear")
    private Double wear;
    @JsonProperty("spotName")
    private String spotName;
    @JsonProperty("isError")
    private Boolean isError;
    @JsonProperty("spotDiaDemand")
    private Float spotDiaDemand;
    @JsonProperty("spotDiaActual")
    private Float spotDiaActual;
    @JsonProperty("uspDemand")
    private Double uspDemand;
    @JsonProperty("uspActual")
    private Double uspActual;
    @JsonProperty("stzvDemand")
    private Double stzvDemand;
    @JsonProperty("stzvActual")
    private Double stzvActual;
    @JsonProperty("partIdentString")
    private String partIdentString;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
    * No args constructor for use in serialization
    * 
    */
    public WeldFaultLog() {
    }

    /**
    * 
    * @param stzvDemand
    * @param protRecordID
    * @param monitorState
    * @param weldActualValue
    * @param dateTime
    * @param timeProgValue
    * @param spotName
    * @param spotDiaDemand
    * @param weldProgValue
    * @param regulationState
    * @param stzvActual
    * @param timerName
    * @param progNo
    * @param uspDemand
    * @param measureState
    * @param partIdentString
    * @param uspActual
    * @param spotDiaActual
    * @param timeActualValue
    * @param isError
    * @param wear
    */
    public WeldFaultLog(LocalDateTime dateTime, Integer protRecordID, String timerName, Integer progNo, Integer monitorState,
            Integer regulationState, Integer measureState, Double weldProgValue, Double weldActualValue,
            Double timeProgValue, Double timeActualValue, Double wear, String spotName, Boolean isError,
            Float spotDiaDemand, Float spotDiaActual, Double uspDemand, Double uspActual, Double stzvDemand,
            Double stzvActual, String partIdentString) {
        super();
        this.dateTime = dateTime;
        this.protRecordID = protRecordID;
        this.timerName = timerName;
        this.progNo = progNo;
        this.monitorState = monitorState;
        this.regulationState = regulationState;
        this.measureState = measureState;
        this.weldProgValue = weldProgValue;
        this.weldActualValue = weldActualValue;
        this.timeProgValue = timeProgValue;
        this.timeActualValue = timeActualValue;
        this.wear = wear;
        this.spotName = spotName;
        this.isError = isError;
        this.spotDiaDemand = spotDiaDemand;
        this.spotDiaActual = spotDiaActual;
        this.uspDemand = uspDemand;
        this.uspActual = uspActual;
        this.stzvDemand = stzvDemand;
        this.stzvActual = stzvActual;
        this.partIdentString = partIdentString;
    }

    @JsonProperty("dateTime")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @JsonProperty("dateTime")
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("protRecord_ID")
    public Integer getProtRecordID() {
        return protRecordID;
    }

    @JsonProperty("protRecord_ID")
    public void setProtRecordID(Integer protRecordID) {
        this.protRecordID = protRecordID;
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
    public Integer getProgNo() {
        return progNo;
    }

    @JsonProperty("progNo")
    public void setProgNo(Integer progNo) {
        this.progNo = progNo;
    }

    @JsonProperty("monitorState")
    public Integer getMonitorState() {
        return monitorState;
    }

    @JsonProperty("monitorState")
    public void setMonitorState(Integer monitorState) {
        this.monitorState = monitorState;
    }

    @JsonProperty("regulationState")
    public Integer getRegulationState() {
        return regulationState;
    }

    @JsonProperty("regulationState")
    public void setRegulationState(Integer regulationState) {
        this.regulationState = regulationState;
    }

    @JsonProperty("measureState")
    public Integer getMeasureState() {
        return measureState;
    }

    @JsonProperty("measureState")
    public void setMeasureState(Integer measureState) {
        this.measureState = measureState;
    }

    @JsonProperty("weldProgValue")
    public Double getWeldProgValue() {
        return weldProgValue;
    }

    @JsonProperty("weldProgValue")
    public void setWeldProgValue(Double weldProgValue) {
        this.weldProgValue = weldProgValue;
    }

    @JsonProperty("weldActualValue")
    public Double getWeldActualValue() {
        return weldActualValue;
    }

    @JsonProperty("weldActualValue")
    public void setWeldActualValue(Double weldActualValue) {
        this.weldActualValue = weldActualValue;
    }

    @JsonProperty("timeProgValue")
    public Double getTimeProgValue() {
        return timeProgValue;
    }

    @JsonProperty("timeProgValue")
    public void setTimeProgValue(Double timeProgValue) {
        this.timeProgValue = timeProgValue;
    }

    @JsonProperty("timeActualValue")
    public Double getTimeActualValue() {
        return timeActualValue;
    }

    @JsonProperty("timeActualValue")
    public void setTimeActualValue(Double timeActualValue) {
        this.timeActualValue = timeActualValue;
    }

    @JsonProperty("wear")
    public Double getWear() {
        return wear;
    }

    @JsonProperty("wear")
    public void setWear(Double wear) {
        this.wear = wear;
    }

    @JsonProperty("spotName")
    public String getSpotName() {
        return spotName;
    }

    @JsonProperty("spotName")
    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    @JsonProperty("isError")
    public Boolean getIsError() {
        return isError;
    }

    @JsonProperty("isError")
    public void setIsError(Boolean isError) {
        this.isError = isError;
    }

    @JsonProperty("spotDiaDemand")
    public Float getSpotDiaDemand() {
        return spotDiaDemand;
    }

    @JsonProperty("spotDiaDemand")
    public void setSpotDiaDemand(Float spotDiaDemand) {
        this.spotDiaDemand = spotDiaDemand;
    }

    @JsonProperty("spotDiaActual")
    public Float getSpotDiaActual() {
        return spotDiaActual;
    }

    @JsonProperty("spotDiaActual")
    public void setSpotDiaActual(Float spotDiaActual) {
        this.spotDiaActual = spotDiaActual;
    }

    @JsonProperty("uspDemand")
    public Double getUspDemand() {
        return uspDemand;
    }

    @JsonProperty("uspDemand")
    public void setUspDemand(Double uspDemand) {
        this.uspDemand = uspDemand;
    }

    @JsonProperty("uspActual")
    public Double getUspActual() {
        return uspActual;
    }

    @JsonProperty("uspActual")
    public void setUspActual(Double uspActual) {
        this.uspActual = uspActual;
    }

    @JsonProperty("stzvDemand")
    public Double getStzvDemand() {
        return stzvDemand;
    }

    @JsonProperty("stzvDemand")
    public void setStzvDemand(Double stzvDemand) {
        this.stzvDemand = stzvDemand;
    }

    @JsonProperty("stzvActual")
    public Double getStzvActual() {
        return stzvActual;
    }

    @JsonProperty("stzvActual")
    public void setStzvActual(Double stzvActual) {
        this.stzvActual = stzvActual;
    }

    @JsonProperty("partIdentString")
    public String getPartIdentString() {
        return partIdentString;
    }

    @JsonProperty("partIdentString")
    public void setPartIdentString(String partIdentString) {
        this.partIdentString = partIdentString;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}