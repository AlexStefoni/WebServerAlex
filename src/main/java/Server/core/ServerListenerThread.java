package Server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static Server.core.ServerStatus.status;

public class ServerListenerThread extends  Thread{
    //private int port;
    private String webroot;
    private ServerSocket serverSocket;
    private String html ;

    public ServerListenerThread(ServerSocket serverSocket,String webroot,String html) throws IOException {
       // this.port=port;
        this.webroot=webroot;
        this.serverSocket = serverSocket;
        this.html=html;

    }


    public String serverGetWebroot(){
        return  this.webroot;
    }
    @Override

    public void run(){
        try {
            if(serverSocket.isClosed()){
                //serverSocket=new ServerSocket(8080);

            }

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
