import javax.swing.*;

public class Board extends JFrame {
    int screenWidth;
    int screenHeight;
    JPanel snake;

    public Board() {
        screenWidth = 1365;
        screenHeight = 740;
        snake = new SnakeController(screenWidth,screenHeight);
        this.setTitle("Snake Java");
        this.setSize(screenWidth,screenHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(snake);
    }
}
