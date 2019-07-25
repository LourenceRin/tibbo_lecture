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

    public static int[] array_ports = {5555, 5556, 5557, 5558, 5559};


    public static void main(String[] args) throws Exception
    {
        INSTANCE.launch(args);
    }

    public static void increase()
    {
        messageCounter++;
    }

    public void launch(String[] args) throws Exception {

        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(5555));
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
