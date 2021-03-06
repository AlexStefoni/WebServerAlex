package Server;


import Server.core.NewJFrame;
import Server.config.ServerConfig;
import Server.core.ServerListenerThread;
import Server.config.ServerStatus;

import java.io.*;
import java.net.ServerSocket;

/*
*
*
* Driver class for the server
*
*
* */

public class WebServer {
    static ServerSocket serverSocket=null;

    public static void main(String[] args) throws IOException, InterruptedException {



        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });

        String html="";
        ServerStatus.setStatus(false);
        ServerStatus.setmFlag(false);
        boolean prevStatus=false;
        boolean flag =true;
        while (flag) {

            //System.out.println("stauts: "+ServerStatus.getStatus());
            //System.out.println("prevstatus: "+prevStatus+"\n");
            //System.out.println("mflag: "+ServerStatus.ismFlag());

            if (ServerStatus.getStatus()==false && prevStatus==true){
                serverSocket.close();
            }


            if (ServerStatus.getStatus()==true && (prevStatus==false)){
                try {

                    if(ServerStatus.ismFlag()){
                        html=ServerConfig.getMaintenanceHtml();
                        //System.out.println("flag trigger");
                    }
                    else html=ServerConfig.getWebrootHtml();

                    serverSocket = new ServerSocket(ServerConfig.getPort());



                    ServerListenerThread serverListenerThread = new ServerListenerThread(serverSocket, "ServerConfig.getWebroot()",
                            html);
                    serverListenerThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            prevStatus=ServerStatus.getStatus();
            Thread.sleep(2000);
        }
    }
}
