package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

class AFKeystoreWrapper {

    /* renamed from: ı */
    final Object f1758 = new Object();

    /* renamed from: ǃ */
    private Context f1759;

    /* renamed from: ɩ */
    int f1760;

    /* renamed from: Ι */
    KeyStore f1761;

    /* renamed from: ι */
    String f1762;

    public AFKeystoreWrapper(Context context) {
        this.f1759 = context;
        this.f1762 = "";
        this.f1760 = 0;
        AFLogger.afInfoLog("Initialising KeyStore..");
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f1761 = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.afErrorLog("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r1 = r4.split(",");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1.length != 3) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        com.appsflyer.AFLogger.afInfoLog("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r3.length != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r1.length != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r7.f1762 = r3[1].trim();
        r7.f1760 = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        r1 = th;
     */
    /* renamed from: ǃ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo15937() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f1758
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.f1761     // Catch:{ all -> 0x008f }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x008c
            java.security.KeyStore r1 = r7.f1761     // Catch:{ all -> 0x0070 }
            java.util.Enumeration r1 = r1.aliases()     // Catch:{ all -> 0x0070 }
        L_0x000f:
            boolean r4 = r1.hasMoreElements()     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x008c
            java.lang.Object r4 = r1.nextElement()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x000f
            boolean r5 = m1503(r4)     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x000f
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch:{ all -> 0x0070 }
            int r5 = r1.length     // Catch:{ all -> 0x0070 }
            r6 = 3
            if (r5 != r6) goto L_0x008c
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x0070 }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x0070 }
            r3 = r1[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006e }
            java.lang.String r4 = "="
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x006e }
            r4 = 2
            r1 = r1[r4]     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006e }
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch:{ all -> 0x006e }
            int r5 = r3.length     // Catch:{ all -> 0x006e }
            if (r5 != r4) goto L_0x008d
            int r5 = r1.length     // Catch:{ all -> 0x006e }
            if (r5 != r4) goto L_0x008d
            r3 = r3[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r3 = r3.trim()     // Catch:{ all -> 0x006e }
            r7.f1762 = r3     // Catch:{ all -> 0x006e }
            r1 = r1[r2]     // Catch:{ all -> 0x006e }
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x006e }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x006e }
            r7.f1760 = r1     // Catch:{ all -> 0x006e }
            goto L_0x008d
        L_0x006e:
            r1 = move-exception
            goto L_0x0072
        L_0x0070:
            r1 = move-exception
            r2 = 0
        L_0x0072:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch:{ all -> 0x008f }
            java.lang.Class r4 = r1.getClass()     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x008f }
            r3.append(r4)     // Catch:{ all -> 0x008f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008f }
            com.appsflyer.AFLogger.afErrorLog(r3, r1)     // Catch:{ all -> 0x008f }
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.mo15937():boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ */
    public final void mo15939(String str) {
        AFLogger.afInfoLog("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(1, 5);
            AlgorithmParameterSpec algorithmParameterSpec = null;
            synchronized (this.f1758) {
                if (!this.f1761.containsAlias(str)) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(instance.getTime()).setCertificateNotAfter(instance2.getTime()).build();
                    } else if (Build.VERSION.SDK_INT >= 18 && !AndroidUtils.m1525()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.f1759).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    }
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(algorithmParameterSpec);
                    instance3.generateKeyPair();
                } else {
                    AFLogger.afInfoLog("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    /* renamed from: Ι */
    private static boolean m1503(String str) {
        return str.startsWith("com.appsflyer");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ */
    public final String mo15938() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.f1758) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.f1762);
            sb.append(",");
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.f1760);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ı */
    public final String mo15936() {
        String str;
        synchronized (this.f1758) {
            str = this.f1762;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: Ι */
    public final int mo15940() {
        int i;
        synchronized (this.f1758) {
            i = this.f1760;
        }
        return i;
    }
}
