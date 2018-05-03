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

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Name",
    "WeldTimer",
    "TimeStamp",
    "OutputFormat",
    "Message"
})
public class PSI6000DataType {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("WeldTimer")
    private String weldTimer;
    @JsonProperty("TimeStamp")
    private String timeStamp;
    @JsonProperty("OutputFormat")
    private String outputFormat;
    @JsonProperty("Message")
    private Message message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PSI6000DataType() {
    }

    /**
     * 
     * @param message
     * @param timeStamp
     * @param outputFormat
     * @param weldTimer
     * @param name
     */
    public PSI6000DataType(String name, String weldTimer, String timeStamp, String outputFormat, Message message) {
        super();
        this.name = name;
        this.weldTimer = weldTimer;
        this.timeStamp = timeStamp;
        this.outputFormat = outputFormat;
        this.message = message;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("WeldTimer")
    public String getWeldTimer() {
        return weldTimer;
    }

    @JsonProperty("WeldTimer")
    public void setWeldTimer(String weldTimer) {
        this.weldTimer = weldTimer;
    }

    @JsonProperty("TimeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("TimeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("OutputFormat")
    public String getOutputFormat() {
        return outputFormat;
    }

    @JsonProperty("OutputFormat")
    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    @JsonProperty("Message")
    public Message getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(Message message) {
        this.message = message;
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
