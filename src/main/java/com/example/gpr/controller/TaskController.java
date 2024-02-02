package com.example.gpr.controller;

import com.example.gpr.entity.TodoTask;
import com.example.gpr.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)

@RestController
public class TaskController {

    @Autowired

    private TodoService service;

    @PostMapping("/addTask")
    public TodoTask addProduct(@RequestBody TodoTask task){return service.saveTask(task);}

    @PostMapping("/addTasks")
    public List<TodoTask> addProducts(@RequestBody List<TodoTask> tasks)
    {
        return service.saveTasks(tasks);
    }

    @GetMapping("/taskById/{id}")
    public TodoTask findProductById(@PathVariable int id){
        return service.getTaskById(id);
    }

    @GetMapping("/taskByName/{title}")
    public List<TodoTask> findProductByName(@PathVariable String title){
        return service.getTaskByTitle(title);
    }

    @GetMapping("/getAllTasks")
    public List<TodoTask> getAllTasks(){
        return service.getTasks();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        return service.deleteTask(id);
    }

    @PutMapping("/update")
    public String updateTask(@RequestBody TodoTask task){
        return service.updateTask(task);
    }

    @PutMapping("/updateCompletion/{id}")
    public String updateTaskCompletion(@PathVariable int id){
        return service.updateTaskCompletion(id);
    }




}
