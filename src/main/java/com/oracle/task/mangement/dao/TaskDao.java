package com.oracle.task.mangement.dao;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface TaskDao {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS Task (" +
            " Task_Id INT NOT NULL AUTO_INCREMENT," +
            " Task_Ref VARCHAR(255) NOT NULL, " +
            " Task_Description VARCHAR(255) NOT NULL, " +
            " Task_Completion_By_Date DATETIME NOT NULL, " +
            " Task_Is_Done Boolean NOT NULL, " +
            " primary key(Task_Id))")
    void createTaskTable();

    @SqlUpdate("INSERT INTO Task (Task_Ref,Task_Description,Task_Completion_By_Date, Task_Is_Done) " +
            "VALUES(:ref, :description, :completionByDate, false)")
    @GetGeneratedKeys
    int addTask(@BindBean Task task);

    @SqlQuery("SELECT * FROM Task")
    List<Task> getAll();

    @SqlUpdate("Update Task Set Task_Is_Done = true WHERE id = :id")
    int completeTask(@Bind("id") int id);

}
