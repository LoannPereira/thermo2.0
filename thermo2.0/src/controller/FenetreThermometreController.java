/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import metier.Capteur;

/**
 *
 * @author pereiraloann
 */
public class FenetreThermometreController {
    
    @FXML
    private Label nom;
    @FXML
    private Rectangle thermo ;
    @FXML
    private Label tem;

    private  ObjectProperty<Capteur> monCapteur = new SimpleObjectProperty<>();
        public final Capteur getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(Capteur value) { monCapteur.set(value); }
        public ObjectProperty<Capteur> monCapteurProperty() {return monCapteur;}
        
    
  
    
    public void onExit(Event event){
       // System.out.println("Arret de : "+monCapteur.get());
       // System.out.println("Arret du thread: "+Thread.currentThread());

        monCapteur.get().arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    public void chargement(Capteur cap){
        setMonCapteur(cap);
        nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        thermo.heightProperty().bind(Bindings.selectInteger(monCapteur,"temperature").add(94));// +94 pour la mise à l'échelle
        tem.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());

    }

}
