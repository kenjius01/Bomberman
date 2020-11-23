package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Bomberman extends Character {
    protected int timeBetweenPutBombs = 0;
    protected int animate = 0;
    protected boolean goUp, goRight, goLeft, goDown;


    public Bomberman(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }


    @Override
    public void update() {
        /*if (!alive) {
            afterKill();
            return;
        }
        if (timeBetweenPutBombs < -7500) timeBetweenPutBombs = 0;
        else {
            timeBetweenPutBombs--;
        }*/
        animate();


    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }


    @Override
    public void kill() {

    }

    @Override
    public void afterKill() {

    }

    @Override
    protected boolean canMove(double x, double y) {
        return false;
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(double xa, double ya) {

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

    public void animate() {
        if (animate < 7500) {
            animate++;
        } else {
            animate = 0;
        }
    }



    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }
}
