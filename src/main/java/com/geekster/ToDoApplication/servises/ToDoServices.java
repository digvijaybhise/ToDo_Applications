package com.geekster.ToDoApplication.servises;

import com.geekster.ToDoApplication.repository.ToDoDao;
import com.geekster.ToDoApplication.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServices {

    @Autowired
    ToDoDao toDoDao;

    public List<ToDo> getTodos(){
        return toDoDao.getAllTodos();
    }

    public String addMyTodo(ToDo toDo){
        if(toDoDao.save(toDo)){
            return "ToDo added Successfully";
        }else{
            return "Failed !!! .... Todo not Possible, DataBase error";
        }
    }

    public ToDo getTodoBasedOnId(String id){
        List<ToDo> todoListRightNow = toDoDao.getAllTodos();

        for(ToDo toDo : todoListRightNow) {
            if (toDo.getId().equals(id)) return toDo;
        }
        return null;
    }

    public String deleteToDoById(String id){
        boolean deleteResponse = false;
        String status = null;
        if(id != null){
            List<ToDo> todoListRightNow = toDoDao.getAllTodos();

            for(ToDo toDo : todoListRightNow) {
                if (toDo.getId().equals(id)) {
                    deleteResponse =  toDoDao.remove(toDo);
                }
                if(deleteResponse) {
                    status = "Todo with id "+ id + " was deleted....!!!";
                }else{
                    status = "Todo with id " + id + " was not deleted...!!!";
                }
                return status;
            }
        }
        return "id with " + id + " does not exist";
    }
}
