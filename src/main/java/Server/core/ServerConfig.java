package Server.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerConfig {
    public static String webroot=null;
    public static int port=8080;
    public static String maintenanceRoot=null;
    public static String webRootHtml="<html><head><title>Simple Server</title></head><body><ch1>404 page not found</ch1></body></html>";
    public static String maintenanceRootHtml="<html><head><title>Simple Server</title></head><body><ch1>page not found</ch1></body></html>";






    public static String getWebroot() {
        return webroot;
    }

    public static void setWebroot(String webroot) {
        ServerConfig.webroot = webroot;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        ServerConfig.port = port;
    }

    public static String getMaintenanceRoot() {
        return maintenanceRoot;
    }

    public static void setMaintenanceRoot(String maintenanceRoot) {
        ServerConfig.maintenanceRoot = maintenanceRoot;
    }


    public static String getWebrootHtml(){
        if(webroot!=null){

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(webroot));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            webRootHtml = scanner.useDelimiter("\\Z").next();
            scanner.close();

        }
        return webRootHtml;
    }

    public static String getMaintenanceHtml(){
        if(maintenanceRoot!=null){

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(maintenanceRoot));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            maintenanceRootHtml = scanner.useDelimiter("\\Z").next();
            scanner.close();

        }
        return maintenanceRootHtml;
    }
}
