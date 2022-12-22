package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.res.AssetManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.internal.C18470br;
import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.a */
final class C18531a {

    /* renamed from: a */
    private final C18533c f53227a;

    C18531a(C18533c cVar) {
        this.f53227a = cVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d A[Catch:{ Exception -> 0x004a }, LOOP:0: B:14:0x0027->B:16:0x002d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[SYNTHETIC, Splitter:B:19:0x0042] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean mo149213a(android.content.Context r8, java.util.Set<java.lang.String> r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.getThreadPolicy()     // Catch:{ Exception -> 0x0010 }
            android.os.StrictMode.allowThreadDiskReads()     // Catch:{ Exception -> 0x000c }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ Exception -> 0x000c }
            goto L_0x001e
        L_0x000c:
            r1 = move-exception
            goto L_0x0012
        L_0x000e:
            r8 = move-exception
            goto L_0x0065
        L_0x0010:
            r1 = move-exception
            r0 = 0
        L_0x0012:
            r4 = r1
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Unable to set up strict mode."
            r1 = 4
            java.lang.String r5 = "com.google.android.play.core.splitcompat.a"
            r6 = -1
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x000e }
        L_0x001e:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ Exception -> 0x004a }
            r1.<init>()     // Catch:{ Exception -> 0x004a }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x004a }
        L_0x0027:
            boolean r2 = r9.hasNext()     // Catch:{ Exception -> 0x004a }
            if (r2 == 0) goto L_0x003d
            java.lang.Object r2 = r9.next()     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x004a }
            com.google.android.play.core.splitcompat.c r3 = r7.f53227a     // Catch:{ Exception -> 0x004a }
            java.io.File r2 = r3.mo149221b((java.lang.String) r2)     // Catch:{ Exception -> 0x004a }
            r1.add(r2)     // Catch:{ Exception -> 0x004a }
            goto L_0x0027
        L_0x003d:
            r7.mo149214b(r8, r1)     // Catch:{ Exception -> 0x004a }
            if (r0 == 0) goto L_0x0045
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x000e }
        L_0x0045:
            r8 = 1
        L_0x0046:
            monitor-exit(r7)
            return r8
        L_0x0048:
            r8 = move-exception
            goto L_0x005e
        L_0x004a:
            r8 = move-exception
            r4 = r8
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Error installing additional splits"
            r1 = 6
            java.lang.String r5 = "com.google.android.play.core.splitcompat.a"
            r6 = -1
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x005c
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x000e }
        L_0x005c:
            r8 = 0
            goto L_0x0046
        L_0x005e:
            if (r0 != 0) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch:{ all -> 0x000e }
        L_0x0064:
            throw r8     // Catch:{ all -> 0x000e }
        L_0x0065:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.C18531a.mo149213a(android.content.Context, java.util.Set):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized void mo149214b(Context context, Set<File> set) {
        AssetManager assets = context.getAssets();
        for (File path : set) {
            int intValue = ((Integer) C18470br.m37847a((Object) assets, "addAssetPath", Integer.class, String.class, path.getPath())).intValue();
            StringBuilder sb = new StringBuilder(39);
            sb.append("addAssetPath completed with ");
            sb.append(intValue);
            SystemUtils.log(3, "SplitCompat", sb.toString(), (Throwable) null, "com.google.android.play.core.splitcompat.a", -1);
        }
    }
}
