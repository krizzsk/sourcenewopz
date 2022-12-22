package com.didichuxing.security.challenge;

import java.io.InputStream;

public interface IHttpResponse<T> {
    String getHeader(String str) throws Exception;

    InputStream getRawBody() throws Exception;

    T getResponse() throws Exception;

    int getResponseCode() throws Exception;
}
