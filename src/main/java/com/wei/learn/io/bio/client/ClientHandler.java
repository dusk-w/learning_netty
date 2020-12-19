package com.wei.learn.io.bio.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            int count = 0;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) != -1) {
                System.out.println("\nReceive a message from the server: " + new String(bytes, 0, count, "utf-8"));
                System.out.println("Please enter the message to be sent: ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}