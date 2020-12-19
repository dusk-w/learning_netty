package com.wei.learn.io.bio.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class BioServerHandler implements Runnable{
    // 负责跟客户端进行通信
    private Socket socket;

    public BioServerHandler(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            int count = 0;
            String content = null;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) != -1) {
                String line = new String(bytes, 0, count, "utf-8");
                System.out.println(line);
                content = line.trim().equalsIgnoreCase("SJ") ? new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) : "what are you sending? ";
                outputStream.write(content.getBytes()); // 写入缓冲区
                outputStream.flush();   // 将缓冲区数据写入客户端
            }
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
