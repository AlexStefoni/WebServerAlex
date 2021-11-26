package Server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorkerThread extends Thread{
    private Socket socket;
    public ServerWorkerThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // TODO reading


            // TODO writing
            final String crlf = "\n\r";
            String html = "<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
            String response =
                    "HTTP/1.1 200 OK"//status line :HTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            + crlf
                            + "Content-Lenght" + html.getBytes().length + crlf + crlf
                            + crlf
                            + html
                            + crlf + crlf;

            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
