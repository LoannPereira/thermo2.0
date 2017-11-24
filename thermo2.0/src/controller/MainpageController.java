/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import metier.Capteur;
import modele.ModeleCapteur;

/**
 *
 * @author lopereira2
 */
public class MainpageController {
    
    @FXML
    MenuButton menubtn;
    @FXML
    Label ermsg;
    @FXML
    private ListView listecapteurs;
    
    public void digit(){
        menubtn.setText("Digital");
    }
    
    public void thermo(){
        menubtn.setText("Thermometre");
    }
    
    public void icone(){
        menubtn.setText("Icones");
    }
    ModeleCapteur data = new ModeleCapteur();
    ObservableList<Capteur> ObsCapteurs = data.getLesCapteurs();

    @FXML
    public void initialize() {
        
        listecapteurs.setItems(ObsCapteurs);
       
        
    }
    
    public void validation() throws IOException{
        switch(menubtn.getText()){
            case "Digital":
                Stage digitale = new Stage();
                Parent digit = FXMLLoader.load(getClass().getResource("/ihm/FenetreDigital.fxml"));
                digitale.setScene(new Scene(digit));
                digitale.setResizable(false);
                digitale.centerOnScreen();
                digitale.setTitle("Mon capteur");
                digitale.show(); 
            break;
            
            case "Thermometre":
                Stage ther = new Stage();
                Parent therm = FXMLLoader.load(getClass().getResource("/ihm/FenetreThermometre.fxml"));
                ther.setScene(new Scene(therm));
                ther.setResizable(false);
                ther.centerOnScreen();
                ther.setTitle("Mon capteur");
                ther.show(); 
                
            break;
            
            case "Icones":
                Stage icone = new Stage();
                Parent ico = FXMLLoader.load(getClass().getResource("/ihm/FenetreIcone.fxml"));
                icone.setScene(new Scene(ico));
                icone.setResizable(false);
                icone.centerOnScreen();
                icone.setTitle("Mon capteur");
                icone.show();
            
            break;
            default:
                ermsg.setVisible(true);
            break;
                
        }
    }
    
    public void onExit(){
        Platform.exit();
    }
}
