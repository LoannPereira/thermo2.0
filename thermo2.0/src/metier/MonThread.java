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
    private final Capteur capteur;

    Random temperature = new Random();
    public MonThread(Capteur capteur){
        this.capteur=capteur;
    }
    @Override
    public void run(){
        while(true){
            System.out.println("temperature ="+capteur.getTemperature());
            Platform.runLater(new Runnable() {
            @Override
             public void run() {
                 capteur.setTemperature(temperature.nextInt(100)-50);
            }
            });
            try {
                Thread.sleep(capteur.getFrequence()*1000);
                
               
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
