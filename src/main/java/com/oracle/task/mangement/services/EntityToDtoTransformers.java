package com.oracle.task.mangement.services;

import com.oracle.task.mangement.dao.Task;
import com.oracle.task.mangement.resources.TaskDto;

public class EntityToDtoTransformers {

    public static TaskDto transform(Task task) {
        return new TaskDto(task.getId(), task.getRef(), task.getDescription(), task.getCompleteByDate(),
                task.isDone());
    }
}
