package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Obstacle.Brick;

import javax.security.auth.Destroyable;
import java.util.LinkedList;

public  class Hiden extends Entity {
    protected LinkedList<Entity> linkedList = new LinkedList<>();

    public Hiden(int _x, int _y, Entity ... entities) {
        x = _x;
        y = _y;

        for (int i = 0; i < entities.length; i++) {
            linkedList.add(entities[i]);
            if (i > 1) {
                if (entities[i] instanceof Brick) {
                    ((Brick) entities[i]).addBelowImage(entities[i-1].getImg());
                }
            }
        }
    }

    public Hiden(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }


    @Override
    public void update() {
        clearRemoved();
        getTopEntity().update();
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(getTopEntity().getImg(), getTopEntity().getX(), getTopEntity().getY());
    }

    public Entity getTopEntity() {

        return linkedList.getLast();
    }

    @Override
    public boolean collide(Entity e) {
        return getTopEntity().collide(e);
    }

    private void clearRemoved() {
        Entity top  = getTopEntity();

        if(top.isRemoved())  {
            linkedList.removeLast();
        }
    }
}
