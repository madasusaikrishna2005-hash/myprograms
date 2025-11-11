import javax.swing.*;

public class Jtabledemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Example");

        String[][] data = {
            {"1", "Alice", "A","d"},
            {"2", "Bob", "B","f"},
            {"3", "Charlie", "C","hi"}
        };

        String[] columns = {"ID", "Name", "Grade","num"};

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}