package com.todolist.app.rest.Controller;

import com.todolist.app.rest.Dto.TaskDTO;
import com.todolist.app.rest.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/tasks")
    public ResponseEntity<?> traerListaDeTareas(){
       return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK) ;
    }

    @PostMapping (value = "/savetask")
    public ResponseEntity<?> crearTareaNueva(@RequestBody TaskDTO taskDTO){
        return new ResponseEntity<>(taskService.saveTask(taskDTO), HttpStatus.CREATED) ;
    }

    @PutMapping (value = "/update/{id}")
    public ResponseEntity<?> modificarTarea (@PathVariable long id, @RequestBody TaskDTO taskDTO) throws Exception {
        return new ResponseEntity<>(taskService.updateTask(id, taskDTO), HttpStatus.OK);
    }

    @DeleteMapping (value = "/delete/{id}")
    public ResponseEntity<?> eliminarTarea(@PathVariable long id) throws Exception {
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
