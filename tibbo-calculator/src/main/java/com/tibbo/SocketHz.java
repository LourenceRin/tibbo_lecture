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
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            while(!socket.isClosed()&&!isInterrupted()){
                String string=null;
                try {
                    string = stream.readUTF();
                }catch (EOFException e) {
                    break;
                }
                if(string!=null)
                    INSTANCE.increase();
                System.out.println(string);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
