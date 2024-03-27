package com.truongbn.security.controller;

import com.truongbn.security.constant.UserConstant;
import com.truongbn.security.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.truongbn.security.entities.Task;

import static com.truongbn.security.constant.UserConstant.*;
@Tag(name = "tasks")
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TasksController {

    private final TaskService taskService;

    @PostMapping
    public Task creartTask(@Valid @RequestBody Task task, @RequestHeader(USER_OWNER_ID) final Integer id) {
        return taskService.addTask(id, task);
    }

    @PatchMapping
    public Task updateTask(@Valid @RequestBody Task task, @RequestHeader(USER_OWNER_ID) final Integer id) {
        return taskService.updateTask(id, task);
    }
}
