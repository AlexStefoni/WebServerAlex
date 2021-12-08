package Server.config;

public class Configuration {
    private int port;
    private String webroot;

    public int getPort() {
        return port;
    }

    public boolean setPort(int port) throws BadPortException{
        if(ConfigUtils.checkPort(port)) {
            this.port = port;
            return true;
        }else this.port=0;
        return false;
    }

    public String getWebroot() {return webroot;}

    public Boolean setWebroot(String webroot) {
        if(webroot==null)
            return false;
        this.webroot = webroot;
        return true;
    }
}
