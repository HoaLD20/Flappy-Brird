/**
 *
 * @author Le Duc Hoa
 */
package Chim;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


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
        y-= 40;
    }
    /*Chim chet*/
    public void rotxuong(){
        y++;
    }
}
