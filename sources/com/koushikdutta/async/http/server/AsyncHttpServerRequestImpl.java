package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.Multimap;
import com.koushikdutta.async.http.Protocol;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public abstract class AsyncHttpServerRequestImpl extends FilteredDataEmitter implements CompletedCallback, AsyncHttpServerRequest {
    AsyncHttpRequestBody mBody;
    LineEmitter.StringCallback mHeaderCallback = new LineEmitter.StringCallback() {
        public void onStringAvailable(String str) {
            if (AsyncHttpServerRequestImpl.this.statusLine == null) {
                String unused = AsyncHttpServerRequestImpl.this.statusLine = str;
                if (!AsyncHttpServerRequestImpl.this.statusLine.contains("HTTP/")) {
                    AsyncHttpServerRequestImpl.this.onNotHttp();
                    AsyncHttpServerRequestImpl.this.mSocket.setDataCallback(new DataCallback.NullDataCallback());
                    AsyncHttpServerRequestImpl.this.report(new IOException("data/header received was not not http"));
                }
            } else if (!StringUtils.f5622CR.equals(str)) {
                AsyncHttpServerRequestImpl.this.mRawHeaders.addLine(str);
            } else {
                DataEmitter bodyDecoder = HttpUtil.getBodyDecoder(AsyncHttpServerRequestImpl.this.mSocket, Protocol.HTTP_1_1, AsyncHttpServerRequestImpl.this.mRawHeaders, true);
                AsyncHttpServerRequestImpl asyncHttpServerRequestImpl = AsyncHttpServerRequestImpl.this;
                asyncHttpServerRequestImpl.mBody = asyncHttpServerRequestImpl.onBody(asyncHttpServerRequestImpl.mRawHeaders);
                if (AsyncHttpServerRequestImpl.this.mBody == null) {
                    AsyncHttpServerRequestImpl asyncHttpServerRequestImpl2 = AsyncHttpServerRequestImpl.this;
                    asyncHttpServerRequestImpl2.mBody = HttpUtil.getBody(bodyDecoder, asyncHttpServerRequestImpl2.mReporter, AsyncHttpServerRequestImpl.this.mRawHeaders);
                    if (AsyncHttpServerRequestImpl.this.mBody == null) {
                        AsyncHttpServerRequestImpl asyncHttpServerRequestImpl3 = AsyncHttpServerRequestImpl.this;
                        asyncHttpServerRequestImpl3.mBody = asyncHttpServerRequestImpl3.onUnknownBody(asyncHttpServerRequestImpl3.mRawHeaders);
                        if (AsyncHttpServerRequestImpl.this.mBody == null) {
                            AsyncHttpServerRequestImpl asyncHttpServerRequestImpl4 = AsyncHttpServerRequestImpl.this;
                            asyncHttpServerRequestImpl4.mBody = new UnknownRequestBody(asyncHttpServerRequestImpl4.mRawHeaders.get("Content-Type"));
                        }
                    }
                }
                AsyncHttpServerRequestImpl.this.mBody.parse(bodyDecoder, AsyncHttpServerRequestImpl.this.mReporter);
                AsyncHttpServerRequestImpl.this.onHeadersReceived();
            }
        }
    };
    /* access modifiers changed from: private */
    public Headers mRawHeaders = new Headers();
    /* access modifiers changed from: private */
    public CompletedCallback mReporter = new CompletedCallback() {
        public void onCompleted(Exception exc) {
            AsyncHttpServerRequestImpl.this.onCompleted(exc);
        }
    };
    AsyncSocket mSocket;
    String method;
    private HashMap<String, Object> state = new HashMap<>();
    /* access modifiers changed from: private */
    public String statusLine;

    /* access modifiers changed from: protected */
    public AsyncHttpRequestBody onBody(Headers headers) {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void onHeadersReceived();

    /* access modifiers changed from: protected */
    public AsyncHttpRequestBody onUnknownBody(Headers headers) {
        return null;
    }

    public HashMap<String, Object> getState() {
        return this.state;
    }

    public String getStatusLine() {
        return this.statusLine;
    }

    public void onCompleted(Exception exc) {
        report(exc);
    }

    /* access modifiers changed from: protected */
    public void onNotHttp() {
        System.out.println("not http!");
    }

    public String getMethod() {
        return this.method;
    }

    /* access modifiers changed from: package-private */
    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
        LineEmitter lineEmitter = new LineEmitter();
        this.mSocket.setDataCallback(lineEmitter);
        lineEmitter.setLineCallback(this.mHeaderCallback);
        this.mSocket.setEndCallback(new CompletedCallback.NullCompletedCallback());
    }

    public AsyncSocket getSocket() {
        return this.mSocket;
    }

    public Headers getHeaders() {
        return this.mRawHeaders;
    }

    public void setDataCallback(DataCallback dataCallback) {
        this.mSocket.setDataCallback(dataCallback);
    }

    public DataCallback getDataCallback() {
        return this.mSocket.getDataCallback();
    }

    public boolean isChunked() {
        return this.mSocket.isChunked();
    }

    public AsyncHttpRequestBody getBody() {
        return this.mBody;
    }

    public void pause() {
        this.mSocket.pause();
    }

    public void resume() {
        this.mSocket.resume();
    }

    public boolean isPaused() {
        return this.mSocket.isPaused();
    }

    public String toString() {
        Headers headers = this.mRawHeaders;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.statusLine);
    }

    public String get(String str) {
        String string = getQuery().getString(str);
        if (string != null) {
            return string;
        }
        Object obj = getBody().get();
        if (obj instanceof Multimap) {
            return ((Multimap) obj).getString(str);
        }
        return null;
    }
}
