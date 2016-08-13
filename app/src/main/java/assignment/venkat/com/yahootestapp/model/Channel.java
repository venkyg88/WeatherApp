package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Channel {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("item")
    private Item item;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The location
     */
    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The item
     */
    @JsonProperty("item")
    public Item getItem() {
        return item;
    }

    /**
     *
     * @param item
     * The item
     */
    @JsonProperty("item")
    public void setItem(Item item) {
        this.item = item;
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
