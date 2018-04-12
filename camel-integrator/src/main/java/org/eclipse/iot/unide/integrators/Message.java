
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
    "WeldLog",
    "DataChangeLog"
})
public class Message {

    @JsonProperty("WeldLog")
    private WeldLog weldLog;
    @JsonProperty("DataChangeLog")
    private DataChangeLog dataChangeLog;
    @JsonProperty("WeldFaultLog")
    private WeldFaultLog weldFaultLog;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Message() {
    }

    /**
     * 
     * @param weldLog
     */
    public Message(WeldLog weldLog, DataChangeLog dataChangeLog, WeldFaultLog weldFaultLog) {
        super();
        this.weldLog = weldLog;
        this.dataChangeLog = dataChangeLog;
        this.weldFaultLog = weldFaultLog;
    }

    @JsonProperty("WeldLog")
    public WeldLog getWeldLog() {
        return weldLog;
    }

    @JsonProperty("WeldLog")
    public void setWeldLog(WeldLog weldLog) {
        this.weldLog = weldLog;
    }

    @JsonProperty("DataChangeLog")
    public DataChangeLog getDataChangeLog() {
        return dataChangeLog;
    }

    @JsonProperty("DataChangeLog")
    public void setDataChangeLog(DataChangeLog dataChangeLog) {
        this.dataChangeLog = dataChangeLog;
    }

    @JsonProperty("WeldFaultLog")
    public WeldFaultLog getWeldFaultLog() {
        return weldFaultLog;
    }

    @JsonProperty("WeldFaultLog")
    public void setWeldFaultLog(WeldFaultLog weldFaultLog) {
        this.weldFaultLog = weldFaultLog;
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
