package com.oracle.task.mangement;

import com.oracle.task.mangement.dao.TaskDao;
import com.oracle.task.mangement.resources.TaskResources;
import com.oracle.task.mangement.sharedkarnel.AppExceptionMapper;
import com.oracle.task.mangement.sharedkarnel.TemplateHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class TaskManagementApplication extends Application<TaskManagementConfiguration> {

    public static void main(String[] args) throws Exception {
        new TaskManagementApplication().run(args);
    }

    @Override
    public void run(TaskManagementConfiguration configuration, Environment environment) throws Exception {

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);


        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");

        final TaskDao taskDao = jdbi.onDemand(TaskDao.class);
        taskDao.createTaskTable();


        environment.jersey().register(new TaskResources(taskDao));
        environment.jersey().register(new AppExceptionMapper());

    }
}
