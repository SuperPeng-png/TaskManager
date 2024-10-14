import java.time.LocalDate;

public class TaskBuilder implements Builder {
    private String title = "Untitled Task";
    private String description = "";
    private TaskPriority priority = TaskPriority.MEDIUM;
    private LocalDate deadline = LocalDate.now().plusDays(7);
    private TaskStatus status = TaskStatus.PENDING;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    @Override
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    @Override
    public Task build() {
        return new Task(title, description, priority, deadline, status);
    }
}
