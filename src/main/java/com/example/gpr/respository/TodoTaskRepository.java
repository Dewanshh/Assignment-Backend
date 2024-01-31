package com.example.gpr.respository;

import com.example.gpr.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoTaskRepository extends JpaRepository<TodoTask,Integer> {

    List<TodoTask> findByTitle(String title);
}
