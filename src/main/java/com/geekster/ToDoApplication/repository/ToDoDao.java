package com.geekster.ToDoApplication.repository;

import com.geekster.ToDoApplication.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoDao {

    private List<ToDo> todoList;

    public ToDoDao(){
        todoList = new ArrayList<>();
        todoList.add(new ToDo("0", "Dummy for Testing", "true"));
    }

    public List<ToDo> getAllTodos(){
        return todoList;
    }

    public boolean save(ToDo toDo){
        todoList.add(toDo);
        return true;
    }

    public boolean remove(ToDo toDo){
        todoList.remove(toDo);
        return true;
    }
}
