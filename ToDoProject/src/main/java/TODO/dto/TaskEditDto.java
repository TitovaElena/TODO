package TODO.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class TaskEditDto {
    private final String category;

    private final String priority;
    
    private final Date deadline;

    private final String text;

    public TaskEditDto(@JsonProperty("category") String category,
                       @JsonProperty("priority") String priority,
                       @JsonProperty("deadline") Date deadline,
                       @JsonProperty("text") String text) {
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.text = text;
    }
}
