package uet.oop.bomberman.entities.Character;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class Character extends Entity {
    protected int direction = -1;
    protected boolean alive = true;
    protected boolean moving = false;
    public int timeAfter = 40;

    public Character(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }



    @Override
    public abstract void update();

    //protected abstract void calculateMove();

    //protected abstract void move(double xa, double ya);

    public abstract void kill();

    public abstract void afterKill();

    protected abstract boolean canMove(double x, double y);

    protected abstract void calculateMove();

    protected abstract void move(double xa, double ya);


    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }

}
