import java.util.Random;

public class Apple {
    final int x;
    final int y;
    Random ran;

    public Apple(int w, int h) {
        ran = new Random();
        x = ran.nextInt((w+10)/50)*50;
        y = ran.nextInt((h-40)/50)*50;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
