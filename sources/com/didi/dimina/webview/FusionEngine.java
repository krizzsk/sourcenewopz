package com.didi.dimina.webview;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.dimina.webview.BusinessAgent;
import com.didi.dimina.webview.container.FusionWebView;
import com.didi.dimina.webview.internalmodules.HttpModule;
import com.didi.dimina.webview.internalmodules.StaticModule;
import com.didi.dimina.webview.internalmodules.TraceModule;
import com.didi.dimina.webview.jsbridge.WebViewJavascriptBridge;
import com.didi.dimina.webview.resource.FusionCacheClient;
import com.didi.dimina.webview.resource.FusionResourceManager;
import com.didi.dimina.webview.resource.offline.OfflineBundleManager;
import com.didi.dimina.webview.util.NetworkUtil;
import java.util.List;
import java.util.Map;

public class FusionEngine {

    /* renamed from: a */
    private static final String f18206a = "FusionEngine";

    /* renamed from: b */
    private static volatile boolean f18207b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile boolean f18208c = false;

    /* renamed from: d */
    private static volatile boolean f18209d = false;

    /* renamed from: e */
    private static final Object f18210e = new Object();

    /* renamed from: f */
    private static Application f18211f;

    /* renamed from: g */
    private static BusinessAgent f18212g;

    /* renamed from: h */
    private static Map<String, Object> f18213h;

    public static void init(Context context) {
        if (f18211f == null && context != null) {
            f18211f = (Application) context.getApplicationContext();
        }
    }

    public static void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (f18210e) {
            if (!f18207b) {
                f18211f = application;
                f18212g = fusionInitConfig.getBusinessAgent();
                f18213h = fusionInitConfig.getExtraAttrsMap();
                if (f18212g != null) {
                    FusionCacheClient.init(application);
                    if (!TextUtils.isEmpty(fusionInitConfig.getHybridUrl()) && !TextUtils.isEmpty(fusionInitConfig.getAppKey())) {
                        OfflineBundleManager.init(application, fusionInitConfig);
                    }
                    if (OfflineBundleManager.isInitialized()) {
                        OfflineBundleManager.getInstance().registerEventListener();
                    }
                    m13571a();
                    f18207b = true;
                }
            }
        }
    }

    public static void mainActivityCreated(Context context) {
        BusinessAgent businessAgent = f18212g;
        if (businessAgent != null) {
            if (businessAgent.needPreInitWebView() && !f18208c) {
                m13572a(context);
            }
            if (f18212g.isOfflineOpen() && OfflineBundleManager.isInitialized()) {
                OfflineBundleManager.getInstance().startUpdate();
            }
            if (NetworkUtil.isNetworkWifi(context)) {
                preloadResource(context);
                return;
            }
            try {
                getApplication().registerReceiver(new NetworkChangedReceiver(), new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    /* renamed from: a */
    private static void m13571a() {
        export("StaticModule", StaticModule.class);
        export("HttpModule", HttpModule.class);
        export("TraceModule", TraceModule.class);
    }

    /* renamed from: a */
    private static void m13572a(final Context context) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                try {
                    new FusionWebView(context).destroy();
                    boolean unused = FusionEngine.f18208c = true;
                } catch (Exception unused2) {
                    boolean unused3 = FusionEngine.f18208c = false;
                }
                return false;
            }
        });
    }

    public static BusinessAgent getBusinessAgent() {
        if (f18212g == null) {
            f18212g = new BusinessAgent.DummyBusinessAgent(f18211f);
        }
        return f18212g;
    }

    public static Application getApplication() {
        return f18211f;
    }

    public static Object getAttr(String str) {
        Map<String, Object> map = f18213h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void export(String str, Class cls) {
        WebViewJavascriptBridge.export(str, cls);
    }

    public static boolean isWebViewPreInited() {
        return f18208c;
    }

    public static void preloadResource(Context context) {
        List<String> preloadUrlList;
        if (!f18209d && (preloadUrlList = getBusinessAgent().getPreloadUrlList()) != null && !preloadUrlList.isEmpty()) {
            f18209d = true;
            FusionResourceManager.preloadResources(context, preloadUrlList);
        }
    }

    static class NetworkChangedReceiver extends BroadcastReceiver {
        NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context)) {
                FusionEngine.preloadResource(context);
            }
        }
    }

    public static void notifyDownloadBundle(String str) {
        Intent intent = new Intent("fusion_offline_event");
        Bundle bundle = new Bundle();
        bundle.putString("fusion_offline_event_type", "1");
        bundle.putString("1", str);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(f18211f).sendBroadcast(intent);
    }
}
