package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.InputStream;

public class StreamBody implements AsyncHttpRequestBody<InputStream> {
    public static final String CONTENT_TYPE = "application/binary";

    /* renamed from: a */
    InputStream f55331a;

    /* renamed from: b */
    int f55332b;

    /* renamed from: c */
    String f55333c = "application/binary";

    public StreamBody(InputStream inputStream, int i) {
        this.f55331a = inputStream;
        this.f55332b = i;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        InputStream inputStream = this.f55331a;
        int i = this.f55332b;
        C20137Util.pump(inputStream, i < 0 ? 2147483647L : (long) i, dataSink, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    public String getContentType() {
        return this.f55333c;
    }

    public StreamBody setContentType(String str) {
        this.f55333c = str;
        return this;
    }

    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public int length() {
        return this.f55332b;
    }

    public InputStream get() {
        return this.f55331a;
    }
}
