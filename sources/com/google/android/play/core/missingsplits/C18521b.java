package com.google.android.play.core.missingsplits;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18432ag;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.missingsplits.b */
final class C18521b implements MissingSplitsManager {

    /* renamed from: a */
    private static final C18432ag f53203a = new C18432ag("MissingSplitsManagerImpl");

    /* renamed from: b */
    private final Context f53204b;

    /* renamed from: c */
    private final Runtime f53205c;

    /* renamed from: d */
    private final C18520a f53206d;

    /* renamed from: e */
    private final AtomicReference<Boolean> f53207e;

    C18521b(Context context, Runtime runtime, C18520a aVar, AtomicReference<Boolean> atomicReference) {
        this.f53204b = context;
        this.f53205c = runtime;
        this.f53206d = aVar;
        this.f53207e = atomicReference;
    }

    /* renamed from: a */
    private final boolean m38015a() {
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(this.f53204b.getPackageManager(), this.f53204b.getPackageName(), 128);
            return (applicationInfo == null || applicationInfo.metaData == null || !Boolean.TRUE.equals(applicationInfo.metaData.get("com.android.vending.splits.required"))) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            f53203a.mo149085d("App '%s' is not found in the PackageManager", this.f53204b.getPackageName());
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m38016a(Set<String> set) {
        return set.isEmpty() || (set.size() == 1 && set.contains(""));
    }

    /* renamed from: b */
    private final Set<String> m38017b() {
        if (Build.VERSION.SDK_INT < 21) {
            return Collections.emptySet();
        }
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(this.f53204b.getPackageManager(), this.f53204b.getPackageName(), 0);
            HashSet hashSet = new HashSet();
            if (packageInfo == null || packageInfo.splitNames == null) {
                return hashSet;
            }
            Collections.addAll(hashSet, packageInfo.splitNames);
            return hashSet;
        } catch (PackageManager.NameNotFoundException unused) {
            f53203a.mo149085d("App '%s' is not found in PackageManager", this.f53204b.getPackageName());
            return Collections.emptySet();
        }
    }

