package TODO.controller;

import TODO.dto.TaskCreateDto;
import TODO.dto.TaskEditDto;
import TODO.dto.TaskDto;
import TODO.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/tasks")
public class TaskController{

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskCreateDto) {
        return taskService.createTask(taskCreateDto);
    }

    @PutMapping("/{id}")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer taskId) {
        return taskService.editTask(taskId, taskEditDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") Integer taskId){
        return new ResponseEntity(HttpStatus.OK);
    }
}
