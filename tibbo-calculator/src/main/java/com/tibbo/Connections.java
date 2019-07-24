package com.tibbo;

import com.tibbo.Server;
import java.io.*;
import java.net.Socket;

public class Connections extends Thread {
    private Socket socket;
    private Server INSTANCE;
    public Connections(Socket socket, Server INSTANCE)
    {
        this.INSTANCE = INSTANCE;
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            String string;
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            while(!isInterrupted()){
                try {
                    string = stream.readUTF();
                }catch (EOFException e)
                {
                    break;
                }
                Server.increase();
                System.out.println(string);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}