package Server.config;

public class HttpConfurationException extends  RuntimeException {
    public HttpConfurationException() {
    }

    public HttpConfurationException(String message) {
        super(message);
    }
    public HttpConfurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpConfurationException(Throwable cause) {
        super(cause);
    }

    public HttpConfurationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
