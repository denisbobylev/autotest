package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoModel {

    @JsonProperty("seed")
    public String seed;

    @JsonProperty("results")
    public String results;

    @JsonProperty("page")
    public String page;

    @JsonProperty("version")
    public String version;

}
