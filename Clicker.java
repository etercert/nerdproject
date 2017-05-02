/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Oskar
 */
public class Clicker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ArrayList<Integer> a = new ArrayList<>();*/
        
        /*for(int obj:clickTimes){
            a.add(obj);
        }
        
        ArrayList<Integer> c = new ArrayList<>();
        c = FrequencyEqualizer.equalize(a, 7);*/
        
        int clickTimes[] = {312,298,305,385,319,309,120};
        int clicksButtonNumbers[] = {1,2,1,2,1,2};
        
        SequenceSingleton seq = SequenceSingleton.getInstance();
        seq.setClicks(clicksButtonNumbers, clickTimes);
        
        int tmp[] = seq.getButtonClickTime();
        System.out.print("seq.getButtonClickTime() = [");
        for(int i:tmp) System.out.print(i + "; "); 
        System.out.print("\b\b]");
        System.out.println("");
        
        ArrayList<Integer> a = new ArrayList<>();
        for(int obj:tmp){
            a.add(obj);
        }
        
        ArrayList<Integer> c = new ArrayList<>();
        c = FrequencyEqualizer.equalize(a, 1000);
        
        System.out.println("a = " + a);
        System.out.println("c = " + c);
    
    }
    
    
    
}
