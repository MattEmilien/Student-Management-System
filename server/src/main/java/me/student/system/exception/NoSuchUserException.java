package me.student.system.exception;

public class NoSuchUserException extends RuntimeException {

    public NoSuchUserException() {
        super("No such user found");
    }

    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchUserException(Throwable cause) {
        super(cause);
    }
}
