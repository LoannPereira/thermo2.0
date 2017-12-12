/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import controller.FenetreDigitalController;
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
public class MenuDigital extends Menu {
     FenetreDigitalController f;
    
    public void lancement(Capteur capteur){
        
         try {
             Stage digitale = new Stage();
             FXMLLoader loaderDigitale = new FXMLLoader(getClass().getResource("/ihm/FenetreDigital.fxml"));
             digitale.setScene(new Scene(loaderDigitale.load()));
             f=loaderDigitale.getController();
             f.chargement(capteur);
             //f.getMonCapteur().demarrer();
             digitale.setResizable(false);
             digitale.centerOnScreen();
             digitale.setTitle("Mon capteur"); 
             digitale.show();
         } catch (IOException ex) {
             Logger.getLogger(MenuDigital.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
