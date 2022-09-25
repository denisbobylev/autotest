package model;

import com.fasterxml.jackson.annotation.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {

    @JsonProperty("results")
    public List<ResultsModel> results;

    @JsonProperty("info")
    public InfoModel info;


}
