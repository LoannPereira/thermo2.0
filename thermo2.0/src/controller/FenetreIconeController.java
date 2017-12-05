/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import metier.Capteur;

/**
 *
 * @author pereiraloann
 */
public class FenetreIconeController {
    @FXML
    private Label nomCapteur;
    @FXML
    private Label temp;

    private  ObjectProperty<Capteur> monCapteur = new SimpleObjectProperty<>(new Capteur("lambda", 666, 1));
        public final Capteur getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(Capteur value) { monCapteur.set(value); }
        public ObjectProperty<Capteur> monCapteurProperty() {return monCapteur;}
        
    
    public void initialize() {
        //nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        //temp.textProperty().bind(Bindings.select(monCapteur,"temperature"));
        
    }
    public void onExit(Event event){
        monCapteur.get().arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    public void chargement(Capteur cap){
        setMonCapteur(cap);
        nomCapteur.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        temp.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());
    }
}
