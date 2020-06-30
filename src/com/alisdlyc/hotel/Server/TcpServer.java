package com.alisdlyc.hotel.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // 1、创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2、监听客户端的连接,会一直等待客户端
        Socket socket = serverSocket.accept();
        // 3、获取输入流
        InputStream inputStream = socket.getInputStream();

        // 4、文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("ovo.mp4"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }

        // 5、通知客户端接收完毕
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("朕已阅".getBytes());

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
