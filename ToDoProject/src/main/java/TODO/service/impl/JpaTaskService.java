package TODO.service.impl;

import TODO.dto.TaskCreateDto;
import TODO.dto.TaskDto;
import TODO.dto.TaskEditDto;
import TODO.entity.Task;
import TODO.repository.TaskRepository;
import TODO.service.TaskService;
import TODO.service.factory.TaskFactory;
import TODO.service.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTaskService implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskFactory taskFactory;

    public JpaTaskService(TaskRepository taskRepository,
                          TaskMapper taskMapper,
                          TaskFactory taskFactory) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskFactory = taskFactory;
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.mapTaskToTaskDto(tasks);
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {
        Task task = taskFactory.build(
                taskCreateDto.getCategory(),
                taskCreateDto.getPriority(),
                taskCreateDto.getDeadline(),
                taskCreateDto.getContent(),

                // todo когда-нибудь нужно прописать реального инициатора создания заметки.
                1
        );

        task = taskRepository.saveAndFlush(task);

        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto editTask(Integer taskId, TaskEditDto taskEditDto) {
        Task task = taskRepository.findById(taskId).orElseThrow();

        task.setContent(taskEditDto.getContent());

        taskRepository.saveAndFlush(task);

        return taskMapper.mapTaskToTaskDto(task);
    }
}
