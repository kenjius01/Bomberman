package uet.oop.bomberman;

import javafx.scene.image.Image;

public class vacham {
    public boolean vch(Image img1,int x, int y, Image img2, int x1, int y1) {
        if (x + img1.getWidth() >= x1 &&
           x1 + img2.getWidth() >= x) {
             if (y + img1.getHeight() >= y1
             && img2.getHeight() + y1 >= y) {
                  return true;
             }
        }
        if (y + img1.getHeight() >= y1
                && img2.getHeight() + y1 >= y) {
            if (x + img1.getWidth() >= x1 &&
                    x1 + img2.getWidth() >= x) {
                return true;
            }
        }
        return false;

    }
}
