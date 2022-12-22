package com.didi.dimina.container.secondparty.trace.inner.net;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.container.mina.DMSingleTaskExecutor;
import com.didi.dimina.container.secondparty.http.DidiNetworkServiceManager;
import com.didi.dimina.container.secondparty.trace.inner.LogManager;
import com.didi.dimina.container.service.RegionConfigService;
import com.didi.dimina.container.util.LogUtil;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.WebSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0016\u0010 \u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001eJ\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0004H\u0007J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, mo175978d2 = {"Lcom/didi/dimina/container/secondparty/trace/inner/net/LogNetManager;", "", "()V", "HTTP_GET_CONFIG", "", "HTTP_URL", "KEY_DATA", "KEY_PUBS", "MEDIA_TYPE", "Ldidihttp/MediaType;", "kotlin.jvm.PlatformType", "PING_INTERVAL", "", "RECONNECT_COUNT", "", "TAG", "WS_URL", "reconnectCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getReconnectCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setReconnectCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "webSocket", "Ldidihttp/WebSocket;", "getWebSocket", "()Ldidihttp/WebSocket;", "setWebSocket", "(Ldidihttp/WebSocket;)V", "createWebSocket", "", "getConfig", "reconnectWebSocket", "listener", "Lcom/didi/dimina/container/secondparty/trace/inner/net/LogWebSocketListener;", "registerNetChangeListener", "send", "content", "sendByHttp", "bundleContent", "2party-impl_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: LogNetManager.kt */
public final class LogNetManager {
    public static final LogNetManager INSTANCE = new LogNetManager();
    public static final String TAG = "LogNetManager";

    /* renamed from: a */
    private static final String f17473a;

    /* renamed from: b */
    private static final String f17474b;

    /* renamed from: c */
    private static final String f17475c;

    /* renamed from: d */
    private static final MediaType f17476d = MediaType.parse("application/json;charset=utf-8");

    /* renamed from: e */
    private static final long f17477e = 9000;

    /* renamed from: f */
    private static final int f17478f = 3;

    /* renamed from: g */
    private static final String f17479g = "pubs";

    /* renamed from: h */
    private static final String f17480h = "data";

    /* renamed from: i */
    private static WebSocket f17481i;

    /* renamed from: j */
    private static AtomicInteger f17482j = new AtomicInteger(0);

    static {
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig = config.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig, "Dimina.getConfig().adapterConfig");
        RegionConfigService regionConfigService = adapterConfig.getRegionConfigService();
        String str = null;
        f17473a = regionConfigService != null ? regionConfigService.getDiminaMonitorWssHost() : null;
        Dimina.Config config2 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig2 = config2.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig2, "Dimina.getConfig().adapterConfig");
        RegionConfigService regionConfigService2 = adapterConfig2.getRegionConfigService();
        f17474b = regionConfigService2 != null ? regionConfigService2.getDiminaMonitorHttpHost() : null;
        Dimina.Config config3 = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config3, "Dimina.getConfig()");
        Dimina.AdapterConfig adapterConfig3 = config3.getAdapterConfig();
        Intrinsics.checkExpressionValueIsNotNull(adapterConfig3, "Dimina.getConfig().adapterConfig");
        RegionConfigService regionConfigService3 = adapterConfig3.getRegionConfigService();
        if (regionConfigService3 != null) {
            str = regionConfigService3.getDiminaMonitorHttpConfigHost();
        }
        f17475c = str;
    }

    private LogNetManager() {
    }

    public final WebSocket getWebSocket() {
        return f17481i;
    }

    public final void setWebSocket(WebSocket webSocket) {
        f17481i = webSocket;
    }

    public final void createWebSocket() {
        DidiHttpClient.Builder builder = new DidiHttpClient.Builder();
        builder.pingInterval(f17477e, TimeUnit.MILLISECONDS);
        DidiHttpClient build = builder.build();
        Request.Builder url = new Request.Builder().url(f17473a);
        for (Map.Entry entry : LogManager.INSTANCE.wssHeaders().entrySet()) {
            url.addHeader((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        Request build2 = url.build();
        LogUtil.iRelease(TAG, build2.headers().toString());
        f17481i = build.newWebSocket(build2, new LogWebSocketListener());
    }

    public final AtomicInteger getReconnectCount() {
        return f17482j;
    }

    public final void setReconnectCount(AtomicInteger atomicInteger) {
        Intrinsics.checkParameterIsNotNull(atomicInteger, "<set-?>");
        f17482j = atomicInteger;
    }

    public final void reconnectWebSocket(WebSocket webSocket, LogWebSocketListener logWebSocketListener) {
        Intrinsics.checkParameterIsNotNull(webSocket, "webSocket");
        Intrinsics.checkParameterIsNotNull(logWebSocketListener, "listener");
        if (f17482j.get() >= 3) {
            LogUtil.iRelease(LogWebSocketListener.TAG, "reconnect count limited");
            LogManager.INSTANCE.setWebSocketStatus(-1);
            return;
        }
        int incrementAndGet = f17482j.incrementAndGet();
        LogUtil.iRelease(LogWebSocketListener.TAG, "start reconnect " + incrementAndGet);
        DMSingleTaskExecutor.schedule$default(DMSingleTaskExecutor.INSTANCE, new LogNetManager$reconnectWebSocket$1(webSocket, logWebSocketListener), f17477e, (TimeUnit) null, 4, (Object) null);
    }

    public final void registerNetChangeListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION);
        Dimina.Config config = Dimina.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config, "Dimina.getConfig()");
        Application app = config.getApp();
        try {
            app.registerReceiver(new LogNetManager$registerNetChangeListener$1(app), intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    @JvmStatic
    public static final void send(String str) {
        Intrinsics.checkParameterIsNotNull(str, "content");
        LogUtil.iRelease(TAG, "send content is " + str);
        if (LogManager.isWebSocketAvailable()) {
            LogUtil.iRelease(TAG, "星河数据平台 send by websocket");
            WebSocket webSocket = f17481i;
            if (webSocket != null) {
                webSocket.send(str);
                return;
            }
            return;
        }
        LogUtil.iRelease(TAG, "星河数据平台 send by http");
        INSTANCE.m12988a(str);
    }

    /* renamed from: a */
    private final void m12988a(String str) {
        DidiHttpClient httpClient = DidiNetworkServiceManager.getHttpClient();
        if (httpClient != null) {
            Request.Builder url = new Request.Builder().url(f17474b);
            HashMap<String, Object> httpPubBody = LogManager.INSTANCE.httpPubBody();
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(f17479g, jSONObject2);
            Map map = httpPubBody;
            Collection arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(jSONObject2.put((String) entry.getKey(), String.valueOf(entry.getValue())));
            }
            List list = (List) arrayList;
            RequestBody create = RequestBody.create(f17476d, jSONObject.toString());
            LogUtil.m13412i("yaowen", "444444  应该是请求的公共参数: " + jSONObject.toString());
            url.post(create);
            httpClient.newCall(url.build()).enqueue(new LogNetManager$sendByHttp$2());
        }
    }

    public final void getConfig() {
        DidiHttpClient httpClient = DidiNetworkServiceManager.getHttpClient();
        if (httpClient != null) {
            httpClient.newCall(new Request.Builder().url(f17475c).get().build()).enqueue(new LogNetManager$getConfig$1());
        }
    }
}
