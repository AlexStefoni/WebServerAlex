package Server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends  Thread{
    private int port;
    private String webroot;
    private ServerSocket serverSocket;
    String html ;

    public ServerListenerThread(int port,String webroot,String html) throws IOException {
        this.port=port;
        this.webroot=webroot;
        this.serverSocket = new ServerSocket(this.port);
        this.html=html;
    }

    @Override
    public void run(){
        try {
            while(serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ServerWorkerThread workerThread = new ServerWorkerThread(socket,html);
                workerThread.start();
            }
            //serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
}
