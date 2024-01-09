package com.ResoTech.taskManagementApp.controllers;

import com.ResoTech.taskManagementApp.Services.taskIface;
import com.ResoTech.taskManagementApp.Services.taskManager;
import com.ResoTech.taskManagementApp.dto.TaskRequest;
import com.ResoTech.taskManagementApp.entity.Task;
import exception.NullValueNotAccepted;
import exception.TaskNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
public class controller {

    private taskIface taskIface;

    public controller(com.ResoTech.taskManagementApp.Services.taskIface taskIface) {
        this.taskIface = taskIface;
    }



    @GetMapping("/getTask")
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(taskIface.getTaskList());
    }
    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) throws TaskNotFoundException {
        return ResponseEntity.ok(taskIface.getTask(id));
    }
    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@RequestBody @Valid TaskRequest task) {
        return new ResponseEntity<>(taskIface.addTask(task), HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskIface.deleteTask(id), HttpStatus.OK);
    }
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id,@RequestParam boolean isDone) {
        return new ResponseEntity<>(taskIface.updateTask(id,isDone), HttpStatus.OK);
    }
    @PutMapping("/updateTask/{id}/taskDescription")
    public ResponseEntity<Task> updateTaskDescription(@PathVariable int id,@RequestParam String taskDescription) throws NullValueNotAccepted, TaskNotFoundException {
        return new ResponseEntity<>(taskIface.updateTaskDescription(id,taskDescription),HttpStatus.OK);
    }
    @PutMapping("/updateTask/{id}/taskDate")
    public ResponseEntity<Task> updateTaskDate(@PathVariable int id,@RequestParam LocalDate completionDate) throws NullValueNotAccepted, TaskNotFoundException {
        return new ResponseEntity<>(taskIface.updateTaskDate(id,completionDate),HttpStatus.OK);
    }

}
