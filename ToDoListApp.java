import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, removeButton;

    public ToDoListApp() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskField = new JTextField();
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Selected");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel controlPanel = new JPanel();
        controlPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addTask());
        removeButton.addActionListener(e -> removeTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskModel.addElement(task);
            taskField.setText("");
        }
    }

    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        new ToDoListApp();
    }
}