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
import metier.ComposantCapteurGlobal;
import metier.Generateur;

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
    private Generateur gen;
    private  ObjectProperty<ComposantCapteurGlobal> monCapteur = new SimpleObjectProperty<>();
        public final ComposantCapteurGlobal getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(ComposantCapteurGlobal value) { monCapteur.set(value); }
        public ObjectProperty<ComposantCapteurGlobal> monCapteurProperty() {return monCapteur;}
        
    
  
    
    public void onExit(Event event){
       // System.out.println("Arret de : "+monCapteur.get());
       // System.out.println("Arret du thread: "+Thread.currentThread());

        gen.arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    public void chargement(ComposantCapteurGlobal cap, Generateur gen){
        setMonCapteur(cap);
        this.gen=gen;
        nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        thermo.heightProperty().bind(Bindings.selectInteger(monCapteur,"temperature").add(94));// +94 pour la mise à l'échelle
        tem.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());

    }

}
