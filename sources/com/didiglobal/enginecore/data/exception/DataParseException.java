package com.didiglobal.enginecore.data.exception;

public class DataParseException extends EngineErrorException {
    private String resultCode = "0";

    public DataParseException(String str) {
        super(404, str);
    }

    public DataParseException(String str, String str2) {
        super(404, str2);
        this.resultCode = str;
    }

    public DataParseException(String str, Exception exc) {
        super(404, str, exc);
    }
}
