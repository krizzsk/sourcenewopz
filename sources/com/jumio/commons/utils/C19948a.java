package com.jumio.commons.utils;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.jumio.commons.utils.a */
/* compiled from: FileUtil */
public class C19948a {

    /* renamed from: com.jumio.commons.utils.a$a */
    /* compiled from: FileUtil */
    public static class C19949a implements FilenameFilter {

        /* renamed from: a */
        public String f54590a = "";

        public C19949a(String str) {
            this.f54590a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.f54590a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[SYNTHETIC, Splitter:B:23:0x0051] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m39483a(java.lang.String r6, com.jumio.core.models.AuthorizationModel.SessionKey r7) throws java.lang.Exception {
        /*
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "r"
            r0.<init>(r6, r1)     // Catch:{ all -> 0x004d }
            long r1 = r0.length()     // Catch:{ all -> 0x004d }
            int r6 = (int) r1     // Catch:{ all -> 0x004d }
            long r3 = (long) r6     // Catch:{ all -> 0x004d }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0045
            javax.crypto.CipherInputStream r1 = new javax.crypto.CipherInputStream     // Catch:{ all -> 0x004d }
            java.nio.channels.FileChannel r0 = r0.getChannel()     // Catch:{ all -> 0x004d }
            java.io.InputStream r0 = java.nio.channels.Channels.newInputStream(r0)     // Catch:{ all -> 0x004d }
            javax.crypto.Cipher r7 = r7.getDecryptCipher()     // Catch:{ all -> 0x004d }
            r1.<init>(r0, r7)     // Catch:{ all -> 0x004d }
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0043 }
            r7 = 2048(0x800, float:2.87E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0043 }
            r0 = 0
            r2 = 0
        L_0x002a:
            int r3 = r1.read(r7)     // Catch:{ all -> 0x0043 }
            r4 = -1
            if (r3 == r4) goto L_0x0036
            java.lang.System.arraycopy(r7, r0, r6, r2, r3)     // Catch:{ all -> 0x0043 }
            int r2 = r2 + r3
            goto L_0x002a
        L_0x0036:
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r7 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r7)
        L_0x003e:
            byte[] r6 = java.util.Arrays.copyOf(r6, r2)
            return r6
        L_0x0043:
            r6 = move-exception
            goto L_0x004f
        L_0x0045:
            java.io.IOException r6 = new java.io.IOException     // Catch:{ all -> 0x004d }
            java.lang.String r7 = "File size >= 2 GB"
            r6.<init>(r7)     // Catch:{ all -> 0x004d }
            throw r6     // Catch:{ all -> 0x004d }
        L_0x004d:
            r6 = move-exception
            r1 = 0
        L_0x004f:
            if (r1 == 0) goto L_0x0059
            r1.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r7 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r7)
        L_0x0059:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.C19948a.m39483a(java.lang.String, com.jumio.core.models.AuthorizationModel$SessionKey):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m39482a(byte[] r3, java.io.File r4, com.jumio.core.models.AuthorizationModel.SessionKey r5) {
        /*
            r0 = 0
            javax.crypto.CipherOutputStream r1 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            javax.crypto.Cipher r4 = r5.getEncryptCipher()     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x0026, all -> 0x001f }
            r1.write(r3)     // Catch:{ Exception -> 0x001d, all -> 0x001a }
            r1.flush()     // Catch:{ Exception -> 0x001d, all -> 0x001a }
            com.jumio.commons.utils.IOUtils.closeQuietly(r1)
            r3 = 1
            goto L_0x002d
        L_0x001a:
            r3 = move-exception
            r0 = r1
            goto L_0x0020
        L_0x001d:
            r0 = r1
            goto L_0x0027
        L_0x001f:
            r3 = move-exception
        L_0x0020:
            if (r0 == 0) goto L_0x0025
            com.jumio.commons.utils.IOUtils.closeQuietly(r0)
        L_0x0025:
            throw r3
        L_0x0026:
        L_0x0027:
            r3 = 0
            if (r0 == 0) goto L_0x002d
            com.jumio.commons.utils.IOUtils.closeQuietly(r0)
        L_0x002d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.commons.utils.C19948a.m39482a(byte[], java.io.File, com.jumio.core.models.AuthorizationModel$SessionKey):boolean");
    }
}
