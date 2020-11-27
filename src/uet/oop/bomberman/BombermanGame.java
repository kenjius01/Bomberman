package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import uet.oop.bomberman.Input.KeyBoard;
import uet.oop.bomberman.entities.Character.Bomberman;
import uet.oop.bomberman.Level.LoadLevelMap;
import uet.oop.bomberman.entities.Character.Character;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class BombermanGame extends Application {

    public static final int WIDTH = 20;
    public static final int HEIGHT = 15;
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Character> characters = new ArrayList<>();
    public Bomberman bomberman;




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

        bomberman = new Bomberman(1, 1, Sprite.player_right.getFxImage(),new KeyBoard());



        LoadLevelMap loadLevelMap = new LoadLevelMap();
        loadLevelMap.loadMap(1);
        loadLevelMap.createMap(entities, characters, bomberman);

        scene.setOnKeyPressed(bomberman.keyBoard);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
                update();

            }
        };
        timer.start();
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
        for (Character character : characters) {
            character.update();
        }
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Entity entity : entities) {
            entity.render(gc);
        }
        for (Character g : characters) {
            g.render(gc);
        }
    }
}