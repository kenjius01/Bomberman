package uet.oop.bomberman.entities.Character;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BombermanController extends Bomberman implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        boolean inGame = false;


        if (inGame) {
            if (key == KeyEvent.VK_LEFT) {
                x = x - 1;
                //bomberman.setX(bomberman.getX() - 1);
                //bomberman.setY(bomberman.getY());
            } else if (key == KeyEvent.VK_RIGHT) {
                x = x + 1;
                //bomberman.setX(bomberman.getX() + 1);
                //bomberman.setY(bomberman.getY());
            } else if (key == KeyEvent.VK_UP) {
                y = y - 1;
                //bomberman.setX(bomberman.getX());
                //bomberman.setY(bomberman.getY() - 1);
            } else if (key == KeyEvent.VK_DOWN) {
                y = y + 1;
                System.out.println("down");
                //bomberman.setX(bomberman.getX());
                //bomberman.setY(bomberman.getY() + 1);
            }
        } else {
            if (key == KeyEvent.VK_SPACE) {
                inGame = true;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
