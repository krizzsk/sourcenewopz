package com.turbomanage.httpclient;

public class BasicHttpClient extends AbstractHttpClient {
    public BasicHttpClient() {
        this("");
    }

    public BasicHttpClient(String str) {
        this(str, new BasicRequestHandler() {
        });
    }

    public BasicHttpClient(String str, RequestHandler requestHandler) {
        super(str, requestHandler);
    }
}
