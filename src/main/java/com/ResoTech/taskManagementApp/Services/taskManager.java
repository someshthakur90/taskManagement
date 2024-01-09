package com.ResoTech.taskManagementApp.Services;

import com.ResoTech.taskManagementApp.DaoLayer.daoIface;
import com.ResoTech.taskManagementApp.dto.TaskRequest;
import com.ResoTech.taskManagementApp.entity.Task;
import exception.NullValueNotAccepted;
import exception.TaskNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;
import java.lang.IllegalArgumentException;

@Service
public class taskManager implements taskIface{

    private daoIface daoIface;

    public taskManager(com.ResoTech.taskManagementApp.DaoLayer.daoIface daoIface) {
        this.daoIface = daoIface;
    }

    public List<Task> getTaskList() {
        return daoIface.findAll();
    }

    public Task addTask(TaskRequest taskRequest) {
        Task task = Task.
                build(0,taskRequest.getTaskDescription(),taskRequest.getCompletionDate(),taskRequest.isCompleted());
        if(task.getCompletionDate().isBefore(LocalDate.now()))  task.setCompletionDate(LocalDate.now());

        return daoIface.save(task);

    }

    public Task getTask(int id) throws TaskNotFoundException {
        Task task = daoIface.findById(id);
        if(task != null)    return task;
        else {
            throw new TaskNotFoundException("Task not found with id: "+id);
        }
    }

    public Task deleteTask(int id) throws TaskNotFoundException {
        Task task = daoIface.findById(id);
        if(task != null) {
            daoIface.deleteById(id);
            return task;

        }
        else {
            throw new TaskNotFoundException("Task doesn't exist with id : "+id);
        }

    }

    public Task updateTask(int id, boolean isDone) {
        Task task = daoIface.findById(id);
        task.setCompleted(isDone);
        daoIface.save(task);
        return task;
    }
    public Task updateTaskDescription(int id, String taskDescription) throws NullValueNotAccepted, TaskNotFoundException {
        Task task = daoIface.findById(id);
        if(task != null){
            if(!taskDescription.equals("")){
                task.setTaskDescription(taskDescription);
                return task;
            }

            else {
                throw new NullValueNotAccepted("Null values are not excepted");
            }
        }
        else {
            throw new TaskNotFoundException("Task doesn't exist");
        }

        //return task;
    }
    public Task updateTaskDate(int id, LocalDate completionDate) throws NullValueNotAccepted, TaskNotFoundException {
        Task task = daoIface.findById(id);

        if(task != null) {
            if(completionDate != null) {
                if(completionDate.isBefore(LocalDate.now()))    task.setCompletionDate(LocalDate.now());
                else task.setCompletionDate(completionDate);
                return task;
            }
            else {
                throw new NullValueNotAccepted("Null date values are not accepted");
            }
        }
        else {
            throw new TaskNotFoundException("Task doesn't exist");
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
