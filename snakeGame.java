import javax.swing.*;
import java.awt.*;

public class snakeGame  {
    JFrame frame;
    snakeGame(){
        frame=new JFrame("Snake Game");
        frame.setBounds(0, 0, 905, 700);
        frame.setVisible(true);
        gamePanel panel = new gamePanel();
        //panel.setBounds(10,10,905,700);
        panel.setBackground(Color.GRAY);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        snakeGame obj = new snakeGame();
    }
}
