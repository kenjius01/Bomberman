package uet.oop.bomberman.Level;

import uet.oop.bomberman.entities.Character.Character;
import uet.oop.bomberman.entities.Character.Enemy.*;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Obstacle.Brick;
import uet.oop.bomberman.entities.Wallpaper.Portal;
import uet.oop.bomberman.entities.Wallpaper.Wall;
import uet.oop.bomberman.entities.Wallpaper.Grass;
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] line = list.get(0).trim().split("\\s+");
        lv = Integer.parseInt(line[0]); // level của map
        h = Integer.parseInt(line[1]); // chieu cao của map.
        w = Integer.parseInt(line[2]); // chiều rộng của map.
        map = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                map[i][j] = list.get(i + 1).charAt(j);
            }
        }

    }
    public void createMap(List<Entity> entities, List<Character> characters) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Entity object;
                Character ch;
                char c  = map[i][j];
                switch (c) {
                    // Thêm cỏ
                    case ' ':
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        entities.add(object);
                        break;
                    // thêm tường
                    case '#':
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                        entities.add(object);
                        break;
                    // thêm brick
                    case '*':
                        entities.add(new Hiden(j, i, new Grass(j, i, Sprite.grass.getFxImage()),
                                new Brick(j, i, Sprite.brick.getFxImage())));
                        break;
                    // thêm balloom
                    case '1' :
                        ch = new Balloom(j, i, Sprite.balloom_left1.getFxImage());
                        entities.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        characters.add(ch);
                        break;
                    // thêm oneal
                    case '2' :
                        ch = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                        entities.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        characters.add(ch);
                        break;
                    /*case 'p' :
                        //bomberman = new Bomberman(1, 1, Sprite.player_right.getFxImage(),new KeyBoard(), new Released());
                        entities.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        characters.add(bomberman);
                        break;*/
                    case 'x':
                        entities.add(new Hiden(j, i,
                                new Grass(j, i, Sprite.grass.getFxImage()),
                                new Portal(j, i, Sprite.portal.getFxImage()),
                                new Brick(j, i, Sprite.brick.getFxImage())));
                        break;
                    default:
                        entities.add(new Grass(j, i, Sprite.grass.getFxImage()));
                        break;
                }
            }
        }
    }
}