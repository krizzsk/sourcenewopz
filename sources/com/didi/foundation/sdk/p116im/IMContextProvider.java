package com.didi.foundation.sdk.p116im;

import android.content.Context;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.didi.foundation.sdk.im.IMContextProvider */
public abstract class IMContextProvider {

    @Deprecated
    /* renamed from: com.didi.foundation.sdk.im.IMContextProvider$AppType */
    public interface AppType {
        public static final int BRAZIL_B_PAD = 1076;
        public static final int BRAZIL_B_PHONE = 1075;
        public static final int BRAZIL_C = 1073;
        public static final int BRAZIL_D = 1074;
        public static final int GLOBAL_B_PAD = 1055;
        public static final int GLOBAL_B_PHONE = 1052;
        public static final int GLOBAL_C = 1051;
        public static final int GLOBAL_D = 1056;
    }

    public int getActivityTheme() {
        return 0;
    }

    public abstract int getAppChannel();

    public abstract Class<?> getAppMainClass();

    public abstract int getBusinessID();

    public IMBusinessConfig getDefaultBusinessConfig() {
        return null;
    }

    public abstract String getDeviceId();

    public Map<String, Integer> getIMResource() {
        return null;
    }

    public abstract Locale getLocale();

    public ArrayList<String> getQuickReplyList(int i) {
        return null;
    }

    public abstract String getVersionName();

    @Deprecated
    public String getWebActivityScheme() {
        return null;
    }

    public boolean handleLink(Context context, String str) {
        return false;
    }

    public abstract boolean isMainActivityAlive();

    public boolean isMoveInnerStorage() {
        return false;
    }

    public boolean isPad() {
        return false;
    }

    public String locationTopScheme() {
        return null;
    }

    public boolean useDecorFloatStyle() {
        return false;
    }
}
