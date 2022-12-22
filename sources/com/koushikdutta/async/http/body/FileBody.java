package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import java.io.File;

public class FileBody implements AsyncHttpRequestBody<File> {
    public static final String CONTENT_TYPE = "application/binary";

    /* renamed from: a */
    File f55311a;

    /* renamed from: b */
    String f55312b = "application/binary";

    public FileBody(File file) {
        this.f55311a = file;
    }

    public FileBody(File file, String str) {
        this.f55311a = file;
        this.f55312b = str;
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C20137Util.pump(this.f55311a, dataSink, completedCallback);
    }

    public void parse(DataEmitter dataEmitter, CompletedCallback completedCallback) {
        throw new AssertionError("not implemented");
    }

    public String getContentType() {
        return this.f55312b;
    }

    public void setContentType(String str) {
        this.f55312b = str;
    }

    public boolean readFullyOnRequest() {
        throw new AssertionError("not implemented");
    }

    public int length() {
        return (int) this.f55311a.length();
    }

    public File get() {
        return this.f55311a;
    }
}
