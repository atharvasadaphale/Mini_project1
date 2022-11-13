import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class Game_MI2 implements ActionListener {
        JFrame frame;
        Game_MI2(){
            frame = new JFrame("frame");
            frame.setBounds(0,0,400,300);
            panel jpanel = new panel(400,300);
            jpanel.setBounds(0,0,400,300);
            jpanel.setBackground(Color.black);
            Container c = frame.getContentPane();
            c.setBackground(Color.blue);
            frame.add(jpanel);
            //frame.setLayout(null);
            frame.setVisible(true);
            frame.setSize(600,600);


        }
        public static void main(String arg[]){
            Game_MI2 firstSession = new Game_MI2();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
