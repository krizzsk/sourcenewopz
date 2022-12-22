package com.turbomanage.httpclient;

public class HttpDelete extends HttpRequest {
    public HttpDelete(String str, ParameterMap parameterMap) {
        super(str, parameterMap);
        this.httpMethod = HttpMethod.DELETE;
    }
}
