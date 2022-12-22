package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18432ag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.play.core.missingsplits.a */
final class C18520a {

    /* renamed from: a */
    private static final C18432ag f53200a = new C18432ag("MissingSplitsAppComponentsHelper");

    /* renamed from: b */
    private final Context f53201b;

    /* renamed from: c */
    private final PackageManager f53202c;

    C18520a(Context context, PackageManager packageManager) {
        this.f53201b = context;
        this.f53202c = packageManager;
    }

    /* renamed from: a */
    private final void m38010a(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f53202c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    /* renamed from: d */
    private final List<ComponentInfo> m38011d() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = SystemUtils.getPackageInfo(this.f53202c, this.f53201b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f53200a.mo149085d("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo149199a() {
        for (ComponentInfo next : m38011d()) {
            if (this.f53202c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f53200a.mo149081a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f53200a.mo149081a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo149200b() {
        f53200a.mo149084c("Disabling all non-activity components", new Object[0]);
        m38010a(m38011d(), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo149201c() {
        f53200a.mo149084c("Resetting enabled state of all non-activity components", new Object[0]);
        m38010a(m38011d(), 0);
    }
}
