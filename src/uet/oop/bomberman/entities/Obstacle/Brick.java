package uet.oop.bomberman.entities.Obstacle;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    private final int MAX_ANIMATE = 7500;
    private int animate = 0;
    protected boolean destroyed = false;
    protected int timeToDisapear = 20;
    protected Image belowImage = Sprite.grass.getFxImage();


    public Brick(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void update() {

    }

    public void render(GraphicsContext gc) {
        if (destroyed) {
            img = movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2).getFxImage();
            gc.drawImage(img, x, y);
        }
    }

        protected Sprite movingSprite (Sprite normal, Sprite x1, Sprite x2){
            int calc = animate % 30;

            if (calc < 10) {
                return normal;
            }

            if (calc < 20) {
                return x1;
            }

            return x2;
        }


        @Override
        public boolean collide (Entity e){
            return false;
        }

        public void addBelowImage(Image image) {
            belowImage = image;
        }


}
