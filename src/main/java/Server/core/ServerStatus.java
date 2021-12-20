package Server.core;

public class ServerStatus {

    public static boolean status=false;
    public static boolean mFlag=false;

    public static boolean ismFlag() {
        return mFlag;
    }

    public static void setmFlag(boolean mFlag) {
        ServerStatus.mFlag = mFlag;
    }

    public static boolean getStatus() {
        return status;
    }

    public static void setStatus(boolean status) {
        ServerStatus.status = status;
    }
}
