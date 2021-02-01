import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //sterowanie W,A,S,D
        EventQueue.invokeLater(() -> {
            JFrame snake = new Board();
            snake.setVisible(true);
        });
    }
}