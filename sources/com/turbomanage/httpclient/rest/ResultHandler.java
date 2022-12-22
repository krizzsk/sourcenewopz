package com.turbomanage.httpclient.rest;

import com.turbomanage.httpclient.HttpResponse;

public abstract class ResultHandler {
    public abstract boolean onResult(HttpResponse httpResponse);

    public void onError(Exception exc) {
        exc.printStackTrace();
    }
}
