package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Location {


    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("region")
    private String region;

    /**
     *
     * @return
     * The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The region
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     * The region
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

}
