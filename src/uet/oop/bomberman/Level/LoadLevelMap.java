package uet.oop.bomberman.Level;

import uet.oop.bomberman.Enemy.*;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadLevelMap {
    private char[][] map;
    private int lv;
    private int h;
    private int w;
    //private List<Entity> entities = new ArrayList<>();
    //private List<Entity> stillObjects = new ArrayList<>();

    public LoadLevelMap() {};

    /**
     * Đọc dữ liệu từ file level.txt.
     * @param level màn chơi.
     */
    public void loadMap(int level) {
        List<String> list = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("res\\levels\\Level" + level + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while (!s.equals("")) {
                list.add(s);
                s = bufferedReader.readLine();
            }
            String[] line = list.get(0).trim().split("\\s+");
            lv = Integer.parseInt(line[0]); // level của map
            h = Integer.parseInt(line[1]); // chieu cao của map.
            w = Integer.parseInt(line[2]); // chiều rộng của map.
            map = new char[h][w];
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = list.get(i + 1).charAt(j);
            }
        }

    }
    public void createMap(List<Entity> entities, List<Enemy> enemies) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Entity object;
                Enemy enemy;
                char c  = map[i][j];
                switch (c) {
                    // Thêm cỏ
                    case ' ':
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                        entities.add(object);
                        break;
                    // thêm tường
                    case '#':
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                        entities.add(object);
                        break;
                    // thêm brick
                    case '*': case 'b': case 'f': case 's': case 'x':
                        object = new Brick(i, j, Sprite.brick.getFxImage());
                        entities.add(object);
                        break;
                    // thêm balloom
                    case '1' :
                        enemy = new Balloom(i, j, Sprite.balloom_left1.getFxImage());
                        enemies.add(enemy);
                        break;
                    // thêm oneal
                    case '2' :
                        enemy = new Oneal(i, j, Sprite.oneal_left1.getFxImage());
                        enemies.add(enemy);
                        break;
                }
            }
        }
    }

}