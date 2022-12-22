package com.didi.dimina.container.secondparty.http;

import android.util.Log;
import com.didi.dimina.container.service.NetworkService;
import com.didi.sdk.apm.SystemUtils;
import didihttp.DidiHttpClient;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class DidiNetworkServiceManager implements NetworkService {

    /* renamed from: a */
    private static final int f17107a = 180;

    /* renamed from: b */
    private static final int f17108b = 10;

    /* renamed from: c */
    private static final String f17109c = "abort";

    /* renamed from: d */
    private static DidiHttpClient f17110d;

    /* renamed from: e */
    private final C7533c f17111e = new C7533c();

    /* renamed from: f */
    private final C7531a f17112f = new C7531a();

    /* renamed from: g */
    private final C7534d f17113g = new C7534d();

    static {
        try {
            Class<?> cls = Class.forName("com.didichuxing.foundation.net.rpc.http.OkHttpRpcClient");
            Field declaredField = cls.getDeclaredField("CLIENT");
            declaredField.setAccessible(true);
            f17110d = (DidiHttpClient) declaredField.get(cls);
        } catch (Throwable th) {
            SystemUtils.log(3, "networking", "" + Log.getStackTraceString(th), (Throwable) null, "com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager", 39);
        }
    }

    public DidiNetworkServiceManager() {
        if (f17110d == null) {
            DidiHttpClient build = new DidiHttpClient.Builder().readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).connectTimeout(180, TimeUnit.SECONDS).build();
            f17110d = build;
            build.dispatcher().setMaxRequests(10);
        }
    }

    public static DidiHttpClient getHttpClient() {
        return f17110d;
    }

    public static DidiHttpClient getHttpClient(long j) {
        return f17110d.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.MILLISECONDS).writeTimeout(j, TimeUnit.MILLISECONDS).build();
    }

    public void request(NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        this.f17111e.mo55585a(this.f17111e.mo55583a(request, f17110d), request, iTaskCallback);
    }

    public void createRequestTask(String str, NetworkService.NetworkTaskModel.Request request, NetworkService.ITaskCallback iTaskCallback) {
        this.f17111e.mo55586a(str, this.f17111e.mo55584a(str, request, f17110d), request, iTaskCallback);
    }

    public void operateRequestTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f17109c.equals(str2)) {
            boolean a = this.f17111e.mo55587a(str, f17110d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void createDownloadTask(String str, NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        this.f17112f.mo55581a(str, this.f17112f.mo55579a(str, download, f17110d), download, iTaskCallback);
    }

    public void operateDownloadTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f17109c.equals(str2)) {
            boolean a = this.f17112f.mo55582a(str, f17110d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void downloadFile(NetworkService.NetworkTaskModel.Download download, NetworkService.ITaskCallback iTaskCallback) {
        this.f17112f.mo55580a(this.f17112f.mo55578a(download, f17110d), download, iTaskCallback);
    }

    public void createUploadTask(String str, NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        this.f17113g.mo55591a(str, this.f17113g.mo55589a(str, upload, f17110d, iTaskCallback), upload, iTaskCallback);
    }

    public void operateUploadTask(String str, String str2, JSONObject jSONObject, NetworkService.ITaskCallback iTaskCallback) {
        if (iTaskCallback != null && f17109c.equals(str2)) {
            boolean a = this.f17113g.mo55592a(str, f17110d);
            JSONObject jSONObject2 = new JSONObject();
            if (a) {
                try {
                    iTaskCallback.onSuccess(jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                iTaskCallback.onFailure(new Exception("请求池中无对应的taskId 请求"));
            }
        }
    }

    public void uploadFile(NetworkService.NetworkTaskModel.Upload upload, NetworkService.ITaskCallback iTaskCallback) {
        this.f17113g.mo55590a(this.f17113g.mo55588a(upload, f17110d, iTaskCallback), upload, iTaskCallback);
    }
}
