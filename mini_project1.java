import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mini_project1 implements ActionListener {
    JFrame frame;
    JTextArea textarea;
    JButton button;
    mini_project1(){
        frame=new JFrame("Word Editor");
        frame.setBounds(1100, 100, 300,300);
        /*frame.setBackground(Color.yellow);does not colour same as that of textarea*/
        frame.getContentPane().setBackground(Color.black);
        button=new JButton("click");
        button.setBounds(120, 20, 50,20);

        button.addActionListener(this);
        
        textarea=new JTextArea("Welcome");
        textarea.setBounds(50, 30, 200, 200);
        textarea.setBackground(Color.green);
        frame.add(button);
        frame.add(textarea);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        mini_project1 object = new mini_project1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textarea.setText("You clicked"); 
    }
}
/*Jframe provides window
JTextArea allows writing area to be created
JButton
JMenu
Action listener
Shifted from awt to Jswing because it was not platform independent and complex and heavier than Jswing*/
