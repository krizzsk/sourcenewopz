package com.didiglobal.privacy.domainmonitor;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.privacy.domainmonitor.utils.JsonUtil;
import com.didiglobal.privacy.domainmonitor.utils.URLConnectionDebugLogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkMonitor {

    /* renamed from: a */
    private static final String f50517a = "NetworkMonitor";

    /* renamed from: b */
    private static List<String> f50518b = new ArrayList();

    public static void initWithApolloName(String str) {
        IToggle toggle = Apollo.getToggle(str);
        if (toggle.allow()) {
            m36322a(toggle.getExperiment().getStringParam("white_list", ""));
        }
    }

    public static void initWithWhiteList(List<String> list) {
        m36323a(list);
    }

    public static void setIsDebug(boolean z) {
        URLConnectionDebugLogUtils.isDebug = z;
    }

    /* renamed from: a */
    private static void m36322a(String str) {
        m36323a((List<String>) Arrays.asList((String[]) JsonUtil.fromJson(str, String[].class)));
    }

    /* renamed from: a */
    private static void m36323a(List<String> list) {
        SystemUtils.log(3, f50517a, list == null ? "null" : list.toString(), (Throwable) null, "com.didiglobal.privacy.domainmonitor.NetworkMonitor", 54);
        if (list != null && !list.isEmpty()) {
            f50518b.addAll(list);
        }
    }

    public static boolean isInWhiteList(String str) {
        if (!TextUtils.isEmpty(str) && !f50518b.isEmpty()) {
            for (String contains : f50518b) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }
}
