package assignment.venkat.com.yahootestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Created by venkatgonuguntala on 8/13/16.
 */

public class Item {

    @JsonProperty("condition")
    private Condition condition;

    /**
     *
     * @return
     * The condition
     */
    @JsonProperty("condition")
    public Condition getCondition() {
        return condition;
    }

    /**
     *
     * @param condition
     * The condition
     */
    @JsonProperty("condition")
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
