package com.megvii.livenessdetection.obf;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* renamed from: com.megvii.livenessdetection.obf.c */
public class C20344c {

    /* renamed from: a */
    private static Context f55801a;

    /* renamed from: b */
    private static C20344c f55802b;

    /* renamed from: a */
    public static synchronized C20344c m40211a(Context context) {
        C20344c cVar;
        synchronized (C20344c.class) {
            if (f55802b == null) {
                f55802b = new C20344c(context);
            }
            cVar = f55802b;
        }
        return cVar;
    }

    private C20344c(Context context) {
        f55801a = context;
    }

    /* renamed from: a */
    public final boolean mo165090a(String str, String str2) {
        boolean z;
        try {
            System.loadLibrary("livenessdetection_v2.4.5");
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return true;
        }
        String str3 = str + "_bak";
        File filesDir = f55801a.getFilesDir();
        if (m40216a(filesDir.toString(), str3, str, str2)) {
            File file = new File(filesDir.toString() + File.separator + (str3 + File.separator + ("lib" + str + "_" + str2 + ".so")));
            StringBuilder sb = new StringBuilder("copy lib to ");
            sb.append(file.toString());
            C20346d.m40219a(sb.toString());
            if (file.exists()) {
                try {
                    System.load(file.toString());
                    return true;
                } catch (UnsatisfiedLinkError e) {
                    C20346d.m40220a("SoProtect", e.toString());
                }
            } else {
                C20346d.m40223b("SoProtect", String.format(Locale.ENGLISH, "error can't find %1$s lib in plugins_lib", new Object[]{str}));
            }
        } else {
            C20346d.m40220a("SoProtect", String.format(Locale.ENGLISH, "error copy %1$s lib fail", new Object[]{str}));
        }
        return z;
    }

    /* renamed from: a */
    private void m40213a(File file, String str) {
        try {
            for (File a : file.listFiles(new C20345a(this, str))) {
                m40212a(a);
            }
        } catch (Exception e) {
            C20346d.m40220a("SoProtect", e.toString());
        }
    }

