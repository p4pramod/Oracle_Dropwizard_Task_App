package com.oracle.task.mangement.usecase.task;

import com.oracle.task.mangement.dao.Task;
import com.oracle.task.mangement.dao.TaskDao;
import com.oracle.task.mangement.resources.TaskDto;
import com.oracle.task.mangement.services.DtoToEntityTransformers;
import com.oracle.task.mangement.services.EntityToDtoTransformers;
import com.oracle.task.mangement.usecase.AbstractUseCase;

public class UserSavesNewTask extends AbstractUseCase<TaskDto, TaskDto> {
    private final TaskDao taskDao;
    private Task task;

    public UserSavesNewTask(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void validate(TaskDto param) {

    }

    @Override
    public void performBusinessLogic(TaskDto param) {
        task = DtoToEntityTransformers.transform(param);
        int i = taskDao.addTask(task);
        task.setId(i);
    }

    @Override
    public TaskDto returnOnException(RuntimeException exception, TaskDto param) {
        throw exception;
    }

    @Override
    public TaskDto returnOnSuccess(TaskDto param) {
        return EntityToDtoTransformers.transform(task);
    }
}
