package com;

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
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionInitConfig;
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

public class FusionEnginex {

    /* renamed from: a */
    private static final String f520a = "FusionEngine";

    /* renamed from: b */
    private static volatile boolean f521b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static volatile boolean f522c = false;

    /* renamed from: d */
    private static volatile boolean f523d = false;

    /* renamed from: e */
    private static final Object f524e = new Object();

    /* renamed from: f */
    private static Application f525f;

    /* renamed from: g */
    private static BusinessAgent f526g;

    /* renamed from: h */
    private static Map<String, Object> f527h;

    public static void init(Context context) {
        if (f525f == null && context != null) {
            f525f = (Application) context.getApplicationContext();
        }
    }

    public static void init(Application application, FusionInitConfig fusionInitConfig) {
        synchronized (f524e) {
            if (!f521b) {
                f525f = application;
                f526g = fusionInitConfig.getBusinessAgent();
                f527h = fusionInitConfig.getExtraAttrsMap();
                if (f526g != null) {
                    FusionCacheClient.init(application);
                    if (!TextUtils.isEmpty(fusionInitConfig.getHybridUrl()) && !TextUtils.isEmpty(fusionInitConfig.getAppKey())) {
                        OfflineBundleManager.init(application, fusionInitConfig);
                    }
                    if (OfflineBundleManager.isInitialized()) {
                        OfflineBundleManager.getInstance().registerEventListener();
                    }
                    m1022a();
                    f521b = true;
                }
            }
        }
    }

    public static void mainActivityCreated(Context context) {
        BusinessAgent businessAgent = f526g;
        if (businessAgent != null) {
            if (businessAgent.needPreInitWebView() && !f522c) {
                m1023a(context);
            }
            if (f526g.isOfflineOpen()) {
                OfflineBundleManager.isInitialized();
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
    private static void m1022a() {
        export("StaticModule", StaticModule.class);
        export("HttpModule", HttpModule.class);
        export("TraceModule", TraceModule.class);
    }

    /* renamed from: a */
    private static void m1023a(final Context context) {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                try {
                    new FusionWebView(context).destroy();
                    boolean unused = FusionEnginex.f522c = true;
                } catch (Exception unused2) {
                    boolean unused3 = FusionEnginex.f522c = false;
                }
                return false;
            }
        });
    }

    public static BusinessAgent getBusinessAgent() {
        if (f526g == null) {
            f526g = new BusinessAgent.DummyBusinessAgent(f525f);
        }
        return f526g;
    }

    public static Application getApplication() {
        return f525f;
    }

    public static Object getAttr(String str) {
        Map<String, Object> map = f527h;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void export(String str, Class cls) {
        WebViewJavascriptBridge.export(str, cls);
    }

    public static boolean isWebViewPreInited() {
        return f522c;
    }

    public static void preloadResource(Context context) {
        List<String> preloadUrlList;
        if (!f523d && (preloadUrlList = getBusinessAgent().getPreloadUrlList()) != null && !preloadUrlList.isEmpty()) {
            f523d = true;
            FusionResourceManager.preloadResources(context, preloadUrlList);
        }
    }

    static class NetworkChangedReceiver extends BroadcastReceiver {
        NetworkChangedReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (NetworkUtil.isNetworkWifi(context)) {
                FusionEnginex.preloadResource(context);
            }
        }
    }

    public static void notifyDownloadBundle(String str) {
        Intent intent = new Intent("fusion_offline_event");
        Bundle bundle = new Bundle();
        bundle.putString("fusion_offline_event_type", "1");
        bundle.putString("1", str);
        intent.putExtras(bundle);
        LocalBroadcastManager.getInstance(f525f).sendBroadcast(intent);
    }
}
