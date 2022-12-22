package com.turbomanage.httpclient;

public abstract class AsyncCallback {
    public abstract void onComplete(HttpResponse httpResponse);

    public void onError(Exception exc) {
        exc.printStackTrace();
    }
}
