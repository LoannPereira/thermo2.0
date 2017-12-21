/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;

/**
 *
 * @author argiraud
 */
public class SuperCapteur extends ComposantCapteurGlobal{
    ArrayList<ComposantCapteurGlobal> sousCapteurs;
    
     public SuperCapteur(String nomCapteur,ArrayList<ComposantCapteurGlobal> sousCapteurs ){
         this.setNomCapteur("*"+nomCapteur);
         this.sousCapteurs=sousCapteurs;
     }
     
     private void ajouterSousCapteur(ComposantCapteurGlobal sousCapteur){
         sousCapteurs.add(sousCapteur);
     }
     
     private void supprimerSousCapteur(ComposantCapteurGlobal sousCapteur){
         sousCapteurs.remove(sousCapteur);
     }
     
     public void temperature(){
         int temp=0;
         int poidsTotal=0;
         for(ComposantCapteurGlobal sousCapteur:sousCapteurs){
            Generateur g=new GenerationAleatoire((Capteur)sousCapteur);
            g.demarrer();
            temp=temp+sousCapteur.temperatureProperty().getValue()*sousCapteur.getPoids();
            poidsTotal=poidsTotal+sousCapteur.getPoids();  
        }
        temp=temp/poidsTotal; 
        this.temperatureProperty().set(temp);
     }
      
     
     
}
