package com.leonardo.logparser.exception;

public class NotFoundLogException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundLogException() {
    }

    public NotFoundLogException(String message) {
        super(message);
    }

}