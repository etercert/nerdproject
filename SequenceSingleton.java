/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

/**
 *
 * @author Oskar
 */
public class SequenceSingleton {
    private static SequenceSingleton instance = null;
    private int[] clickedButtonNumber;
    private int[] buttonClickTime;

    private SequenceSingleton() {
    }
    
    public static SequenceSingleton getInstance() {
        if (instance == null) {
            instance = new SequenceSingleton() ;
        }
        return instance;
    }

    public void setClicks(int[] clickedButtonNumber, int[] buttonClickTime) {
        if (clickedButtonNumber.length + 1 != buttonClickTime.length) {
            System.out.println("Given vectors must be of the same length!");
        }
        else {        
            this.clickedButtonNumber = clickedButtonNumber;
            this.buttonClickTime = buttonClickTime;
        }
        
    }

    
    

    public int[] getClickedButtonNumber() {
        return clickedButtonNumber;
    }

    public int[] getButtonClickTime() {
        return buttonClickTime;
    }

    
    
    
}