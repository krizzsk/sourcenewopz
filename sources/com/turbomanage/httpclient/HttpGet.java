package com.turbomanage.httpclient;

public class HttpGet extends HttpRequest {
    public HttpGet(String str, ParameterMap parameterMap) {
        super(str, parameterMap);
        this.httpMethod = HttpMethod.GET;
    }
}
