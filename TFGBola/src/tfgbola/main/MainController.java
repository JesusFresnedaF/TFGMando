/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.main;

import tfgbola.TFGBola;
import tfgbola.main.objects.Bola;

/**
 *
 * @author jesus
 */
public class MainController {

    private TFGBola tFGBola;

    private MainViewer viewer;
    private MainModel model;

    public MainController(TFGBola aThis) {
        this.tFGBola = aThis;
        this.model = new MainModel(this);
        this.viewer = new MainViewer(this);
        Thread viewerTh = new Thread(this.viewer);
        viewerTh.start();
    }

    public MainModel getModel() {
        return this.model;
    }

    public Bola getBola() {
        return this.model.getBola();
    }

}
