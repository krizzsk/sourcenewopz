package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.StringParser;

public class StringBody implements AsyncHttpRequestBody<String> {
    public static final String CONTENT_TYPE = "text/plain";

    /* renamed from: a */
    byte[] f55334a;

    /* renamed from: b */
    String f55335b;

    public String getContentType() {
        return "text/plain";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public StringBody() {
    }

    public StringBody(String str) {
        this();
        this.f55335b = str;
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new StringParser().parse(dataEmitter).setCallback(new FutureCallback<String>() {
            public void onCompleted(Exception exc, String str) {
                StringBody.this.f55335b = str;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        if (this.f55334a == null) {
            this.f55334a = this.f55335b.getBytes();
        }
        C20137Util.writeAll(dataSink, this.f55334a, completedCallback);
    }

    public int length() {
        if (this.f55334a == null) {
            this.f55334a = this.f55335b.getBytes();
        }
        return this.f55334a.length;
    }

    public String toString() {
        return this.f55335b;
    }

    public String get() {
        return toString();
    }
}
