package com.turbomanage.httpclient;

public interface AsyncRequestExecutorFactory {
    AsyncRequestExecutor getAsyncRequestExecutor(AsyncHttpClient asyncHttpClient, AsyncCallback asyncCallback);
}
