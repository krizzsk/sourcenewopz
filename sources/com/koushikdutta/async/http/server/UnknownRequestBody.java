package com.koushikdutta.async.http.server;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.AsyncHttpRequestBody;

public class UnknownRequestBody implements AsyncHttpRequestBody<Void> {

    /* renamed from: a */
    int f55434a = -1;

    /* renamed from: b */
    DataEmitter f55435b;

    /* renamed from: c */
    private String f55436c;

    public Void get() {
        return null;
    }

    public boolean readFullyOnRequest() {
        return false;
    }

    public UnknownRequestBody(String str) {
        this.f55436c = str;
    }

    public UnknownRequestBody(DataEmitter dataEmitter, String str, int i) {
        this.f55436c = str;
        this.f55435b = dataEmitter;
        this.f55434a = i;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C20137Util.pump(this.f55435b, dataSink, completedCallback);
        if (this.f55435b.isPaused()) {
            this.f55435b.resume();
        }
    }

    public String getContentType() {
        return this.f55436c;
    }

    public int length() {
        return this.f55434a;
    }

    @Deprecated
    public void setCallbacks(DataCallback dataCallback, CompletedCallback completedCallback) {
        this.f55435b.setEndCallback(completedCallback);
        this.f55435b.setDataCallback(dataCallback);
    }

    public DataEmitter getEmitter() {
        return this.f55435b;
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        this.f55435b = dataEmitter;
        dataEmitter.setEndCallback(completedCallback);
        dataEmitter.setDataCallback(new DataCallback.NullDataCallback());
    }
}
