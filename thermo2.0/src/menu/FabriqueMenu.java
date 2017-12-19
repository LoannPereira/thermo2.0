/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

/**
 *
 * @author pereiraloann
 */
public class FabriqueMenu {
    Menu create(String typeMenu){
    if(typeMenu.equals("Digital")) {
      return new MenuDigital();
    } 
    else if(typeMenu.equals("Icone")) {
      return new MenuIcone();
    } 
    else if(typeMenu.equals("Thermometre")) {
      return new MenuThermo();
    }
    return null;
    }
}
