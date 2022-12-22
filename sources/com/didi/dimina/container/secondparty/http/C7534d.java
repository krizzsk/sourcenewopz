package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import com.didi.dimina.container.service.NetworkService;
import com.didi.dimina.container.util.LogUtil;
import didihttp.Call;
import didihttp.DidiHttpClient;
import didihttp.Headers;
import didihttp.MediaType;
import didihttp.MultipartBody;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.didi.dimina.container.secondparty.http.d */
/* compiled from: UploadTask */
class C7534d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Map<String, String> f17126a = new ConcurrentHashMap();

    C7534d() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55589a(String str, NetworkService.NetworkTaskModel.Upload upload, DidiHttpClient didiHttpClient, NetworkService.ITaskCallback iTaskCallback) {
        Call newCall = didiHttpClient.newCall(m12702a(upload, (RequestBody) new ProgressRequestBody(m12703a(upload), new UploadTask$1(this, iTaskCallback))));
        if (!TextUtils.isEmpty(str)) {
            this.f17126a.put(str, newCall.request().tag().toString());
        }
        return newCall;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Call mo55588a(NetworkService.NetworkTaskModel.Upload upload, DidiHttpClient didiHttpClient, NetworkService.ITaskCallback iTaskCallback) {
        return mo55589a("", upload, didiHttpClient, iTaskCallback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55591a(String str, Call call, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        call.enqueue(new UploadTask$2(this, str, iTaskCallback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55590a(Call call, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        mo55591a("", call, upload, iTaskCallback);
    }

    /* renamed from: a */
    public boolean mo55592a(String str, DidiHttpClient didiHttpClient) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String str2 = this.f17126a.get(str);
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
            LogUtil.iRelease("UploadTask", "upload load abort failed");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private Request m12702a(NetworkService.NetworkTaskModel.Upload upload, RequestBody requestBody) {
        return new Request.Builder().post(requestBody).url(upload.url).headers(Headers.m40612of((Map<String, String>) upload.headers)).tag(Long.valueOf(System.currentTimeMillis())).build();
    }

    /* renamed from: a */
    private static RequestBody m12703a(NetworkService.NetworkTaskModel.Upload upload) {
        File file = new File(upload.filePath);
        MultipartBody.Builder addFormDataPart = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart(upload.fileName, file.getName(), RequestBody.create(MediaType.parse(C7532b.m12688a(upload.filePath)), file));
        for (Map.Entry next : upload.formData.entrySet()) {
            try {
                addFormDataPart.addFormDataPart(URLEncoder.encode((String) next.getKey(), "UTF-8"), URLEncoder.encode(next.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return addFormDataPart.build();
    }
}
