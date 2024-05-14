/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.main;

import tfgbola.main.objects.Bola;

/**
 *
 * @author jesus
 */
public class MainModel {

    private MainController mainController;
    
    private Bola bola;
    
    public MainModel(MainController aThis) {
        mainController = aThis;
        this.bola = new Bola();
        this.bola.setModel(this);
    }

    public Bola getBola() {
        return this.bola;
    }
    
}
