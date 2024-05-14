/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.main.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import tfgbola.comms.dtos.Vector;
import tfgbola.main.MainModel;

/**
 *
 * @author jesus
 */
public class Bola extends VODynamic implements Runnable {

    private double radio;
    private Color color;

    private MainModel model;

    public Bola() {
        super();
        this.radio = 10;
        this.color = Color.BLUE;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setModel(MainModel model) {
        this.model = model;
    }

    public Vector getPosicion() {
        return super.getPosicion();
    }

    public void setPosicion(Vector posicion) {
        super.setPosicion(posicion);
    }

    public double getDiam() {
        return (this.radio * 2);
    }

    @Override
    public void pintar(Graphics g) {
        g.setColor(this.color);
        int posicionX = (int) (this.getPosicion().getX() - this.getRadio());
        int posicionY = (int) (this.getPosicion().getY() - this.getRadio());
        g.fillOval(posicionX, posicionY, (int) this.getDiam(), (int) this.getDiam());

    }

    @Override
    public synchronized void mover() {
        //super.setPosition(model.calcNewPositions(this));
    }

    @Override
    public void run() {
        while (true) {
            try {
                mover();
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Bola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
