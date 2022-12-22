package com.turbomanage.httpclient;

public class HttpHead extends HttpRequest {
    public HttpHead(String str, ParameterMap parameterMap) {
        super(str, parameterMap);
        this.httpMethod = HttpMethod.HEAD;
    }
}
