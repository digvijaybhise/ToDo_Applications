package com.geekster.ToDoApplication.model;

import lombok.Data;

@Data
public class ToDo {

    private String id;
    private String todoName;
    private String todoStatus;

    public ToDo(String id, String todoName, String todoStatus) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = todoStatus;
    }
}
