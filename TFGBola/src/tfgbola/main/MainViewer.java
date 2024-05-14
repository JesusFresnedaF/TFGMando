/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import tfgbola.main.objects.Bola;

/**
 *
 * @author jesus
 */
public class MainViewer extends JFrame implements Runnable {

    private MainController mainController;
    private MainPanel mainPanel;

    private Bola bola;

    public MainViewer(MainController aThis) {
        this.mainController = aThis;
        this.setSize(900, 900);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        addPanel();
    }

    public void addPanel() {
        this.bola = new Bola();
        this.bola.setModel(this.mainController.getModel());
        this.mainPanel = new MainPanel(this);
        this.add(mainPanel);
    }

    public Bola getBola() {
        return this.bola;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.bola = this.mainController.getBola();
                this.mainPanel.setBola(this.bola);
                this.mainPanel.paint();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
