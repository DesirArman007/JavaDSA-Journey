package Stack;

public class StackException extends Exception{
    public StackException() {
    }

    public StackException(String message) {
        super(message);
    }

    public StackException(String message, Throwable cause) {
        super(message, cause);
    }

    public StackException(Throwable cause) {
        super(cause);
    }

    public StackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
