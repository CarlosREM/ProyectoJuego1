package ADT;

/**
 *
 * @author carlo
 */
public class Hitbox {
    private final int x1,
                      x2,
                      y1,
                      y2;

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    
    public Hitbox(int x, int y, int w, int h) {
        this.x1 = x;
        this.x2 = x+w;
        this.y1 = y;
        this.y2 = y+h;
    }
    
    public boolean checkLeft(int x2) {
        return x2 < this.x1;
    }
    
    public boolean checkRight(int x1) {
        return this.x2 < x1;
    }
    
    public boolean checkUp(int y2) {
        return y2 < this.y1;
    }
    
    public boolean checkDown(int y1) {
        return this.y2 < y1;
    }
    
    public boolean checkCollision(Hitbox h) {
        return !(checkLeft(h.getX2()) |
                 checkRight(h.getX1()) |
                 checkUp(h.getY2()) |
                 checkDown(h.getY1()));
    }
}
