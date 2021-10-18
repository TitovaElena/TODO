package TODO.service.factory;

import TODO.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskFactory {

    public Task build(String category, String priority, Date deadline, String content, Integer creatorId) {
        return new Task(category, priority, deadline, content, creatorId);
    }
}
