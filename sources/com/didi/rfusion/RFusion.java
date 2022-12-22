package com.didi.rfusion;

import android.app.Application;
import android.content.Context;
import com.didi.rfusion.config.RFFontDelegate;
import com.didi.rfusion.config.RFusionConfig;
import com.didi.rfusion.utils.RFActivityManager;
import java.util.Locale;

public class RFusion {

    /* renamed from: a */
    private static Application f33186a;

    /* renamed from: b */
    private static RFusionConfig.IRFusionLogger f33187b;

    /* renamed from: c */
    private static RFusionConfig.IRFusionTracker f33188c;

    /* renamed from: d */
    private static Locale f33189d;

    /* renamed from: e */
    private static RFFontDelegate f33190e;

    public static void init(RFusionConfig rFusionConfig) {
        f33186a = rFusionConfig.getApplication();
        f33187b = rFusionConfig.getLogger();
        f33188c = rFusionConfig.getTracker();
        f33189d = rFusionConfig.getLocale();
        f33190e = rFusionConfig.getFontDelegate();
        if (f33186a != null) {
            RFActivityManager.getInstance().init(f33186a);
        }
    }

    public static void updateLocale(Locale locale) {
        f33189d = locale;
    }

    public static Context getContext() {
        return f33186a;
    }

    public static RFusionConfig.IRFusionLogger getLogger() {
        return f33187b;
    }

    public static RFusionConfig.IRFusionTracker getTracker() {
        return f33188c;
    }

    public static Locale getLocale() {
        return f33189d;
    }

    public static String getLanguage() {
        Locale locale = f33189d;
        if (locale != null) {
            return locale.getLanguage();
        }
        return null;
    }

    public static RFFontDelegate getFontDelegate() {
        return f33190e;
    }
}
