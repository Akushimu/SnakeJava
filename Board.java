import javax.swing.*;

public class Board extends JFrame {
    public Board() {
        this.setTitle("Snake Java");
        this.setSize(1365,740);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new SnakeController());
    }
}
