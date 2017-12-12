/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author pereiraloann
 */
public abstract class  Generateur {
      // public Capteur capteur;
       public abstract long getFrequence();
       public abstract void algo();
       public abstract void demarrer();
       public abstract void arret();
}
