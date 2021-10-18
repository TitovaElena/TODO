package TODO.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class TaskDto {
    private final Integer id;

    private final String category;

    private final String priority;

    private final Date deadline;

    private final String content;

    public TaskDto(Integer id,
                   String category,
                   String priority,
                   Date deadline,
                   String content) {
        this.id = id;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.content = content;
    }
}
