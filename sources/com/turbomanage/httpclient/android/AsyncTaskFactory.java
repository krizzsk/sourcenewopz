package com.turbomanage.httpclient.android;

import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.AsyncHttpClient;
import com.turbomanage.httpclient.AsyncRequestExecutor;
import com.turbomanage.httpclient.AsyncRequestExecutorFactory;

public class AsyncTaskFactory implements AsyncRequestExecutorFactory {
    public AsyncRequestExecutor getAsyncRequestExecutor(AsyncHttpClient asyncHttpClient, AsyncCallback asyncCallback) {
        return new DoHttpRequestTask(asyncHttpClient, asyncCallback);
    }
}
