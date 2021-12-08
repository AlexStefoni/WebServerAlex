package Server.config;

public class BadPortException extends Throwable {

    public BadPortException(String message) {
        super(message);
    }

    public BadPortException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadPortException(Throwable cause) {
        super(cause);
    }
    public BadPortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
