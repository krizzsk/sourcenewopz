package com.didichuxing.security.challenge;

public interface IHttpRequest<T> {
    IHttpResponse<T> execute() throws Exception;

    String getHeader(String str) throws Exception;

    String getUrl() throws Exception;

    void removeHeader(String str) throws Exception;

    void setHeader(String str, String str2) throws Exception;
}
