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
    
     public SuperCapteur(String nomCapteur, int frequence){
         this.setNomCapteur(nomCapteur);
         this.setFrequence(frequence);
         this.sousCapteurs=new ArrayList<>();
     }
     
     public void ajouterSousCapteur(ComposantCapteurGlobal sousCapteur){
         sousCapteurs.add(sousCapteur);
     }
     
     public void supprimerSousCapteur(ComposantCapteurGlobal sousCapteur){
         sousCapteurs.remove(sousCapteur);
     }
     
     public void temperature(){
         int temp=0;
         int poidsTotal=0;
         for(ComposantCapteurGlobal sousCapteur:sousCapteurs){
            temp=temp+sousCapteur.getTemperature()*sousCapteur.getPoids();
            poidsTotal=poidsTotal+sousCapteur.getPoids();  
        }
        temp=temp/poidsTotal; 
        this.temperatureProperty().set(temp);
     }
      
     
     
}
