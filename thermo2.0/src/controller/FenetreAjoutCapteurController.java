/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import metier.Capteur;
import modele.ModeleCapteur;

/**
 *
 * @author pereiraloann
 */
public class FenetreAjoutCapteurController {
    @FXML
    private TextField nom;
    @FXML
    private TextField temp;
    @FXML
    private TextField freq;
    @FXML
    private Label ermsg;
    
    ObservableList<Capteur> modele;
    
    public void ajoutCapteur(Event event){
        if(nom.getText().isEmpty()||temp.getText().isEmpty()||freq.getText().isEmpty()){
            ermsg.setVisible(true);
        }else{
            modele.add(new Capteur(nom.getText(),Integer.parseInt(temp.getText()),Integer.parseInt(freq.getText())));
            ((Node)event.getSource()).getScene().getWindow().hide();

        }
    }
    
    public void getModel(ObservableList<Capteur> m){
        modele = m;
    }
    
   
}
