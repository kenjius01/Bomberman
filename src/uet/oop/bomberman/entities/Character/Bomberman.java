package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Bomberman extends Character {
    public Bomberman(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    @Override
    public void update() {

    }

    @Override
    protected void calculateMove() {

    }

    @Override
    protected void move(double xa, double ya) {

    }

    @Override
    public void kill() {

    }

    @Override
    protected boolean canMove(double x, double y) {
        return false;
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

}