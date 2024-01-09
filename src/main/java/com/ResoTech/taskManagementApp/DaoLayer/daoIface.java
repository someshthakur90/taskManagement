package com.ResoTech.taskManagementApp.DaoLayer;

import com.ResoTech.taskManagementApp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface daoIface extends JpaRepository<Task,Integer> {
    Task findById(int id);
}
