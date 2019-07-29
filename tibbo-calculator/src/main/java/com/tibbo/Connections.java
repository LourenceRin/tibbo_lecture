package com.tibbo;

import java.io.*;
import java.net.Socket;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class Connections extends Thread {
    private Socket socket;
    private Evaluator evaluator = new Evaluator();

    Connections(Socket socket)
    {
        this.socket = socket;
    }


    private String getResult(String string1){
        try {
            return evaluator.evaluate(string1);
        }catch (EvaluationException e){
            return ServerMessagesHelper.MESSAGE_ERROR;
        }
    }

    @Override
    public void run()
    {
        try
        {

            DataInputStream stream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            while(!isInterrupted()){
                String string;
                try {
                    string = stream.readUTF();
                }catch (EOFException e)
                {
                    continue;
                }
                String res = getResult(string);
                if(res!=null)
                    Server.increase();
                System.out.println(string);
                System.out.println(res);
                assert res != null;
                outputStream.writeUTF(res);
                outputStream.flush();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}