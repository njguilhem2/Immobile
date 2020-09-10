package br.com.imobzi.batch.handler;

public class ForbiddenException extends RuntimeException{
    private static final long serialVersionUID = 2L;

    public ForbiddenException(String msg) {
        super(msg);
    }

    public ForbiddenException(String msg, Exception e) {
        super(msg + e.getMessage());
    }
}
