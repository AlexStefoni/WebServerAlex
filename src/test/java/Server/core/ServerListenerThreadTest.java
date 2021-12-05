package Server.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ServerListenerThreadTest {

    @Test
    void testIfRootWorks() throws IOException {
        int expectedport=8080;
        String expectedwebroot="src/main/resources/TestSite";
        ServerListenerThread serverListenerThread =new ServerListenerThread(8080,"src/main/resources/TestSite","",1);

        assertEquals(serverListenerThread.serverGetPort(),expectedport);
        assertEquals(serverListenerThread.serverGetWebroot(),expectedwebroot);
    }

    //trying mockito
    @Test
    public void invocation() {
                         //mock creation
                         List<String> mockedList = mock(List.class);

                         //using mock object
                         mockedList.add("one");
                         mockedList.clear();

                         //verification
                         verify(mockedList).add("one");
                         verify(mockedList).clear();
    }

    @AfterAll
    public void tearDown() throws Exception {
    }


    @Test
    public void InitializeServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket clientSocket = serverSocket.accept();
        assertEquals(serverSocket.isBound(),false);
        assertEquals(serverSocket.isBound(),true);


        serverSocket.close();
        assertEquals(serverSocket.isClosed(),true);

    }
}