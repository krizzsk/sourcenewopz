package com.sdk.poibase.model;

import java.io.IOException;

public interface IHttpListener<T> {
    void onFail(IOException iOException);

    void onSuccess(T t);
}
