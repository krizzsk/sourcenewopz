package com.jumio.core.environment;

import android.content.Context;
import android.os.Build;
import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.plugins.C20007a;
import com.jumio.sdk.exceptions.PlatformNotSupportedException;
import java.io.File;
import jumio.core.C21385u0;
import org.bouncycastle.crypto.signers.PSSSigner;

public class Environment {
    public static final String ALE_VERSION = "1.9.0";
    public static final String BUILD_NUMBER = "0-90";
    public static final String BUILD_VERSION = "4.1.0";
    public static final String CDN_URL = StringDeobfuscator.deobfuscate(new byte[]{-88, 61, -12, -4, -97, 19, 108, 48, -61, Ascii.ETB, 19, -24, -100, 36, PSSSigner.TRAILER_IMPLICIT, 57, -116, 10, 77, -56, Ascii.f53596US, 64, -79, -40, -84, -33, Ascii.f53587FS, 33, 44, -47, 70, 108, -77, 44, Ascii.DC4, PSSSigner.TRAILER_IMPLICIT, -34, -48, -95}, 1409823437804407156L);
    public static String DATA_DIRECTORY = "/jumio/";
    public static final String IPROOV_VERSION = "7.2.0";
    public static final String JVISION_VERSION = "0.16.0";
    public static final String LEGACY_VERSION = "JMSDK 4.1.0 (0-90)";
    public static final String PHOTOPAY_VERSION = "8.0.0";

    /* renamed from: a */
    public static boolean f54706a = false;

    /* renamed from: b */
    public static boolean f54707b = false;

    /* renamed from: c */
    public static boolean f54708c = false;

