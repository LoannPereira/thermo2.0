/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Capteur;
import metier.ComposantCapteurGlobal;
import metier.SuperCapteur;

/**
 *
 * @author argiraud
 */
public class ModeleCapteur {
    
    private ObservableList<ComposantCapteurGlobal> lesCapteursObs = FXCollections.observableArrayList();

    private final ListProperty<ComposantCapteurGlobal> lesCapteurs = new SimpleListProperty<>(lesCapteursObs);
        public ObservableList<ComposantCapteurGlobal> getLesCapteurs() {return lesCapteurs.get();}
        public ReadOnlyListProperty<ComposantCapteurGlobal> lesCapteursProperty() {return lesCapteurs;}
    
    public ModeleCapteur(){
        ArrayList<ComposantCapteurGlobal> sousCapteurs=new ArrayList<>();
        ComposantCapteurGlobal salon=new Capteur("Salon",20,1);
        ComposantCapteurGlobal garage=new Capteur("Garage",10,5);
        ComposantCapteurGlobal cabane=new Capteur("Cabane",5,2);
        ComposantCapteurGlobal chambre=new Capteur("Chambre",5,1);
        salon.setPoids(1);
        sousCapteurs.add(salon);
        lesCapteursObs.add(salon);
        lesCapteursObs.add(garage);
        lesCapteursObs.add(cabane);
        lesCapteursObs.add(chambre);
        
        lesCapteursObs.add(new SuperCapteur("Chambre",sousCapteurs));
    }
}
