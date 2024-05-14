/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfgbola.comms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import tfgbola.TFGBola;

/**
 *
 * @author jesus
 */
public class CommsController implements Runnable {

    private Socket socket;
    private InputStreamReader isr;
    private BufferedReader br;

    private TFGBola tfgbola;

    public CommsController(TFGBola aThis) {
        this.tfgbola = aThis;
        try {
            String ipServer = "192.168.0.104";
            this.socket = new Socket(ipServer, 10000);
            this.isr = new InputStreamReader(socket.getInputStream());
            this.br = new BufferedReader(isr);
        } catch (IOException ex) {
            Logger.getLogger(CommsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {
        try {
            this.socket = null;
            this.isr.close();
            this.br.close();
        } catch (IOException ex) {
            Logger.getLogger(CommsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String readMessage() {
        String msg = "NotAMsg";
        try {
            String line = br.readLine();
            if (line != null) {
                msg = line;
            }
        } catch (IOException ex) {
            Logger.getLogger(CommsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }

    @Override
    public void run() {
        while(true){
            try {
                String msg = readMessage();
                System.out.println(msg);
                if(!msg.equals("NotAMsg")){
                    tfgbola.getMsg(msg);
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CommsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
