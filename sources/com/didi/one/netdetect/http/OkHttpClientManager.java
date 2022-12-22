package com.didi.one.netdetect.http;

import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;

public class OkHttpClientManager {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: a */
    private static final String f29444a = "OND_OkHttpClientManager";

    /* renamed from: b */
    private static OkHttpClientManager f29445b;

    /* renamed from: c */
    private DidiHttpClient f29446c = new DidiHttpClient();

    private OkHttpClientManager() {
    }

    public static OkHttpClientManager getInstance() {
        if (f29445b == null) {
            synchronized (OkHttpClientManager.class) {
                if (f29445b == null) {
                    f29445b = new OkHttpClientManager();
                }
            }
        }
        return f29445b;
    }

    public void getAsync(String str, Callback callback) {
        Request build = new Request.Builder().url(str).build();
        if (callback != null) {
            this.f29446c.newCall(build).enqueue(callback);
        }
    }

    public void postAsync(String str, String str2, Callback callback) {
        Request build = new Request.Builder().url(str).post(RequestBody.create(JSON, str2)).build();
        if (callback != null) {
            this.f29446c.newCall(build).enqueue(callback);
        }
    }
}
