package com.didiglobal.enginecore.data.exception;

public class BffException extends EngineErrorException {
    public BffException(String str) {
        super(500, "traceid: " + str);
    }

    public BffException(String str, Exception exc) {
        super(500, "traceid: " + str, exc);
    }
}
