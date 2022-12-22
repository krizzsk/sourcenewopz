package com.koushikdutta.async.http;

public class RedirectLimitExceededException extends Exception {
    public RedirectLimitExceededException(String str) {
        super(str);
    }
}
