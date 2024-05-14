/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tfgbola;

import tfgbola.comms.CommsController;
import tfgbola.main.MainController;

/**
 *
 * @author jesus
 */
public class TFGBola {

    private CommsController comms;
    private MainController main;
    
    public TFGBola(){
        comms = new CommsController(this);
        Thread thComms = new Thread(comms);
        thComms.start();
        main = new MainController(this);
    }
    
    public void getMsg(String msg){
        System.out.println(msg);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new TFGBola();
    }
    
}
