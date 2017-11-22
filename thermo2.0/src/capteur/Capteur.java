/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteur;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
       
    private final IntegerProperty frequence = new SimpleIntegerProperty();
        public int getFrequence() {return frequence.get();}
        public void setFrequence(int frequence) {this.frequence.set(frequence);}
        public IntegerProperty frequenceProperty(){return frequence;}
    
   
   
    
    public Capteur(String nomCapteur,int temperature, int frequence) {
        setNomCapteur(nomCapteur);
        setTemperature(temperature);
        setFrequence(frequence);
    }
    
    @Override
    public String toString()
    {
        return String.format("%s", getNomCapteur() );
    }
    
    
}
