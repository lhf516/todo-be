package com.fungtech.todolist.Service;

import java.util.UUID;

import com.fungtech.todolist.Dao.TaskRepository;
import com.fungtech.todolist.Dto.TaskDto;
import com.fungtech.todolist.Model.Task;

public class TaskService {
  private TaskRepository taskRepository;
  
  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public TaskDto getTaskById(UUID id) {
    Task task = taskRepository.findById(id).orElseThrow();
    return convertToDTO(task);
  }

  public Task updateTask(UUID id, TaskDto taskDTO) {
    Task task = taskRepository.findById(id).orElseThrow();

    if (taskDTO.getTitle() != null)
      task.setTitle(taskDTO.getTitle());
    if (taskDTO.getDetail() != null)
      task.setDetail(taskDTO.getDetail());
    task.setCompleted(taskDTO.getCompleted());
    if (taskDTO.getCreatedAt() != null)
      task.setCreatedAt(taskDTO.getCreatedAt());
    task.setDeletedAt(taskDTO.getDeletedAt());

    return taskRepository.save(task);
  }

  private TaskDto convertToDTO(Task task) {
    return null;

  }

  private Task convertToModel(TaskDto taskDTO) {
    Task task = new Task();

    System.out.println("task.getTitle(): " + task.getTitle());
    System.out.println("task.getDetail(): " + task.getDetail());
    System.out.println("task.getCompleted(): " + task.getCompleted());
    System.out.println("task.getCreatedAt(): " + task.getCreatedAt());
    System.out.println("task.getDeletedAt(): " + task.getDeletedAt());

    System.out.println("taskDTO.getTitle(): " + taskDTO.getTitle());
    System.out.println("taskDTO.getDetail(): " + taskDTO.getDetail());
    System.out.println("taskDTO.getCompleted(): " + taskDTO.getCompleted());
    System.out.println("taskDTO.getCreatedAt(): " + taskDTO.getCreatedAt());
    System.out.println("taskDTO.getDeletedAt(): " + taskDTO.getDeletedAt());

    if (taskDTO.getTitle() != null)
      task.setTitle(taskDTO.getTitle());
    if (taskDTO.getDetail() != null)
      task.setDetail(taskDTO.getDetail());
    task.setCompleted(taskDTO.getCompleted());
    if (taskDTO.getCreatedAt() != null)
      task.setCreatedAt(taskDTO.getCreatedAt());
    task.setDeletedAt(taskDTO.getDeletedAt());

    return task;
  }

}
