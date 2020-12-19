package com.wei.learn.io.bio.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("127.0.0.1", 9090);
            new Thread(new ClientHandler(socket)).start(); // 循环读服务端返回的数据 由于有阻塞方法，如果不开线程下面代码无法执行
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the message to be sent");
            while (true) {
                String s = scanner.nextLine();
                if ("by".equals(s.trim())) {
                    break;
                }
                outputStream.write(s.getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
