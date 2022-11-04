package com.todolist.app.rest.Service;

import com.todolist.app.rest.Dto.TaskDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TaskService {

    public List<TaskDTO> getTasks();

    public String saveTask(@RequestBody TaskDTO task);

    public String updateTask (@PathVariable long id, @RequestBody TaskDTO task) throws Exception;

    public String deleteTask (@PathVariable long id) throws Exception;
}
