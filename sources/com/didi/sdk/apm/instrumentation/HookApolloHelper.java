package com.didi.sdk.apm.instrumentation;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

class HookApolloHelper {

    /* renamed from: a */
    private static final String f35036a = "HookApolloHelper";

    /* renamed from: b */
    private static final String f35037b = "global_passenger_activity_mgr_hook";

    /* renamed from: c */
    private static final boolean f35038c = false;

    /* renamed from: d */
    private static final String f35039d = "apm_hook_apollo_helper";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Boolean f35040e;

    HookApolloHelper() {
    }

    /* renamed from: a */
    public static boolean m24761a(Context context) {
        Boolean bool = f35040e;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m24764d(context).getBoolean("isOpen", false));
        f35040e = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: b */
    public static void m24762b(Context context) {
        Apollo.addToggleStateChangeListener(new ANROnToggleStateChangeListener(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static SharedPreferences m24764d(Context context) {
        return context.getSharedPreferences(f35039d, 0);
    }

    private static class ANROnToggleStateChangeListener implements OnToggleStateChangeListener {
        private final Context mContext;

        public ANROnToggleStateChangeListener(Context context) {
            this.mContext = context;
        }

        public void onStateChanged() {
            boolean isOpen = RemoteConfiguration.isOpen(HookApolloHelper.f35037b, false);
            if (HookApolloHelper.f35040e == null || HookApolloHelper.f35040e.booleanValue() != isOpen) {
                Log.d(HookApolloHelper.f35036a, "apollo apm hook:" + isOpen);
                HookApolloHelper.m24764d(this.mContext).edit().putBoolean("isOpen", isOpen).commit();
            }
        }
    }
}
