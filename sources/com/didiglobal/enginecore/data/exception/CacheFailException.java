package com.didiglobal.enginecore.data.exception;

public class CacheFailException extends EngineErrorException {
    public CacheFailException(String str) {
        super(300, str);
    }

    public CacheFailException(String str, Exception exc) {
        super(300, str, exc);
    }
}
