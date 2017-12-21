/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import metier.Capteur;
import metier.ComposantCapteurGlobal;
import metier.SuperCapteur;
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
    @FXML
    private CheckBox  checkSuperCapteur;
    @FXML
    private ListView<ComposantCapteurGlobal> listeCapteurDispo;
    @FXML
    private ListView<ComposantCapteurGlobal> listeCapteurCreation;
    @FXML
    private ComboBox comboBoxAlgo;
    @FXML
    private TextField fieldPoids;
    @FXML
    private Button ajouterListeDispo;
    @FXML
    private Button supprimerListeCreation;
    @FXML
    private Label erreurPoidsLabel;
    @FXML
    private Label erreurSuppressionLabel;
    
    private ArrayList<ComposantCapteurGlobal>sousCapteurs;
    ObservableList<ComposantCapteurGlobal> modele;
    ObservableList<ComposantCapteurGlobal> listeCreation=FXCollections.observableArrayList();
    
    private final String erreurPoidsVide="Le poids ne doit pas être nul";
    private final String erreurPoidsInvalide="Le poids doit être supérieur à 0";
    private final String erreurSelection="Aucun capteur sélectionné";
            
    @FXML
    public void initialize(){
        comboBoxAlgo.getItems().addAll("Aleatoire", "Intervalle", "Fenetre glissante");
        erreurSuppressionLabel.setVisible(false);
        erreurPoidsLabel.setVisible(false);
        listeCapteurDispo.setDisable(true);
        listeCapteurCreation.setDisable(true);
        comboBoxAlgo.setDisable(true);
        fieldPoids.setDisable(true);
        ajouterListeDispo.setDisable(true);
        supprimerListeCreation.setDisable(true);
        sousCapteurs=new ArrayList<>();
        listeCapteurCreation.setItems(listeCreation);
        listeCapteurCreation.setCellFactory((param) -> {
            return new ListCell<ComposantCapteurGlobal>(){
               //@Override
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
        
    }
    
    public void ajoutCapteur(Event event){
        
       
            if(nom.getText().isEmpty()||temp.getText().isEmpty()||freq.getText().isEmpty()){
                ermsg.setVisible(true);
            }
            else{
                if(checkSuperCapteur.isSelected()){
                    ArrayList<ComposantCapteurGlobal> liste=new ArrayList<>();
                      liste.addAll(listeCapteurCreation.getItems());
                      modele.add(new SuperCapteur(nom.getText(),liste));
                }
                else{
                    modele.add(new Capteur(nom.getText(),Integer.parseInt(temp.getText()),Integer.parseInt(freq.getText())));
                    ((Node)event.getSource()).getScene().getWindow().hide();
                }
                
            }
        
    }
    
    public void checkBoxSuperCapteur(Event event){
        if(checkSuperCapteur.isSelected()){
            listeCapteurDispo.setDisable(false);
            listeCapteurCreation.setDisable(false);
            comboBoxAlgo.setDisable(false);
            fieldPoids.setDisable(false);
            ajouterListeDispo.setDisable(false);
            supprimerListeCreation.setDisable(false);
        }
        else{
            listeCapteurDispo.setDisable(true);
            listeCapteurCreation.setDisable(true);
            comboBoxAlgo.setDisable(true);
            fieldPoids.setDisable(true);
            ajouterListeDispo.setDisable(true);
            supprimerListeCreation.setDisable(true);
        }
    }
    
    public void ajouterListe(Event event){
        erreurPoidsLabel.setVisible(false);
        if("".equals(fieldPoids.getText())){
            erreurPoidsLabel.setText(erreurPoidsVide);
            erreurPoidsLabel.setVisible(true);
        }
        else{
            if(Integer.parseInt(fieldPoids.getText())>0 && listeCapteurDispo.getSelectionModel().getSelectedIndex()!=-1){
                Integer.parseInt(fieldPoids.getText());
                listeCapteurDispo.getSelectionModel().getSelectedItem().setPoids(Integer.parseInt(fieldPoids.getText()));
                listeCreation.add(listeCapteurDispo.getSelectionModel().getSelectedItem()); 
                fieldPoids.setText("");
            }
            else{
                if(listeCapteurDispo.getSelectionModel().getSelectedIndex()==-1){
                    erreurPoidsLabel.setText(erreurSelection);
                    erreurPoidsLabel.setVisible(true);
                }
            
                else {
                    erreurPoidsLabel.setText(erreurPoidsInvalide);
                erreurPoidsLabel.setVisible(true);
                }
            }
        }    
    }
    
    public void supprimerListe(Event event){
        erreurSuppressionLabel.setVisible(false);
        if(listeCapteurCreation.getSelectionModel().getSelectedIndex()!=-1){
            listeCapteurDispo.getSelectionModel().getSelectedItem().setPoids(-1);
            listeCreation.remove(listeCapteurCreation.getSelectionModel().getSelectedItem());     
        }
        else{
            erreurSuppressionLabel.setText(erreurSelection);
            erreurSuppressionLabel.setVisible(true);
        }  
    }
    
    
    public void getModel(ObservableList<ComposantCapteurGlobal> m){
        modele = m;
        listeCapteurDispo.setItems(modele);
        listeCapteurDispo.setCellFactory((param) -> {
            return new ListCell<ComposantCapteurGlobal>(){
               //@Override
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
    }
    
   
}
