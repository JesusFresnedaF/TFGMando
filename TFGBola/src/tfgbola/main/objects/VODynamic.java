/*
    Clase de dinamica de objetos visuales
 */
package tfgbola.main.objects;

import tfgbola.comms.dtos.Vector;

/**
 *
 * @author jesus
 */
public class VODynamic extends VisualObject {

    private Vector posicion;
    private Vector velocidad;
    private Vector aceleracion;

    public VODynamic() {
        this.posicion = new Vector();
        this.velocidad = new Vector();
        this.aceleracion = new Vector();
    }

    public Vector getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector posicion) {
        this.posicion = posicion;
    }

    public Vector getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector velocidad) {
        this.velocidad = velocidad;
    }

    public Vector getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(Vector aceleracion) {
        this.aceleracion = aceleracion;
    }

    public void mover() {
    }

    public void damage(Bola bola) {
    }

    public void explode() {
    }

    public void rebotarX() {
    }

    public void rebotarY() {
    }

    public void sendBola() {
    }

}
