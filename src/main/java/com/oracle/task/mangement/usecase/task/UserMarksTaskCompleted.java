package com.oracle.task.mangement.usecase.task;

import com.oracle.task.mangement.dao.TaskDao;
import com.oracle.task.mangement.usecase.AbstractUseCase;

public class UserMarksTaskCompleted extends AbstractUseCase<Integer, Integer> {
    private final TaskDao taskDao;
    private int returnValue;

    public UserMarksTaskCompleted(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public void validate(Integer param) {

    }

    @Override
    public void performBusinessLogic(Integer param) {
        returnValue = taskDao.completeTask(param);
    }

    @Override
    public Integer returnOnException(RuntimeException exception, Integer param) {
        throw exception;
    }

    @Override
    public Integer returnOnSuccess(Integer param) {
        return returnValue;
    }
}
