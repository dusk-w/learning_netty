package com.wei.learn.io.bio.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class JedisSocket {

    private Socket socket;

    public InputStream inputStream;

    public OutputStream outputStream;

    public JedisSocket(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 向Redis服务器发送的字符串
    public void send(String message){
        try {
            outputStream.write(message.getBytes());
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
        }
    }

    public String read(){
        byte[] bytes = new byte[1024];
        int count = 0;
        try {
            count = inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String(bytes, 0, count);
    }
}
