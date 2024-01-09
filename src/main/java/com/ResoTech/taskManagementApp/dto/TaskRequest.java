package com.ResoTech.taskManagementApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class TaskRequest {
    @NotNull
    @NotBlank(message = "task description should not be null")
    private String taskDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    private LocalDate completionDate;
    @NotNull(message = "isCompleted should not be null. It will set to false when you add a task")
    private boolean isCompleted;
}
