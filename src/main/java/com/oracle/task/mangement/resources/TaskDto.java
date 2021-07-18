package com.oracle.task.mangement.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDto {

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
    private boolean isDone;
}
