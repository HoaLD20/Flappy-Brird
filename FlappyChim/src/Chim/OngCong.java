/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Le Duc Hoa
 */
public class OngCong extends JPanel {

    /*set x for each ong cong*/
    private static int x1 = 450;
    private static int x2 = x1 + 250;
    private static int x3 = x2 + 250;
    private static int x4 = x3 + 250;
    private static int x5 = x4 + 250;

    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getX3() {
        return x3;
    }

    public static int getX4() {
        return x4;
    }

    public static int getX5() {
        return x5;
    }

    public static int getH1() {
        return h1;
    }

    public static int getH2() {
        return h2;
    }

    public static int getH3() {
        return h3;
    }

    public static int getH4() {
        return h4;
    }

    public static int getH5() {
        return h5;
    }

    /*set random height for each ong cong*/
    private static int h1, h2, h3, h4, h5;

    /*Stop random for each ong cong*/
    public static boolean pause1 = false;
    public static boolean pause2 = false;
    public static boolean pause3 = false;
    public static boolean pause4 = false;
    public static boolean pause5 = false;

    private BufferedImage ongcongtren, ongcongduoi;

    public void randomHeight() {
        Random rd = new Random();
        if (pause1 == false) {
            h1 = rd.nextInt(200);
            pause1 = true;
        }
        if (pause2 == false) {
            h2 = rd.nextInt(200);
            pause2 = true;
        }
        if (pause3 == false) {
            h3 = rd.nextInt(200);
            pause3 = true;
        }
        if (pause4 == false) {
            h4 = rd.nextInt(200);
            pause4 = true;

        }
        if (pause5 == false) {
            h5 = rd.nextInt(200);
            pause5 = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        try {
            randomHeight();
            ongcongtren = ImageIO.read(new File("./src/UI/Ongnuoctren.png"));
            ongcongduoi = ImageIO.read(new File("./src/UI/Ongnuocduoi.png"));

            /**
             * x, y, r, d x| | | | | | | | |______| y
             */
            /*Ong cong 1*/
            g.drawImage(ongcongtren, x1, 0, 100, h1, null);
            g.drawImage(ongcongduoi, x1, h1 + 300, 100, 400, null);

            /*Ong cong 2*/
            g.drawImage(ongcongtren, x2, 0, 100, h1, null);
            g.drawImage(ongcongduoi, x2, h2 + 300, 100, 400, null);

            /*Ong cong 3*/
//            g.setColor(Color.green);
//            g.fillRect(x3, 0, 100, h3);
//            
//            g.setColor(Color.green);
//            g.fillRect(x3, h3 + 300, 100, 400);
            g.drawImage(ongcongtren, x3, 0, 100, h3, null);
            g.drawImage(ongcongduoi, x3, h3 + 300, 100, 400, null);

            /*Ong cong 4*/
            g.drawImage(ongcongtren, x4, 0, 100, h4, null);
            g.drawImage(ongcongduoi, x4, h4 + 300, 100, 400, null);

            /*Ong cong 5*/
            g.drawImage(ongcongtren, x5, 0, 100, h5, null);
            g.drawImage(ongcongduoi, x5, h5 + 300, 100, 400, null);
        } catch (IOException ex) {
            Logger.getLogger(OngCong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void moveOngcong() {
        x1--;
        x2--;
        x3--;
        x4--;
        x5--;
    }

    public void repeatOngcong() {
        if (x1 == -100) {
            x1 = 1000;
            pause1 = false;
        }
        if (x2 == -100) {
            x2 = 1000;
            pause2 = false;
        }
        if (x3 == -100) {
            x3 = 1000;
            pause3 = false;
        }
        if (x4 == -100) {
            x4 = 1000;
            pause4 = false;
        }
        if (x5 == -100) {
            x5 = 1000;
            pause5 = false;
        }
    }

}
