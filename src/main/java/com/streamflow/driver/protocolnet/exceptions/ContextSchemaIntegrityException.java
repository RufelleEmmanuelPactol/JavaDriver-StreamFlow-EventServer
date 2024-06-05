package com.streamflow.driver.protocolnet.exceptions;

public class ContextSchemaIntegrityException extends StreamFlowException{
    public ContextSchemaIntegrityException() {
        super();
    }

    public ContextSchemaIntegrityException(String message) {
        super(message);
    }

    public ContextSchemaIntegrityException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContextSchemaIntegrityException(Throwable cause) {
        super(cause);
    }

    protected ContextSchemaIntegrityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
