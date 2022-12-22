package com.koushikdutta.async.http.filter;

public class PrematureDataEndException extends Exception {
    public PrematureDataEndException(String str) {
        super(str);
    }
}
