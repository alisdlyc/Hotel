package com.alisdlyc.hotel.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        try {
            // 1、创建socket连接
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),10105);
            // 2、创建一个输出流
            OutputStream outputStream = socket.getOutputStream();
            // 3、获取文件流,读取文件
            // FileInputStream fileInputStream = new FileInputStream(new File("qwq.mp4"));
            // 4、写出文件
            /*byte[] bytes = new byte[1024];
            int len;
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }

            // 通知服务器传输结束
            socket.shutdownOutput();*/

            // 5、接受服务器的信息
            InputStream inputStream = socket.getInputStream();
            // 返回值为string类型的数组
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] bytes1 = new byte[1024];
            int len1;
            while ((len1=inputStream.read(bytes1))!=-1){
                byteArrayOutputStream.write(bytes1,0,len1);
            }

            System.out.println(byteArrayOutputStream.toString());

            byteArrayOutputStream.close();
            // fileInputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
