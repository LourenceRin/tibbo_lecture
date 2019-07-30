package com.tibbo;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class Server
{
    private static final Server INSTANCE = new Server();
    private ServerSocket serverSocket;
    private static int messageCounter = 0;
    private Thread thread;
    private List<Thread> list = new ArrayList<>();
    private static Integer port = 5555;


    public static void main(String[] args){
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception f) {
            System.out.println(f);
        }
        try {
            INSTANCE.launch(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void increase()
    {
        messageCounter++;
    }

    public void launch(int port) throws Exception {

        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        thread = new Thread() {
            public void run() {
                try {
                    Socket socket;
                    while (!isInterrupted()) {

                        try {
                            socket = serverSocket.accept();
                        } catch (SocketException e) {
                            break;
                        }
                        Connections test = new Connections(socket);
                        test.start();
                        list.add(test);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }


    public static void reset(){
        messageCounter = 0;
    }
    public void close() throws IOException
    {
        thread.interrupt();
        serverSocket.close();
        for (Thread i: list){
            i.interrupt();
        }

    }
    public int getMessageCounter()
    {
        return messageCounter;
    }
}