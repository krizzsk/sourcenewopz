package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.Request;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.dimina.container.secondparty.http.a */
/* compiled from: DownloadTask */
class C7531a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<String, String> f17119a = new ConcurrentHashMap();

    C7531a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55579a(String str, NetworkService.NetworkTaskModel.Download download, DidiHttpClient didiHttpClient) {
        Call newCall = didiHttpClient.newCall(m12681a(download));
        if (!TextUtils.isEmpty(str)) {
            this.f17119a.put(str, newCall.request().tag().toString());
        }
        return newCall;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55578a(NetworkService.NetworkTaskModel.Download download, DidiHttpClient didiHttpClient) {
        return mo55579a("", download, didiHttpClient);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55581a(String str, Call call, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        call.enqueue(new DownloadTask$1(this, str, iTaskCallback, download));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55580a(Call call, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        mo55581a("", call, download, iTaskCallback);
    }

    /* renamed from: a */
    private Request m12681a(NetworkService.NetworkTaskModel.Download download) {
        Request.Builder builder = new Request.Builder();
        if (download.headers != null) {
            builder.headers(Headers.m40612of((Map<String, String>) download.headers));
        }
        return builder.url(download.url).tag(Long.valueOf(System.currentTimeMillis())).get().build();
    }

    /* renamed from: a */
    public boolean mo55582a(String str, DidiHttpClient didiHttpClient) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = this.f17119a.get(str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            for (Call next : didiHttpClient.dispatcher().queuedCalls()) {
                if (str2.equals(next.request().tag().toString())) {
                    if (!next.isCanceled()) {
                        next.cancel();
                    }
                    z = true;
                }
            }
            for (Call next2 : didiHttpClient.dispatcher().runningCalls()) {
                if (str2.equals(next2.request().tag().toString())) {
                    if (!next2.isCanceled()) {
                        next2.cancel();
                    }
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            LogUtil.iRelease("DownloadTask", "download abort failed");
            e.printStackTrace();
        }
    }
}
