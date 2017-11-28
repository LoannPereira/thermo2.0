/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ListView<Capteur> listeCapteurs;
    @FXML
    private ImageView imgCapteur;
    @FXML
    public ImageView imgAlgo;
    @FXML
    private Label nomCapteur;
    
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
        listeCapteurs.setItems(ObsCapteurs);
        listeCapteurs.setCellFactory((param) -> {
            return new ListCell<Capteur>(){
               @Override
                protected void updateItem(Capteur capteur, boolean empty) {
                    super.updateItem(capteur, empty);
                    if (!empty) {
                        textProperty().bind(capteur.nomCapteurProperty());
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }  
            };
        });
        listeCapteurs.getSelectionModel().selectedItemProperty().addListener((o,old,newV)->{
            if (old != null) {
                nomCapteur.textProperty().unbindBidirectional(old.nomCapteurProperty());
                
            }
            if (newV != null) {
                nomCapteur.textProperty().bindBidirectional(newV.nomCapteurProperty());
            }
        });
        
        if(!listeCapteurs.getSelectionModel().isEmpty()){
            Image image = new Image("@../img/tick.png");
            imgCapteur.setImage(image);
            
        }
        
    }
    
    public void validation() throws IOException{
        if(!nomCapteur.getText().equals("Aucun")){
            switch(menubtn.getText()){
                case "Digital":
                
                    Stage digitale = new Stage();
                    FenetreDigitalController f;
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/FenetreDigital.fxml"));
                    digitale.setScene(new Scene(loader.load()));
                    f=loader.getController();
                    f.setMonCapteur(getCapteur(nomCapteur.getText()));
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
        else 
            ermsg.setVisible(true);
    }
    
    /*
    * Permet d'obtenir un objet capteur correspondant au nom du capteur passé en paramètre.
    *
    *@param nom nom du capteur
    *@return L'objet capteur voulu.
    */
    public Capteur getCapteur(String nom){
        for(Capteur cap : listeCapteurs.getItems()){
            if(nom==cap.getNomCapteur())
                return cap;
        }
        return null;
    }
    
    public void onExit(){
        Platform.exit();
    }
}
