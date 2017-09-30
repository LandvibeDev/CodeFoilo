package com.landvibe.codefolio.error;

public class UserExistException extends RuntimeException {
    public UserExistException() {
    }

    public UserExistException(String msg) {
        super(msg);
    }

    public UserExistException(String msg, Throwable t) {
        super(msg, t);
    }
}
