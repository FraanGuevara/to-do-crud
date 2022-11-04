package com.todolist.app.rest.Repository;

import com.todolist.app.rest.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TaskModel, Long> {
}
