package com.tibbo;

import java.io.*;
import java.net.Socket;

public class SocketHz extends Thread {
    private Socket socket;
    private Server INSTANCE;
    public SocketHz(Socket socket, Server INSTANCE)
    {
        this.INSTANCE = INSTANCE;
        this.socket = socket;//примитивные типы не копируются, толку передвать его сюда нету
    }// у нас создается только один поток

    @Override
    public void run()
    {
        try
        {
            String string;
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            string = stream.readUTF();
            INSTANCE.increase();
            System.out.println(string);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
