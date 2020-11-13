package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.Bomber.Bomberman;
import uet.oop.bomberman.Enemy.Enemy;
import uet.oop.bomberman.Level.LoadLevelMap;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 31;

    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Enemy> items = new ArrayList<>();
    private Bomberman bomberman = new Bomberman();


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
        LoadLevelMap loadLevelMap = new LoadLevelMap();
        loadLevelMap.loadMap(1);
        loadLevelMap.createMap(entities, enemies);



    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        bomberman = new Bomberman(1, 1, Sprite.player_right.getFxImage());
        bomberman.render(gc);
        entities.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
    }
}