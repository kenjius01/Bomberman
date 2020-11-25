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
    public KeyBoard keyBoard;

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
        //animate();

        calculateMove();


    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

//----ham kiem tra di chuyen
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
//-----ham di chuyen nhan vat
    @Override
    protected void calculateMove() {
        if (keyBoard.up) {
            x = x - 3;
        } else if (keyBoard.down) {
            x = x + 3;
        } else if (keyBoard.left) {
            y = y + 3;
        } else if (keyBoard.right) {
            y = y - 3;
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
