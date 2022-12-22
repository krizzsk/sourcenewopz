package com.didichuxing.diface.appeal;

import android.app.Activity;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.appeal.mexico.PreDocSelectAct;

public class AppealLauncher {

    /* renamed from: BR_STYLE */
    public static final int df_activity_br_style = 2132018385;
    public static final String EXTRA_KEY_SUBMIT_PARAM = "submit_param";

    /* renamed from: GLOBAL_STYLE */
    public static final int df_activity_global_style = 2132018386;

    /* renamed from: a */
    private static final String f46968a = "BR";

    /* renamed from: b */
    private static final String f46969b = "MX";

    /* renamed from: c */
    private static int f46970c = 2132018386;

    private AppealLauncher() {
    }

    public static void start(Activity activity, AppealParam appealParam) {
        String str = appealParam.country;
        LogUtils.m33569i("appeal country===" + str);
        CheckUtils.checkAssert(TextUtils.isEmpty(str) ^ true, "invalid country, country is empty!!!");
        SubmitParam submitParam = new SubmitParam();
        submitParam.token = appealParam.token;
        submitParam.faceSessionId = appealParam.faceSessionId;
        m33663a(str);
        PreDocSelectAct.start(activity, appealParam);
    }

    /* renamed from: a */
    private static void m33663a(String str) {
        if ("BR".equals(str)) {
            f46970c = df_activity_br_style;
        } else {
            f46970c = df_activity_global_style;
        }
    }

    public static int getTheme() {
        return f46970c;
    }

    public static void finishActivity() {
        BusUtils.post(new AppealRequestSuccessEvent());
    }
}
