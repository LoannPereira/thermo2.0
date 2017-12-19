/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import metier.Capteur;
import metier.Generateur;

/**
 *
 * @author pereiraloann
 */
public abstract class Menu {
    public abstract void lancement(Capteur capteur,Generateur gen);
}

