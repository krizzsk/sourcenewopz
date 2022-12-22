package com.didi.common.map.util;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.List;

public class DNSUtil {

    /* renamed from: a */
    private static final String f10939a = "global_map_sdk_httpdns_toggle";

    /* renamed from: b */
    private static final String f10940b = "apimap-ru.didiglobal.com";

    /* renamed from: c */
    private static final String f10941c = "apimap-de.didiglobal.com";

    /* renamed from: d */
    private static final String f10942d = "apimap-us.didiglobal.com";

    /* renamed from: e */
    private static final String f10943e = "apimap.didiglobal.com";

    /* renamed from: f */
    private static String f10944f = "";

    /* renamed from: g */
    private static List<String> f10945g;

    public static List<String> getIpsWithDNS(String str) {
        SystemUtils.log(6, "DNSUtil", "getIpsWithDNS", (Throwable) null, "com.didi.common.map.util.DNSUtil", 30);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SystemUtils.log(6, "DNSUtil", "getIpsWithDNS:" + str, (Throwable) null, "com.didi.common.map.util.DNSUtil", 34);
        String str2 = "apimap.didiglobal.com";
        if (!str.contains(str2)) {
            str2 = str.contains(f10940b) ? f10940b : str.contains(f10941c) ? f10941c : str.contains(f10942d) ? f10942d : null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (f10944f.equals(str2)) {
            return f10945g;
        }
        SystemUtils.log(6, "DNSUtil", "getIpsWithDNS  key:" + str2, (Throwable) null, "com.didi.common.map.util.DNSUtil", 51);
        IToggle toggle = Apollo.getToggle(f10939a);
        if (toggle.allow()) {
            String str3 = (String) toggle.getExperiment().getParam("iplist", "");
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(";");
                if (!CollectionUtil.isEmpty((Object[]) split)) {
                    for (String contains : split) {
                        if (contains.contains(str2)) {
                            String[] split2 = str3.split(",");
                            if (!CollectionUtil.isEmpty((Object[]) split2)) {
                                f10945g = new ArrayList();
                                for (int i = 1; i < split2.length; i++) {
                                    SystemUtils.log(6, "DNSUtil", "getIpsWithDNS success : " + split2[i], (Throwable) null, "com.didi.common.map.util.DNSUtil", 66);
                                    f10945g.add(split2[i]);
                                }
                                f10944f = str2;
                                return f10945g;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
