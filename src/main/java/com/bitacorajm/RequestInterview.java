package com.bitacorajm;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author juan
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"text"
})
public class RequestInterview {

    @JsonProperty("text")
    private char[] text;

    @JsonProperty("text")
    public char[] getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(char[] text) {
        this.text = text;
    }

}
