package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONObjectParser;
import org.json.JSONObject;

public class JSONObjectBody implements AsyncHttpRequestBody<JSONObject> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a */
    byte[] f55316a;

    /* renamed from: b */
    JSONObject f55317b;

    public String getContentType() {
        return "application/json";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public JSONObjectBody() {
    }

    public JSONObjectBody(JSONObject jSONObject) {
        this();
        this.f55317b = jSONObject;
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new JSONObjectParser().parse(dataEmitter).setCallback(new FutureCallback<JSONObject>() {
            public void onCompleted(Exception exc, JSONObject jSONObject) {
                JSONObjectBody.this.f55317b = jSONObject;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C20137Util.writeAll(dataSink, this.f55316a, completedCallback);
    }

    public int length() {
        byte[] bytes = this.f55317b.toString().getBytes();
        this.f55316a = bytes;
        return bytes.length;
    }

    public JSONObject get() {
        return this.f55317b;
    }
}
