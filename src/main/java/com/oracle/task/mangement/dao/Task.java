package com.oracle.task.mangement.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @NotNull
    @JsonProperty
    private int id;

    @NotNull
    @JsonProperty
    private String name;

    @NotNull
    @JsonProperty
    private String phoneNumber;


    @NotNull
    @JsonProperty
    private String acronym;

}
