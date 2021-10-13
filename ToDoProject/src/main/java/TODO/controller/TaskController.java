package TODO.controller;

import TODO.dto.TaskCreateDto;
import TODO.dto.TaskEditDto;
import TODO.dto.TaskDto;
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
    @GetMapping
    public List<TaskDto> getAllNotes() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return List.of(
                new TaskDto(1, "cleaning", "low", formatter.parse("2021-12-12"), "text"),
                new TaskDto(2, "studies", "medium", formatter.parse("2021-12-13"), "text"),
                new TaskDto(3, "birthdays", "high", formatter.parse("2021-12-14"), "text")
        );
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskCreateDto taskCreateDto) {

        TaskDto taskDto = new TaskDto(
                10,
                taskCreateDto.getCategory(),
                taskCreateDto.getPriority(),
                taskCreateDto.getDeadline(),
                taskCreateDto.getText()
        );

        return taskDto;
    }

    @PutMapping("/{id}")
    public TaskDto editTask(@RequestBody TaskEditDto taskEditDto,
                            @PathVariable("id") Integer taskId) {
        // Task когда-нибудь изменить объект по-настоящему в БД :)

        TaskDto taskDto = new TaskDto(
                taskId,
                taskEditDto.getCategory(),
                taskEditDto.getPriority(),
                taskEditDto.getDeadline(),
                taskEditDto.getText()
        );

        return taskDto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") Integer taskId){
        return new ResponseEntity(HttpStatus.OK);
    }
}
