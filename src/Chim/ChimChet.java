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
    private final MyChim mychim = new MyChim();
    
    /*Chim rot xuong dat -> chim chet*/
    public boolean chimchet(){
        
        if(mychim.y >= 480 - 40 || mychim.y <= 15){
            return true;
        }
        
       
        
        return false;
                
    }
    
}
