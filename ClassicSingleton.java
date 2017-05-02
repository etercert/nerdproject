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
public class ClassicSingleton {
   private static ClassicSingleton instance = null;
   
   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      
      return instance;
   }
   
   
   
}
