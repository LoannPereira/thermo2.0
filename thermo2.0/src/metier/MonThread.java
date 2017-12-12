/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Random;
import javafx.application.Platform;

/**
 *
 * @author argiraud
 */
    

public class MonThread extends Thread {
    private final Generateur gen;

    //Random temperature = new Random();
    public MonThread(Generateur gen){
        this.gen=gen;
    }
    @Override
    public void run(){
        while(true){
            //System.out.println("temperature ="+capteur.getTemperature());
            Platform.runLater(() -> gen.algo());
            try {
                Thread.sleep(gen.getFrequence());
                
               
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
    
}
