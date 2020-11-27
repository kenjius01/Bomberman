package uet.oop.bomberman.Input;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyBoard implements EventHandler<KeyEvent> {

    public boolean up = false;
    public boolean down = false;
    public boolean left = false;
    public boolean right = false;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                up = true;
                break;
            case DOWN:
                down = true;
                break;
            case LEFT:
                left = true;
                break;
            case RIGHT:
                right = true;
                break;
            case SPACE:

                break;
        }
    }
}
