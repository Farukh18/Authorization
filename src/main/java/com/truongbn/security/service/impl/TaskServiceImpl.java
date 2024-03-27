package com.truongbn.security.service.impl;

import com.truongbn.security.entities.Status;
import com.truongbn.security.entities.Task;
import com.truongbn.security.exception.BadRequestException;
import com.truongbn.security.exception.NotFoundException;
import com.truongbn.security.repository.TaskRepository;
import com.truongbn.security.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Transactional
    @Override
    public Task addTask(Integer id, Task task) {
        log.info("Adding task for user with id: {}", id);
        if (task.getName() != null && task.getDescribe() != null) {
            task.getOwner().setId(id);
            setStatusTask(task);
            Task savedTask = repository.save(task);
            log.info("Task added with id: {}", savedTask.getId());
        }
        throw new BadRequestException("This task is not valid");
    }

    @Transactional
    @Override
    public Task updateTask(final Integer id, Task task) {
        log.info("Updating task with id :{} for this user with id: {}", task.getId(), id);
        if (!task.getOwner().getId().equals(id)) {
            log.error("User with id: {} is not owner of the task with id: {}", task.getId(), id);
            throw new BadRequestException("The user is not owner for this task");
        }
        Task taskInRepository = repository.findById(task.getId())
                .orElseThrow(() -> new NotFoundException("This task will be not found"));
        if (task.getName() != null) {
            taskInRepository.setName(task.getName());
        }
        if (task.getDescribe() != null) {
            taskInRepository.setDescribe(taskInRepository.getDescribe());
        }
        setStatusTask(task);
        Task updatedTask = repository.save(task);
        log.info("Task with id: {} updated", task.getId());
        return updatedTask;
    }

    @Transactional
    @Override
    public void deleteTask(Long id) {
        log.info("Deleting task with id: {}", id);
        repository.deleteById(id);
        log.info("Task with id: {} deleted", id);
    }

    @Override
    public Task getTask(Long id, Integer userId) {
        log.info("Retrieving task with id: {} for this user with id {}", id, userId);
        Task task = repository.findByIdAndOwnerId(id, userId);
        if (task == null) {
            log.error("Task with id: {} not found for this user with id: {}", id, userId);
            throw new NotFoundException("Task was not found");
        }
        log.info("Task with id: {} retrieved for user with id: {}", id, userId);
        return task;
    }

    @Override
    public List<Task> getAll() {
        log.info("Retrieving all tasks");
        List<Task> tasks = repository.findAll();
        log.info("Retrieved {} tasks", tasks.size());
        return tasks;
    }

    private void setStatusTask(Task task) {
        String originalStatus = String.valueOf(task.getStatus());
        if (task.getStatus() != Status.NEW && task.getStatus() != Status.DONE) {
            task.setStatus(Status.DONE);
        } else if (task.getStatus() != Status.NEW && task.getStatus() != Status.IN_PROGRESS) {
            task.setStatus(Status.DONE);
        } else {
            task.setStatus(Status.NEW);
        }
        log.info("Status for task with id: {} changed from {} to {}", task.getId(), originalStatus, task.getStatus());
    }
}
