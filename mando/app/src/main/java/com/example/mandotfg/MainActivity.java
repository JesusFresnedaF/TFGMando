package com.example.mandotfg;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    private int i = 100;
    private int j = 100;


    //lectura y escritura
    private InputStreamReader isr;
    private OutputStreamWriter osw;
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket socket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button arriba, abajo, izquierda, derecha;
        int tamPantalla = 900;

        arriba = findViewById(R.id.arriba);
        abajo = findViewById(R.id.abajo);
        izquierda = findViewById(R.id.izquierda);
        derecha = findViewById(R.id.derecha);

        initConnection();

        arriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j - 10 > 0) {
                    j -= 10;
                }
                mover(i, j);
            }
        });
        abajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j + 10 < tamPantalla) {
                    j += 10;
                }
                mover(i, j);
            }
        });
        izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i - 10 > 0) {
                    i -= 10;
                }
                mover(i, j);
            }
        });
        derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i + 10 < tamPantalla) {
                    i += 10;
                }
                mover(i, j);
            }
        });

    }


    public void initConnection() {
        Log.d("InitConection", "hola");
        ServerConnector serverConnector = new ServerConnector(); // Crear la instancia de ServerConnector
        Thread thServer = new Thread(serverConnector); // Crear el hilo con la instancia de ServerConnector
        thServer.start(); // Iniciar el hilo

        while (serverConnector.getSocket() == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Socket socket = serverConnector.getSocket();
        try {
            this.osw = new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.bw = new BufferedWriter(osw);
    }

    public void mover(int i, int j) {
        Log.d("velocidades: ", i + " - " + j + "");
        String velocidad = i + "_" + j;
        try {
            bw.write(velocidad);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}