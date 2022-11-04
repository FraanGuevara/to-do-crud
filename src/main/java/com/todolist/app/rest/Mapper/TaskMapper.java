package com.todolist.app.rest.Mapper;

import com.todolist.app.rest.Dto.TaskDTO;

import com.todolist.app.rest.Model.TaskModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public TaskDTO toTaskDTO (TaskModel task){
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        return dto;
    }

    public TaskModel toTaskModel (TaskDTO dto){
        TaskModel newTask = new TaskModel();
        newTask.setTitle(dto.getTitle());
        newTask.setDescription(dto.getDescription());
        return newTask;
    }

    public List<TaskDTO> toTaskDTOList (List <TaskModel> TaskList){
        List <TaskDTO> listTaskDTO = new ArrayList<>();
        for (TaskModel task : TaskList){
            TaskDTO taskDTOcasteado = toTaskDTO(task);
            listTaskDTO.add(taskDTOcasteado);
        }
        return listTaskDTO;
    }

}