    /* renamed from: d */
    public static boolean f54709d = false;

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC, Splitter:B:27:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String calculateHash(java.io.File r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = r6.isFile()
            r2 = 0
            if (r1 != 0) goto L_0x000d
            return r2
        L_0x000d:
            java.lang.String r1 = "SHA-256"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x006a }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ all -> 0x005e }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x005e }
            java.lang.String r6 = r6.getPath()     // Catch:{ all -> 0x005e }
            r4.<init>(r6)     // Catch:{ all -> 0x005e }
            r3.<init>(r4)     // Catch:{ all -> 0x005e }
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x005b }
        L_0x0025:
            int r2 = r3.read(r6)     // Catch:{ all -> 0x005b }
            r4 = -1
            r5 = 0
            if (r2 == r4) goto L_0x0031
            r1.update(r6, r5, r2)     // Catch:{ all -> 0x005b }
            goto L_0x0025
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r6 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r6)     // Catch:{ Exception -> 0x006a }
        L_0x0039:
            byte[] r6 = r1.digest()     // Catch:{ Exception -> 0x006a }
            int r1 = r6.length     // Catch:{ Exception -> 0x006a }
        L_0x003e:
            if (r5 >= r1) goto L_0x006e
            byte r2 = r6[r5]     // Catch:{ Exception -> 0x006a }
            r3 = r2 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> 4
            r4 = 16
            char r3 = java.lang.Character.forDigit(r3, r4)     // Catch:{ Exception -> 0x006a }
            r0.append(r3)     // Catch:{ Exception -> 0x006a }
            r2 = r2 & 15
            char r2 = java.lang.Character.forDigit(r2, r4)     // Catch:{ Exception -> 0x006a }
            r0.append(r2)     // Catch:{ Exception -> 0x006a }
            int r5 = r5 + 1
            goto L_0x003e
        L_0x005b:
            r6 = move-exception
            r2 = r3
            goto L_0x005f
        L_0x005e:
            r6 = move-exception
        L_0x005f:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r1 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r1)     // Catch:{ Exception -> 0x006a }
        L_0x0069:
            throw r6     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            r6 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r6)
        L_0x006e:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.calculateHash(java.io.File):java.lang.String");
    }

    public static void checkDependencies(Context context) throws PlatformNotSupportedException {
        String str;
        if (C20007a.m39595c(C20007a.C20010c.FACE_IPROOV)) {
            try {
                Class<?> cls = Class.forName("com.iproov.sdk.IProov");
                str = (String) cls.getDeclaredMethod("getSDKVersion", new Class[0]).invoke(cls, new Object[0]);
            } catch (Exception unused) {
                str = "";
            }
            if (new C21385u0(str).compareTo(new C21385u0(IPROOV_VERSION)) < 0) {
                throw new PlatformNotSupportedException(String.format("IProov version too low. Found %s, Required minimum %s", new Object[]{str, IPROOV_VERSION}));
            }
        }
    }

    public static void checkOcrVersion(Context context) {
        File dataDirectory = getDataDirectory(context);
        File file = new File(dataDirectory, "cv");
        if (!"0.16.0".equals(readFile(file))) {
            deleteDirectory(dataDirectory);
            writeFile("0.16.0", file);
        }
    }

    public static void deleteDirectory(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Deprecated
    public static String extractFile(Context context, String str, String str2, String str3) {
        return extractFile(context, Environment.class, str, str2, str3);
    }

    public static File getDataDirectory(Context context) {
        File file = new File(context.getFilesDir(), DATA_DIRECTORY);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean isLollipop() {
        return Build.VERSION.SDK_INT == 21;
    }

    public static boolean isPieOrAbove() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static synchronized boolean loadAleLib() {
        synchronized (Environment.class) {
            if (!f54708c) {
                System.loadLibrary("aleInterface");
                f54708c = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadCpuInfoLib() {
        synchronized (Environment.class) {
            if (!f54707b) {
                System.loadLibrary("cpuinfo");
                f54707b = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadJniImageQualityLib() {
        synchronized (Environment.class) {
            if (!f54709d) {
                System.loadLibrary("JVImgJava");
                f54709d = true;
            }
        }
        return true;
    }

    public static synchronized boolean loadJniJvCoreLib() {
        synchronized (Environment.class) {
            if (!f54706a) {
                System.loadLibrary("gnustl_shared");
                System.loadLibrary("JVCore");
                System.loadLibrary("JVCoreJava");
                f54706a = true;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[Catch:{ Exception -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[Catch:{ Exception -> 0x003f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFile(java.io.File r5) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            if (r5 == 0) goto L_0x0053
            boolean r1 = r5.isFile()
            if (r1 != 0) goto L_0x000e
            goto L_0x0053
        L_0x000e:
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0036 }
            r2.<init>(r5)     // Catch:{ all -> 0x0036 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0030 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0030 }
            r3.<init>(r2)     // Catch:{ all -> 0x0030 }
            r5.<init>(r3)     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = r5.readLine()     // Catch:{ all -> 0x002c }
            r0.append(r1)     // Catch:{ all -> 0x002c }
            r2.close()     // Catch:{ Exception -> 0x003f }
            r5.close()     // Catch:{ Exception -> 0x003f }
            goto L_0x004a
        L_0x002c:
            r1 = move-exception
            r4 = r2
            r2 = r1
            goto L_0x0034
        L_0x0030:
            r5 = move-exception
            r4 = r2
            r2 = r5
            r5 = r1
        L_0x0034:
            r1 = r4
            goto L_0x0039
        L_0x0036:
            r5 = move-exception
            r2 = r5
            r5 = r1
        L_0x0039:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ Exception -> 0x003f }
            goto L_0x0041
        L_0x003f:
            r5 = move-exception
            goto L_0x0047
        L_0x0041:
            if (r5 == 0) goto L_0x0046
            r5.close()     // Catch:{ Exception -> 0x003f }
        L_0x0046:
            throw r2     // Catch:{ Exception -> 0x003f }
        L_0x0047:
            com.jumio.commons.log.Log.printStackTrace(r5)
        L_0x004a:
            java.lang.String r5 = r0.toString()
            java.lang.String r5 = r5.trim()
            return r5
        L_0x0053:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.readFile(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[Catch:{ Exception -> 0x0021 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeFile(java.lang.String r1, java.io.File r2) {
        /*
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ all -> 0x0016 }
            r0.<init>(r2)     // Catch:{ all -> 0x0016 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0016 }
            r2.<init>(r0)     // Catch:{ all -> 0x0016 }
            r2.write(r1)     // Catch:{ all -> 0x0014 }
            r2.flush()     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0025
        L_0x0014:
            r1 = move-exception
            goto L_0x0018
        L_0x0016:
            r1 = move-exception
            r2 = 0
        L_0x0018:
            if (r2 == 0) goto L_0x0020
            r2.flush()     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0020:
            throw r1     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            r1 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r1)
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.writeFile(java.lang.String, java.io.File):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[SYNTHETIC, Splitter:B:38:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b A[SYNTHETIC, Splitter:B:45:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String extractFile(android.content.Context r2, java.lang.Class<?> r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r2 = getDataDirectory(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r2, r6)
            java.lang.String r2 = r0.getName()
            java.lang.String r6 = "_"
            boolean r2 = r2.startsWith(r6)
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = r0.getName()
            r6 = 1
            java.lang.String r2 = r2.substring(r6)
            java.io.File r6 = new java.io.File
            java.io.File r0 = r0.getParentFile()
            r6.<init>(r0, r2)
            r0 = r6
        L_0x0037:
            java.lang.String r2 = calculateHash(r0)
            boolean r6 = r0.isFile()
            if (r6 == 0) goto L_0x0047
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L_0x0081
        L_0x0047:
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]
            boolean r5 = r0.isFile()
            if (r5 == 0) goto L_0x0055
            r0.delete()
            goto L_0x005c
        L_0x0055:
            java.io.File r5 = r0.getParentFile()
            r5.mkdirs()
        L_0x005c:
            r5 = 0
            java.io.InputStream r3 = r3.getResourceAsStream(r4)     // Catch:{ all -> 0x008a }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0088 }
            r4.<init>(r0)     // Catch:{ all -> 0x0088 }
        L_0x0066:
            int r6 = r3.read(r2)     // Catch:{ all -> 0x0086 }
            if (r6 <= 0) goto L_0x0071
            r1 = 0
            r4.write(r2, r1, r6)     // Catch:{ all -> 0x0086 }
            goto L_0x0066
        L_0x0071:
            r3.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r2 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r2)     // Catch:{ Exception -> 0x0093 }
        L_0x0079:
            r4.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r2 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r2)     // Catch:{ Exception -> 0x0093 }
        L_0x0081:
            java.lang.String r2 = r0.getAbsolutePath()
            return r2
        L_0x0086:
            r2 = move-exception
            goto L_0x008d
        L_0x0088:
            r2 = move-exception
            goto L_0x008c
        L_0x008a:
            r2 = move-exception
            r3 = r5
        L_0x008c:
            r4 = r5
        L_0x008d:
            if (r3 == 0) goto L_0x0099
            r3.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0099
        L_0x0093:
            r2 = move-exception
            goto L_0x00a4
        L_0x0095:
            r3 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r3)     // Catch:{ Exception -> 0x0093 }
        L_0x0099:
            if (r4 == 0) goto L_0x00a3
            r4.close()     // Catch:{ IOException -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r3 = move-exception
            com.jumio.commons.log.Log.printStackTrace(r3)     // Catch:{ Exception -> 0x0093 }
        L_0x00a3:
            throw r2     // Catch:{ Exception -> 0x0093 }
        L_0x00a4:
            com.jumio.commons.log.Log.printStackTrace(r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.environment.Environment.extractFile(android.content.Context, java.lang.Class, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
