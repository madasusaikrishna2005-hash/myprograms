import javax.swing.*;

public class Jlabel{
    public static void main(String[] args) {
    JFrame f=new JFrame ("label example");
   JLabel l=new JLabel("SAI KRISHNA");
   l.setBounds(50,50,100,150);
   f.add(l);
   f.setSize(200,100);
   f.setLayout(null);
   f.setVisible(true);
    }
}