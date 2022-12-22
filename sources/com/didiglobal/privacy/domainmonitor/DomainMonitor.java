package com.didiglobal.privacy.domainmonitor;

import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.privacy.domainmonitor.model.InterceptRouter;
import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpDMInterceptor;
import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpHooker;
import com.didiglobal.privacy.domainmonitor.utils.JsonUtil;
import com.didiglobal.privacy.domainmonitor.utils.UrlUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DomainMonitor {
    public static final String TAG = "DomainMonitor";

    /* renamed from: a */
    private static List<InterceptRouter> f50503a = new ArrayList();

    /* renamed from: b */
    private static List<String> f50504b = new ArrayList();

    /* renamed from: c */
    private static Map<String, String> f50505c = new HashMap();

    /* renamed from: d */
    private static List<String> f50506d = new ArrayList();

    /* renamed from: e */
    private static volatile boolean f50507e = false;

    /* renamed from: f */
    private static volatile boolean f50508f = false;

    /* renamed from: g */
    private static boolean f50509g = false;

    /* renamed from: h */
    private static boolean f50510h = false;

    /* renamed from: i */
    private static final String f50511i = "omgup.didiglobal.com";

    /* renamed from: j */
    private static final String f50512j = "omgup-g.didiglobal.com";

    /* renamed from: k */
    private static final String f50513k = "omgup-us.didiglobal.com";

    /* renamed from: l */
    private static final String f50514l = "omgup-ru.didiglobal.com";

    /* renamed from: m */
    private static final String f50515m = "img0.didiglobal.com";

    /* renamed from: n */
    private static final String f50516n = "firebaseinstallations.googleapis.com";

    public static void initSdkWithApolloName(String str, Boolean bool) {
        initSdkWithApolloName(str, "", bool.booleanValue());
    }

    public static void initSdkWithApolloName(String str, String str2, boolean z) {
        m36319a(str, str2);
        f50510h = z;
    }

    /* renamed from: a */
    private static void m36319a(String str, String str2) {
        if (!str.isEmpty()) {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow()) {
                m36321b(toggle.getExperiment().getStringParam("alarm_list", ""));
                m36317a();
            }
        }
        if (!str2.isEmpty()) {
            IToggle toggle2 = Apollo.getToggle(str2);
            if (toggle2.allow()) {
                f50508f = true;
                m36318a(toggle2.getExperiment().getStringParam("redirect_list", ""));
            }
        }
    }

    public static void initSdkWithList(List<String> list, List<String> list2, Boolean bool) {
        if (list2 != null && !list2.isEmpty()) {
            f50504b = list2;
            f50509g = true;
            if (list != null && !list.isEmpty()) {
                for (String put : list) {
                    f50505c.put(put, "1");
                }
            }
            f50510h = bool.booleanValue();
            m36317a();
        }
    }

    /* renamed from: a */
    private static void m36317a() {
        if (!f50507e) {
            SystemUtils.log(3, TAG, "monitorInstall: 安装成功", (Throwable) null, "com.didiglobal.privacy.domainmonitor.DomainMonitor", 114);
            m36320b();
            OkHttpHooker.installNetworkInterceptors(new OkHttpDMInterceptor());
            f50507e = true;
        }
    }

    /* renamed from: a */
    private static void m36318a(String str) {
        if (!str.isEmpty()) {
            f50503a = UrlUtil.stringToList(str);
        }
    }

    /* renamed from: b */
    private static void m36321b(String str) {
        if (!str.isEmpty()) {
            f50509g = true;
            Map<String, Object> json2Map = JsonUtil.json2Map(str);
            if (json2Map.containsKey("black_list")) {
                List<String> list = (List) json2Map.get("black_list");
                f50504b = list;
                if (list.isEmpty()) {
                    f50509g = false;
                }
            }
            if (json2Map.containsKey("white_list")) {
                f50505c = (Map) json2Map.get("white_list");
                return;
            }
            return;
        }
        f50509g = false;
    }

    /* renamed from: b */
    private static void m36320b() {
        f50506d.add("omgup.didiglobal.com");
        f50506d.add(f50513k);
        f50506d.add(f50512j);
        f50506d.add(f50514l);
        f50506d.add(f50515m);
        f50506d.add(f50516n);
    }

    public static boolean isMonitor() {
        return f50507e;
    }

    public static boolean isRedirect() {
        return f50508f;
    }

    public static boolean isAlarm() {
        return f50509g;
    }

    public static List<InterceptRouter> getRedirectList() {
        return f50503a;
    }

    public static List<String> getBlackList() {
        return f50504b;
    }

    public static Map<String, String> getWhiteList() {
        return f50505c;
    }

    public static List<String> getFilterList() {
        return f50506d;
    }

    public static boolean isDebug() {
        return f50510h;
    }
}
