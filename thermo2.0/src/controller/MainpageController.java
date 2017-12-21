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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import menu.Menu;
import menu.MenuDigital;
import menu.MenuIcone;
import menu.MenuThermo;
import metier.Capteur;
import metier.ComposantCapteurGlobal;
import metier.Generateur;
import modele.ModeleCapteur;
import metier.GenerationAleatoire;
import metier.GenerationGlissante;
import metier.GenerationInter;
import metier.SuperCapteur;

/**
 *
 * @author lopereira2
 */
public class MainpageController {
    @FXML
    MenuButton menubtn;
    @FXML
    MenuButton algobtn;
    @FXML
    public Label ermsg;
    @FXML
    Label param;
    @FXML
    Label nomAlgo;
    @FXML
    private ListView<ComposantCapteurGlobal> listeCapteurs;
    @FXML
    private ImageView imgCapteur;
    @FXML
    public ImageView imgAlgo;
    @FXML
    private Label nomCapteur;
    @FXML
    private TextField min;
    @FXML
    private TextField max;
    @FXML
    private TextField fenetre;
    Menu menucourant ;
    
    Generateur gen;

    public void digit(){
        menubtn.setText("Digital");
        menucourant= new MenuDigital();
    }
    
    public void thermo(){
        menubtn.setText("Thermometre");
        menucourant= new MenuThermo();
    }
    
    public void icone(){
        menubtn.setText("Icone");
        menucourant= new MenuIcone();
    }
    
    public void aleat(){
         algobtn.setText("Aléatoire");
         min.setVisible(false);
         max.setVisible(false);
         param.setVisible(false);
         fenetre.setVisible(false);
         
    }
    
     public void inter(){
         algobtn.setText("Intervalle");
         param.setVisible(true);
         min.setVisible(true);
         max.setVisible(true);
         fenetre.setVisible(false);
         
    }
      public void fenetreglissante(){
         algobtn.setText("Fenêtre Glissante");
         min.setVisible(false);
         max.setVisible(false);
         param.setVisible(true);
         fenetre.setVisible(true);
    }
      
      public void selectAlgo(){
          System.out.println(algobtn.getText());
          switch(algobtn.getText()){
              case "Aléatoire":
                  if(!nomCapteur.getText().startsWith("*")){
                  gen= new GenerationAleatoire((Capteur)getCapteur(nomCapteur.getText()));
                  }
                  break;
                  
              case "Intervalle":
                  if(min.getText()!=null && max.getText()!=null&&!nomCapteur.getText().startsWith("*")){
                     gen = new GenerationInter((Capteur)getCapteur(nomCapteur.getText()),Integer.parseInt(min.getText()),Integer.parseInt(max.getText()));
                      
                  }
                  else{
                    ermsg.setVisible(true);
                  }
                  break;
              case "Fenêtre Glissante":
                  if(fenetre.getText()!=null && !nomCapteur.getText().startsWith("*")){
  
                    gen = new GenerationGlissante((Capteur)getCapteur(nomCapteur.getText()),Integer.parseInt(fenetre.getText()));

                  } 
                  break;
              default : 
                  ermsg.setVisible(true);
                  break;
                  
          }
      }
    ModeleCapteur data = new ModeleCapteur();
    ObservableList<ComposantCapteurGlobal> ObsCapteurs = data.getLesCapteurs();
    ObservableList<String> ObsAlgo;
    
    
    
    @FXML
    public void initialize() {
        listeCapteurs.setItems(ObsCapteurs);
        listeCapteurs.setCellFactory((param) -> {
            return new ListCell<ComposantCapteurGlobal>(){
               @Override
                protected void updateItem(ComposantCapteurGlobal capteur, boolean empty) {
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
                if(newV.getNomCapteur().startsWith("*")){
                    algobtn.setDisable(true);
                }
                else{
                    algobtn.setDisable(false);
                }
            }
        });
        nomAlgo.textProperty().bind(algobtn.textProperty());
        

        
    }
    
    public void ajoutCapteur() throws IOException{
        FenetreAjoutCapteurController f;
        Stage ajout = new Stage();
        FXMLLoader loaderDigitale = new FXMLLoader(getClass().getResource("/ihm/FenetreAjoutCapteur.fxml"));
        ajout.setScene(new Scene(loaderDigitale.load()));
        f=loaderDigitale.getController();
        f.getModel(ObsCapteurs);
        ajout.setResizable(false);
        ajout.centerOnScreen();
        ajout.setTitle("Mon capteur");
        ajout.show(); 
    }
    
    public void validation() throws IOException{
        FenetreDigitalController f;
        FenetreThermometreController t;
        FenetreIconeController i;
        if(!nomCapteur.getText().equals("Aucun")&&!nomCapteur.getText().startsWith("*")){
           selectAlgo();
            menucourant.lancement((Capteur)getCapteur(nomCapteur.getText()),gen);
        }
        else if(nomCapteur.getText().startsWith("*")){
                SuperCapteur c=(SuperCapteur)getCapteur(nomCapteur.getText());
                c.temperature();
                menucourant.lancement((SuperCapteur)getCapteur(nomCapteur.getText()),gen);
             }
             else ermsg.setVisible(true);
    }
    
    /*
    * Permet d'obtenir un objet capteur correspondant au nom du capteur passé en paramètre.
    *
    *@param nom nom du capteur
    *@return L'objet capteur voulu.
    */
    public ComposantCapteurGlobal getCapteur(String nom){
        for(ComposantCapteurGlobal cap : listeCapteurs.getItems()){
            if(nom==cap.getNomCapteur())
                return cap;
        }
        return null;
    }
    
    public void onExit(){
        Platform.exit();
    }
}
