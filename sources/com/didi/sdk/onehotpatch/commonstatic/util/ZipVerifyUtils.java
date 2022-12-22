package com.didi.sdk.onehotpatch.commonstatic.util;

import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
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
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (r2 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
        if (r2 != null) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[SYNTHETIC, Splitter:B:36:0x0070] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:30:0x0067=Splitter:B:30:0x0067, B:24:0x005d=Splitter:B:24:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean verifyZip(android.content.Context r5, java.lang.String r6) {
        /*
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r1 = 0
            r2 = 0
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            r4 = 28
            if (r3 < r4) goto L_0x0028
            java.lang.String r5 = com.didichuxing.security.safecollector.WsgSecInfo.packageName(r5)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r5 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r0, r5, r3)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            android.content.pm.SigningInfo r5 = r5.signingInfo     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            boolean r0 = r5.hasMultipleSigners()     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            if (r0 == 0) goto L_0x0023
            android.content.pm.Signature[] r5 = r5.getApkContentsSigners()     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            goto L_0x0034
        L_0x0023:
            android.content.pm.Signature[] r5 = r5.getSigningCertificateHistory()     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            goto L_0x0034
        L_0x0028:
            java.lang.String r5 = com.didichuxing.security.safecollector.WsgSecInfo.packageName(r5)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            r3 = 64
            android.content.pm.PackageInfo r5 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r0, r5, r3)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            android.content.pm.Signature[] r5 = r5.signatures     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
        L_0x0034:
            r5 = r5[r1]     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            byte[] r5 = r5.toByteArray()     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            r3.<init>(r5)     // Catch:{ NameNotFoundException -> 0x0066, CertificateException -> 0x005c }
            java.security.cert.Certificate r5 = r0.generateCertificate(r3)     // Catch:{ NameNotFoundException -> 0x0057, CertificateException -> 0x0054, all -> 0x0051 }
            boolean r5 = verifyZip((java.security.cert.Certificate) r5, (java.lang.String) r6)     // Catch:{ NameNotFoundException -> 0x0057, CertificateException -> 0x0054, all -> 0x0051 }
            r3.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            return r5
        L_0x0051:
            r5 = move-exception
            r2 = r3
            goto L_0x006e
        L_0x0054:
            r5 = move-exception
            r2 = r3
            goto L_0x005d
        L_0x0057:
            r5 = move-exception
            r2 = r3
            goto L_0x0067
        L_0x005a:
            r5 = move-exception
            goto L_0x006e
        L_0x005c:
            r5 = move-exception
        L_0x005d:
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r5)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x006d
        L_0x0062:
            r2.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x006d
        L_0x0066:
            r5 = move-exception
        L_0x0067:
            com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r5)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x006d
            goto L_0x0062
        L_0x006d:
            return r1
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ZipVerifyUtils.verifyZip(android.content.Context, java.lang.String):boolean");
    }

    public static boolean verifyZip(Certificate certificate, String str) {
        try {
            String checkZipFile = checkZipFile(str);
            if (checkZipFile != null) {
                certificate.verify(getCertificateFromZip(str, checkZipFile).getPublicKey());
                return true;
            }
            throw new Exception("can't find cert path from zip file.");
        } catch (Exception e) {
            Logger.warn(e);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.util.zip.ZipFile} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.cert.Certificate getCertificateFromZip(java.lang.String r4, java.lang.String r5) throws java.lang.Exception {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ZipVerifyUtils.getCertificateFromZip(java.lang.String, java.lang.String):java.security.cert.Certificate");
    }

    private static String checkZipFile(String str) throws IOException {
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
