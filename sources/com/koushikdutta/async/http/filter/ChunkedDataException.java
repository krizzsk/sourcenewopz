package com.koushikdutta.async.http.filter;

public class ChunkedDataException extends Exception {
    public ChunkedDataException(String str) {
        super(str);
    }
}
