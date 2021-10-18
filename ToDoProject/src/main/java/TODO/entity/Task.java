package TODO.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.Instant;
import java.util.Date;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @SequenceGenerator(name = "task_id_seq_generator",
            sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "task_id_seq_generator")
    private Integer id;

    private String category;

    private String priority;

    private Date deadline;

    private String content;

    @UpdateTimestamp
    private Instant updatedAt;

    private Integer creatorId;

    public Task() {
    }

    public Task(String category, String priority, Date deadline, String content, Integer creatorId) {
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
        this.content = content;
        this.creatorId = creatorId;
    }
}
