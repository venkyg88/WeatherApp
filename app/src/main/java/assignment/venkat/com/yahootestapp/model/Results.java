package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Results {
    @JsonProperty("channel")
    private List<Channel> channel = new ArrayList<Channel>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The channel
     */
    @JsonProperty("channel")
    public List<Channel> getChannel() {
        return channel;
    }

    /**
     *
     * @param channel
     * The channel
     */
    @JsonProperty("channel")
    public void setChannel(List<Channel> channel) {
        this.channel = channel;
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
