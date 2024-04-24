package com.fungtech.todolist.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import com.fungtech.todolist.Dao.TaskRepository;
import com.fungtech.todolist.Dto.TaskDto;
import com.fungtech.todolist.Model.Task;
import com.fungtech.todolist.Service.TaskService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/todos")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    // Use Dependency Injection to inject TodoRepository
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        taskService = new TaskService(taskRepository);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findByDeletedAtNull();
    }

    @GetMapping("include-deleted")
    public List<Task> getAllTasksIncludeDeleted() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getOneById(@PathVariable UUID id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody TaskDto taskDto) {
        return taskService.updateTask(id, taskDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setDeletedAt(new Date());
        taskRepository.save(task);
    }
}
