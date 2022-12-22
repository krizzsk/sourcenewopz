package com.turbomanage.httpclient.android;

import android.os.AsyncTask;
import com.turbomanage.httpclient.AsyncCallback;
import com.turbomanage.httpclient.AsyncHttpClient;
import com.turbomanage.httpclient.AsyncRequestExecutor;
import com.turbomanage.httpclient.HttpRequest;
import com.turbomanage.httpclient.HttpResponse;

public class DoHttpRequestTask extends AsyncTask<HttpRequest, Void, HttpResponse> implements AsyncRequestExecutor {
    private AsyncCallback callback;
    private AsyncHttpClient client;
    private Exception savedException;

    public DoHttpRequestTask(AsyncHttpClient asyncHttpClient, AsyncCallback asyncCallback) {
        this.client = asyncHttpClient;
        this.callback = asyncCallback;
    }

    /* access modifiers changed from: protected */
    public HttpResponse doInBackground(HttpRequest... httpRequestArr) {
        if (httpRequestArr != null) {
            try {
                if (httpRequestArr.length > 0) {
                    return this.client.tryMany(httpRequestArr[0]);
                }
            } catch (Exception e) {
                this.savedException = e;
                cancel(true);
                return null;
            }
        }
        throw new IllegalArgumentException("DoHttpRequestTask takes exactly one argument of type HttpRequest");
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(HttpResponse httpResponse) {
        this.callback.onComplete(httpResponse);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        this.callback.onError(this.savedException);
    }

    public void execute(HttpRequest httpRequest) {
        super.execute(new HttpRequest[]{httpRequest});
    }
}
