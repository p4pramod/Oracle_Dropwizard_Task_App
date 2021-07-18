package com.oracle.task.mangement.usecase;

import com.oracle.task.mangement.sharedkarnel.BusinessException;

public abstract class AbstractUseCase<P, R> {

    public R execute(P param) {
        try {
            validate(param);
            performBusinessLogic(param);
            return returnOnSuccess(param);
        } catch (RuntimeException exception) {
            return returnOnException(exception, param);
        }

    }

    public abstract void validate(P param) throws BusinessException;

    public abstract void performBusinessLogic(P param);

    public abstract R returnOnException(RuntimeException exception, P param);

    public abstract R returnOnSuccess(P param);
}
