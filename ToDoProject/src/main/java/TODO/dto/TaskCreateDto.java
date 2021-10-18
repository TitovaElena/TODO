package TODO.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class TaskCreateDto {
    private final String category;

    private final String priority;

    private final Date deadline;

    private final String content;

    public TaskCreateDto(@JsonProperty("category") String category,
                         @JsonProperty("priority") String priority,
                         @JsonProperty("deadline") Date deadline,
                         @JsonProperty("content") String content) {
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.content = content;
    }
}
