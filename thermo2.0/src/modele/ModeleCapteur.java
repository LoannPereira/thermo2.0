/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Capteur;

/**
 *
 * @author argiraud
 */
public class ModeleCapteur {
    
    private ObservableList<Capteur> lesCapteursObs = FXCollections.observableArrayList();

    private final ListProperty<Capteur> lesCapteurs = new SimpleListProperty<>(lesCapteursObs);
        public ObservableList<Capteur> getLesCapteurs() {return lesCapteurs.get();}
        public ReadOnlyListProperty<Capteur> lesCapteursProperty() {return lesCapteurs;}

    public ModeleCapteur(){
        lesCapteursObs.add(new Capteur("Capteur1",20,2));
        lesCapteursObs.add(new Capteur("Capteur2",10,5));
        lesCapteursObs.add(new Capteur("Capteur3",5,1));
    }
}
