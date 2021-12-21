package Server.config;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testBadPort() throws BadPortException {
        Configuration  conf = new Configuration ();
        assertFalse(conf.setPort(0));
    }
    @Test
    public void testGoodPort() throws BadPortException {
        Configuration  conf = new Configuration ();
        assertTrue(conf.setPort(8080));
    }

    @Test
    public void testGoodPortSet() throws BadPortException {
       int port=8080;
       int expectedPort=8080;
       Configuration  conf = new Configuration ();
       conf.setPort(port);
       assertEquals(expectedPort,conf.getPort());
    }
    @Test
    public void testBadPortSet() throws BadPortException {
        int port=0;
        int expectedPort=0;
        Configuration  conf = new Configuration ();
        conf.setPort(port);
        assertEquals(expectedPort,conf.getPort());
    }

    @Test
    public void testBadWebroot(){
        String web=null;
        Configuration  conf = new Configuration ();
        assertFalse(conf.setWebroot(web));
    }

    @Test
    public void testGoodWebroot(){
        String web="   ";
        Configuration  conf = new Configuration ();
        assertTrue(conf.setWebroot(web));
    }

    @Test
    public void testWebrootGet(){
        String web="   ";
        String expectedWeb="   ";
        Configuration  conf = new Configuration ();
        conf.setWebroot(web);
        assertEquals(expectedWeb,conf.getWebroot());
    }
    @Test
    public void testConfigManagerMock(){

        ConfigurationManager manager = mock(ConfigurationManager.class);

        verify(manager,times(1)).getInstance().loadConfigFile("src/main/resources/http.json");;
    }

    @Test
    public void gerConfigFromManager() throws BadPortException {
        Configuration  conf = new Configuration ();
        conf.setWebroot("/tmp");
        conf.setPort(8080);
        ConfigurationManager.getInstance().loadConfigFile("src/main/resources/http.json");
        Configuration  confM= ConfigurationManager.getInstance().getCurrentConfig();

        assertEquals(conf.getPort(),confM.getPort());
        assertEquals(conf.getWebroot(),confM.getWebroot());
    }


    @Test
    public void mockConfigSet() throws BadPortException {

        Configuration  conf = mock(Configuration.class);

        verify(conf,never()).setPort(8080);
        verify(conf,never()).setWebroot(" ");

    }

    @Test
    public void checkStatus(){

        assertEquals(false,ServerStatus.getStatus());
        ServerStatus.setStatus(true);
        assertEquals(true,ServerStatus.getStatus());
        ServerStatus.setStatus(false);
        assertEquals(false,ServerStatus.getStatus());
    }
    @Test
    public void checkMflag(){

        assertEquals(false,ServerStatus.ismFlag());
        ServerStatus.setmFlag(true);
        assertEquals(true,ServerStatus.ismFlag());
        ServerStatus.setmFlag(false);
        assertEquals(false,ServerStatus.ismFlag());
    }

    @Test
    public void checkConfig(){
        String def1=ServerConfig.getMaintenanceHtml();
        String def2=ServerConfig.getWebrootHtml();

        String expected="<html><head><title>Simple Server</title></head><body><ch1>page not found</ch1></body></html>";
        assertEquals(expected,def1);
        assertEquals(expected,def1);
    }
    @Test
    public void checkConfigFiles(){

       String ref="<html><head><title>Simple Server</title></head><body><ch1>page not found</ch1></body></html>";

       String refroot="src/main/resources/test.html";
        ServerConfig.setWebroot("src/main/resources/test.html");
        ServerConfig.setMaintenanceRoot("src/main/resources/test.html");
        String html1=ServerConfig.getWebrootHtml();
        String html2=ServerConfig.getMaintenanceHtml();


        assertEquals(ref,html1);
        assertEquals(ref,html2);
        assertEquals(refroot,ServerConfig.getWebroot());
        assertEquals(refroot,ServerConfig.getMaintenanceRoot());

    }
}