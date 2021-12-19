package Server;

import Server.config.Configuration;
import Server.config.ConfigurationManager;
import Server.core.MainFrame;
import Server.core.ServerListenerThread;
import Server.core.ServerStatus;

import javax.swing.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

/*
*
*
* Driver class for the server
*
*
* */

public class WebServer {
    static ServerSocket serverSocket=null;

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable()  {
            public void run() {
                JFrame jframe= new MainFrame("WebServer" );
                jframe.setSize(400,400);
                jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jframe.setVisible(true);
            }
        });

        System.out.println("starting here");
        ConfigurationManager.getInstance().loadConfigFile("src/main/resources/http.json");
        Configuration conf= ConfigurationManager.getInstance().getCurrentConfig();



        System.out.println("using port"+ conf.getPort());
        System.out.println("using webroot"+ conf.getWebroot());


        /**
         * To DO develop on the status
         * for now
         * 0-Stopped
         * 1-Running
         * 2-Maintenance
         */
        int status= 0;
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
        boolean flag =true;
        while (flag) {

            System.out.println(serverSocket.isClosed());

            if(status==3) return;
            System.out.println("Status : "+status );
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                status= Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (status==2){
                serverSocket.close();
            }


            if (status==1) {
                try {

                    serverSocket = new ServerSocket(conf.getPort());
                    ServerListenerThread serverListenerThread = new ServerListenerThread(serverSocket, conf.getWebroot(), html);
                    serverListenerThread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
