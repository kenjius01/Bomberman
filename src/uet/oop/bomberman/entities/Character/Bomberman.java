package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.Input.KeyBoard;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Bomberman extends Character {
    protected int timeBetweenPutBombs = 0;
    protected int animate = 0;
    public KeyBoard keyBoard;

    //----ham khoi tao
    public Bomberman(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public Bomberman(int xUnit, int yUnit, Image img, KeyBoard keyBoard) {
        super(xUnit, yUnit, img);
        this.keyBoard = keyBoard;

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
            this.setY(-1);
            setImg(Sprite.movingSprite(Sprite.player_up_1,
                    Sprite.player_up_2, animate, 20).getFxImage());
        } else if (keyBoard.down) {
            this.setY(1);
            setImg(Sprite.movingSprite(Sprite.player_down_1,
                    Sprite.player_down_2, animate, 20).getFxImage());
        } else if (keyBoard.left) {
            this.setX(-1);
            setImg(Sprite.movingSprite(Sprite.player_left_1,
                    Sprite.player_left_2, animate, 20).getFxImage());
        } else if (keyBoard.right) {
            this.setX(1);
            setImg(Sprite.movingSprite(Sprite.player_right_1,
                    Sprite.player_right_2, animate, 20).getFxImage());
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

