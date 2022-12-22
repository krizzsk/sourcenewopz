package com.didi.onehybrid;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.internalmodules.HttpModule;
import com.didi.onehybrid.internalmodules.StaticModule;
import com.didi.onehybrid.internalmodules.TraceModule;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.resource.FusionCacheClient;
import com.didi.onehybrid.resource.FusionResourceManager;
import com.didi.onehybrid.resource.offline.OfflineBundleManager;
import com.didi.onehybrid.util.NetworkUtil;
import java.util.List;
import java.util.Map;

public class FusionEngine {

    /* renamed from: a */
    private static final String f29492a = "FusionEngine";

    /* renamed from: b */
    private static volatile boolean f29493b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile boolean f29494c = false;

    /* renamed from: d */
    private static volatile boolean f29495d = false;

    /* renamed from: e */
    private static final Object f29496e = new Object();

    /* renamed from: f */
    private static Application f29497f;

    /* renamed from: g */
    private static BusinessAgent f29498g;

    /* renamed from: h */
    private static Map<String, Object> f29499h;

    public static void init(Context context) {
        if (f29497f == null && context != null) {
            f29497f = (Application) context.getApplicationContext();
        }
    }

    public static void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (f29496e) {
            if (!f29493b) {
                f29497f = application;
                f29498g = fusionInitConfig.getBusinessAgent();
                f29499h = fusionInitConfig.getExtraAttrsMap();
                if (f29498g != null) {
                    FusionCacheClient.init(application);
                    OfflineBundleManager.init(application, fusionInitConfig);
                    if (OfflineBundleManager.isInitialized()) {
                        OfflineBundleManager.getInstance().registerEventListener();
                    }
                    m20775a();
                    f29493b = true;
                }
            }
        }
    }

    public static void preloadWebView(Context context) {
        BusinessAgent businessAgent = f29498g;
        if (businessAgent != null && businessAgent.needPreInitWebView() && !f29494c) {
            m20776a(context);
        }
    }

    public static void startUp() {
        BusinessAgent businessAgent = f29498g;
        if (businessAgent != null && businessAgent.isOfflineOpen() && OfflineBundleManager.getInstance() != null) {
            OfflineBundleManager.getInstance().getBundleInfo();
        }
    }

    /* renamed from: a */
    private static void m20775a() {
        export("StaticModule", StaticModule.class);
        export("HttpModule", HttpModule.class);
        export("TraceModule", TraceModule.class);
    }

    /* renamed from: a */
    private static void m20776a(final Context context) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                try {
                    new FusionWebView(context).destroy();
                    boolean unused = FusionEngine.f29494c = true;
                } catch (Exception unused2) {
                    boolean unused3 = FusionEngine.f29494c = false;
                }
                return false;
            }
        });
    }

    public static BusinessAgent getBusinessAgent() {
        if (f29498g == null) {
            f29498g = new BusinessAgent.DummyBusinessAgent(f29497f);
        }
        return f29498g;
    }

    public static Application getApplication() {
        return f29497f;
    }

    public static Object getAttr(String str) {
        Map<String, Object> map = f29499h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void export(String str, Class cls) {
        WebViewJavascriptBridge.export(str, cls);
    }

    public static boolean isWebViewPreInited() {
        return f29494c;
    }

    public static void preloadResource(Context context) {
        List<String> preloadUrlList;
        if (!f29495d && (preloadUrlList = getBusinessAgent().getPreloadUrlList()) != null && !preloadUrlList.isEmpty()) {
            f29495d = true;
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
        LocalBroadcastManager.getInstance(f29497f).sendBroadcast(intent);
    }
}
