package com.didi.dimina.p108v8;

import com.didi.dimina.p108v8.PlatformDetector;
import java.io.File;

/* renamed from: com.didi.dimina.v8.LibraryLoader */
class LibraryLoader {
    static final String DELIMITER = System.getProperty("line.separator");
    static final String SEPARATOR = System.getProperty("file.separator");
    static final String SWT_LIB_DIR = ".j2v8";

    LibraryLoader() {
    }

    public static String computeLibraryShortName(boolean z) {
        String str;
        String name = (!z || !PlatformDetector.C7780OS.isLinux()) ? null : PlatformDetector.Vendor.getName();
        String name2 = PlatformDetector.C7780OS.getName();
        String name3 = PlatformDetector.Arch.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("j2v8");
        if (name != null) {
            str = "-" + name;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("-");
        sb.append(name2);
        sb.append("-");
        sb.append(name3);
        return sb.toString();
    }

    public static String computeLibraryFullName(boolean z) {
        return "lib" + computeLibraryShortName(z) + "." + PlatformDetector.C7780OS.getLibFileExtension();
    }

    static boolean tryLoad(boolean z, StringBuffer stringBuffer) {
        String computeLibraryShortName = computeLibraryShortName(z);
        String computeLibraryFullName = computeLibraryFullName(z);
        String str = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName;
        if (load(computeLibraryFullName, stringBuffer) || load(computeLibraryShortName, stringBuffer)) {
            return true;
        }
        if (!new File(str).exists() || !load(str, stringBuffer)) {
            return false;
        }
        return true;
    }

    static void loadLibrary(String str) {
        System.loadLibrary("dimina-j2v8");
    }

    static boolean load(String str, StringBuffer stringBuffer) {
        try {
            if (str.indexOf(SEPARATOR) != -1) {
                System.load(str);
                return true;
            }
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (stringBuffer.length() == 0) {
                stringBuffer.append(DELIMITER);
            }
            stringBuffer.append(9);
            stringBuffer.append(e.getMessage());
            stringBuffer.append(DELIMITER);
            return false;
        }
    }

    static boolean extract(String str, boolean z, StringBuffer stringBuffer) {
        String computeLibraryFullName = computeLibraryFullName(z);
        return extract(str + SEPARATOR + computeLibraryFullName, computeLibraryFullName, stringBuffer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056 A[SYNTHETIC, Splitter:B:23:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d A[SYNTHETIC, Splitter:B:27:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean extract(java.lang.String r7, java.lang.String r8, java.lang.StringBuffer r9) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r1 = 1
            r2 = 0
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x0011
            r0.delete()     // Catch:{ all -> 0x0052 }
        L_0x0011:
            java.lang.Class<com.didi.dimina.v8.LibraryLoader> r4 = com.didi.dimina.p108v8.LibraryLoader.class
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r5.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = "/"
            r5.append(r6)     // Catch:{ all -> 0x0052 }
            r5.append(r8)     // Catch:{ all -> 0x0052 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0052 }
            java.io.InputStream r8 = r4.getResourceAsStream(r8)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x006d
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0054 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0054 }
            r5.<init>(r7)     // Catch:{ all -> 0x0054 }
        L_0x0033:
            int r2 = r8.read(r4)     // Catch:{ all -> 0x0050 }
            r6 = -1
            if (r2 == r6) goto L_0x003e
            r5.write(r4, r3, r2)     // Catch:{ all -> 0x0050 }
            goto L_0x0033
        L_0x003e:
            r5.close()     // Catch:{ all -> 0x0050 }
            r8.close()     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "755"
            chmod(r2, r7)     // Catch:{ all -> 0x0050 }
            boolean r7 = load(r7, r9)     // Catch:{ all -> 0x0050 }
            if (r7 == 0) goto L_0x006d
            return r1
        L_0x0050:
            r2 = r5
            goto L_0x0054
        L_0x0052:
            r8 = r2
            r1 = 0
        L_0x0054:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005b
        L_0x005a:
        L_0x005b:
            if (r8 == 0) goto L_0x0062
            r8.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            if (r1 == 0) goto L_0x006d
            boolean r7 = r0.exists()
            if (r7 == 0) goto L_0x006d
            r0.delete()
        L_0x006d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.p108v8.LibraryLoader.extract(java.lang.String, java.lang.String, java.lang.StringBuffer):boolean");
    }

    static void chmod(String str, String str2) {
        if (!PlatformDetector.C7780OS.isWindows()) {
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", str, str2}).waitFor();
            } catch (Throwable unused) {
            }
        }
    }
}
