package com.koushikdutta.async.http.filter;

public class DataRemainingException extends Exception {
    public DataRemainingException(String str, Exception exc) {
        super(str, exc);
    }
}
