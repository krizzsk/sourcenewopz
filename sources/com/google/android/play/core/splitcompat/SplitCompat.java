package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18445at;
import com.google.android.play.core.internal.C18446au;
import com.google.android.play.core.internal.C18448aw;
import com.google.android.play.core.internal.C18468bp;
import com.google.android.play.core.splitinstall.C18584l;
import com.google.android.play.core.splitinstall.C18588o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {

    /* renamed from: a */
    private static final AtomicReference<SplitCompat> f53223a = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C18533c f53224b;

    /* renamed from: c */
    private final Set<String> f53225c = new HashSet();

    /* renamed from: d */
    private final C18531a f53226d;

    private SplitCompat(Context context) {
        try {
            C18533c cVar = new C18533c(context);
            this.f53224b = cVar;
            this.f53226d = new C18531a(cVar);
        } catch (PackageManager.NameNotFoundException e) {
            throw new C18468bp((Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m38030a() {
        return f53223a.get() != null;
    }

    /* renamed from: a */
    public static boolean m38031a(Context context) {
        return m38032a(context, true);
    }

    /* renamed from: a */
    private static boolean m38032a(Context context, boolean z) {
        if (m38035b()) {
            return false;
        }
        boolean compareAndSet = f53223a.compareAndSet((Object) null, new SplitCompat(context));
        SplitCompat splitCompat = f53223a.get();
        if (compareAndSet) {
            C18584l.f53328a.mo149299a(new C18445at(context, C18546p.m38077a(), new C18446au(context, splitCompat.f53224b, new C18448aw(), (byte[]) null), splitCompat.f53224b, new C18546p()));
            C18588o.m38165a(new C18542l(splitCompat));
            C18546p.m38077a().execute(new C18543m(context));
        }
        try {
            splitCompat.m38034b(context, z);
            return true;
        } catch (Exception e) {
            SystemUtils.log(6, "SplitCompat", "Error installing additional splits", e, "com.google.android.play.core.splitcompat.SplitCompat", -1);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ae A[SYNTHETIC, Splitter:B:81:0x01ae] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m38034b(android.content.Context r17, boolean r18) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            monitor-enter(r16)
            if (r0 == 0) goto L_0x000d
            com.google.android.play.core.splitcompat.c r2 = r1.f53224b     // Catch:{ all -> 0x0263 }
            r2.mo149219a()     // Catch:{ all -> 0x0263 }
            goto L_0x0019
        L_0x000d:
            java.util.concurrent.Executor r2 = com.google.android.play.core.splitcompat.C18546p.m38077a()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.n r3 = new com.google.android.play.core.splitcompat.n     // Catch:{ all -> 0x0263 }
            r3.<init>(r1)     // Catch:{ all -> 0x0263 }
            r2.execute(r3)     // Catch:{ all -> 0x0263 }
        L_0x0019:
            java.lang.String r2 = r17.getPackageName()     // Catch:{ all -> 0x0263 }
            r3 = 0
            android.content.pm.PackageManager r4 = r17.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0251 }
            android.content.pm.PackageInfo r4 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r4, r2, r3)     // Catch:{ NameNotFoundException -> 0x0251 }
            java.lang.String[] r5 = r4.splitNames     // Catch:{ NameNotFoundException -> 0x0251 }
            if (r5 != 0) goto L_0x0030
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x0251 }
            r4.<init>()     // Catch:{ NameNotFoundException -> 0x0251 }
            goto L_0x0036
        L_0x0030:
            java.lang.String[] r4 = r4.splitNames     // Catch:{ NameNotFoundException -> 0x0251 }
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NameNotFoundException -> 0x0251 }
        L_0x0036:
            com.google.android.play.core.splitcompat.c r2 = r1.f53224b     // Catch:{ all -> 0x0263 }
            java.util.Set r2 = r2.mo149225d()     // Catch:{ all -> 0x0263 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r5.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0045:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x006a
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C18547q) r7     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r7.mo149239b()     // Catch:{ all -> 0x0263 }
            boolean r8 = r4.contains(r7)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x0045
            if (r0 == 0) goto L_0x0063
            com.google.android.play.core.splitcompat.c r8 = r1.f53224b     // Catch:{ all -> 0x0263 }
            r8.mo149229f(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0066
        L_0x0063:
            r5.add(r7)     // Catch:{ all -> 0x0263 }
        L_0x0066:
            r6.remove()     // Catch:{ all -> 0x0263 }
            goto L_0x0045
        L_0x006a:
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x0263 }
            if (r6 != 0) goto L_0x007c
            java.util.concurrent.Executor r6 = com.google.android.play.core.splitcompat.C18546p.m38077a()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.o r7 = new com.google.android.play.core.splitcompat.o     // Catch:{ all -> 0x0263 }
            r7.<init>(r1, r5)     // Catch:{ all -> 0x0263 }
            r6.execute(r7)     // Catch:{ all -> 0x0263 }
        L_0x007c:
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r5.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0085:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x009f
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C18547q) r7     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r7.mo149239b()     // Catch:{ all -> 0x0263 }
            boolean r8 = com.google.android.play.core.splitinstall.C18589p.m38167b(r7)     // Catch:{ all -> 0x0263 }
            if (r8 != 0) goto L_0x0085
            r5.add(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0085
        L_0x009f:
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x00a3:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0263 }
            if (r6 == 0) goto L_0x00b9
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0263 }
            boolean r7 = com.google.android.play.core.splitinstall.C18589p.m38167b(r6)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x00a3
            r5.add(r6)     // Catch:{ all -> 0x0263 }
            goto L_0x00a3
        L_0x00b9:
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            int r6 = r2.size()     // Catch:{ all -> 0x0263 }
            r4.<init>(r6)     // Catch:{ all -> 0x0263 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0263 }
        L_0x00c6:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0263 }
            if (r6 == 0) goto L_0x00fc
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r6 = (com.google.android.play.core.splitcompat.C18547q) r6     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = r6.mo149239b()     // Catch:{ all -> 0x0263 }
            boolean r7 = com.google.android.play.core.splitinstall.C18589p.m38166a(r7)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x00f8
            java.lang.String r7 = r6.mo149239b()     // Catch:{ all -> 0x0263 }
            boolean r8 = com.google.android.play.core.splitinstall.C18589p.m38166a(r7)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x00e9
            java.lang.String r7 = ""
            goto L_0x00f2
        L_0x00e9:
            java.lang.String r8 = "\\.config\\."
            r9 = 2
            java.lang.String[] r7 = r7.split(r8, r9)     // Catch:{ all -> 0x0263 }
            r7 = r7[r3]     // Catch:{ all -> 0x0263 }
        L_0x00f2:
            boolean r7 = r5.contains(r7)     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x00c6
        L_0x00f8:
            r4.add(r6)     // Catch:{ all -> 0x0263 }
            goto L_0x00c6
        L_0x00fc:
            com.google.android.play.core.splitcompat.k r2 = new com.google.android.play.core.splitcompat.k     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.c r3 = r1.f53224b     // Catch:{ all -> 0x0263 }
            r2.<init>(r3)     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.internal.av r3 = com.google.android.play.core.internal.C18448aw.m37795a()     // Catch:{ all -> 0x0263 }
            java.lang.ClassLoader r5 = r17.getClassLoader()     // Catch:{ all -> 0x0263 }
            if (r0 == 0) goto L_0x0115
            java.util.Set r2 = r2.mo149232a()     // Catch:{ all -> 0x0263 }
            r3.mo149100a(r5, r2)     // Catch:{ all -> 0x0263 }
            goto L_0x0133
        L_0x0115:
            java.util.Iterator r6 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x0119:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x0133
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C18547q) r7     // Catch:{ all -> 0x0263 }
            java.util.Set r7 = r2.mo149233a(r7)     // Catch:{ all -> 0x0263 }
            if (r7 != 0) goto L_0x012f
            r6.remove()     // Catch:{ all -> 0x0263 }
            goto L_0x0119
        L_0x012f:
            r3.mo149100a(r5, r7)     // Catch:{ all -> 0x0263 }
            goto L_0x0119
        L_0x0133:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r2.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r6 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x013c:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0263 }
            if (r7 == 0) goto L_0x01b8
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r7 = (com.google.android.play.core.splitcompat.C18547q) r7     // Catch:{ all -> 0x0263 }
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x01a9 }
            java.io.File r9 = r7.mo149238a()     // Catch:{ IOException -> 0x01a9 }
            r8.<init>(r9)     // Catch:{ IOException -> 0x01a9 }
            java.lang.String r9 = "classes.dex"
            java.util.zip.ZipEntry r9 = r8.getEntry(r9)     // Catch:{ IOException -> 0x01a7 }
            r8.close()     // Catch:{ IOException -> 0x01a7 }
            if (r9 == 0) goto L_0x019f
            com.google.android.play.core.splitcompat.c r8 = r1.f53224b     // Catch:{ all -> 0x0263 }
            java.lang.String r9 = r7.mo149239b()     // Catch:{ all -> 0x0263 }
            java.io.File r8 = r8.mo149224c((java.lang.String) r9)     // Catch:{ all -> 0x0263 }
            java.io.File r9 = r7.mo149238a()     // Catch:{ all -> 0x0263 }
            boolean r8 = r3.mo149101a(r5, r8, r9, r0)     // Catch:{ all -> 0x0263 }
            if (r8 == 0) goto L_0x0171
            goto L_0x019f
        L_0x0171:
            java.io.File r7 = r7.mo149238a()     // Catch:{ all -> 0x0263 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0263 }
            int r8 = r8.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r8 = r8 + 24
            r9.<init>(r8)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = "split was not installed "
            r9.append(r8)     // Catch:{ all -> 0x0263 }
            r9.append(r7)     // Catch:{ all -> 0x0263 }
            java.lang.String r11 = "SplitCompat"
            java.lang.String r12 = r9.toString()     // Catch:{ all -> 0x0263 }
            r10 = 5
            r13 = 0
            java.lang.String r14 = "com.google.android.play.core.splitcompat.SplitCompat"
            r15 = -1
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0263 }
            goto L_0x013c
        L_0x019f:
            java.io.File r7 = r7.mo149238a()     // Catch:{ all -> 0x0263 }
            r2.add(r7)     // Catch:{ all -> 0x0263 }
            goto L_0x013c
        L_0x01a7:
            r0 = move-exception
            goto L_0x01ab
        L_0x01a9:
            r0 = move-exception
            r8 = 0
        L_0x01ab:
            r2 = r0
            if (r8 == 0) goto L_0x01b7
            r8.close()     // Catch:{ IOException -> 0x01b2 }
            goto L_0x01b7
        L_0x01b2:
            r0 = move-exception
            r3 = r0
            com.google.android.play.core.internal.C18489cj.m37906a(r2, r3)     // Catch:{ all -> 0x0263 }
        L_0x01b7:
            throw r2     // Catch:{ all -> 0x0263 }
        L_0x01b8:
            com.google.android.play.core.splitcompat.a r0 = r1.f53226d     // Catch:{ all -> 0x0263 }
            r3 = r17
            r0.mo149214b(r3, r2)     // Catch:{ all -> 0x0263 }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0263 }
            r0.<init>()     // Catch:{ all -> 0x0263 }
            java.util.Iterator r3 = r4.iterator()     // Catch:{ all -> 0x0263 }
        L_0x01c8:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0263 }
            if (r4 == 0) goto L_0x0243
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0263 }
            com.google.android.play.core.splitcompat.q r4 = (com.google.android.play.core.splitcompat.C18547q) r4     // Catch:{ all -> 0x0263 }
            java.io.File r5 = r4.mo149238a()     // Catch:{ all -> 0x0263 }
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x0263 }
            if (r5 == 0) goto L_0x0214
            java.lang.String r5 = r4.mo149239b()     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0263 }
            int r6 = r6.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r6 = r6 + 30
            r7.<init>(r6)     // Catch:{ all -> 0x0263 }
            java.lang.String r6 = "Split '"
            r7.append(r6)     // Catch:{ all -> 0x0263 }
            r7.append(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = "' installation emulated"
            r7.append(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r9 = "SplitCompat"
            java.lang.String r10 = r7.toString()     // Catch:{ all -> 0x0263 }
            r8 = 3
            r11 = 0
            java.lang.String r12 = "com.google.android.play.core.splitcompat.SplitCompat"
            r13 = -1
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0263 }
            java.lang.String r4 = r4.mo149239b()     // Catch:{ all -> 0x0263 }
            r0.add(r4)     // Catch:{ all -> 0x0263 }
            goto L_0x01c8
        L_0x0214:
            java.lang.String r4 = r4.mo149239b()     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0263 }
            int r5 = r5.length()     // Catch:{ all -> 0x0263 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0263 }
            int r5 = r5 + 35
            r6.<init>(r5)     // Catch:{ all -> 0x0263 }
            java.lang.String r5 = "Split '"
            r6.append(r5)     // Catch:{ all -> 0x0263 }
            r6.append(r4)     // Catch:{ all -> 0x0263 }
            java.lang.String r4 = "' installation not emulated."
            r6.append(r4)     // Catch:{ all -> 0x0263 }
            java.lang.String r8 = "SplitCompat"
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0263 }
            r7 = 3
            r10 = 0
            java.lang.String r11 = "com.google.android.play.core.splitcompat.SplitCompat"
            r12 = -1
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0263 }
            goto L_0x01c8
        L_0x0243:
            java.util.Set<java.lang.String> r2 = r1.f53225c     // Catch:{ all -> 0x0263 }
            monitor-enter(r2)     // Catch:{ all -> 0x0263 }
            java.util.Set<java.lang.String> r3 = r1.f53225c     // Catch:{ all -> 0x024e }
            r3.addAll(r0)     // Catch:{ all -> 0x024e }
            monitor-exit(r2)     // Catch:{ all -> 0x024e }
            monitor-exit(r16)
            return
        L_0x024e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x024e }
            throw r0     // Catch:{ all -> 0x0263 }
        L_0x0251:
            r0 = move-exception
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0263 }
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0263 }
            r5[r3] = r2     // Catch:{ all -> 0x0263 }
            java.lang.String r2 = "Cannot load data for application '%s'"
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x0263 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0263 }
            throw r4     // Catch:{ all -> 0x0263 }
        L_0x0263:
            r0 = move-exception
            monitor-exit(r16)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.m38034b(android.content.Context, boolean):void");
    }

    /* renamed from: b */
    private static boolean m38035b() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final Set<String> m38036c() {
        HashSet hashSet;
        synchronized (this.f53225c) {
            hashSet = new HashSet(this.f53225c);
        }
        return hashSet;
    }

    public static boolean install(Context context) {
        return m38032a(context, false);
    }

    public static boolean installActivity(Context context) {
        if (m38035b()) {
            return false;
        }
        SplitCompat splitCompat = f53223a.get();
        if (splitCompat != null) {
            return splitCompat.f53226d.mo149213a(context, splitCompat.m38036c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
