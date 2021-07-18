package com.oracle.task.mangement.usecase.task;

import com.oracle.task.mangement.dao.Task;
import com.oracle.task.mangement.dao.TaskDao;
import com.oracle.task.mangement.resources.TaskDto;
import com.oracle.task.mangement.services.EntityToDtoTransformers;
import com.oracle.task.mangement.usecase.AbstractUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class UserFetchesAllCompletedTask extends AbstractUseCase<Long, List<TaskDto>> {
    private final TaskDao taskDao;
    private List<Task> allTask;

    public UserFetchesAllCompletedTask(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void validate(Long param) {

    }

    @Override
    public void performBusinessLogic(Long param) {
        allTask = taskDao.getAll();
    }

    @Override
    public List<TaskDto> returnOnException(RuntimeException exception, Long param) {
        throw exception;
    }

    @Override
    public List<TaskDto> returnOnSuccess(Long param) {
        return allTask.stream().map(EntityToDtoTransformers::transform).collect(Collectors.toList());
    }
}
