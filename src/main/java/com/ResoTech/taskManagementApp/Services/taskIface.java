package com.ResoTech.taskManagementApp.Services;

import com.ResoTech.taskManagementApp.dto.TaskRequest;
import com.ResoTech.taskManagementApp.entity.Task;
import exception.NullValueNotAccepted;
import exception.TaskNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface taskIface {
    public List<Task> getTaskList();
    public  Task addTask(TaskRequest taskRequest);
    public Task getTask(int id) throws TaskNotFoundException;
    public Task deleteTask(int id) throws TaskNotFoundException;
    public Task updateTask(int id, boolean isDone);


    Task updateTaskDescription(int id, String taskDescription) throws NullValueNotAccepted, TaskNotFoundException;

    Task updateTaskDate(int id, LocalDate completionDate) throws NullValueNotAccepted, TaskNotFoundException;
}
