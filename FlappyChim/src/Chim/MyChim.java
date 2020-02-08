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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Le Duc Hoa
 */
public class MyChim {
    
    static int y = 250;
    static int x = 300;
    private static BufferedImage chim;
            
    
    public void paint(Graphics g){
        try {
            //        g.setColor(Color.red);
//        g.fillRect(200, y, 50, 50);
            chim = ImageIO.read(new File("./src/UI/Bird.png"));
            g.drawImage(chim, x, y, null);
        } catch (IOException ex) {
            Logger.getLogger(MyChim.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*Chim bay*/
    public void baylen(){
        y-= 80;
    }
    /*Chim chet*/
    public void rotxuong(){
        y++;
    }
}
