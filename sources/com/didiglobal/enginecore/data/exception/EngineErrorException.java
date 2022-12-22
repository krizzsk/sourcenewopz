package com.didiglobal.enginecore.data.exception;

public class EngineErrorException extends Exception {
    private int errNo;

    public EngineErrorException(int i, String str) {
        super(str);
        this.errNo = i;
    }

    public EngineErrorException(Exception exc) {
        super(exc);
        this.errNo = -1;
    }

    public EngineErrorException(int i, String str, Exception exc) {
        super(str, exc);
        this.errNo = i;
    }

    public int getErrNo() {
        return this.errNo;
    }
}
