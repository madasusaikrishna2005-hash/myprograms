// Import necessary Java Swing and AWT packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple To-Do List application built with Java Swing.
 * This class creates the GUI and handles all the user interactions
 * as described in the project documentation.
 */
public class ToDoList extends JFrame {

    // --- Core Swing Components ---
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addTaskButton;
    private JButton deleteTaskButton;

    /**
     * Constructor for ToDoListApp.
     * Sets up the main window and initializes the UI components.
     */
    public ToDoList() {
        // --- 1. Set up the main window (JFrame) ---
        setTitle("To-Do List Application");
        setSize(400, 500); // Set a default size for the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the app closes properly
        setLocationRelativeTo(null); // Center the window on the screen

        // --- 2. Initialize the UI components ---
        createUI();
    }

    /**
     * Initializes and arranges all the Swing components on the frame.
     */
    private void createUI() {
        // --- A. Data Model and Visual List ---
        // The model holds the data (the to-do items)
        listModel = new DefaultListModel<>();
        // The JList visually displays the data from the model
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only one item to be selected at a time

        // Add a scrollbar to the list for when there are many tasks
        JScrollPane scrollPane = new JScrollPane(taskList);

        // --- B. Input field and "Add Task" button ---
        taskInputField = new JTextField(20); // Create a text field with a preferred width
        addTaskButton = new JButton("Add Task");

        // Create a panel to hold the input field and add button together
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskInputField);
        inputPanel.add(addTaskButton);

        // --- C. "Delete Task" button ---
        deleteTaskButton = new JButton("Delete Selected Task");

        // --- D. Add ActionListeners to handle events ---
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // Also allow adding a task by pressing Enter in the text field
        taskInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });

        // --- E. Set the layout for the main frame and add components ---
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);   // Input goes at the top
        add(scrollPane, BorderLayout.CENTER);  // Task list goes in the middle
        add(deleteTaskButton, BorderLayout.SOUTH); // Delete button goes at the bottom
    }

    /**
     * Core method for adding a task.
     * Gets text from the input field and adds it to the list model.
     */
    private void addTask() {
        String task = taskInputField.getText().trim(); // Get text and remove whitespace
        if (!task.isEmpty()) {
            listModel.addElement(task); // Add the task to our data model
            taskInputField.setText("");   // Clear the input field for the next task
        } else {
            // Optional: Show a message if the user tries to add an empty task
            JOptionPane.showMessageDialog(this, "Task cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Core method for deleting a task.
     * Gets the selected item from the list and removes it.
     */
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex(); // Find out which item is selected
        if (selectedIndex != -1) { // -1 means nothing is selected
            listModel.removeElementAt(selectedIndex); // Remove the selected item from the model
        } else {
            // Optional: Show a message if the user clicks delete without selecting a task
            JOptionPane.showMessageDialog(this, "Please select a task to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * The main entry point of the application.
     */
    public static void main(String[] args) {
        // Swing applications should be run on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create an instance of our app and make it visible
                new ToDoListApp().setVisible(true);
            }
        });
    }
}