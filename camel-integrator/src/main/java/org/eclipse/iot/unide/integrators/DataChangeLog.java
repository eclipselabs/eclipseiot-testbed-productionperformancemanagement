
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
@JsonPropertyOrder({ "timerName", "protRecord_ID", "dateTime", "param_ID", "subIndex", "oldValue", "newValue",
		"oldNormValue", "newNormValue", "physicalUnitId", "computerName", "userName", "comment" })
public class DataChangeLog {

	@JsonProperty("timerName")
	private String timerName;
	@JsonProperty("protRecord_ID")
	private Double protRecordID;
	@JsonProperty("dateTime")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateTime;
	@JsonProperty("param_ID")
	private Integer paramID;
	@JsonProperty("subIndex")
	private Integer subIndex;
	@JsonProperty("oldValue")
	private String oldValue;
	@JsonProperty("newValue")
	private String newValue;
	@JsonProperty("oldNormValue")
	private String oldNormValue;
	@JsonProperty("newNormValue")
	private String newNormValue;
	@JsonProperty("physicalUnitId")
	private Integer physicalUnitId;
	@JsonProperty("computerName")
	private String computerName;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("comment")
	private String comment;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public DataChangeLog() {
	}

	/**
	 * 
	 * @param newNormValue
	 * @param protRecordID
	 * @param timerName
	 * @param subIndex
	 * @param newValue
	 * @param dateTime
	 * @param oldNormValue
	 * @param userName
	 * @param computerName
	 * @param oldValue
	 * @param paramID
	 * @param comment
	 * @param physicalUnitId
	 */
	public DataChangeLog(String timerName, Double protRecordID, LocalDateTime dateTime, Integer paramID,
			Integer subIndex, String oldValue, String newValue, String oldNormValue, String newNormValue,
			Integer physicalUnitId, String computerName, String userName, String comment) {
		super();
		this.timerName = timerName;
		this.protRecordID = protRecordID;
		this.dateTime = dateTime;
		this.paramID = paramID;
		this.subIndex = subIndex;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.oldNormValue = oldNormValue;
		this.newNormValue = newNormValue;
		this.physicalUnitId = physicalUnitId;
		this.computerName = computerName;
		this.userName = userName;
		this.comment = comment;
	}

	@JsonProperty("timerName")
	public String getTimerName() {
		return timerName;
	}

	@JsonProperty("timerName")
	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}

	@JsonProperty("protRecord_ID")
	public Double getProtRecordID() {
		return protRecordID;
	}

	@JsonProperty("protRecord_ID")
	public void setProtRecordID(Double protRecordID) {
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

	@JsonProperty("param_ID")
	public Integer getParamID() {
		return paramID;
	}

	@JsonProperty("param_ID")
	public void setParamID(Integer paramID) {
		this.paramID = paramID;
	}

	@JsonProperty("subIndex")
	public Integer getSubIndex() {
		return subIndex;
	}

	@JsonProperty("subIndex")
	public void setSubIndex(Integer subIndex) {
		this.subIndex = subIndex;
	}

	@JsonProperty("oldValue")
	public String getOldValue() {
		return oldValue;
	}

	@JsonProperty("oldValue")
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	@JsonProperty("newValue")
	public String getNewValue() {
		return newValue;
	}

	@JsonProperty("newValue")
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	@JsonProperty("oldNormValue")
	public String getOldNormValue() {
		return oldNormValue;
	}

	@JsonProperty("oldNormValue")
	public void setOldNormValue(String oldNormValue) {
		this.oldNormValue = oldNormValue;
	}

	@JsonProperty("newNormValue")
	public String getNewNormValue() {
		return newNormValue;
	}

	@JsonProperty("newNormValue")
	public void setNewNormValue(String newNormValue) {
		this.newNormValue = newNormValue;
	}

	@JsonProperty("physicalUnitId")
	public Integer getPhysicalUnitId() {
		return physicalUnitId;
	}

	@JsonProperty("physicalUnitId")
	public void setPhysicalUnitId(Integer physicalUnitId) {
		this.physicalUnitId = physicalUnitId;
	}

	@JsonProperty("computerName")
	public String getComputerName() {
		return computerName;
	}

	@JsonProperty("computerName")
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
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
