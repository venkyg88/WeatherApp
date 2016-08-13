package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Query {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("created")
    private String created;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("results")
    private Results results;

    /**
     *
     * @return
     * The count
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The created
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The created
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The lang
     */
    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    /**
     *
     * @param lang
     * The lang
     */
    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     *
     * @return
     * The results
     */
    @JsonProperty("results")
    public Results getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
    }
}
