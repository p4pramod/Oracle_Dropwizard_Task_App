package com.oracle.task.mangement.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @NotNull
    @JsonProperty
    private int id;

    @NotNull
    @JsonProperty
    private String ref;

    @NotNull
    @JsonProperty
    private String description;


    @NotNull
    @JsonProperty
    private String completeByDate;

    @NotNull
    @JsonProperty
    private boolean done;

}
