/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Random;

/**
 *
 * @author pereiraloann
 */
public class GenerationGlissante extends Generateur {
    Capteur cap;
    MonThread thread;
    Random temperature;
    public long getFrequence(){return cap.getFrequence();}
    public void algo(){
        
    }
    public void demarrer(){
         thread=new MonThread(this);
         thread.start();
    }
    public void arret(){
        thread.interrupt();
    }
}
