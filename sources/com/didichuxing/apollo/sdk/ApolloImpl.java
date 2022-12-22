package com.didichuxing.apollo.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.dataprovider.DataProvider;
import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ApolloErrorLog;
import com.didichuxing.apollo.sdk.log.ApolloLog;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.log.LogCoolDownWrapper;
import com.didichuxing.apollo.sdk.log.LogDelegateWrapper;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.log.impl.ILogDelegateImpl;
import com.didichuxing.apollo.sdk.model.ResponseObj;
import com.didichuxing.apollo.sdk.model.ToggleData;
import com.didichuxing.apollo.sdk.net.HttpRequest;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.apollo.sdk.utils.HotPatchUtil;
import com.didichuxing.apollo.sdk.utils.Utils;
import com.didichuxing.request.ServerParam;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ApolloImpl implements C15050a {

    /* renamed from: a */
    private final CopyOnWriteArrayList<OnToggleStateChangeListener> f45574a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private final CopyOnWriteArrayList<OnCacheLoadedListener> f45575b = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public volatile Map<String, IToggle> f45576c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile String f45577d;

    /* renamed from: e */
    private ILogDelegate f45578e;

    /* renamed from: f */
    private ILogDelegate f45579f;

    /* renamed from: g */
    private IUserInfoDelegate f45580g;

    /* renamed from: h */
    private IAppInfoDelegate f45581h;

    /* renamed from: i */
    private IDataProvider f45582i;

    /* renamed from: j */
    private RequestHandler f45583j;

    /* renamed from: k */
    private String f45584k;

    /* renamed from: l */
    private boolean f45585l = true;

    /* renamed from: m */
    private long f45586m = 0;

    /* renamed from: n */
    private final Integer f45587n = 1;

    /* renamed from: o */
    private Context f45588o;

    /* renamed from: p */
    private boolean f45589p = false;

    public ApolloImpl() {
    }

    public ApolloImpl(Context context) {
        this.f45588o = context;
    }

    public void setContext(Context context) {
        this.f45588o = context;
    }

    public IToggle getToggle(String str) {
        ILogDelegate iLogDelegate;
        IAppInfoDelegate iAppInfoDelegate;
        StringBuilder sb = new StringBuilder();
        sb.append("getToggle ");
        sb.append(str == null ? "null" : str);
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, sb.toString());
        if (this.f45576c == null) {
            new DataProvider(this.f45588o, this.f45584k, this.f45580g, this.f45581h, this.f45583j).getData(new IDataProvider.IGetCallback<ToggleData>() {
                public void onFail() {
                }

                public void onGetData(ToggleData toggleData) {
                    Map unused = ApolloImpl.this.f45576c = toggleData.toggleMap;
                    String unused2 = ApolloImpl.this.f45577d = toggleData.key;
                    ApolloImpl.this.m32675a(toggleData);
                    ApolloImpl.this.m32672a();
                }
            });
        }
        if (this.f45576c == null) {
            return new EmptyToggle();
        }
        IToggle iToggle = this.f45576c.get(str);
        if (iToggle == null) {
            return new EmptyToggle();
        }
        if (iToggle.allow() && this.f45587n.equals(iToggle.getCachePlan()) && (iAppInfoDelegate = this.f45581h) != null) {
            String fullVersion = iAppInfoDelegate.getFullVersion();
            String fullAppVersionWhenCached = this.f45582i.getFullAppVersionWhenCached();
            if (fullVersion == null || fullAppVersionWhenCached == null || !fullVersion.equals(fullAppVersionWhenCached)) {
                if (fullVersion == null || fullVersion.equals("")) {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "full version is null or empty");
                }
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "cache plan 1, version not equal return empty toggle");
                return new EmptyToggle();
            }
        }
        if (iToggle.allow() && (iLogDelegate = this.f45578e) != null) {
            iLogDelegate.saveLog(new ApolloLog(iToggle, this.f45577d));
        }
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "getToggle end " + iToggle.toString());
        return iToggle;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32675a(ToggleData toggleData) {
        IToggle iToggle = this.f45576c.get("apollo_sdk_log_level");
        if (iToggle != null && iToggle.allow()) {
            Apollo.setDebug(true);
            LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "IGetCallback onGetData: " + toggleData);
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f45588o, "apollo_sdk_settings", 0).edit();
        IToggle iToggle2 = this.f45576c.get("apollo_sdk_explore");
        if (iToggle2 == null || !iToggle2.allow()) {
            edit.putBoolean("scan", false);
        } else {
            IExperiment experiment = iToggle2.getExperiment();
            edit.putBoolean("scan", true);
            edit.putInt("scan_mode", ((Integer) experiment.getParam(ParamKeys.PARAM_MODE, 0)).intValue());
            edit.putInt("scan_debug", ((Integer) experiment.getParam("debug", 0)).intValue());
            edit.putString("scan_time", (String) experiment.getParam("time", ""));
        }
        edit.apply();
    }

    public IToggle getToggle(String str, boolean z) {
        IToggle toggle = getToggle(str);
        if (toggle != null && (toggle instanceof EmptyToggle)) {
            ((EmptyToggle) toggle).setDefaultAllow(z);
        }
        return toggle;
    }

    public String getTestKey(String str) {
        IExperiment experiment;
        IToggle iToggle = this.f45576c != null ? this.f45576c.get(str) : null;
        return (iToggle == null || (experiment = iToggle.getExperiment()) == null) ? "" : experiment.getTestKey();
    }

    public void setLogDelegate(ILogDelegate iLogDelegate) {
        this.f45579f = iLogDelegate;
        if (getToggle("apollo_cool_down_log").allow()) {
            this.f45578e = new LogCoolDownWrapper(iLogDelegate);
        } else {
            this.f45578e = new LogDelegateWrapper(iLogDelegate);
        }
        LogUtils.attachLogDelegate(iLogDelegate);
    }

    public void setUserInfoDelegate(IUserInfoDelegate iUserInfoDelegate) {
        this.f45580g = iUserInfoDelegate;
    }

    public void setAppInfoDelegate(IAppInfoDelegate iAppInfoDelegate) {
        this.f45581h = iAppInfoDelegate;
    }

    public void setDataProvider(IDataProvider iDataProvider) {
        this.f45582i = iDataProvider;
    }

    public void checkUpdate() {
        if (this.f45582i != null && HotPatchUtil.enable()) {
            this.f45582i.update(new IDataProvider.IUpdateCallback<ToggleData>() {
                public void onFail() {
                }

                public void onNoChange() {
                }

                public void onUpdate(ToggleData toggleData) {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "server data:" + toggleData.toggleMap.toString());
                    Map unused = ApolloImpl.this.f45576c = toggleData.toggleMap;
                    String unused2 = ApolloImpl.this.f45577d = toggleData.key;
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "mDataProvider.update");
                    ApolloImpl.this.m32676b();
                }
            });
        }
    }

    public void setRequestHandler(RequestHandler requestHandler) {
        this.f45583j = requestHandler;
        IDataProvider iDataProvider = this.f45582i;
        if (iDataProvider != null) {
            iDataProvider.setmRequestHandler(requestHandler);
        }
    }

    public void setNamespace(String str) {
        this.f45584k = str;
    }

    public String getNamespace() {
        return this.f45584k;
    }

    public void enableLooper(boolean z) {
        this.f45585l = z;
    }

    public void enableLooper(boolean z, long j) {
        this.f45585l = z;
        this.f45586m = j;
    }

    public void startup() {
        startup(false, (IStartupCallback) null);
    }

    public void startup(boolean z, final IStartupCallback iStartupCallback) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "startup");
        if (this.f45582i == null) {
            DataProvider dataProvider = new DataProvider(this.f45588o, this.f45584k, this.f45580g, this.f45581h, this.f45583j);
            dataProvider.setLogDelegate(this.f45578e);
            DataProvider.UpdatePolicy updatePolicy = new DataProvider.UpdatePolicy();
            updatePolicy.minUpdateInterval = 0;
            dataProvider.setUpdatePolicy(updatePolicy);
            this.f45582i = dataProvider;
        }
        if (this.f45576c == null) {
            this.f45582i.getData(new IDataProvider.IGetCallback<ToggleData>() {
                public void onGetData(ToggleData toggleData) {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "IGetCallback onGetData: " + toggleData);
                    Map unused = ApolloImpl.this.f45576c = toggleData.toggleMap;
                    String unused2 = ApolloImpl.this.f45577d = toggleData.key;
                    ApolloImpl.this.m32672a();
                    IStartupCallback iStartupCallback = iStartupCallback;
                    if (iStartupCallback != null) {
                        iStartupCallback.onCacheLoadFinish();
                    }
                }

                public void onFail() {
                    LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "IGetCallback onFail");
                    IStartupCallback iStartupCallback = iStartupCallback;
                    if (iStartupCallback != null) {
                        iStartupCallback.onCacheLoadFinish();
                    }
                }
            });
        }
        if (z) {
            checkUpdate();
        }
        if (this.f45585l && HotPatchUtil.enable()) {
            ApolloLooper instance = ApolloLooper.getInstance(this);
            long j = this.f45586m;
            if (j > 0) {
                instance.setInterval(j);
            }
            instance.startup();
        }
        this.f45589p = true;
    }

    public void shutdown() {
        ApolloLooper.getInstance(this).shutdown();
        this.f45589p = false;
    }

    public boolean isStarted() {
        return this.f45589p;
    }

    public void resetCoolDownLogger() {
        ILogDelegate iLogDelegate = this.f45578e;
        if (iLogDelegate != null && (iLogDelegate instanceof LogCoolDownWrapper)) {
            ((LogCoolDownWrapper) iLogDelegate).reset();
        }
    }

    public void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "addToggleStateChangeListener");
        this.f45574a.add(onToggleStateChangeListener);
        LogUtils.m32691d("apollo ", "listeners.size : " + this.f45574a.size());
    }

    public void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "removeToggleStateChangeListener");
        this.f45574a.remove(onToggleStateChangeListener);
        LogUtils.m32691d("apollo ", "listeners.size : " + this.f45574a.size());
    }

    public synchronized void addCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        if (this.f45576c == null) {
            this.f45575b.add(onCacheLoadedListener);
            return;
        }
        try {
            onCacheLoadedListener.onCacheAlreadyLoaded();
        } catch (Exception unused) {
        }
    }

    public void removeCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        this.f45575b.remove(onCacheLoadedListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32672a() {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "notifyCacheLoaded");
        Iterator<OnCacheLoadedListener> it = this.f45575b.iterator();
        while (it.hasNext()) {
            try {
                it.next().onCacheAlreadyLoaded();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32676b() {
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "notifyToggleStateChange");
        Iterator<OnToggleStateChangeListener> it = this.f45574a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStateChanged();
            } catch (Exception unused) {
            }
        }
    }

    public CopyOnWriteArrayList<OnToggleStateChangeListener> getOnToggleStateChangeListeners() {
        return this.f45574a;
    }

    public RequestHandler getmRequestHandler() {
        return this.f45583j;
    }

    public IToggle getSyncToggle(String str, Map<String, String> map) {
        return getSyncToggle(str, map, 2000, 2000);
    }

    public IToggle getSyncToggle(String str, Map<String, String> map, int i, int i2) {
        ILogDelegate iLogDelegate;
        Map<String, IToggle> toggleMap;
        LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "getSyncToggle featureName: " + String.valueOf(str));
        if (str != null && !str.isEmpty()) {
            if (map == null || map.isEmpty()) {
                map = new HashMap<>();
            }
            map.put("name", str);
            map.put("os_type", Utils.getOsType());
            map.put(ServerParam.PARAM_OS_VERSION, Utils.getOsVersion());
            map.put("key", Utils.generateKey());
            if (getToggle("apollo_cool_down_log").allow()) {
                iLogDelegate = new LogCoolDownWrapper(new ILogDelegateImpl());
            } else {
                iLogDelegate = new LogDelegateWrapper(new ILogDelegateImpl());
            }
            try {
                String singleToggle = HttpRequest.getSingleToggle(map, i, i2);
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, "HttpRequest.getSingleToggle return:" + singleToggle);
                ResponseObj responseObj = (ResponseObj) new Gson().fromJson(singleToggle, ResponseObj.class);
                if (responseObj.code == 0 && (toggleMap = responseObj.getToggleMap()) != null) {
                    IToggle iToggle = toggleMap.get(str);
                    if (iToggle != null && iToggle.allow()) {
                        iLogDelegate.saveLog(new ApolloLog(iToggle, Utils.generateKey()));
                    }
                    return iToggle;
                }
            } catch (Exception e) {
                LogUtils.m32691d(GlobalCashierCoreModule.APOLLO, e.getMessage());
                iLogDelegate.saveErrorLog(new ApolloErrorLog(e.getMessage()));
            }
        }
        return new EmptyToggle();
    }

    public void getAsyncToggle(String str, Map<String, String> map, int i, int i2, IAsyncToggleCallback iAsyncToggleCallback) {
        if (map == null || map.isEmpty()) {
            map = new HashMap<>();
        }
        final Map<String, String> map2 = map;
        map2.put("name", str);
        map2.put("os_type", Utils.getOsType());
        map2.put(ServerParam.PARAM_OS_VERSION, Utils.getOsVersion());
        map2.put("key", Utils.generateKey());
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        final IAsyncToggleCallback iAsyncToggleCallback2 = iAsyncToggleCallback;
        new Thread(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a5, code lost:
                r0 = e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c6, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c7, code lost:
                com.didichuxing.apollo.sdk.log.LogUtils.m32691d(com.didi.global.fintech.cashier.core.GlobalCashierCoreModule.APOLLO, java.lang.String.valueOf(r0.getMessage()));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00db, code lost:
                throw new com.didichuxing.apollo.sdk.ApolloException(r0.getMessage());
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00c6 A[ExcHandler: ApolloException (r0v5 'e' com.didichuxing.apollo.sdk.ApolloException A[CUSTOM_DECLARE]), Splitter:B:8:0x004f] */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x00e5  */
            /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "getSyncToggle featureName: "
                    r0.append(r1)
                    java.lang.String r1 = r2
                    java.lang.String r1 = java.lang.String.valueOf(r1)
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "apollo"
                    com.didichuxing.apollo.sdk.log.LogUtils.m32691d(r1, r0)
                    com.didichuxing.apollo.sdk.EmptyToggle r0 = new com.didichuxing.apollo.sdk.EmptyToggle
                    r0.<init>()
                    java.lang.String r2 = r2
                    r3 = 0
                    if (r2 == 0) goto L_0x00dc
                    boolean r2 = r2.isEmpty()
                    if (r2 != 0) goto L_0x00dc
                    com.didichuxing.apollo.sdk.ApolloImpl r2 = com.didichuxing.apollo.sdk.ApolloImpl.this
                    java.lang.String r4 = "apollo_cool_down_log"
                    com.didichuxing.apollo.sdk.IToggle r2 = r2.getToggle(r4)
                    boolean r2 = r2.allow()
                    if (r2 == 0) goto L_0x0045
                    com.didichuxing.apollo.sdk.log.LogCoolDownWrapper r2 = new com.didichuxing.apollo.sdk.log.LogCoolDownWrapper
                    com.didichuxing.apollo.sdk.log.impl.ILogDelegateImpl r4 = new com.didichuxing.apollo.sdk.log.impl.ILogDelegateImpl
                    r4.<init>()
                    r2.<init>(r4)
                    goto L_0x004f
                L_0x0045:
                    com.didichuxing.apollo.sdk.log.LogDelegateWrapper r2 = new com.didichuxing.apollo.sdk.log.LogDelegateWrapper
                    com.didichuxing.apollo.sdk.log.impl.ILogDelegateImpl r4 = new com.didichuxing.apollo.sdk.log.impl.ILogDelegateImpl
                    r4.<init>()
                    r2.<init>(r4)
                L_0x004f:
                    java.util.Map r4 = r3     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    int r5 = r4     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    int r6 = r5     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.String r4 = com.didichuxing.apollo.sdk.net.HttpRequest.getSingleToggle(r4, r5, r6)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    r5.<init>()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.String r6 = "HttpRequest.getSingleToggle return:"
                    r5.append(r6)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    r5.append(r6)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.String r5 = r5.toString()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    com.didichuxing.apollo.sdk.log.LogUtils.m32691d(r1, r5)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    com.google.gson.Gson r5 = new com.google.gson.Gson     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    r5.<init>()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.Class<com.didichuxing.apollo.sdk.model.ResponseObj> r6 = com.didichuxing.apollo.sdk.model.ResponseObj.class
                    java.lang.Object r4 = r5.fromJson((java.lang.String) r4, r6)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    com.didichuxing.apollo.sdk.model.ResponseObj r4 = (com.didichuxing.apollo.sdk.model.ResponseObj) r4     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    int r5 = r4.code     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    if (r5 != 0) goto L_0x00dc
                    java.util.Map r4 = r4.getToggleMap()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    if (r4 == 0) goto L_0x00dc
                    java.lang.String r5 = r2     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    java.lang.Object r4 = r4.get(r5)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    com.didichuxing.apollo.sdk.IToggle r4 = (com.didichuxing.apollo.sdk.IToggle) r4     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a7 }
                    if (r4 == 0) goto L_0x00c4
                    boolean r0 = r4.allow()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a5 }
                    if (r0 == 0) goto L_0x00c4
                    com.didichuxing.apollo.sdk.log.ApolloLog r0 = new com.didichuxing.apollo.sdk.log.ApolloLog     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a5 }
                    java.lang.String r5 = com.didichuxing.apollo.sdk.utils.Utils.generateKey()     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a5 }
                    r0.<init>((com.didichuxing.apollo.sdk.IToggle) r4, (java.lang.String) r5)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a5 }
                    r2.saveLog(r0)     // Catch:{ ApolloException -> 0x00c6, Exception -> 0x00a5 }
                    goto L_0x00c4
                L_0x00a5:
                    r0 = move-exception
                    goto L_0x00aa
                L_0x00a7:
                    r3 = move-exception
                    r4 = r0
                    r0 = r3
                L_0x00aa:
                    boolean r3 = r0 instanceof java.net.SocketTimeoutException
                    java.lang.String r5 = r0.getMessage()
                    java.lang.String r5 = java.lang.String.valueOf(r5)
                    com.didichuxing.apollo.sdk.log.LogUtils.m32691d(r1, r5)
                    com.didichuxing.apollo.sdk.log.ApolloErrorLog r1 = new com.didichuxing.apollo.sdk.log.ApolloErrorLog
                    java.lang.String r0 = r0.getMessage()
                    r1.<init>(r0)
                    r2.saveErrorLog(r1)
                L_0x00c4:
                    r0 = r4
                    goto L_0x00dc
                L_0x00c6:
                    r0 = move-exception
                    java.lang.String r2 = r0.getMessage()
                    java.lang.String r2 = java.lang.String.valueOf(r2)
                    com.didichuxing.apollo.sdk.log.LogUtils.m32691d(r1, r2)
                    com.didichuxing.apollo.sdk.ApolloException r1 = new com.didichuxing.apollo.sdk.ApolloException
                    java.lang.String r0 = r0.getMessage()
                    r1.<init>(r0)
                    throw r1
                L_0x00dc:
                    com.didichuxing.apollo.sdk.ToggleResult r1 = new com.didichuxing.apollo.sdk.ToggleResult
                    r1.<init>(r3, r0)
                    com.didichuxing.apollo.sdk.IAsyncToggleCallback r0 = r6
                    if (r0 == 0) goto L_0x00e8
                    r0.onSuccess(r1)
                L_0x00e8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.apollo.sdk.ApolloImpl.C150474.run():void");
            }
        }).start();
    }
}
