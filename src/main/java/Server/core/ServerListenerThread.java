package Server.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListenerThread extends  Thread{
    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public ServerListenerThread(int port,String webroot) throws IOException {
        this.port=port;
        this.webroot=webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run(){
        try {
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            // TODO reading


            // TODO writing
            final String crlf ="\n\r";
            String html = "<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
            String response =
                    "HTTP/1.1 200 OK"//status line :HTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            +crlf
                            +"Content-Lenght"+html.getBytes().length+crlf+crlf
                            +crlf
                            +html
                            +crlf+crlf;

            outputStream.write(response.getBytes());
            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
