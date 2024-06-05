package com.streamflow.driver.protocolnet.exceptions;

import java.io.IOException;

public class StreamFlowException extends Exception {

    public StreamFlowException() {
        super();
    }

    public StreamFlowException(String message) {
        super(message);
    }

    public StreamFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamFlowException(Throwable cause) {
        super(cause);
    }

    protected StreamFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
