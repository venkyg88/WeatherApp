package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Condition {
    @JsonProperty("code")
    private String code;
    @JsonProperty("date")
    private String date;
    @JsonProperty("temp")
    private String temp;
    @JsonProperty("text")
    private String text;

    /**
     *
     * @return
     * The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The date
     */
    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     * The date
     */
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return
     * The temp
     */
    @JsonProperty("temp")
    public String getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     * The temp
     */
    @JsonProperty("temp")
    public void setTemp(String temp) {
        this.temp = temp;
    }

    /**
     *
     * @return
     * The text
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     * The text
     */
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }


}
