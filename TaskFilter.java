public interface TaskFilter {
    void filterByStatus(TaskStatus status);
    void filterByPriority(TaskPriority priority);

}
