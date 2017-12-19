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
public class GenerationInter extends Generateur {
    Capteur cap;
    MonThread thread;
    int min,max;
    Random temperature;
    public GenerationInter(){}
    public GenerationInter(Capteur cap, int min, int max){
        this.cap = cap;
        this.min=min;
        this.max=max;
        temperature=new Random();
    }
    public long getFrequence(){return cap.getFrequence();}
    public void algo(){
        cap.setTemperature(temperature.nextInt(Math.abs(min)+Math.abs(max))-Math.abs(min));
    }
   public void demarrer(){
         thread=new MonThread(this);
         thread.start();
    }
    public void arret(){
        thread.interrupt();
    }
}
