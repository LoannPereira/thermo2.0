/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author argiraud
 */
public class Capteur {
    
    private final StringProperty nomCapteur = new SimpleStringProperty();
        public String getNomCapteur() {return nomCapteur.get();}
        public void setNomCapteur(String nom) {this.nomCapteur.set(nom);}
        public StringProperty nomCapteurProperty(){return nomCapteur;}

    private final IntegerProperty temperature = new SimpleIntegerProperty();
        public int getTemperature() {return temperature.get();}
        public void setTemperature(int temperature) {this.temperature.set(temperature);}
        public IntegerProperty temperatureProperty(){return temperature;}
       
    private final LongProperty frequence = new SimpleLongProperty();
        public long getFrequence() {return frequence.get();}
        public void setFrequence(int frequence) {this.frequence.set(frequence);}
        public LongProperty frequenceProperty(){return frequence;}
    
    private static final int TMAX=50;
    
    private static final int TMIN=-50;
    MonThread t ;
    
    
    public Capteur(String nomCapteur,int temperature, int frequence) {
        this.nomCapteur.set(nomCapteur);
        this.temperature.set(temperature);
        this.frequence.set(frequence);
        t= new MonThread(this);
        t.setName("TH"+nomCapteur);
    }

    public void arret(){
        System.out.println("Arret du thread: "+t);
        t.interrupt();
    }
    public void demarrer(){
        System.out.println("demarrage du thread: "+t);
        t.start();
        
    }
    
    
    @Override
    public String toString()
    {
        return String.format("%s", getNomCapteur() );
    }
    
    
}
