package com.oracle.task.mangement.dao;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface TaskDao {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS Task (" +
            " id INT NOT NULL AUTO_INCREMENT," +
            " ref VARCHAR(255) NOT NULL, " +
            " description VARCHAR(255) NOT NULL, " +
            " completeByDate VARCHAR(12) NOT NULL, " +
            " done Boolean NOT NULL, " +
            " primary key(id))")
    void createTaskTable();

    @SqlUpdate("INSERT INTO Task (ref, description, completeByDate, done) " +
            "VALUES(:ref, :description, :completeByDate, false)")
    @GetGeneratedKeys
    int addTask(@BindBean Task task);

    @SqlQuery("SELECT * FROM Task")
    List<Task> getAll();

    @SqlUpdate("Update Task Set done = true WHERE id = :id")
    int completeTask(@Bind("id") int id);

}
