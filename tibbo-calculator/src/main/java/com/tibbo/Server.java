package com.tibbo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  private static final Server INSTANCE = new Server();
  private ServerSocket serverSocket;
  private static int messageCounter = 0;
  
  public static void main(String[] args) throws Exception
  {
    INSTANCE.launch(args);
  }

  public static void increase()
  {
    messageCounter++;
  }
  
  public void launch(String[] args) throws Exception
  {
    serverSocket = new ServerSocket();
    serverSocket.bind(new InetSocketAddress(5555));
    Thread thread = new Thread(){
      public void run()
      {
        //у тебя этот поток, который обрабатывает  клиентские подключение не зациклен, он один ращз отработает и все
        int i =3;
        try
        {
          while(i>0) {
            Socket socket = serverSocket.accept();
            SocketHz test = new SocketHz(socket, INSTANCE);
            test.start();
            i--;
          }
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
      }
    };
    thread.start();
  }
  
  public void close() throws IOException
  {
    serverSocket.close();

  }
  
  public int getMessageCounter()
  {
    return messageCounter;
  }
}
