package com.didi.ninja;

import android.content.Context;
import com.didi.global.ninja.Ninja;
import com.didi.global.ninja.strategy.CountStrategy;
import com.didi.sdk.apm.SystemUtils;

public class NinjaShare {

    /* renamed from: a */
    private static String f29088a = "NinjaShare";

    public static void regist(Context context) {
        try {
            Ninja.getInstance(context).registe("FACEBOOK_SHARE", new CountStrategy("FACEBOOK_SHARE", 1, 600));
        } catch (Exception e) {
            String str = f29088a;
            SystemUtils.log(6, str, "NinjaShare-->regist出错了！！！" + e.getLocalizedMessage(), (Throwable) null, "com.didi.ninja.NinjaShare", 25);
        }
    }
}
