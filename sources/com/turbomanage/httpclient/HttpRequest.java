package com.turbomanage.httpclient;

public abstract class HttpRequest {
    public static final String MULTIPART = "multipart/form-data";
    public static final String URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8";
    protected byte[] content;
    protected String contentType;
    protected HttpMethod httpMethod;
    protected String path = "";

    public HttpRequest(String str, ParameterMap parameterMap) {
        if (str != null) {
            this.path = str;
        }
        if (parameterMap != null) {
            this.path += "?" + parameterMap.urlEncode();
        }
    }

    public String getPath() {
        return this.path;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getContent() {
        return this.content;
    }
}
