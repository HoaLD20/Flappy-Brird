/**
 *
 * @author Le Duc Hoa
 */
package Chim;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;


public class Screen extends JFrame{
    
    private Draw draw = new Draw();
    private MyChim mychim = new MyChim();
    
    /**
     * Show screen with height 600 and width 1000
     * Click x in window, my bird will stop
     * Set location when screen appear: 
     *     O ___________ x = 400
     *      |
     *      |
     *      |
     *y =250|
     */     
    
    public Screen(){
        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 250);
        add(draw);
        
        /*Nhan gia tri tu ban phim*/
        addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent e) {
                mychim.baylen();
                       
            }
            
        });
        /*Nhan tin hieu tu chuot*/
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                mychim.baylen();
            }
            
});
    
        
       
    }
    
    /**/
    public static void main(String[] args) {
        Screen screen = new Screen();
        Draw.sound("D:\\Dengue Fever - Integration.mp3");
    }
}
