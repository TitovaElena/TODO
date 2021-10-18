package TODO.service;

import TODO.dto.TaskCreateDto;
import TODO.dto.TaskDto;
import TODO.dto.TaskEditDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask(Integer taskId, TaskEditDto taskEditDto);

}
