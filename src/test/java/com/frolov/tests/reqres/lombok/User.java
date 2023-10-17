package com.frolov.tests.reqres.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Integer id;
    private String email;
    private String job;
    private String name;

    public User() {
    }

    public User(String firstName, String job) {
        this.firstName = firstName;
        this.job = job;
    }
}