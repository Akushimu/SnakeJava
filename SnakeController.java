import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeController extends JPanel implements ActionListener {
    JButton startButton;
    JLabel gameOverLabel;
    int apples;
    boolean running;
    Timer tim;
    Apple a;
    Snake s;
    int screenWidth;
    int screenHeight;

    public SnakeController() {
        running = false;
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = Character.toUpperCase(e.getKeyChar());
                if(key == 'W') {
                    if(s.getDirection() != 'D')
                        s.setDirection('U');
                }
                if(key == 'A') {
                    if(s.getDirection() != 'R')
                        s.setDirection('L');
                }
                if(key == 'S') {
                    if(s.getDirection() != 'U')
                        s.setDirection('D');
                }
                if(key == 'D') {
                    if(s.getDirection() != 'L')
                        s.setDirection('R');
                }
            }
        });
        startButton = new JButton("Rozpocznij nową grę");
        gameOverLabel = new JLabel();
        startButton.setFont(new Font("Serif", Font.BOLD, 25));
        gameOverLabel.setFont(new Font("Serif", Font.BOLD, 25));
        startButton.addActionListener(this);
        screenWidth = 1365;
        screenHeight = 740;
        this.setSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.lightGray);
        this.setFocusable(true);
        this.add(startButton);
        this.add(gameOverLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == startButton) {
            startButton.setVisible(false);
            startSnake();
        }
        if(source == tim) {
            if(running) {
                moveSnake();
                checkPos();
                repaint();
            }
            if(!running) {
                gameOver();
            }
        }
    }

    public void startSnake() {
        s = new Snake();
        a = new Apple();
        running = true;
        apples = 0;
        tim = new Timer(s.getSpeed(), this);
        tim.start();
        gameOverLabel.setVisible(false);
    }

    public void checkPos() {
        //sprawdzamy kolizję z ciałem
        for(int i = s.getLength(); i > 0; i--) {
            if ((s.getX(0) == s.getX(i)) && s.getY(0) == s.getY(i)) {
                running = false;
            }
        }
        //sprawdzamy kolizję ze ścianami
        if(s.getX(0) < 0 || s.getX(0) > screenWidth - 65 || s.getY(0) < 0 || s.getY(0) > screenHeight - 90)
            running = false;
        //sprawdzamy kolizję z jabłkami
        if(a.getX() == s.getX(0) && a.getY() == s.getY(0)) {
            apples++;
            s.addLength();
            a = new Apple();
            tim.setDelay(s.addSpeed());
        }
    }

    //ruch węża
    public void moveSnake() {
        for(int i = s.getLength(); i > 0; i--) {
            s.moveBody(i);
        }
        s.moveHead();
    }

    //malowanie węża i jabłka
    public void draw(Graphics g) {
        if(running) {
            g.setColor(Color.RED);
            g.fillOval(a.getX(), a.getY(), 50, 50);
            for(int i = 0; i < s.getLength(); i++) {
                    g.setColor(Color.GREEN);
                    g.fillOval(s.getX(i), s.getY(i), 50, 50);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    //ekran końcowy
    public void gameOver() {
        tim.stop();
        startButton.setVisible(true);
        gameOverLabel.setText("Koniec gry, twój wynik to: " + apples);
        gameOverLabel.setVisible(true);
    }
}

