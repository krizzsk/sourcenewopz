package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* renamed from: com.appsflyer.internal.ag */
public final class C1678ag {

    /* renamed from: ı */
    private C1680a f1897 = new C1680a() {
        /* renamed from: ǃ */
        public final Class<?> mo16115(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    /* renamed from: com.appsflyer.internal.ag$a */
    interface C1680a {
        /* renamed from: ǃ */
        Class<?> mo16115(String str) throws ClassNotFoundException;
    }

    /* renamed from: ı */
    public final String mo16114() {
        for (C1681c cVar : C1681c.values()) {
            if (m1622(cVar.f1907)) {
                return cVar.f1908;
            }
        }
        return C1681c.DEFAULT.f1908;
    }

    /* renamed from: ι */
    private boolean m1622(String str) {
        try {
            this.f1897.mo16115(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    /* renamed from: com.appsflyer.internal.ag$c */
    enum C1681c {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT("android_native", "android_native"),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin");
        
        /* access modifiers changed from: private */

        /* renamed from: і */
        public String f1907;
        /* access modifiers changed from: private */

        /* renamed from: Ӏ */
        public String f1908;

        private C1681c(String str, String str2) {
            this.f1908 = str;
            this.f1907 = str2;
        }
    }
}
