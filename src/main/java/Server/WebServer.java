package Server;

import Server.config.Configuration;
import Server.config.ConfigurationManager;
import Server.core.NewJFrame;
import Server.core.ServerConfig;
import Server.core.ServerListenerThread;
import Server.core.ServerStatus;

import java.io.*;
import java.net.ServerSocket;
import java.sql.Time;
import java.util.Scanner;
import java.util.Timer;

import static Server.core.ServerStatus.status;

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

        System.out.println("starting here");
        ConfigurationManager.getInstance().loadConfigFile("src/main/resources/http.json");
        Configuration conf= ConfigurationManager.getInstance().getCurrentConfig();




        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/main/resources/TestSite/a.html"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String html = scanner.useDelimiter("\\Z").next();
        scanner.close();
        serverSocket=new ServerSocket();
        serverSocket.setReuseAddress(true);
        //serverSocket.bind(new InetSocketAddress(conf.getPort()));
        //String html="<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";

        ServerStatus.setStatus(false);
        ServerStatus.setmFlag(false);
        boolean prevStatus=true;
        boolean flag =true;
        while (flag) {

            //System.out.println(ServerStatus.getStatus());


            Thread.sleep(2000);

            /*
            System.out.println("Status : "+ServerStatus.getStatus() );
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                ServerStatus.setStatus( Integer.parseInt(br.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();


             */
            if (ServerStatus.getStatus()==false && prevStatus==true){
                serverSocket.close();
            }


            if (ServerStatus.getStatus()==true && (prevStatus!=false || ServerStatus.ismFlag()==true)){
                try {

                    serverSocket = new ServerSocket(ServerConfig.getPort());
                    ServerListenerThread serverListenerThread = new ServerListenerThread(serverSocket, "ServerConfig.getWebroot()", ServerConfig.getWebrootHtml());
                    serverListenerThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            prevStatus=ServerStatus.getStatus();
        }
    }
}
