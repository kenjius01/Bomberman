package uet.oop.bomberman.entities.Character.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Character.Character;
import uet.oop.bomberman.entities.Entity;

import java.util.zip.CheckedInputStream;

public class Oneal extends Character {

    public Oneal(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

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
    protected boolean canMove(int x, int y) {
        return false;
    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(double xa, double ya) {

    }
}
