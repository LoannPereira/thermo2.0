/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Capteur extends ComposantCapteurGlobal {
    
    
    
    
    public Capteur(String nomCapteur,int temperature, int frequence) {
        this.setNomCapteur(nomCapteur);
        this.setTemperature(temperature);
        this.setFrequence(frequence);
        
    }

    @Override
    public String toString()
    {
        return String.format("%s", getNomCapteur() );
    }
    
    
}
