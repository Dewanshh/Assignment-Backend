package com.example.gpr.service;

import com.example.gpr.entity.TodoTask;
import com.example.gpr.respository.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoTaskRepository repository;

    public TodoTask saveTask(TodoTask task)
    {
        try {
            return repository.save(task);
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while saving data: "+e.getMessage(),e);
        }
    }

    public List<TodoTask> saveTasks(List<TodoTask> tasks){
        try {
            return repository.saveAll(tasks);
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while saving data: "+e.getMessage(),e);
        }
    }
    public List<TodoTask> getTaskByTitle(String title){
        try {
            return repository.findByTitle(title);
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while fetching data using title: "+e.getMessage(),e);
        }
    }

    public TodoTask getTaskById(int id){
        try {
            return repository.findById(id).orElse(null);
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while fetching data using id: "+e.getMessage(),e);
        }
    }
    public List<TodoTask> getTasks(){
        try{
            return repository.findAll();
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while fetching all tasks: "+e.getMessage(),e);
        }
    }

    public String deleteTask(int id){
        try{
            repository.deleteById(id);
            return "Task Deleted Successfully";
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while deletion of task: "+e.getMessage(),e);
        }
    }
    public String updateTask(TodoTask task){
        try{
            TodoTask existingTask=repository.findById(task.getId()).orElse(null);
            if(existingTask!=null){
                existingTask.setTitle(task.getTitle());
                existingTask.setTitleDescription(task.getTitleDescription());
                existingTask.setCompleted(task.isCompleted());
                existingTask.setDue_date(task.getDue_date());
                repository.save(existingTask);
                return "Task Updated Succesfully";
            }
            return "Task Not Found";
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while updating task: "+task.getId()+" "+e.getMessage(),e);
        }
    }

    public String updateTaskCompletion(int id)
    {
        try{
            TodoTask existingTask=repository.findById(id).orElse(null);
            if(existingTask!=null)
            {
                existingTask.setCompleted(!existingTask.isCompleted());
                repository.save(existingTask);
                return "Task Updated Succesfully";
            }
            return "No Task Found";
        }catch(Exception e){
            throw new TodoServiceException("Error occurred while updating task: "+id+" "+e.getMessage(),e);
        }
    }



}

