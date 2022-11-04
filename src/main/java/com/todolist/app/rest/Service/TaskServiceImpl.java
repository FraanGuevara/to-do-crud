package com.todolist.app.rest.Service;

import com.todolist.app.rest.Dto.TaskDTO;
import com.todolist.app.rest.Mapper.TaskMapper;
import com.todolist.app.rest.Model.TaskModel;
import com.todolist.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<TaskDTO> getTasks() {
        List <TaskDTO> listDTO = new ArrayList<>();
        listDTO = taskMapper.toTaskDTOList(todoRepository.findAll());
        return listDTO;
    }

    @Override
    public String saveTask(TaskDTO task) {
        TaskModel taskModel = new TaskModel();
        taskModel = taskMapper.toTaskModel(task);
        todoRepository.save(taskModel);
        return "Saved task";
    }

    @Override
    public String updateTask(long id, TaskDTO task) throws  Exception{
        TaskModel taskModel = taskMapper.toTaskModel(task);
        TaskModel updatedTask = todoRepository.findById(id).orElseThrow(() -> new Exception("El id buscado no existe"));
        updatedTask.setTitle(taskModel.getTitle());
        updatedTask.setDescription(taskModel.getDescription());
        todoRepository.save(updatedTask);
        return "Update task";
    }

    @Override
    public String deleteTask(long id) throws Exception {
        TaskModel taskModel = todoRepository.findById(id).orElseThrow(()-> new Exception("El id buscado no existe"));
            todoRepository.deleteById(id);
            return "Deleted task";
    }
}
