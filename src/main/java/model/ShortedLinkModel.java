package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortedLinkModel {

    @JsonProperty("result_url")
    public String resultUrl;

    @JsonProperty("error")
    public String error;

}
