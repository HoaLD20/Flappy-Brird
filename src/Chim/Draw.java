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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Draw extends JPanel implements Runnable {

    MyChim mychim = new MyChim();
    OngCong ongcong = new OngCong();
    ChimChet chimchet = new ChimChet();

    private BufferedImage background, matdat;

    Thread threadchim;

    /*get sound effect*/
    public static void sound(String filepath) {
        InputStream sound;
        try{
            
            sound = new FileInputStream(new File(filepath));
            AudioStream audio = new AudioStream(sound);
            AudioPlayer.player.start(audio);
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    /*----------------------*/

    public Draw() {
        Thread threadDraw = new Thread(this);
        threadDraw.start();
    }

    public void paint(Graphics g) {
        try {

            background = ImageIO.read(new File("./src/UI/bg.jpg"));
            g.drawImage(background, 0, 0, null);
            g.drawImage(background, 284, 0, null);
            g.drawImage(background, 568, 0, null);
            g.drawImage(background, 568 + 284, 0, null);

            ongcong.paint(g);

//            g.setColor(Color.green);
//            g.fillRect(0, 450, getWidth(), getHeight());
//            
//            g.setColor(Color.orange);
//            g.fillRect(0, 475, getWidth(), getHeight());
            matdat = ImageIO.read(new File("./src/UI/ground.png"));
            g.drawImage(matdat, 0, 480, null);
            g.drawImage(matdat, 336, 480, null);
            g.drawImage(matdat, 336 * 2, 480, null);
            g.drawImage(matdat, 336 * 3, 480, null);

            mychim.paint(g);
        } catch (IOException ex) {
            Logger.getLogger(Draw.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void run() {

        while (true) {
            repaint();
            
            ongcong.moveOngcong();
            try {
                Thread.sleep(5);

            } catch (InterruptedException ex) {
                Logger.getLogger(Draw.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            ongcong.repeatOngcong();
            mychim.rotxuong();
            chimchet.chimchet();
            if (chimchet.chimchet() == true) {
                threadchim.stop();
            }
        }
    }

}
