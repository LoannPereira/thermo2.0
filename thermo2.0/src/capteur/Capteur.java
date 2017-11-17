/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capteur;

/**
 *
 * @author argiraud
 */
public class Capteur {
    private String nomCapteur;
    private int temperature;
    private int tMax;//température maximale
    private int tMin;//température minimale
    
    public Capteur(String nomCapteur,int temperature, int tMax, int tMin) {
        this.nomCapteur=nomCapteur;
        this.tMax=tMax;
        this.tMin=tMin;
        this.temperature=temperature;
    }
    
}
