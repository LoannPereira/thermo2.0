/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import controller.FenetreIconeController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.Capteur;
import metier.Generateur;

/**
 *
 * @author pereiraloann
 */
public class MenuIcone extends Menu {
    FenetreIconeController i;
    @Override
    public void lancement(Capteur capteur, Generateur gen){
        try {
            Stage ther = new Stage();
            FXMLLoader loaderTher = new FXMLLoader(getClass().getResource("/ihm/FenetreIcone.fxml"));
            ther.setScene(new Scene(loaderTher.load()));
            i=loaderTher.getController();
            i.chargement(capteur, gen);
            gen.demarrer();
            ther.setResizable(false);
            ther.centerOnScreen();
            ther.setTitle("Mon capteur");
            ther.show(); 
        } catch (IOException ex) {
            Logger.getLogger(MenuIcone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
