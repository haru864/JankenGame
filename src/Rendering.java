import java.awt.Image;
import javax.swing.ImageIcon;

public class Rendering {
    public static ImageIcon renderingImageIcon(ImageIcon imgIcon) {
        double magnification = 0.5;
        int iconWidth = (int) (imgIcon.getIconWidth() * magnification);
        int iconHeight = (int) (imgIcon.getIconHeight() * magnification);

        Image smallImage = imgIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);

        imgIcon = new ImageIcon(smallImage);

        return imgIcon;
    }
}
