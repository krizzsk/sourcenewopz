package com.jumio.core.extraction.barcode.exception;

public class PDF417ParserException extends Exception {
    public PDF417ParserException(String str) {
        this((Exception) null, str);
    }

    public PDF417ParserException(Exception exc, String str) {
        super(str);
        if (exc != null) {
            setStackTrace(exc.getStackTrace());
        }
    }

    public PDF417ParserException(String str, Object... objArr) {
        this((Exception) null, str, objArr);
    }

    public PDF417ParserException(Exception exc, String str, Object... objArr) {
        super(String.format(str, objArr));
        if (exc != null) {
            setStackTrace(exc.getStackTrace());
        }
    }
}
