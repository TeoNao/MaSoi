package testSV;

import static java.lang.Thread.sleep;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

class test{
    static int Second = 180;
    public static void clock (){
       Thread th = new Thread(){
           @Override
           public void run() {
               for (int i = 1; i <= 31; i++) {                  
                   System.out.println("ngày "+i);
               for (int iz = 180; iz >= 0 ; iz--) {
                   try {
                       Thread.sleep(100);
                       System.out.println("buổi sáng : "+iz);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   
               }
               for (int iz = 30; iz >= 0; iz--) {
                   try {
                       Thread.sleep(100);
                         System.out.println("buổi tối : "+iz);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 
               }
               }
//               while (true) {                   
//                   System.out.println("hello hello");
//               }
           }           
       };
       th.start();
    }
    public static void main(String[] args) {
        clock();
    }
}