package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.JSONArrayParser;
import org.json.JSONArray;

public class JSONArrayBody implements AsyncHttpRequestBody<JSONArray> {
    public static final String CONTENT_TYPE = "application/json";

    /* renamed from: a */
    byte[] f55314a;

    /* renamed from: b */
    JSONArray f55315b;

    public String getContentType() {
        return "application/json";
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public JSONArrayBody() {
    }

    public JSONArrayBody(JSONArray jSONArray) {
        this();
        this.f55315b = jSONArray;
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new JSONArrayParser().parse(dataEmitter).setCallback(new FutureCallback<JSONArray>() {
            public void onCompleted(Exception exc, JSONArray jSONArray) {
                JSONArrayBody.this.f55315b = jSONArray;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        C20137Util.writeAll(dataSink, this.f55314a, completedCallback);
    }

    public int length() {
        byte[] bytes = this.f55315b.toString().getBytes();
        this.f55314a = bytes;
        return bytes.length;
    }

    public JSONArray get() {
        return this.f55315b;
    }
}