    /* renamed from: c */
    private final List<ActivityManager.AppTask> m38018c() {
        List<ActivityManager.AppTask> appTasks = ((ActivityManager) this.f53204b.getSystemService("activity")).getAppTasks();
        return appTasks != null ? appTasks : Collections.emptyList();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        f53203a.mo149085d("App '%s' is not found in PackageManager", r8.f53204b.getPackageName());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean disableAppIfMissingRequiredSplits() {
        /*
            r8 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x01d2
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r8.f53207e
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r3 = r8.f53207e     // Catch:{ all -> 0x01cf }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x01cf }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x01cf }
            r4 = 1
            if (r3 != 0) goto L_0x00b3
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r3 = r8.f53207e     // Catch:{ all -> 0x01cf }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01cf }
            if (r5 >= r1) goto L_0x001e
        L_0x001b:
            r1 = 0
            goto L_0x00ac
        L_0x001e:
            android.content.Context r5 = r8.f53204b     // Catch:{ all -> 0x01cf }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x01cf }
            android.content.Context r6 = r8.f53204b     // Catch:{ NameNotFoundException -> 0x0099 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0099 }
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = com.didi.sdk.apm.SystemUtils.getApplicationInfo(r5, r6, r7)     // Catch:{ NameNotFoundException -> 0x0099 }
            if (r5 == 0) goto L_0x001b
            android.os.Bundle r6 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0099 }
            if (r6 == 0) goto L_0x001b
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ NameNotFoundException -> 0x0099 }
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0099 }
            java.lang.String r7 = "com.android.vending.splits.required"
            java.lang.Object r5 = r5.get(r7)     // Catch:{ NameNotFoundException -> 0x0099 }
            boolean r5 = r6.equals(r5)     // Catch:{ NameNotFoundException -> 0x0099 }
            if (r5 == 0) goto L_0x001b
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01cf }
            if (r5 >= r1) goto L_0x004f
        L_0x004a:
            java.util.Set r1 = java.util.Collections.emptySet()     // Catch:{ all -> 0x01cf }
            goto L_0x0083
        L_0x004f:
            android.content.Context r1 = r8.f53204b     // Catch:{ NameNotFoundException -> 0x0071 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0071 }
            android.content.Context r5 = r8.f53204b     // Catch:{ NameNotFoundException -> 0x0071 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0071 }
            android.content.pm.PackageInfo r1 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r1, r5, r2)     // Catch:{ NameNotFoundException -> 0x0071 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ NameNotFoundException -> 0x0071 }
            r5.<init>()     // Catch:{ NameNotFoundException -> 0x0071 }
            if (r1 == 0) goto L_0x006f
            java.lang.String[] r6 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x0071 }
            if (r6 == 0) goto L_0x006f
            java.lang.String[] r1 = r1.splitNames     // Catch:{ NameNotFoundException -> 0x0071 }
            java.util.Collections.addAll(r5, r1)     // Catch:{ NameNotFoundException -> 0x0071 }
        L_0x006f:
            r1 = r5
            goto L_0x0083
        L_0x0071:
            com.google.android.play.core.internal.ag r1 = f53203a     // Catch:{ all -> 0x01cf }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x01cf }
            android.content.Context r6 = r8.f53204b     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01cf }
            r5[r2] = r6     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = "App '%s' is not found in PackageManager"
            r1.mo149085d(r6, r5)     // Catch:{ all -> 0x01cf }
            goto L_0x004a
        L_0x0083:
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x01cf }
            if (r5 != 0) goto L_0x0097
            int r5 = r1.size()     // Catch:{ all -> 0x01cf }
            if (r5 != r4) goto L_0x001b
            java.lang.String r5 = ""
            boolean r1 = r1.contains(r5)     // Catch:{ all -> 0x01cf }
            if (r1 == 0) goto L_0x001b
        L_0x0097:
            r1 = 1
            goto L_0x00ac
        L_0x0099:
            com.google.android.play.core.internal.ag r1 = f53203a     // Catch:{ all -> 0x01cf }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x01cf }
            android.content.Context r6 = r8.f53204b     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x01cf }
            r5[r2] = r6     // Catch:{ all -> 0x01cf }
            java.lang.String r6 = "App '%s' is not found in the PackageManager"
            r1.mo149085d(r6, r5)     // Catch:{ all -> 0x01cf }
            goto L_0x001b
        L_0x00ac:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x01cf }
            r3.set(r1)     // Catch:{ all -> 0x01cf }
        L_0x00b3:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r8.f53207e     // Catch:{ all -> 0x01cf }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x01cf }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x01cf }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x01cf }
            monitor-exit(r0)     // Catch:{ all -> 0x01cf }
            if (r1 == 0) goto L_0x01bc
            java.util.List r0 = r8.m38018c()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ca:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x010c
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            if (r3 == 0) goto L_0x00ca
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            if (r3 == 0) goto L_0x00ca
            android.app.ActivityManager$RecentTaskInfo r3 = r1.getTaskInfo()
            android.content.Intent r3 = r3.baseIntent
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x00ca
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r1 = r1.getClassName()
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            java.lang.String r3 = r3.getName()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x00ca
            goto L_0x01bb
        L_0x010c:
            java.util.List r0 = r8.m38018c()
            java.util.Iterator r0 = r0.iterator()
        L_0x0114:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0170
            java.lang.Object r1 = r0.next()
            android.app.ActivityManager$AppTask r1 = (android.app.ActivityManager.AppTask) r1
            android.app.ActivityManager$RecentTaskInfo r1 = r1.getTaskInfo()
            if (r1 == 0) goto L_0x0114
            android.content.Intent r3 = r1.baseIntent
            if (r3 == 0) goto L_0x0114
            android.content.Intent r3 = r1.baseIntent
            android.content.ComponentName r3 = r3.getComponent()
            if (r3 == 0) goto L_0x0114
            android.content.Intent r1 = r1.baseIntent
            android.content.ComponentName r1 = r1.getComponent()
            java.lang.String r3 = r1.getClassName()
            java.lang.Class r1 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0156 }
        L_0x0140:
            if (r1 == 0) goto L_0x0114
            java.lang.Class<android.app.Activity> r3 = android.app.Activity.class
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x014c
        L_0x014a:
            r0 = 1
            goto L_0x0171
        L_0x014c:
            java.lang.Class r3 = r1.getSuperclass()
            if (r3 == r1) goto L_0x0154
            r1 = r3
            goto L_0x0140
        L_0x0154:
            r1 = 0
            goto L_0x0140
        L_0x0156:
            com.google.android.play.core.internal.ag r5 = f53203a
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r6[r2] = r3
            java.lang.String r3 = "ClassNotFoundException when scanning class hierarchy of '%s'"
            r5.mo149085d(r3, r6)
            android.content.Context r3 = r8.f53204b     // Catch:{ NameNotFoundException -> 0x016e }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x016e }
            android.content.pm.ActivityInfo r1 = r3.getActivityInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x016e }
            if (r1 == 0) goto L_0x0114
            goto L_0x014a
        L_0x016e:
            goto L_0x0114
        L_0x0170:
            r0 = 0
        L_0x0171:
            com.google.android.play.core.missingsplits.a r1 = r8.f53206d
            r1.mo149200b()
            java.util.List r1 = r8.m38018c()
            java.util.Iterator r1 = r1.iterator()
        L_0x017e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x018e
            java.lang.Object r3 = r1.next()
            android.app.ActivityManager$AppTask r3 = (android.app.ActivityManager.AppTask) r3
            r3.finishAndRemoveTask()
            goto L_0x017e
        L_0x018e:
            if (r0 == 0) goto L_0x01b6
            android.content.Context r0 = r8.f53204b
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r3 = r8.f53204b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r5 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r1.<init>(r3, r5)
            r0.setComponentEnabledSetting(r1, r4, r4)
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r8.f53204b
            java.lang.Class<com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity> r3 = com.google.android.play.core.missingsplits.PlayCoreMissingSplitsActivity.class
            r0.<init>(r1, r3)
            r1 = 884998144(0x34c00000, float:3.5762787E-7)
            android.content.Intent r0 = r0.addFlags(r1)
            android.content.Context r1 = r8.f53204b
            r1.startActivity(r0)
        L_0x01b6:
            java.lang.Runtime r0 = r8.f53205c
            r0.exit(r2)
        L_0x01bb:
            return r4
        L_0x01bc:
            com.google.android.play.core.missingsplits.a r0 = r8.f53206d
            boolean r0 = r0.mo149199a()
            if (r0 == 0) goto L_0x01ce
            com.google.android.play.core.missingsplits.a r0 = r8.f53206d
            r0.mo149201c()
            java.lang.Runtime r0 = r8.f53205c
            r0.exit(r2)
        L_0x01ce:
            return r2
        L_0x01cf:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01cf }
            throw r1
        L_0x01d2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.missingsplits.C18521b.disableAppIfMissingRequiredSplits():boolean");
    }

    public final boolean isMissingRequiredSplits() {
        boolean booleanValue;
        synchronized (this.f53207e) {
            if (this.f53207e.get() == null) {
                AtomicReference<Boolean> atomicReference = this.f53207e;
                boolean z = false;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (m38015a() && m38016a(m38017b())) {
                        z = true;
                    }
                }
                atomicReference.set(Boolean.valueOf(z));
            }
            booleanValue = this.f53207e.get().booleanValue();
        }
        return booleanValue;
    }
}
