package com.truongbn.security.service;

import com.truongbn.security.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;

import com.truongbn.security.exception.BadRequestException;
import com.truongbn.security.exception.NotFoundException;

/**
 * Interface for managing tasks within the application.
 * Provides methods to add, update, delete, and retrieve tasks.
 */
@Service
public interface TaskService {

    /**
     * Adds a new task to the system.
     *
     * @param userId The ID of the user creating the task.
     * @param task   The task object to be added.
     * @return The saved task with a generated ID.
     * @throws BadRequestException if the task is not valid or the user ID is null.
     */
    Task addTask(Integer userId, Task task);

    /**
     * Updates an existing task in the system.
     *
     * @param userId The ID of the user updating the task.
     * @param task   The task object containing updated fields.
     * @return The updated task object.
     * @throws BadRequestException if the task does not belong to the user, or if the task is not found.
     * @throws NotFoundException   if the task to be updated is not found.
     */
    Task updateTask(Integer userId, Task task);

    /**
     * Deletes a task from the system by its ID.
     *
     * @param taskId The ID of the task to be deleted.
     * @throws NotFoundException if the task to be deleted is not found.
     */
    void deleteTask(Long taskId);

    /**
     * Retrieves a task by its ID and the owner's user ID.
     *
     * @param taskId The ID of the task to retrieve.
     * @param userId The ID of the owner of the task.
     * @return The requested task.
     * @throws NotFoundException if the task with the given ID and user ID is not found.
     */
    Task getTask(Long taskId, Integer userId);

    /**
     * Retrieves all tasks in the system.
     *
     * @return A list of all tasks.
     */
    List<Task> getAll();
}
