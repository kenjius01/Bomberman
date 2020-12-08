package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.vacham;

import java.util.Iterator;

import static uet.oop.bomberman.BombermanGame.entities;

public class Bomberman extends Character {
    protected int timeBetweenPutBombs = 0;
    protected int animate = 0;
    protected boolean up, down, left, right;
    vacham vc = new vacham();

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
    protected boolean canMove(int x, int y) {
//        int dx, dy;
//        if (x == 0 && y < 0) {
//            //trên trai
//            dx = x + getX();
//            dy = y + getY();
//            Entity a = getEntity(dx, dy);
//            if (!a.collide(this)) {
//                return false;
//            }
//            //trên phai
//            dx = getX() + x + 22;
//            dy = getY() + y;
//            Entity a2 = getEntity(dx, dy);
//            if (!a2.collide(this)) {
//                return false;
//            }
//            //goc duoi trai
//            dx = x + getX();
//            dy = y + getY() + 31;
//            Entity a3 = getEntity(dx, dy);
//            if (!a3.collide(this)) {
//                return false;
//            }
//            //goc duoi phai
//            dx = x + getX() + 22;
//            dy = y + getY() + 31;
//            Entity a4 = getEntity(dx, dy);
//            if (!a4.collide(this)) {
//                return false;
//            }
//
//        } else if (x == 0 && y > 0) {
//            //trên trai
//            dx = x + getX();
//            dy = y + getY();
//            Entity a = getEntity(dx, dy);
//            if (!a.collide(this)) {
//                return false;
//            }
//            //trên phai
//            dx = getX() + x + 22;
//            dy = getY() + y;
//            Entity a2 = getEntity(dx, dy);
//            if (!a2.collide(this)) {
//                return false;
//            }
//            //goc duoi trai
//            dx = x + getX();
//            dy = y + getY() + 31;
//            Entity a3 = getEntity(dx, dy);
//            if (!a3.collide(this)) {
//                return false;
//            }
//            //goc duoi phai
//            dx = x + getX() + 22;
//            dy = y + getY() + 31;
//            Entity a4 = getEntity(dx, dy);
//            if (!a4.collide(this)) {
//                return false;
//            }
//        } else if (x < 0 && y == 0) {
//            //trên trai
//            dx = x + getX();
//            dy = y + getY() + 2;
//            Entity a = getEntity(dx, dy);
//            if (!a.collide(this)) {
//                return false;
//            }
//            //trên phai
//            dx = getX() + x + 20;
//            dy = getY() + y + 2;
//            Entity a2 = getEntity(dx, dy);
//            if (!a2.collide(this)) {
//                return false;
//            }
//            //goc duoi trai
//            dx = x + getX();
//            dy = y + getY() + 31;
//            Entity a3 = getEntity(dx, dy);
//            if (!a3.collide(this)) {
//                return false;
//            }
//            //goc duoi phai
//            dx = x + getX() ;
//            dy = y + getY() ;
//            Entity a4 = getEntity(dx, dy);
//            if (!a4.collide(this)) {
//                return false;
//            }
//        } else if (x > 0 && y ==0) {
//            //trên trai
//            dx = x + getX();
//            dy = y + getY();
//            Entity a = getEntity(dx, dy);
//            if (!a.collide(this)) {
//                return false;
//            }
//            //trên phai
//            dx = getX() + x ;
//            dy = getY() + y ;
//            Entity a2 = getEntity(dx, dy);
//            if (!a2.collide(this)) {
//                return false;
//            }
//            //goc duoi trai
//            dx = x + getX() ;
//            dy = y + getY() ;
//            Entity a3 = getEntity(dx, dy);
//            if (!a3.collide(this)) {
//                return false;
//            }
//            //goc duoi phai
//            dx = x + getX() ;
//            dy = y + getY() ;
//            Entity a4 = getEntity(dx, dy);
//            if (!a4.collide(this)) {
//                return false;
//            }
//        }
        return true;
    }

    //-----ham di chuyen nhan vat
    @Override
    protected void calculateMove() {
        if (this.isUp()) {
            if (canMove(0, 1)) this.setY(1);
            setImg(Sprite.movingSprite(Sprite.player_up_1,
                    Sprite.player_up_2, animate, 20).getFxImage());
        } else if (this.isDown()) {
            if (canMove(0,1)) this.setY(1);
            setImg(Sprite.movingSprite(Sprite.player_down_1,
                    Sprite.player_down_2, animate, 20).getFxImage());
        } else if (this.isLeft()) {
            if (canMove(1,0)) this.setX(1);
            setImg(Sprite.movingSprite(Sprite.player_left_1,
                    Sprite.player_left_2, animate, 20).getFxImage());
        } else if (this.isRight()) {
            if (canMove(1,0)) this.setX(1);
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

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public Entity getEntity(int x, int y) {
        Iterator<Entity> e = entities.iterator();
        Entity m;
        while (e.hasNext()) {
            m = e.next();
            if (m.getX() == x && m.getY() == y) {
                return m;
            }
        } return null;
    }
}

