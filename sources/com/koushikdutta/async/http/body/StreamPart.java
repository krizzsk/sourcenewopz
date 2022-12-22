package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.NameValuePair;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class StreamPart extends Part {
    /* access modifiers changed from: protected */
    public abstract InputStream getInputStream() throws IOException;

    public StreamPart(String str, long j, List<NameValuePair> list) {
        super(str, j, list);
    }

    public void write(DataSink dataSink, CompletedCallback completedCallback) {
        try {
            C20137Util.pump(getInputStream(), dataSink, completedCallback);
        } catch (Exception e) {
            completedCallback.onCompleted(e);
        }
    }
}
