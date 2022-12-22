package com.didichuxing.apollo.sdk;

import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.observer.OnCacheLoadedListener;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import java.util.Map;

/* renamed from: com.didichuxing.apollo.sdk.a */
/* compiled from: IApollo */
interface C15050a {
    void addCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener);

    void addToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener);

    void checkUpdate();

    void enableLooper(boolean z);

    void enableLooper(boolean z, long j);

    void getAsyncToggle(String str, Map<String, String> map, int i, int i2, IAsyncToggleCallback iAsyncToggleCallback);

    String getNamespace();

    IToggle getSyncToggle(String str, Map<String, String> map);

    IToggle getSyncToggle(String str, Map<String, String> map, int i, int i2);

    String getTestKey(String str);

    IToggle getToggle(String str);

    IToggle getToggle(String str, boolean z);

    boolean isStarted();

    void removeCacheLoadedListener(OnCacheLoadedListener onCacheLoadedListener);

    void removeToggleStateChangeListener(OnToggleStateChangeListener onToggleStateChangeListener);

    void resetCoolDownLogger();

    void setAppInfoDelegate(IAppInfoDelegate iAppInfoDelegate);

    void setDataProvider(IDataProvider iDataProvider);

    void setLogDelegate(ILogDelegate iLogDelegate);

    void setNamespace(String str);

    void setRequestHandler(RequestHandler requestHandler);

    void setUserInfoDelegate(IUserInfoDelegate iUserInfoDelegate);

    void shutdown();

    void startup();

    void startup(boolean z, IStartupCallback iStartupCallback);
}
