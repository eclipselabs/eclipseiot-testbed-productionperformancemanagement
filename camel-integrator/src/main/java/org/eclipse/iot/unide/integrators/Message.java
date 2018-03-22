
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
    "WeldLog"
})
public class Message {

    @JsonProperty("WeldLog")
    private WeldLog weldLog;
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
    public Message(WeldLog weldLog) {
        super();
        this.weldLog = weldLog;
    }

    @JsonProperty("WeldLog")
    public WeldLog getWeldLog() {
        return weldLog;
    }

    @JsonProperty("WeldLog")
    public void setWeldLog(WeldLog weldLog) {
        this.weldLog = weldLog;
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
