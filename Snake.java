public class Snake {
    int length;
    int speed;
    char direction;
    //wąż jako tablica x i y gdzie zerowy indeks to głowa a reszta to segmenty ciała
    //wielkość tablicy określa też maksymalny rozmiar węża
    final int[] xPos;
    final int[] yPos;

    public Snake() {
        length = 3;
        speed = 80;
        direction = 'D';
        xPos = new int[100];
        yPos = new int[100];
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

    //ruch ciała węża, czyli reszta indeksów poza zerowym podążą za poprzednim
    public void moveBody(int i) {
        xPos[i] = xPos[i-1];
        yPos[i] = yPos[i-1];
    }

    //ruch samej głowy węża, czyli zerowego indeksu tablicy w zależności od kierunku
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
