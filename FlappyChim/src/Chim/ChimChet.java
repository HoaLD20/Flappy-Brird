/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chim;

/**
 *
 * @author Le Duc Hoa
 */
public class ChimChet {
    private MyChim mychim = new MyChim();
    public boolean chimchet(){
        
        if(mychim.y + 50 >= 450){
            return true;
        }
        
        return false;
                
    }
    
}
