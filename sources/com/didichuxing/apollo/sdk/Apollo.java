package com.didichuxing.apollo.sdk;

import android.content.Context;
import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.net.HttpRequest;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.util.HashMap;
import org.json.JSONObject;

public class Apollo {

    /* renamed from: a */
    private static C15050a f45573a = new ApolloImpl();

    public static synchronized void setContext(Context context) {
        synchronized (Apollo.class) {
            ((ApolloImpl) f45573a).setContext(context);
            WsgSecInfo.init(context);
        }
    }

    public static void init(Context context) {
        setContext(context);
    }

    public static IToggle getToggle(String str) {
        return f45573a.getToggle(str);
    }

    public static IToggle getToggle(String str, boolean z) {
        return f45573a.getToggle(str, z);
    }

    public static String getTestKey(String str) {
        return f45573a.getTestKey(str);
    }

    public static void setLogDelegate(ILogDelegate iLogDelegate) {
        f45573a.setLogDelegate(iLogDelegate);
    }

    public static void setUserInfoDelegate(IUserInfoDelegate iUserInfoDelegate) {
        f45573a.setUserInfoDelegate(iUserInfoDelegate);
    }

    public static void setAppInfoDelegate(IAppInfoDelegate iAppInfoDelegate) {
        f45573a.setAppInfoDelegate(iAppInfoDelegate);
    }

    public static void checkUpdate() {
        f45573a.checkUpdate();
    }

    public static void setDataProvider(IDataProvider iDataProvider) {
        f45573a.setDataProvider(iDataProvider);
    }

    public static void setRequestHandler(RequestHandler requestHandler) {
        f45573a.setRequestHandler(requestHandler);
    }

    public static void setNamespace(String str) {
        f45573a.setNamespace(str);
    }

    public static String getNamespace() {
        return f45573a.getNamespace();
    }

    public static void enableLooper(boolean z) {
        f45573a.enableLooper(z);
    }

    public static void enableLooper(boolean z, long j) {
        f45573a.enableLooper(z, j);
    }

    public static void startup() {
        f45573a.startup();
    }

    public static void startup(boolean z) {
        f45573a.startup(z, (IStartupCallback) null);
    }

    public static void startup(boolean z, IStartupCallback iStartupCallback) {
        f45573a.startup(z, iStartupCallback);
    }

    public static void shutdown() {
        f45573a.shutdown();
    }

    public static boolean isStared() {
        return f45573a.isStarted();
    }

    public static void setDebug(boolean z) {
        LogUtils.DEBUG = z;
    }

    public static void setServerHost(String str) {
        HttpRequest.setHost(str);
    }

    public static String getServerHost() {
        return HttpRequest.getHost();
    }

    public static void setServerPath(String str) {
        HttpRequest.setPath(str);
    }

    public static void enableUpdate(boolean z) {
        HttpRequest.setEnable(z);
    }

    public static JSONObject getJsonToggle(String str) {
        IToggle toggle = f45573a.getToggle(str);
        if (toggle != null) {
            return toggle.toJsonObject();
        }
        return new JSONObject();
    }

    public static void addCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        f45573a.addCacheLoadedListener(onCacheLoadedListener);
    }

    public static void removeCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener) {
        f45573a.removeCacheLoadedListener(onCacheLoadedListener);
    }

    public static void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        f45573a.addToggleStateChangeListener(onToggleStateChangeListener);
    }

    public static void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener) {
        f45573a.removeToggleStateChangeListener(onToggleStateChangeListener);
    }

    public static IToggle getSyncToggle(String str, HashMap<String, String> hashMap) {
        return f45573a.getSyncToggle(str, hashMap);
    }

    public static IToggle getSyncToggle(String str, HashMap<String, String> hashMap, int i, int i2) {
        return f45573a.getSyncToggle(str, hashMap, i, i2);
    }

    public static void getAsyncToggle(String str, HashMap<String, String> hashMap, int i, int i2, IAsyncToggleCallback iAsyncToggleCallback) {
        f45573a.getAsyncToggle(str, hashMap, i, i2, iAsyncToggleCallback);
    }

    public static void resetCoolDownLogger() {
        f45573a.resetCoolDownLogger();
    }
}
