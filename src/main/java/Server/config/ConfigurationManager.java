package Server.config;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;

    private ConfigurationManager() {
    }
    public static ConfigurationManager getInstance(){
        if(myConfigurationManager==null)
            myConfigurationManager=new ConfigurationManager();
        return myConfigurationManager;
    }
    /**
    * used to load a configuration file
    *
    * */
    public void loadConfigFile(String filePath){

    }
    /**
     *
     * retuns curent loaded configurations
     * */
    public void getCurrentConfig(){

    }
}
