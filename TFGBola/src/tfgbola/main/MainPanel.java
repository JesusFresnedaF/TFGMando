/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import javax.swing.JPanel;
import tfgbola.main.objects.Bola;

/**
 *
 * @author jesus
 */
public class MainPanel extends Canvas {

    private MainViewer mainViewer;
    private Bola bola;

    public MainPanel(MainViewer mainViewer) {
        this.mainViewer = mainViewer;
        this.setSize(900, 900);
    }

    public void paint() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if (bufferStrategy == null) {
            this.createBufferStrategy(3); // Crea tres buffers para la estrategia
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();

        // Limpia la pantalla
        g.clearRect(0, 0, getWidth(), getHeight());

        // Dibuja la bola
        this.bola.pintar(g);
        
        // Muestra los gráficos
        bufferStrategy.show();

        // Libera los recursos gráficos
        g.dispose();
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }
}
