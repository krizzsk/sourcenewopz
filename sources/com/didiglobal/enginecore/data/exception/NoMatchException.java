package com.didiglobal.enginecore.data.exception;

public class NoMatchException extends EngineErrorException {
    public NoMatchException(String str) {
        super(1, str);
    }
}
