package com.didi.map.utils;

import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpNetUtils {

    /* renamed from: b */
    private static HttpNetUtils f29026b;

    /* renamed from: a */
    private OkHttpClient f29027a;

    public static HttpNetUtils Instance() {
        return InstanceHolder.Instance;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static HttpNetUtils Instance = new HttpNetUtils();

        private InstanceHolder() {
        }
    }

    private HttpNetUtils() {
        this.f29027a = new OkHttpClient().newBuilder().connectTimeout(50, TimeUnit.SECONDS).connectionPool(new ConnectionPool(32, 50, TimeUnit.SECONDS)).readTimeout(50, TimeUnit.SECONDS).writeTimeout(50, TimeUnit.SECONDS).build();
    }

    public byte[] doPost(String str, byte[] bArr) {
        try {
            return this.f29027a.newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/x-protobuf"), bArr)).build()).execute().body().bytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
