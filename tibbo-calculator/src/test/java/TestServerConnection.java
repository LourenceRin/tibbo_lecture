import com.tibbo.Server;
import com.tibbo.ServerMessagesHelper;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestServerConnection extends TestCase {
    private Server server;
    @Test
    public void testServerConnection() throws Exception {

        /*Thread thread = new Thread(){
            @Override
            public void run(){
                try {
                    server.connection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();*/

        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 4000));
        socket.getOutputStream().write(ServerMessagesHelper.FIRST_MESSAGE.getBytes());

        Socket socket1 = new Socket();
        socket1.connect(new InetSocketAddress("localhost", 4000));
        socket.getOutputStream().write(ServerMessagesHelper.SECOND_MESSAGE.getBytes());

        Socket socket2 = new Socket();
        socket2.connect(new InetSocketAddress("localhost", 4000));
        socket2.getOutputStream().write(ServerMessagesHelper.THIRD_MESSAGE.getBytes());

        assertTrue(socket.isConnected());
        assertTrue(socket1.isConnected());
        assertTrue(socket2.isConnected());

        //server.connection();  //it work here

        Thread.sleep(1000);
        assertEquals(3, server.getMessageCounter());

        socket.close();
        socket1.close();
        socket2.close();
    }

    @Override
    protected void setUp() throws Exception {
        server = new Server();
        server.launch(null);
    }

    @Override
    protected void tearDown() throws Exception {
        server.close();
    }
}
