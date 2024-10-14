import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TaskManagerUI {
    private TaskManager taskManager;
    private JTextArea taskDisplayArea;
    private JTextField titleField, descriptionField, searchField;

    public TaskManagerUI() {
        taskManager = new TaskManager();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Title:"));
        titleField = new JTextField();
        panel.add(titleField);

        panel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        panel.add(descriptionField);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new AddTaskListener());
        panel.add(addButton);

        JButton viewButton = new JButton("View Tasks");
        viewButton.addActionListener(e -> displayTasks());
        panel.add(viewButton);

        JButton editButton = new JButton("Edit Task");
        editButton.addActionListener(new EditTaskListener());
        panel.add(editButton);

        JButton deleteButton = new JButton("Delete Task");
        deleteButton.addActionListener(new DeleteTaskListener());
        panel.add(deleteButton);

        panel.add(new JLabel("Search (by Title):"));
        searchField = new JTextField();
        panel.add(searchField);

        JButton searchButton = new JButton("Search Task");
        searchButton.addActionListener(new SearchTaskListener());
        panel.add(searchButton);

        taskDisplayArea = new JTextArea();
        taskDisplayArea.setEditable(false);
        panel.add(new JScrollPane(taskDisplayArea));

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    private void displayTasks() {
        taskDisplayArea.setText("");
        for (Task task : taskManager.getAllTasks()) {
            taskDisplayArea.append(task.toString() + "\n");
        }
    }

    private class AddTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String description = descriptionField.getText();
            TaskBuilder builder = new TaskBuilder();
            builder.setTitle(title);
            builder.setDescription(description);
            Task newTask = builder.build();
            taskManager.addTask(newTask);
            titleField.setText("");
            descriptionField.setText("");
        }
    }

    private class EditTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String description = descriptionField.getText();

            Task existingTask = taskManager.getTaskByTitle(title);
            if (existingTask != null) {
                TaskBuilder builder = new TaskBuilder();
                builder.setTitle(title);
                builder.setDescription(description);

                Task updatedTask = builder.build();
                taskManager.editTask(existingTask, updatedTask);
            } else {
                JOptionPane.showMessageDialog(null, "Task not found!");
            }

            titleField.setText("");
            descriptionField.setText("");
        }
    }

    private class DeleteTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            Task existingTask = taskManager.getTaskByTitle(title);
            if (existingTask != null) {
                taskManager.removeTask(existingTask);
            } else {
                JOptionPane.showMessageDialog(null, "Task not found!");
            }

            titleField.setText("");
        }
    }

    private class SearchTaskListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String keyword = searchField.getText();
            taskDisplayArea.setText("");
            for (Task task : taskManager.getAllTasks()) {
                if (task.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    taskDisplayArea.append(task.toString() + "\n");
                }
            }
            searchField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManagerUI::new);
    }
}
