package com.didi.beatles.p099im.plugin.robot;

import android.content.Context;
import android.text.TextUtils;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.model.IMBottomGuideConfig;
import com.didi.beatles.p099im.protocol.view.IMGuideConfig;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotGuideHelper */
public class IMRobotGuideHelper {

    /* renamed from: a */
    private static final String f9483a = "IMRobotGuideHelper";

    /* renamed from: b */
    private static final String f9484b = "IM_Config_Robot_Enter_Show";

    /* renamed from: c */
    private static final String f9485c = "p_robot_pop_guide_1_";

    /* renamed from: d */
    private static final String f9486d = "p_robot_pop_guide_3_";

    /* renamed from: e */
    private static final boolean f9487e;

    /* renamed from: f */
    private static long f9488f = -1;

    static {
        IToggle toggle = Apollo.getToggle(f9484b);
        f9487e = toggle != null && toggle.allow();
        IMLog.m6635i(f9483a, "apollo robot config" + f9487e);
    }

    public static boolean enterShow() {
        return f9487e;
    }

    /* renamed from: a */
    private static String m6438a() {
        return f9487e ? f9485c : f9486d;
    }

    public static boolean canShowPop(Context context, long j, String str, IMBottomGuideConfig iMBottomGuideConfig) {
        String a = m6438a();
        IMPreference instance = IMPreference.getInstance(context);
        Set<String> setValue = instance.getSetValue(a + j, Collections.emptySet());
        if (TextUtils.equals(f9486d, a)) {
            if (setValue.contains(str) || iMBottomGuideConfig == null || setValue.size() >= iMBottomGuideConfig.count) {
                return false;
            }
            return true;
        } else if (setValue.contains(str) || setValue.size() >= 3) {
            return false;
        } else {
            return true;
        }
    }

    public static IMGuideConfig popShowConfig(Context context, IMBottomGuideConfig iMBottomGuideConfig) {
        if (f9487e) {
            return new IMGuideConfig("msg", context.getString(R.string.im_plugin_robot_guide_text_msg));
        }
        if (iMBottomGuideConfig != null) {
            return new IMGuideConfig("more", iMBottomGuideConfig.tip);
        }
        return null;
    }

    public static void onShowPop(Context context, long j, String str) {
        String a = m6438a();
        IMPreference instance = IMPreference.getInstance(context);
        Set setValue = instance.getSetValue(a + j, (Set<String>) null);
        if (setValue == null) {
            setValue = new HashSet();
        }
        setValue.add(str);
        IMPreference instance2 = IMPreference.getInstance(context);
        instance2.setSetValue(a + j, setValue);
    }

    public static boolean canFuncRedDot(Context context, long j, int i) {
        return IMPreference.getInstance(context).getPluginExtendActionRedDotShowedCount(j, i) < 1;
    }

    public static void onClickRedDot(Context context, long j, int i) {
        if (j != f9488f) {
            IMPreference.getInstance(context).savePluginExtendActionRedDotShowedCount(j, i, 1);
            f9488f = j;
        }
    }
}
