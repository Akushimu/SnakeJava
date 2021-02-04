import java.util.Random;

public class Apple {
    final int x;
    final int y;
    Random ran;

    public Apple() {
        ran = new Random();
        x = ran.nextInt(1375/50)*50;
        y = ran.nextInt(700/50)*50;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
