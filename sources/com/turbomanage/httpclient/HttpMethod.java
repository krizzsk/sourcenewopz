package com.turbomanage.httpclient;

public enum HttpMethod {
    GET(true, false),
    POST(true, true),
    PUT(true, true),
    DELETE(true, false),
    HEAD(false, false);
    
    private boolean doInput;
    private boolean doOutput;

    private HttpMethod(boolean z, boolean z2) {
        this.doInput = z;
        this.doOutput = z2;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public String getMethodName() {
        return toString();
    }
}
