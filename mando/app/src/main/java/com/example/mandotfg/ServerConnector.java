package com.example.mandotfg;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector implements Runnable {

    private ServerSocket serverSocket;
    private Socket socket;

    public ServerConnector() {
        try {
            this.serverSocket = new ServerSocket(10000);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        try {
            Log.d("ServerInfo", "Escuchando...");
            this.socket = this.serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return this.socket;
    }
}
