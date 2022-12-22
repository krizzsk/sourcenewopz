package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;
import java.nio.charset.Charset;

/* renamed from: com.koushikdutta.async.http.a */
/* compiled from: AsyncHttpResponseImpl */
abstract class C20198a extends FilteredDataEmitter implements DataEmitter, AsyncHttpClientMiddleware.ResponseHead, AsyncHttpResponse {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int code;
    boolean mCompleted = false;
    private boolean mFirstWrite = true;
    protected Headers mHeaders;
    private CompletedCallback mReporter = new AsyncHttpResponseImpl$2(this);
    private AsyncHttpRequest mRequest;
    DataSink mSink;
    /* access modifiers changed from: private */
    public AsyncSocket mSocket;
    String message;
    String protocol;

    /* access modifiers changed from: protected */
    public void onHeadersReceived() {
    }

    /* access modifiers changed from: protected */
    public void onRequestCompleted(Exception exc) {
    }

    public AsyncSocket socket() {
        return this.mSocket;
    }

    public AsyncHttpRequest getRequest() {
        return this.mRequest;
    }

    /* access modifiers changed from: package-private */
    public void setSocket(AsyncSocket asyncSocket) {
        this.mSocket = asyncSocket;
        if (asyncSocket != null) {
            asyncSocket.setEndCallback(this.mReporter);
        }
    }

    /* access modifiers changed from: protected */
    public void onHeadersSent() {
        AsyncHttpRequestBody body = this.mRequest.getBody();
        if (body != null) {
            body.write(this.mRequest, this.mSink, new AsyncHttpResponseImpl$1(this));
        } else {
            onRequestCompleted((Exception) null);
        }
    }

    public DataEmitter emitter() {
        return getDataEmitter();
    }

    public AsyncHttpClientMiddleware.ResponseHead emitter(DataEmitter dataEmitter) {
        setDataEmitter(dataEmitter);
        return this;
    }

    private void terminate() {
        this.mSocket.setDataCallback(new AsyncHttpResponseImpl$3(this));
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        super.report(exc);
        terminate();
        this.mSocket.setWriteableCallback((WritableCallback) null);
        this.mSocket.setClosedCallback((CompletedCallback) null);
        this.mSocket.setEndCallback((CompletedCallback) null);
        this.mCompleted = true;
    }

    public void close() {
        super.close();
        terminate();
    }

    public C20198a(AsyncHttpRequest asyncHttpRequest) {
        this.mRequest = asyncHttpRequest;
    }

    public Headers headers() {
        return this.mHeaders;
    }

    public AsyncHttpClientMiddleware.ResponseHead headers(Headers headers) {
        this.mHeaders = headers;
        return this;
    }

    public int code() {
        return this.code;
    }

    public AsyncHttpClientMiddleware.ResponseHead code(int i) {
        this.code = i;
        return this;
    }

    public AsyncHttpClientMiddleware.ResponseHead protocol(String str) {
        this.protocol = str;
        return this;
    }

    public AsyncHttpClientMiddleware.ResponseHead message(String str) {
        this.message = str;
        return this;
    }

    public String protocol() {
        return this.protocol;
    }

    public String message() {
        return this.message;
    }

    public String toString() {
        Headers headers = this.mHeaders;
        if (headers == null) {
            return super.toString();
        }
        return headers.toPrefixString(this.protocol + " " + this.code + " " + this.message);
    }

    private void assertContent() {
        if (this.mFirstWrite) {
            this.mFirstWrite = false;
        }
    }

    public DataSink sink() {
        return this.mSink;
    }

    public AsyncHttpClientMiddleware.ResponseHead sink(DataSink dataSink) {
        this.mSink = dataSink;
        return this;
    }

    public AsyncServer getServer() {
        return this.mSocket.getServer();
    }

    public String charset() {
        String string;
        Multimap parseSemicolonDelimited = Multimap.parseSemicolonDelimited(headers().get("Content-Type"));
        if (parseSemicolonDelimited == null || (string = parseSemicolonDelimited.getString("charset")) == null || !Charset.isSupported(string)) {
            return null;
        }
        return string;
    }
}
