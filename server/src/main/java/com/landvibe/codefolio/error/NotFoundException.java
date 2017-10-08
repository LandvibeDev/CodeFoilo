package com.landvibe.codefolio.error;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
    }

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
