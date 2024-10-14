import java.time.LocalDate;

interface Builder {
    void setTitle(String title);
    void setDescription(String description);
    void setPriority(TaskPriority priority);
    void setDeadline(LocalDate deadline);
    void setStatus(TaskStatus status);
    Task build();

}
