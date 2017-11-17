/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.Event;
import javafx.scene.Node;

/**
 *
 * @author pereiraloann
 */
public class FenetreIconeController {
    public void onExit(Event event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
}
