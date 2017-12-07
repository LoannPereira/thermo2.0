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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private Label nom;
    @FXML
    private ImageView image;

     private  ObjectProperty<Capteur> monCapteur = new SimpleObjectProperty<>();
        public final Capteur getMonCapteur()  { return monCapteur.get(); }
        public final void setMonCapteur(Capteur value) { monCapteur.set(value); }
        public ObjectProperty<Capteur> monCapteurProperty() {return monCapteur;}
        
    public void initialize(){
        
    }
  
    
    public void onExit(Event event){
       // System.out.println("Arret de : "+monCapteur.get());
       // System.out.println("Arret du thread: "+Thread.currentThread());

        monCapteur.get().arret();
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    }
    public void chargement(Capteur cap){
        Image soleil=new Image("Image/soleil.png");
        Image nuage=new Image("Image/nuage.png");
        Image neige=new Image("Image/neige.png");
        setMonCapteur(cap);
        nom.textProperty().bind(Bindings.select(monCapteur, "nomCapteur"));
        temp.textProperty().bind(Bindings.selectInteger(monCapteur, "temperature").asString());
        getMonCapteur().temperatureProperty().addListener((o,old,newV)->{
            if((int)newV<0){
                System.out.println("neige");
                image.setImage(neige);
            }
            if((int)newV>20){
                System.out.println("soleil");
                image.setImage(soleil);
            }
            if((int)newV>= 0&& (int)newV<=20){
                System.out.println("nuage");
                image.setImage(nuage);
            }
    });
    }
}
