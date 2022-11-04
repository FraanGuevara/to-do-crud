package com.todolist.app.rest.Dto;

import lombok.Data;

@Data
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
}
