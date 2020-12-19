package com.wei.learn.io.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    ServerSocket serverSocket = null;

    public BioServer() {
        try {
            serverSocket = new ServerSocket(9090);
            while (true) {
                Socket socket = serverSocket.accept(); // 阻塞
                System.out.println("client: "+socket.getRemoteSocketAddress().toString()+" already connection");
                new Thread(new BioServerHandler(socket)).start(); // 必须要开一个线程，如果下面有方法阻塞就无法连接客户端
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

    }

    public static void main(String[] args) {
        new BioServer().start();
    }
}
