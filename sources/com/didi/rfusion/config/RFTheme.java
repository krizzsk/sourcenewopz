package com.didi.rfusion.config;

import android.app.Activity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RFTheme {
    public static final String RF_THEME_99 = "rf_theme_yellow";
    public static final String RF_THEME_DIDI = "rf_theme_orange";

    /* renamed from: a */
    private String f33192a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RFThemeType {
    }

    public void setDefaultTheme(Activity activity) {
    }

    private RFTheme() {
        this.f33192a = RF_THEME_DIDI;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static RFTheme INSTANCE = new RFTheme();

        private SingletonHolder() {
        }
    }

    public static RFTheme getThemeManager() {
        return SingletonHolder.INSTANCE;
    }
}
