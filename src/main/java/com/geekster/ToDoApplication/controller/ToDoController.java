package com.geekster.ToDoApplication.controller;

import com.geekster.ToDoApplication.servises.ToDoServices;
import com.geekster.ToDoApplication.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    ToDoServices toDoServices;

    // get me all todos

    @RequestMapping(value = "/todo",method = RequestMethod.GET)
    public List<ToDo> getAllTodos(){
        return toDoServices.getTodos();
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String addToDo(@RequestBody ToDo toDo){
        toDoServices.addMyTodo(toDo);
        return toDoServices.addMyTodo(toDo);
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public ToDo getTodoById(@PathVariable String id){
        return toDoServices.getTodoBasedOnId(id);
    }

    @DeleteMapping(value = "/todo/{id}")
        public String deleteToDoById(@PathVariable String id){
            toDoServices.deleteToDoById(id);
            return  id + "was deleted !!";
        }
}