    /* renamed from: a */
    private void m40212a(File file) {
        if (!file.exists()) {
            C20346d.m40223b("SoProtect", "所删除的文件不存在！\n");
        } else if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File a : file.listFiles()) {
                m40212a(a);
            }
            file.delete();
        }
    }

    /* renamed from: a */
    private boolean m40216a(String str, String str2, String str3, String str4) {
        String str5;
        String str6 = Build.CPU_ABI;
        String str7 = "lib" + str3 + "_" + str4 + ".so";
        if ("x86".equals(str6)) {
            str5 = "lib/x86/" + str7;
        } else if ("armeabi-v7a".equals(str6)) {
            str5 = "lib/armeabi-v7a/" + str7;
        } else {
            C20346d.m40220a("SoProtect", "apse is not support for this mode");
            return false;
        }
        try {
            File file = new File(str + File.separator + str2);
            File file2 = new File(file.toString() + File.separator + str7);
            if (file2.exists()) {
                C20346d.m40223b("SoProtect", "file " + file2.toString() + " is exist");
                return true;
            }
            m40213a(file, "lib" + str3);
            file.mkdirs();
            boolean a = m40215a(str, str5, str7, file2);
            if (a || !str6.equals("armeabi-v7a")) {
                return a;
            }
            C20346d.m40223b("SoProtect", String.format("%s arch copy failed, try to copy %s arch", new Object[]{"armeabi-v7a", "armeabi"}));
            return m40215a(str, "lib/armeabi/" + str7, str7, file2);
        } catch (Exception e) {
            C20346d.m40220a("SoProtect", e.toString());
            return false;
        }
    }

    /* renamed from: a */
    private boolean m40215a(String str, String str2, String str3, File file) {
        InputStream resourceAsStream = C20344c.class.getClassLoader().getResourceAsStream(str2);
        if (resourceAsStream != null) {
            if (str == null) {
                C20346d.m40220a("SoProtect", "apse file cann't be null...");
            }
            boolean a = m40214a(resourceAsStream, file);
            try {
                resourceAsStream.close();
                return a;
            } catch (IOException e) {
                C20346d.m40220a("SoProtect", e.toString());
                return a;
            }
        } else {
            C20346d.m40223b("SoProtect", "error: can't find " + str3 + " in apk");
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007d A[SYNTHETIC, Splitter:B:46:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0082 A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0087 A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0097 A[SYNTHETIC, Splitter:B:57:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x009f A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00a4 A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b3 A[SYNTHETIC, Splitter:B:68:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00bb A[Catch:{ IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00c0 A[Catch:{ IOException -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0074=Splitter:B:43:0x0074, B:54:0x008e=Splitter:B:54:0x008e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m40214a(java.io.InputStream r7, java.io.File r8) {
        /*
            java.lang.String r0 = "SoProtect"
            r1 = 0
            r2 = 0
            boolean r3 = r8.exists()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0071, all -> 0x006d }
            if (r3 == 0) goto L_0x000d
            r8.delete()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0071, all -> 0x006d }
        L_0x000d:
            r8.createNewFile()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0071, all -> 0x006d }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0071, all -> 0x006d }
            r3.<init>(r7)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x0071, all -> 0x006d }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0067, all -> 0x0064 }
            r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0067, all -> 0x0064 }
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x0058, all -> 0x0051 }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x0058, all -> 0x0051 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0041 }
        L_0x0023:
            int r4 = r3.read(r1)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0041 }
            r5 = -1
            if (r4 == r5) goto L_0x002e
            r8.write(r1, r2, r4)     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0041 }
            goto L_0x0023
        L_0x002e:
            r8.flush()     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0041 }
            r7.flush()     // Catch:{ FileNotFoundException -> 0x004c, IOException -> 0x0047, all -> 0x0041 }
            r1 = 1
            r7.close()     // Catch:{ IOException -> 0x009b }
            r3.close()     // Catch:{ IOException -> 0x009b }
            r8.close()     // Catch:{ IOException -> 0x009b }
            r2 = 1
            goto L_0x00af
        L_0x0041:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
            goto L_0x00b1
        L_0x0047:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
            goto L_0x0074
        L_0x004c:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
            goto L_0x008e
        L_0x0051:
            r8 = move-exception
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
            goto L_0x00b1
        L_0x0058:
            r8 = move-exception
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
            goto L_0x0074
        L_0x005e:
            r8 = move-exception
            r6 = r1
            r1 = r7
            r7 = r8
            r8 = r6
            goto L_0x008e
        L_0x0064:
            r7 = move-exception
            r8 = r1
            goto L_0x00b1
        L_0x0067:
            r7 = move-exception
            r8 = r1
            goto L_0x0074
        L_0x006a:
            r7 = move-exception
            r8 = r1
            goto L_0x008e
        L_0x006d:
            r7 = move-exception
            r8 = r1
            r3 = r8
            goto L_0x00b1
        L_0x0071:
            r7 = move-exception
            r8 = r1
            r3 = r8
        L_0x0074:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b0 }
            com.megvii.livenessdetection.obf.C20346d.m40220a(r0, r7)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0080
            r1.close()     // Catch:{ IOException -> 0x009b }
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3.close()     // Catch:{ IOException -> 0x009b }
        L_0x0085:
            if (r8 == 0) goto L_0x00af
            r8.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00af
        L_0x008b:
            r7 = move-exception
            r8 = r1
            r3 = r8
        L_0x008e:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b0 }
            com.megvii.livenessdetection.obf.C20346d.m40220a(r0, r7)     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x009d
            r1.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r7 = move-exception
            goto L_0x00a8
        L_0x009d:
            if (r3 == 0) goto L_0x00a2
            r3.close()     // Catch:{ IOException -> 0x009b }
        L_0x00a2:
            if (r8 == 0) goto L_0x00af
            r8.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00af
        L_0x00a8:
            java.lang.String r7 = r7.toString()
            com.megvii.livenessdetection.obf.C20346d.m40220a(r0, r7)
        L_0x00af:
            return r2
        L_0x00b0:
            r7 = move-exception
        L_0x00b1:
            if (r1 == 0) goto L_0x00b9
            r1.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00b9
        L_0x00b7:
            r8 = move-exception
            goto L_0x00c4
        L_0x00b9:
            if (r3 == 0) goto L_0x00be
            r3.close()     // Catch:{ IOException -> 0x00b7 }
        L_0x00be:
            if (r8 == 0) goto L_0x00cb
            r8.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00cb
        L_0x00c4:
            java.lang.String r8 = r8.toString()
            com.megvii.livenessdetection.obf.C20346d.m40220a(r0, r8)
        L_0x00cb:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.megvii.livenessdetection.obf.C20344c.m40214a(java.io.InputStream, java.io.File):boolean");
    }

    /* renamed from: com.megvii.livenessdetection.obf.c$a */
    class C20345a implements FileFilter {

        /* renamed from: a */
        private String f55803a = "";

        public C20345a(C20344c cVar, String str) {
            this.f55803a = str;
        }

        public final boolean accept(File file) {
            return file.getName().startsWith(this.f55803a);
        }
    }
}
