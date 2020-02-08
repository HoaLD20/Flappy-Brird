/**
 *
 * @author Le Duc Hoa
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

public class Draw extends JPanel implements Runnable {

    MyChim mychim = new MyChim();
    OngCong ongcong = new OngCong();
    ChimChet chimchet = new ChimChet();
    
    private BufferedImage background, matdat;
    
    Thread threadchim;
    
    public Draw() {
        Thread threadDraw = new Thread(this);
        threadDraw.start();
    }

    public void paint(Graphics g) {
        try {
            
            background = ImageIO.read(new File("./src/UI/BG_2.png"));
            g.drawImage(background, 0, 0, null);
            
          
            
            ongcong.paint(g);
            
//            g.setColor(Color.green);
//            g.fillRect(0, 450, getWidth(), getHeight());
//            
//            g.setColor(Color.orange);
//            g.fillRect(0, 475, getWidth(), getHeight());
            matdat = ImageIO.read(new File("./src/UI/NenDat.png"));
            g.drawImage(matdat, 0, 460, null);
            g.drawImage(matdat, 400, 460, null);
            g.drawImage(matdat, 800, 460, null);
                    
            
            mychim.paint(g);
        } catch (IOException ex) {
            Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }

    @Override
    public void run() {
        while(true){
            repaint();
            ongcong.moveOngcong();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
            }
            ongcong.repeatOngcong();
            mychim.rotxuong();
            chimchet.chimchet(); 
            if(chimchet.chimchet() == true){
                threadchim.stop();
            }
        }
    }

}
