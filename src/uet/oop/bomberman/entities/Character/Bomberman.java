package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Input.KeyBoard;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Bomberman extends Character {
    protected int timeBetweenPutBombs = 0;
    protected int animate = 0;
    protected boolean goUp, goRight, goLeft, goDown;
    protected KeyBoard keyBoard;
    protected int velocityX = 0;
    protected int velocityY = 0;

//----ham khoi tao
    public Bomberman(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
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

//-----cap nhap di chuyen
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

        calculateMove();


    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

//----ham di chuyen cua nhan vat
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
        if (keyBoard.up) {
            velocityY = -3;
        } else if (keyBoard.down) {
            velocityX = 3;
        } else if (keyBoard.left) {
            velocityY = -3;
        } else if (keyBoard.right) {
            velocityY = -3;
        }
    }

    @Override
    protected void move(double xa, double ya) {

    }

    public void animate() {
        if (animate < 7500) {
            animate++;
        } else {
            animate = 0;
        }
    }


}
