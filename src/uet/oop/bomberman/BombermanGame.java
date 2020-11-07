package uet.oop.bomberman;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.Group;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private boolean inGame = false;



    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();
        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);

        class TAdapter extends KeyAdapter {

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                if (inGame) {
                    if (key == KeyEvent.VK_LEFT) {
                        bomberman.setX(bomberman.getX() - 1);
                        bomberman.setY(bomberman.getY());
                    } else if (key == KeyEvent.VK_RIGHT) {
                        bomberman.setX(bomberman.getX() + 1);
                        bomberman.setY(bomberman.getY());
                    } else if (key == KeyEvent.VK_UP) {
                        bomberman.setX(bomberman.getX());
                        bomberman.setY(bomberman.getY() - 1);
                    } else if (key == KeyEvent.VK_DOWN) {
                        bomberman.setX(bomberman.getX());
                        bomberman.setY(bomberman.getY() + 1);
                    }
                } else {
                    if (key == KeyEvent.VK_SPACE) {
                        inGame = true;
                    }
                }
            }
            
        }

    }
    int[][] map = {
            {0,0,0,0,0,0,0,0},
            {0,1,2,3,2,2,3,0},
            {0,3,2,2,3,3,2,0},
            {0,2,2,3,3,3,3,0},
            {0,3,0,2,0,2,3,0},
            {0,2,2,0,2,2,3,0},
            {0,3,3,2,0,0,2,0},
            {0,2,2,3,3,0,2,0},
    };

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (map[i][j] == 0) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                } else if (map[i][j] == 3) {
                    object = new Brick(i,j, Sprite.brick.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));

    }


    }







