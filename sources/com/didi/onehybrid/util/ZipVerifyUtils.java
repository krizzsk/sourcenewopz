package com.didi.onehybrid.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipVerifyUtils {
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        if (r3 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
        if (r3 != null) goto L_0x0064;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072 A[SYNTHETIC, Splitter:B:36:0x0072] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0069=Splitter:B:30:0x0069, B:24:0x005f=Splitter:B:24:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean verifyZip(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "ZipUtil"
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            r2 = 0
            r3 = 0
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            r5 = 28
            if (r4 < r5) goto L_0x002a
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            r4 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r6 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r1, r6, r4)     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            android.content.pm.SigningInfo r6 = r6.signingInfo     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            boolean r1 = r6.hasMultipleSigners()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            if (r1 == 0) goto L_0x0025
            android.content.pm.Signature[] r6 = r6.getApkContentsSigners()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            goto L_0x0036
        L_0x0025:
            android.content.pm.Signature[] r6 = r6.getSigningCertificateHistory()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            goto L_0x0036
        L_0x002a:
            java.lang.String r6 = r6.getPackageName()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            r4 = 64
            android.content.pm.PackageInfo r6 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r1, r6, r4)     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            android.content.pm.Signature[] r6 = r6.signatures     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
        L_0x0036:
            r6 = r6[r2]     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            byte[] r6 = r6.toByteArray()     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            r4.<init>(r6)     // Catch:{ NameNotFoundException -> 0x0068, CertificateException -> 0x005e }
            java.security.cert.Certificate r6 = r1.generateCertificate(r4)     // Catch:{ NameNotFoundException -> 0x0059, CertificateException -> 0x0056, all -> 0x0053 }
            boolean r6 = verifyZip((java.security.cert.Certificate) r6, (java.lang.String) r7)     // Catch:{ NameNotFoundException -> 0x0059, CertificateException -> 0x0056, all -> 0x0053 }
            r4.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            return r6
        L_0x0053:
            r6 = move-exception
            r3 = r4
            goto L_0x0070
        L_0x0056:
            r6 = move-exception
            r3 = r4
            goto L_0x005f
        L_0x0059:
            r6 = move-exception
            r3 = r4
            goto L_0x0069
        L_0x005c:
            r6 = move-exception
            goto L_0x0070
        L_0x005e:
            r6 = move-exception
        L_0x005f:
            android.util.Log.w(r0, r6)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x006f
        L_0x0064:
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x006f
        L_0x0068:
            r6 = move-exception
        L_0x0069:
            android.util.Log.w(r0, r6)     // Catch:{ all -> 0x005c }
            if (r3 == 0) goto L_0x006f
            goto L_0x0064
        L_0x006f:
            return r2
        L_0x0070:
            if (r3 == 0) goto L_0x0075
            r3.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.util.ZipVerifyUtils.verifyZip(android.content.Context, java.lang.String):boolean");
    }

    public static boolean verifyZip(Certificate certificate, String str) {
        try {
            String a = m20879a(str);
            if (a != null) {
                certificate.verify(m20880a(str, a).getPublicKey());
                return true;
            }
            throw new Exception("can't find cert path from zip file.");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.zip.ZipFile} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.Certificate m20880a(java.lang.String r4, java.lang.String r5) throws java.lang.Exception {
        /*
            r0 = 0
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ all -> 0x0028 }
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ all -> 0x0028 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0028 }
            r3.<init>(r4)     // Catch:{ all -> 0x0028 }
            r2.<init>(r3)     // Catch:{ all -> 0x0028 }
            java.util.zip.ZipEntry r4 = r2.getEntry(r5)     // Catch:{ all -> 0x0026 }
            java.io.InputStream r0 = r2.getInputStream(r4)     // Catch:{ all -> 0x0026 }
            java.security.cert.Certificate r4 = r1.generateCertificate(r0)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0022
            r0.close()
        L_0x0022:
            r2.close()
            return r4
        L_0x0026:
            r4 = move-exception
            goto L_0x002a
        L_0x0028:
            r4 = move-exception
            r2 = r0
        L_0x002a:
            if (r0 == 0) goto L_0x002f
            r0.close()
        L_0x002f:
            if (r2 == 0) goto L_0x0034
            r2.close()
        L_0x0034:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.util.ZipVerifyUtils.m20880a(java.lang.String, java.lang.String):java.security.cert.Certificate");
    }

    /* renamed from: a */
    private static String m20879a(String str) throws IOException {
        ZipFile zipFile = new ZipFile(new File(str));
        InputStream inputStream = zipFile.getInputStream(zipFile.getEntry("META-INF/MANIFEST.MF"));
        Manifest manifest = new Manifest(inputStream);
        inputStream.close();
        HashSet hashSet = new HashSet();
        for (Map.Entry next : manifest.getEntries().entrySet()) {
            for (Object next2 : ((Attributes) next.getValue()).keySet()) {
                if ((next2 instanceof Attributes.Name) && next2.toString().contains("-Digest")) {
                    hashSet.add(next.getKey());
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        String str2 = null;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (!zipEntry.isDirectory()) {
                String name = zipEntry.getName();
                if (!name.contains("/../") && !name.contains("/./")) {
                    if (!name.startsWith("META-INF/")) {
                        hashSet2.add(name);
                    } else if (name.endsWith(".RSA") || name.endsWith(".DSA")) {
                        str2 = name;
                    }
                }
            }
        }
        HashSet hashSet3 = new HashSet(hashSet2);
        hashSet3.removeAll(hashSet);
        HashSet hashSet4 = new HashSet(hashSet);
        hashSet4.removeAll(hashSet2);
        zipFile.close();
        if (!hashSet3.isEmpty() || !hashSet4.isEmpty()) {
            return null;
        }
        return str2;
    }
}
