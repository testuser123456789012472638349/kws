package dynamic_beat_1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public DynamicBeat() {
        setTitle("DynamicBeat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        introBackground = new ImageIcon(Main.class.getResource("../imges/introBackground.png")).getImage();
    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0,0, null );
    }
    public void screenDraw(Graphics g) {
        g.drawImage(introBackground,0,0,null);
        this.repaint();
    }
}

