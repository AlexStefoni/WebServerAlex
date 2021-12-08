package Server.config;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class ConfigUtils {

    public static boolean checkPort(int portNumber)
    {
        if (portNumber <= 0){
            return false;
        }

        try (var ss = new ServerSocket(portNumber); var ds = new DatagramSocket(portNumber)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }


}
