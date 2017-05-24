/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker;
import java.util.ArrayList;

/**
 *
 * @author Oskar
 */
public abstract class FrequencyEqualizer {

    /**
     *
     * @param clicks
     * @return
     */
    static public ArrayList<Integer> equalize(ArrayList<Integer> clicksInput, int tempo){
        ArrayList<Integer> clicksOutput = new ArrayList<>();
        
        int n = clicksInput.size();
//         Nie możemy tego tak zrobić bo nie ma Javy 8
//        double mean = clicksInput.stream().mapToInt(Integer::intValue).sum();
        double mean = 0;
        for (Integer click: clicksInput) {
            mean += click;
        }
        mean = mean/n;
        System.out.println("mean = " + mean);
        
        int currentClick = 0;
        Double  tmp = 0.0;
        
        for(int i=0; i<n; i++){
            currentClick = clicksInput.get(i);
            
            if (currentClick <= mean/2) {
                tmp = (double)tempo/2;                
                clicksOutput.add(tmp.intValue());
            }
            else {
                clicksOutput.add(tempo);
            }
        }
        return(clicksOutput);
                
    }
    
    static public ArrayList<Integer> cumsum(ArrayList<Integer> clicksInput) { //suma kumulacyjna [1, 1, 1] -> [1, 2, 3]
        ArrayList<Integer> clicksOutput = new ArrayList<>();
        
        return clicksOutput;
        
    }
}

    