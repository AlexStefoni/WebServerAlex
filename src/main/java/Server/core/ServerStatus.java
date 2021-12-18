package Server.core;

public class ServerStatus {

    public static int status;
    public ServerStatus(int status){
        this.status=status;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        ServerStatus.status = status;
    }
}
