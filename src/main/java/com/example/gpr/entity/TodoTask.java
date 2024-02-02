package com.example.gpr.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="todoList")
public class TodoTask implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String titleDescription;
    private String due_date;
    private  boolean completed;


}
