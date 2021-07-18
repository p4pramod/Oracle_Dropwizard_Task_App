package com.oracle.task.mangement.resources;

import com.oracle.task.mangement.dao.TaskDao;
import com.oracle.task.mangement.usecase.task.UserFetchesAllCompletedTask;
import com.oracle.task.mangement.usecase.task.UserMarksTaskCompleted;
import com.oracle.task.mangement.usecase.task.UserSavesNewTask;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResources {

    private final TaskDao taskDao;

    public TaskResources(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GET
    @Path("/getAll")
    public List<TaskDto> getAllEmployees() {
        return new UserFetchesAllCompletedTask(this.taskDao).execute(1L);
    }

    @POST
    public TaskDto addTask(@Valid TaskDto taskDto) {
        UserSavesNewTask userSavesNewTask = new UserSavesNewTask(taskDao);
        return userSavesNewTask.execute(taskDto);
    }

    @PUT
    @Path("/mark-done/{id}")
    public int markDone(@PathParam("id") int id) {
        return new UserMarksTaskCompleted(this.taskDao).execute(id);
    }
}