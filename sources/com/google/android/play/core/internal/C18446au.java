package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitcompat.C18533c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.au */
public final class C18446au {

    /* renamed from: a */
    private final C18533c f53159a;

    /* renamed from: b */
    private final Context f53160b;

    /* renamed from: c */
    private final C18448aw f53161c;

    public C18446au(Context context, C18533c cVar, C18448aw awVar, byte[] bArr) {
        this.f53159a = cVar;
        this.f53161c = awVar;
        this.f53160b = context;
    }

    /* renamed from: a */
    private static X509Certificate m37790a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            SystemUtils.log(6, "SplitCompat", "Cannot decode certificate.", e, "com.google.android.play.core.internal.au", -1);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c1, code lost:
        r4 = "SplitCompat";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r7).length() + 32);
        r5.append("Downloaded split ");
        r5.append(r7);
        r5.append(" is not signed.");
        r5 = r5.toString();
        r3 = 6;
        r6 = null;
        r7 = "com.google.android.play.core.internal.au";
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo149098a() {
        /*
            r15 = this;
            java.lang.String r0 = " is not signed."
            java.lang.String r1 = "Downloaded split "
            r2 = 0
            com.google.android.play.core.splitcompat.c r3 = r15.f53159a     // Catch:{ IOException -> 0x0127 }
            java.io.File r3 = r3.mo149223c()     // Catch:{ IOException -> 0x0127 }
            r4 = 0
            android.content.Context r5 = r15.f53160b     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.Context r6 = r15.f53160b     // Catch:{ NameNotFoundException -> 0x0021 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0021 }
            r7 = 64
            android.content.pm.PackageInfo r5 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r5, r6, r7)     // Catch:{ NameNotFoundException -> 0x0021 }
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ NameNotFoundException -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r5 = r4
        L_0x0022:
            if (r5 != 0) goto L_0x0025
            goto L_0x003c
        L_0x0025:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r6 = r5.length
            r7 = 0
        L_0x002c:
            if (r7 >= r6) goto L_0x003c
            r8 = r5[r7]
            java.security.cert.X509Certificate r8 = m37790a((android.content.pm.Signature) r8)
            if (r8 == 0) goto L_0x0039
            r4.add(r8)
        L_0x0039:
            int r7 = r7 + 1
            goto L_0x002c
        L_0x003c:
            if (r4 == 0) goto L_0x011f
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0046
            goto L_0x011f
        L_0x0046:
            java.io.File[] r3 = r3.listFiles()
            java.util.Arrays.sort(r3)
            int r5 = r3.length
        L_0x004e:
            int r5 = r5 + -1
            if (r5 < 0) goto L_0x011d
            r6 = r3[r5]
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x0114 }
            java.security.cert.X509Certificate[][] r8 = com.google.android.play.core.internal.C18500i.m37933a((java.lang.String) r7)     // Catch:{ Exception -> 0x00e4 }
            if (r8 == 0) goto L_0x00c1
            int r9 = r8.length     // Catch:{ Exception -> 0x0114 }
            if (r9 == 0) goto L_0x00c1
            r9 = r8[r2]     // Catch:{ Exception -> 0x0114 }
            int r9 = r9.length     // Catch:{ Exception -> 0x0114 }
            if (r9 != 0) goto L_0x0067
            goto L_0x00c1
        L_0x0067:
            boolean r7 = r4.isEmpty()     // Catch:{ Exception -> 0x0114 }
            if (r7 == 0) goto L_0x007b
            java.lang.String r10 = "SplitCompat"
            java.lang.String r11 = "No certificates found for app."
            r9 = 6
            r12 = 0
            java.lang.String r13 = "com.google.android.play.core.internal.au"
            r14 = -1
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0114 }
            goto L_0x0107
        L_0x007b:
            java.util.Iterator r7 = r4.iterator()     // Catch:{ Exception -> 0x0114 }
        L_0x007f:
            boolean r9 = r7.hasNext()     // Catch:{ Exception -> 0x0114 }
            if (r9 == 0) goto L_0x00a9
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x0114 }
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9     // Catch:{ Exception -> 0x0114 }
            int r10 = r8.length     // Catch:{ Exception -> 0x0114 }
            r11 = 0
        L_0x008d:
            if (r11 >= r10) goto L_0x009c
            r12 = r8[r11]     // Catch:{ Exception -> 0x0114 }
            r12 = r12[r2]     // Catch:{ Exception -> 0x0114 }
            boolean r12 = r12.equals(r9)     // Catch:{ Exception -> 0x0114 }
            if (r12 != 0) goto L_0x007f
            int r11 = r11 + 1
            goto L_0x008d
        L_0x009c:
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "There's an app certificate that doesn't sign the split."
            r3 = 4
            r6 = 0
            java.lang.String r7 = "com.google.android.play.core.internal.au"
        L_0x00a4:
            r8 = -1
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0114 }
            goto L_0x0107
        L_0x00a9:
            com.google.android.play.core.splitcompat.c r7 = r15.f53159a     // Catch:{ IOException -> 0x00b3 }
            java.io.File r7 = r7.mo149216a((java.io.File) r6)     // Catch:{ IOException -> 0x00b3 }
            r6.renameTo(r7)     // Catch:{ IOException -> 0x00b3 }
            goto L_0x004e
        L_0x00b3:
            r0 = move-exception
            r6 = r0
            r3 = 6
            r8 = -1
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "Cannot write verified split."
        L_0x00bb:
            java.lang.String r7 = "com.google.android.play.core.internal.au"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            return r2
        L_0x00c1:
            java.lang.String r4 = "SplitCompat"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0114 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0114 }
            int r3 = r3 + 32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0114 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0114 }
            r5.append(r1)     // Catch:{ Exception -> 0x0114 }
            r5.append(r7)     // Catch:{ Exception -> 0x0114 }
            r5.append(r0)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0114 }
            r3 = 6
            r6 = 0
            java.lang.String r7 = "com.google.android.play.core.internal.au"
            goto L_0x00a4
        L_0x00e4:
            r6 = move-exception
            java.lang.String r4 = "SplitCompat"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0114 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0114 }
            int r3 = r3 + 32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0114 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0114 }
            r5.append(r1)     // Catch:{ Exception -> 0x0114 }
            r5.append(r7)     // Catch:{ Exception -> 0x0114 }
            r5.append(r0)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0114 }
            r3 = 6
            java.lang.String r7 = "com.google.android.play.core.internal.au"
            goto L_0x00a4
        L_0x0107:
            java.lang.String r10 = "SplitCompat"
            java.lang.String r11 = "Split verification failure."
            r9 = 6
            r12 = 0
            java.lang.String r13 = "com.google.android.play.core.internal.au"
            r14 = -1
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0114 }
            return r2
        L_0x0114:
            r0 = move-exception
            r6 = r0
            r3 = 6
            r8 = -1
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "Split verification error."
            goto L_0x00bb
        L_0x011d:
            r0 = 1
            return r0
        L_0x011f:
            r3 = 6
            r6 = 0
            r8 = -1
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "No app certificates found."
            goto L_0x00bb
        L_0x0127:
            r0 = move-exception
            r6 = r0
            r3 = 6
            r8 = -1
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "Cannot access directory for unverified splits."
            goto L_0x00bb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C18446au.mo149098a():boolean");
    }

    /* renamed from: a */
    public final boolean mo149099a(List<Intent> list) throws IOException {
        for (Intent stringExtra : list) {
            if (!this.f53159a.mo149221b(stringExtra.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
