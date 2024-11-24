package backend.academy.fractalflame.exceptions;

public class AwaitException extends RuntimeException {
    public AwaitException(String message) {
        super(message);
    }

    public AwaitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AwaitException(Throwable cause) {
        super(cause);
    }
}
