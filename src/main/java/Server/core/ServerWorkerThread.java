package Server.core;

import java.io.*;
import java.net.Socket;
import java.util.Locale;
import java.util.StringTokenizer;

public class ServerWorkerThread extends Thread{
    private Socket socket;
    String html;
    int status;
    public ServerWorkerThread(Socket socket,String html){
        this.html=html;
        this.socket=socket;
    }

    InputStream inputStream =null;
    OutputStream outputStream=null;

    @Override
    public void run() {

        try {

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            /*
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input= in.readLine();
            StringTokenizer parse= new StringTokenizer(input);
            String method = parse.nextToken().toUpperCase();
            System.out.println(method);

              */
            // TODO reading

            // TODO writing
            final String crlf = "\n\r";
            //String html = "<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
            String response =
                    "HTTP/1.1 200 OK"//status line :HTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                            + crlf
                            + "Content-Lenght" + html.getBytes().length + crlf + crlf
                            + crlf
                            + html
                            + crlf + crlf;

            outputStream.write(response.getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }


            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }



            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {}
            }

        }
    }
}
