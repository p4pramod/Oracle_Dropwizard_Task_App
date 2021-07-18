package com.oracle.task.mangement.services;

import com.oracle.task.mangement.dao.Task;
import com.oracle.task.mangement.resources.TaskDto;

public class DtoToEntityTransformers {

    public static Task transform(TaskDto taskDto) {
        return new Task(1, taskDto.getRef(), taskDto.getDescription(), taskDto.getCompleteByDate(),
                taskDto.isDone());
    }
}
