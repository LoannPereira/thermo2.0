/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionListener;
import metier.Capteur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author pereiraloann
 */
    

public class FenetreDigitalController {
    @FXML
    private TextField textField;
    @FXML
    private Label nom;
    @FXML
    private Label tem;

    private  ObjectProperty<Capteur> monCapteur = new SimpleObjectProperty<>();
        public final Capteur getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(Capteur value) { monCapteur.set(value); }
        public ObjectProperty<Capteur> monCapteurProperty() {return monCapteur;}
        
    
  
    
    public void onExit(Event event){
       // System.out.println("Arret de : "+monCapteur.get());
       // System.out.println("Arret du thread: "+Thread.currentThread());

        //monCapteur.get().arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    public void chargement(Capteur cap){
        setMonCapteur(cap);
        nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        tem.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());
    }
}
