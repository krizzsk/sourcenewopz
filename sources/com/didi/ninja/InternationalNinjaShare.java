package com.didi.ninja;

import android.content.Context;
import com.didi.global.ninja.Ninja;
import com.didi.global.ninja.strategy.CountStrategy;
import com.didi.sdk.apm.SystemUtils;

public class InternationalNinjaShare {

    /* renamed from: a */
    private static String f29087a = "NinjaShare";

    public static class Key {
        public static final String COPYLINK_SHARE = "COPYLINK_SHARE";
        public static final String EMAIL_SHARE = "EMAIL_SHARE";
        public static final String INTERNATIONAL_SHARE = "INTERNATIONAL_SHARE";
        public static final String SAVAIMAGE_SHARE = "SAVEIMAGE_SHARE";
    }

    public static class StrategyConstants {
        public static final String COPYLINK_SHARE = "COPYLINK_SHARE";
        public static final String EMAIL_SHARE = "EMAIL_SHARE";
        public static final String INTERNATIONAL_SHARE = "INTERNATIONAL_SHARE";
        public static final String SAVAIMAGE_SHARE = "SAVEIMAGE_SHARE";
    }

    public static void regist(Context context) {
        try {
            Ninja.getInstance(context).registe("COPYLINK_SHARE", new CountStrategy("COPYLINK_SHARE"));
            Ninja.getInstance(context).registe("EMAIL_SHARE", new CountStrategy("EMAIL_SHARE"));
            Ninja.getInstance(context).registe("INTERNATIONAL_SHARE", new CountStrategy("INTERNATIONAL_SHARE"));
            Ninja.getInstance(context).registe("SAVEIMAGE_SHARE", new CountStrategy("SAVEIMAGE_SHARE"));
        } catch (Exception e) {
            String str = f29087a;
            SystemUtils.log(6, str, "NinjaShare-->regist出错了！！！" + e.getLocalizedMessage(), (Throwable) null, "com.didi.ninja.InternationalNinjaShare", 38);
        }
    }
}
