package Server.config;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {

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
}