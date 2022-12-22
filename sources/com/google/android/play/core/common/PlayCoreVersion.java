package com.google.android.play.core.common;

import android.os.Bundle;
import com.didi.soda.customer.app.constant.StringConst;
import com.google.android.play.core.internal.C18432ag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PlayCoreVersion {

    /* renamed from: a */
    private static final Set<String> f53114a = new HashSet(Arrays.asList(new String[]{"review"}));

    /* renamed from: b */
    private static final Set<String> f53115b = new HashSet(Arrays.asList(new String[]{"native", "unity"}));

    /* renamed from: c */
    private static final Map<String, Map<String, Integer>> f53116c = new HashMap();

    /* renamed from: d */
    private static final C18432ag f53117d = new C18432ag("PlayCoreVersion");

    private PlayCoreVersion() {
    }

    /* renamed from: a */
    public static Bundle m37734a() {
        Bundle bundle = new Bundle();
        Map<String, Integer> a = m37735a("review");
        bundle.putInt("playcore_version_code", a.get(StringConst.JAVA).intValue());
        if (a.containsKey("native")) {
            bundle.putInt("playcore_native_version", a.get("native").intValue());
        }
        if (a.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", a.get("unity").intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    public static synchronized Map<String, Integer> m37735a(String str) {
        Map<String, Integer> map;
        synchronized (PlayCoreVersion.class) {
            if (!f53116c.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(StringConst.JAVA, 10802);
                f53116c.put(str, hashMap);
            }
            map = f53116c.get(str);
        }
        return map;
    }

    public static synchronized void addVersion(String str, String str2, int i) {
        synchronized (PlayCoreVersion.class) {
            if (!f53114a.contains(str)) {
                f53117d.mo149085d("Illegal module name: %s", str);
            } else if (!f53115b.contains(str2)) {
                f53117d.mo149085d("Illegal platform name: %s", str2);
            } else {
                m37735a(str).put(str2, Integer.valueOf(i));
            }
        }
    }
}
