/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import controller.FenetreThermometreController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.Capteur;

/**
 *
 * @author pereiraloann
 */
public class MenuThermo extends Menu{
     FenetreThermometreController t;
    @Override
    public void lancement(Capteur capteur){
         try {
             Stage ther = new Stage();
             FXMLLoader loaderTher = new FXMLLoader(getClass().getResource("/ihm/FenetreThermometre.fxml"));
             ther.setScene(new Scene(loaderTher.load()));
             t=loaderTher.getController();
             t.chargement(capteur);
             // t.getMonCapteur().demarrer();
             ther.setResizable(false);
             ther.centerOnScreen();
             ther.setTitle("Mon capteur"); 
             ther.show();
         } catch (IOException ex) {
             Logger.getLogger(MenuThermo.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
