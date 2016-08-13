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

public class Weather {

    @JsonProperty("query")
    private Query query;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The query
     */
    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
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
