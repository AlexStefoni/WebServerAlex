package Server.config;

import Server.config.util.Json;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigurationManager {
    private static ConfigurationManager myConfigurationManager;
    private static Configuration myCurrentConfiguration;

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
    public void loadConfigFile(String filePath)  {
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new HttpConfurationException(e);
        }
        StringBuffer sb=new StringBuffer();
        int i;
        try {
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        }catch (IOException e){
            throw new HttpConfurationException(e);
        }
        JsonNode conf= null;
        try {
            conf = Json.parse(sb.toString());
        } catch (JsonProcessingException e) {
            throw new HttpConfurationException("error parsing the configuration file ",e);
        }
        try {
            myCurrentConfiguration=Json.fromJson(conf,Configuration.class);
        } catch (JsonProcessingException e) {
            throw new HttpConfurationException("error pasing the configuratio file internal",e);
        }
    }
    /**
     *
     * retuns curent loaded configurations
     * */
    public Configuration getCurrentConfig(){
        if (myCurrentConfiguration==null){
            throw new HttpConfurationException("no curretn configuration set");
        }
        return myCurrentConfiguration;

    }
}
