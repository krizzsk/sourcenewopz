package com.didi.map.setting.common.diversion;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NavDiversionApollo {

    /* renamed from: a */
    private static final int f28941a = 5;

    /* renamed from: b */
    private static List<String> f28942b = new ArrayList();

    /* renamed from: c */
    private static List<String> f28943c = new ArrayList();

    /* renamed from: d */
    private static int f28944d;

    /* renamed from: e */
    private static boolean f28945e;

    static {
        f28944d = 8;
        IToggle toggle = Apollo.getToggle("map_driver_nav_diversion");
        boolean allow = toggle.allow();
        f28945e = allow;
        if (allow) {
            IExperiment experiment = toggle.getExperiment();
            String str = (String) experiment.getParam("from", "");
            if (!TextUtils.isEmpty(str)) {
                f28942b.addAll(Arrays.asList(str.split(",")));
            }
            String str2 = (String) experiment.getParam("to", "");
            if (!TextUtils.isEmpty(str2)) {
                f28943c.addAll(Arrays.asList(str2.split(",")));
            }
            f28944d = ((Integer) experiment.getParam("usage_count", 0)).intValue();
        }
    }

    public static List<String> getNavFromList() {
        return f28942b.size() > 5 ? f28942b.subList(0, 5) : f28942b;
    }

    public static List<String> getNavToList() {
        return f28943c.size() > 5 ? f28943c.subList(0, 5) : f28943c;
    }

    public static int getUsageThreshold() {
        return Math.min(10, f28944d);
    }

    public static boolean allow() {
        return f28945e;
    }
}
