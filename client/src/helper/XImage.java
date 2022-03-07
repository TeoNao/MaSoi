/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author thaip
 */
public class XImage {
    static final int white = 800;
    static final int height = 500;

    public static Image getApplcon() {
        URL url = XImage.class.getResource("/img/iconAppl.png");
        return new ImageIcon(url).getImage();
    }
    public static ImageIcon reads(String fordel, String nameImg, JLabel jLabel) throws IOException {
        File path = new File("src/"+ fordel +"/" + nameImg);
        BufferedImage icon = ImageIO.read(path);
        return new ImageIcon(icon.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH));
    }
    public static ImageIcon read(String nameImg) throws IOException {
        File path = new File("src/img/" + nameImg);
        BufferedImage icon = ImageIO.read(path);
        return new ImageIcon(icon.getScaledInstance(white, height, Image.SCALE_SMOOTH));
    }
}
