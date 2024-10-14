import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TaskManager implements TaskFilter  {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        System.out.println("Задача с id " + task.getId() + " Была добавлена.");
        tasks.add(task);

    }
    public void removeTask(Task task){
        System.out.println("Задача с id " + task.getId() + " Была удалена.");
        tasks.remove(task);



    }
    public void editTask(Task task, Task updatedTask){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(task.getId())) {
                tasks.set(i, updatedTask);
                System.out.println("Задача с id " + task.getId() + " Была обновлена.");
                return;
            }
        }
    }
    public void displayAllTasks(){
        Iterator<Task> iterator = this.tasks.iterator();
        System.out.println("Список всех задач: ");
        while (iterator.hasNext()) {
            Task item = iterator.next();
            System.out.println(item);
        }

    }
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
    public Task getTaskByTitle(String title){
        for (Task i: tasks){
            if (i.getTitle().equals(title)) {
                System.out.println("Задача найдена: " + i);
                return (Task) i;
            }
        }
        System.out.println("Такой задачи нет :(");
        return null; // исключение
    }
    public void searchTasks(String keyword){
        System.out.println("Результат поиска: ");
        for (int i = 0; i < tasks.size(); i++) {
            String[] wordsArray = tasks.get(i).getTitle().toLowerCase().split(" ");
            for (String j: wordsArray){
                if (j.equals(keyword.toLowerCase()))
                    System.out.println(tasks.get(i));
            }
        }
    }

    @Override
    public void filterByStatus(TaskStatus status) {
        System.out.println("---Задачи отфильтрованы по Статусу---");
        tasks.stream()
                .filter(task -> task.getStatus() == status)
                .forEach(task -> System.out.println(task.getTitle()));
    }

    @Override
    public void filterByPriority(TaskPriority priority) {
        System.out.println("---Задачи отфильтрованы по Приоритету---");
        tasks.stream()
                .filter(task -> task.getPriority() == priority)
                .forEach(task -> System.out.println(task.getTitle()));
    }
    public void sortTasksByDeadline() {
        tasks.sort(Comparator.comparing(Task::getDeadline));
    }


    public void sortTasksByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
    }
}
