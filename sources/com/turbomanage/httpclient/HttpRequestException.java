package com.turbomanage.httpclient;

public class HttpRequestException extends Exception {
    private static final long serialVersionUID = -2413629666163901633L;
    private HttpResponse httpResponse;

    public HttpRequestException(Exception exc, HttpResponse httpResponse2) {
        super(exc);
        this.httpResponse = httpResponse2;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
