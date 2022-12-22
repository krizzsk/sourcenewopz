package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18432ag;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C18589p {

    /* renamed from: a */
    private static final C18432ag f53333a = new C18432ag("SplitInstallInfoProvider");

    /* renamed from: b */
    private final Context f53334b;

    /* renamed from: c */
    private final String f53335c;

    public C18589p(Context context) {
        this.f53334b = context;
        this.f53335c = context.getPackageName();
    }

    public C18589p(Context context, String str) {
        this.f53334b = context;
        this.f53335c = str;
    }

    /* renamed from: a */
    public static boolean m38166a(String str) {
        return str.startsWith("config.");
    }

    /* renamed from: b */
    public static boolean m38167b(String str) {
        return m38166a(str) || str.contains(".config.");
    }

    /* renamed from: d */
    private final Set<String> m38168d() {
        HashSet hashSet = new HashSet();
        Bundle e = m38169e();
        if (e != null) {
            String string = e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f53333a.mo149081a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(this.f53334b.getPackageManager(), this.f53335c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f53333a.mo149085d("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f53333a.mo149081a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f53333a.mo149081a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            C18587n a = C18588o.m38164a();
            if (a != null) {
                hashSet.addAll(a.mo149234a());
            }
        }
        return hashSet;
    }

    /* renamed from: e */
    private final Bundle m38169e() {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(this.f53334b.getPackageManager(), this.f53335c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f53333a.mo149081a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f53333a.mo149085d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final Set<String> mo149300a() {
        HashSet hashSet = new HashSet();
        for (String next : m38168d()) {
            if (!m38167b(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public final Set<String> mo149301b() {
        C18580h c = mo149302c();
        if (c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = m38168d();
        d.add("");
        Set<String> a = mo149300a();
        a.add("");
        for (Map.Entry next : c.mo149298a(a).entrySet()) {
            if (d.containsAll((Collection) next.getValue())) {
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    public final C18580h mo149302c() {
        Bundle e = m38169e();
        if (e == null) {
            f53333a.mo149085d("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i = e.getInt("com.android.vending.splits");
        if (i == 0) {
            f53333a.mo149085d("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            C18580h a = C18583k.m38154a((XmlPullParser) this.f53334b.getResources().getXml(i), new C18579g());
            if (a == null) {
                f53333a.mo149085d("Can't parse languages metadata.", new Object[0]);
            }
            return a;
        } catch (Resources.NotFoundException unused) {
            f53333a.mo149085d("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }
}
