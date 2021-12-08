package Server.config;

public class Configuration {
    private int port;
    private String webroot;

    public int getPort() {
        return port;
    }

    public void setPort(int port) throws BadPortException{
        this.port = port;
    }

    public String getWebroot() {
        return webroot;
    }

    public void setWebroot(String webroot) {
        this.webroot = webroot;
    }
}
