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
    private String html ;
    private int status;
    public ServerListenerThread(int port,String webroot,String html,int status) throws IOException {
        this.port=port;
        this.webroot=webroot;
        this.serverSocket = new ServerSocket(this.port);
        this.html=html;
        this.status=status;
    }
    public int serverGetPort(){
        return this.port;
    }

    public String serverGetWebroot(){
        return  this.webroot;
    }
    @Override
    public void run(){
        try {
            if(status==0 ){
                serverSocket.close();}
            while(status==1 && serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ServerWorkerThread workerThread = new ServerWorkerThread(socket,html);
                workerThread.start();
            }

            if(status==0 && !serverSocket.isClosed()){
                serverSocket.close();
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
