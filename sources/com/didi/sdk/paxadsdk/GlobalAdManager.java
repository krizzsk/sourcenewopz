package com.didi.sdk.paxadsdk;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.paxadsdk.admob.AdmobLoader;
import java.util.HashMap;
import java.util.Map;

public class GlobalAdManager {

    /* renamed from: a */
    private Map<String, AdAgency> f36880a;

    /* renamed from: b */
    private boolean f36881b;

    private GlobalAdManager() {
        this.f36880a = new HashMap();
        this.f36881b = false;
    }

    public static GlobalAdManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final GlobalAdManager sInstance = new GlobalAdManager();

        private SingletonHolder() {
        }
    }

    public void initial(Context context) {
        if (!this.f36881b) {
            this.f36880a.clear();
            AdmobLoader admobLoader = new AdmobLoader();
            this.f36880a.put(admobLoader.getName(), admobLoader);
            m26116a(context);
            this.f36881b = true;
        }
    }

    /* renamed from: a */
    private void m26116a(Context context) {
        for (Map.Entry<String, AdAgency> value : this.f36880a.entrySet()) {
            ((AdAgency) value.getValue()).init(context);
        }
    }

    public void loadNativeAD(Context context, String str, NativeAdStyle nativeAdStyle, String str2, AdLoadListenner adLoadListenner) {
        initial(context);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            SystemUtils.log(3, "admob", "empty agency or adid ", (Throwable) null, "com.didi.sdk.paxadsdk.GlobalAdManager", 48);
            return;
        }
        AdAgency a = m26115a(str);
        if (a != null) {
            a.loadNativeAD(context, nativeAdStyle, str2, adLoadListenner);
        }
    }

    /* renamed from: a */
    private AdAgency m26115a(String str) {
        String trim = str.trim();
        for (Map.Entry next : this.f36880a.entrySet()) {
            if (((String) next.getKey()).equalsIgnoreCase(trim)) {
                return (AdAgency) next.getValue();
            }
        }
        return null;
    }

    public void releaseAll() {
        for (Map.Entry<String, AdAgency> value : this.f36880a.entrySet()) {
            ((AdAgency) value.getValue()).releaseAll();
        }
    }

    public void release(String str, NativeAdStyle nativeAdStyle, String str2) {
        if (TextUtils.isEmpty(str) || nativeAdStyle == null || str2 == null || TextUtils.isEmpty(str2)) {
            SystemUtils.log(3, "admob", "release empty argus ", (Throwable) null, "com.didi.sdk.paxadsdk.GlobalAdManager", 77);
            return;
        }
        AdAgency a = m26115a(str);
        if (a != null) {
            a.release(nativeAdStyle, str2);
        }
    }
}
