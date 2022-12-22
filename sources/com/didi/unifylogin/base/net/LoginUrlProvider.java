package com.didi.unifylogin.base.net;

import com.didi.unifylogin.base.api.BaseListenerContainer;

public class LoginUrlProvider {

    /* renamed from: a */
    private static boolean f44694a = false;

    /* renamed from: b */
    private static boolean f44695b = false;

    /* renamed from: c */
    private static boolean f44696c = false;

    /* renamed from: d */
    private static String f44697d = "";

    /* synthetic */ LoginUrlProvider(C145291 r1) {
        this();
    }

    private LoginUrlProvider() {
    }

    private static class LoginUrlProviderHolder {
        /* access modifiers changed from: private */
        public static final LoginUrlProvider singleton = new LoginUrlProvider((C145291) null);

        private LoginUrlProviderHolder() {
        }
    }

    public static LoginUrlProvider getInstance() {
        return LoginUrlProviderHolder.singleton;
    }

    public String getPassportBaseUrl() {
        if (f44696c) {
            return f44697d;
        }
        int i = C145291.$SwitchMap$com$didi$unifylogin$base$net$LoginEnvironment[m31731a().ordinal()];
        if (i == 1) {
            return f44695b ? "https://epassport-ru.didiglobal.com" : "https://epassport.didiglobal.com";
        }
        if (i != 2) {
            return f44695b ? "https://epassport-ru.didiglobal.com" : "https://epassport.didiglobal.com";
        }
        if (f44695b) {
            return "https://epassport-ru.didiglobal.com";
        }
        return "https://prepassport.didiglobal.com";
    }

    /* renamed from: com.didi.unifylogin.base.net.LoginUrlProvider$1 */
    static /* synthetic */ class C145291 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginEnvironment;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.unifylogin.base.net.LoginEnvironment[] r0 = com.didi.unifylogin.base.net.LoginEnvironment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$base$net$LoginEnvironment = r0
                com.didi.unifylogin.base.net.LoginEnvironment r1 = com.didi.unifylogin.base.net.LoginEnvironment.DEBUG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginEnvironment     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.base.net.LoginEnvironment r1 = com.didi.unifylogin.base.net.LoginEnvironment.PRE_RELEASE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.base.net.LoginUrlProvider.C145291.<clinit>():void");
        }
    }

    /* renamed from: a */
    private LoginEnvironment m31731a() {
        LoginNetModeListener netModeListener = BaseListenerContainer.getNetModeListener();
        if (netModeListener != null) {
            return netModeListener.getDevMode();
        }
        return LoginEnvironment.RELEASE;
    }

    public static void setIsGlobal(boolean z) {
        f44694a = z;
    }

    public static void setIsRussia(boolean z) {
        f44695b = z;
    }

    public static void setUseCustomBaseUrl(boolean z) {
        f44696c = z;
    }

    public static void setCustomBaseUrl(String str) {
        f44697d = str;
    }
}
