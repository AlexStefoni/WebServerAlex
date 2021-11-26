package Server;

import Server.config.Configuration;
import Server.config.ConfigurationManager;
import Server.core.ServerListenerThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

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

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
