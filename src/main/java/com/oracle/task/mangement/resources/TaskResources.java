package com.oracle.task.mangement.resources;

import com.oracle.task.mangement.dao.Task;
import com.oracle.task.mangement.dao.TaskDao;

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
    public List<Task> getAllEmployees() {
        return this.taskDao.getAll();
    }

    @POST
    public Task addEmployee(@Valid Task task) {
        int employeeID = this.taskDao.addTask(task);
        task.setId(employeeID);
        return task;
    }

    @DELETE
    @Path("/mark-done/{id}")
    public int markDone(@PathParam("id") int id) {
        this.taskDao.completeTask(id);
        return id;
    }
}