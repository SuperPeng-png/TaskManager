import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private final String id;
    private final String title;
    private final String description;
    private final TaskPriority priority;
    private final LocalDate deadline;
    private final TaskStatus status;


    Task(String title, String description, TaskPriority priority, LocalDate deadline, TaskStatus status) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", deadline=" + deadline +
                ", status=" + status +
                '}';
    }
}
