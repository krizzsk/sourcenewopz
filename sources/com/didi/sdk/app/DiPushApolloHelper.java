package com.didi.sdk.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;

public class DiPushApolloHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f35161a = DiPushApolloHelper.class.getName();

    /* renamed from: b */
    private static final String f35162b = "brazil_push_verify_phone";

    /* renamed from: c */
    private static final boolean f35163c = true;

    /* renamed from: d */
    private static final String f35164d = "dipush_kick_by_phone";

    /* renamed from: e */
    private static final String f35165e = "isDipushOpen";

    /* renamed from: f */
    private static Boolean f35166f;

    public static boolean isNewPhoneFormatOpen(Context context) {
        Boolean bool = f35166f;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m24847b(context).getBoolean(f35165e, true));
        f35166f = valueOf;
        return valueOf.booleanValue();
    }

    public static void addToggleStateChangeListener(Context context) {
        Apollo.addToggleStateChangeListener(new PushOnToggleStateChangeListener(context));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static SharedPreferences m24847b(Context context) {
        return SystemUtils.getSharedPreferences(context, f35164d, 0);
    }

    private static class PushOnToggleStateChangeListener implements OnToggleStateChangeListener {
        private final Context mContext;

        public PushOnToggleStateChangeListener(Context context) {
            this.mContext = context;
        }

        public void onStateChanged() {
            boolean allow = Apollo.getToggle(DiPushApolloHelper.f35162b, true).allow();
            String a = DiPushApolloHelper.f35161a;
            SystemUtils.log(3, a, "apollo HotPatch:" + allow, (Throwable) null, "com.didi.sdk.app.DiPushApolloHelper$PushOnToggleStateChangeListener", 73);
            DiPushApolloHelper.m24847b(this.mContext).edit().putBoolean(DiPushApolloHelper.f35165e, allow).commit();
        }
    }
}
