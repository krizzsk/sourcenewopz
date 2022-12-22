package com.didi.onehybrid.exception;

public class BridgeCallException extends RuntimeException {
    public BridgeCallException(String str) {
        super(str);
    }

    public BridgeCallException(String str, Exception exc) {
        super(str, exc);
    }
}
