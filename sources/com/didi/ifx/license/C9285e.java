package com.didi.ifx.license;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileReader;

/* renamed from: com.didi.ifx.license.e */
/* compiled from: SystemUtil */
class C9285e {
    C9285e() {
    }

    /* renamed from: a */
    static String m17460a() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    /* renamed from: b */
    static String m17461b() {
        String str = Build.MODEL;
        return str == null ? "" : str;
    }

    /* renamed from: c */
    static String m17462c() {
        String str = Build.BRAND;
        return str == null ? "" : str;
    }

    /* renamed from: d */
    static String m17463d() {
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            String[] split = new BufferedReader(fileReader).readLine().split(":\\s+", 2);
            fileReader.close();
            String str = split[1];
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }
}
