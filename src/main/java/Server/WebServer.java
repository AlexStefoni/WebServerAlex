package Server;

import Server.config.Configuration;
import Server.config.ConfigurationManager;
import Server.core.ServerListenerThread;

import java.io.*;
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
    public static void main(String[] args){
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




        //String html="<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
        boolean flag =true;
        while (flag) {

            System.out.println("Status : "+status );
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                status= Integer.parseInt(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();




            try {
                ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot(), html, status);
                serverListenerThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
