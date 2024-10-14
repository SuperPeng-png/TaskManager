import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskBuilder builder = new TaskBuilder();
        TaskManager manager = new TaskManager();


        builder.setTitle("Задача 1");
        builder.setDescription("Описание задачи");
        builder.setPriority(TaskPriority.HIGH);
        builder.setDeadline(LocalDate.of(2024, 10, 31));
        builder.setStatus(TaskStatus.IN_PROGRESS);


        Task task1 = builder.build();

        System.out.println(task1);
        manager.addTask(task1);


    }
}