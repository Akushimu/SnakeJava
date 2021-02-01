public class Snake {
    int length;
    int speed;
    char direction;
    int[] xPos;
    int[] yPos;

    public Snake() {
        length = 3;
        speed = 80;
        direction = 'D';
        xPos = new int[390];
        yPos = new int[390];
    }

    public int getLength() {
        return length;
    }

    public int getSpeed() {
        return speed;
    }

    public char getDirection() {
        return direction;
    }

    public void addLength() {
        length++;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void moveBody(int i) {
        xPos[i] = xPos[i-1];
        yPos[i] = yPos[i-1];
    }

    public void moveHead() {
        char dir = this.direction;
        if(dir == 'U')
            yPos[0] = yPos[0] - 50;
        if(dir == 'L')
            xPos[0] = xPos[0] - 50;
        if(dir == 'D')
            yPos[0] = yPos[0] + 50;
        if(dir == 'R')
            xPos[0] = xPos[0] + 50;
    }

    public int addSpeed() {
        return --speed;
    }

    public int getX(int i) {
        return xPos[i];
    }

    public int getY(int i) { return yPos[i]; }
}
