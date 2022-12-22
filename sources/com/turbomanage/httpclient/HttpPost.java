package com.turbomanage.httpclient;

public class HttpPost extends HttpRequest {
    public HttpPost(String str, ParameterMap parameterMap) {
        super(str, (ParameterMap) null);
        this.httpMethod = HttpMethod.POST;
        this.path = str;
        this.contentType = "application/x-www-form-urlencoded;charset=UTF-8";
        if (parameterMap != null) {
            this.content = parameterMap.urlEncodedBytes();
        }
    }

    public HttpPost(String str, ParameterMap parameterMap, String str2, byte[] bArr) {
        super(str, parameterMap);
        this.httpMethod = HttpMethod.POST;
        this.contentType = str2;
        this.content = bArr;
    }
}
