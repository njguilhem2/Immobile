package br.com.imobzi.batch.handler;

import org.springframework.remoting.RemoteTimeoutException;

public class BadRequestException extends RemoteTimeoutException {
    private static final long serialVersionUID = 1L;

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(String msg, Exception e) {
        super(msg + e.getMessage());
    }
}
