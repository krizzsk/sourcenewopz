package com.didi.map.common.lib;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MapWorkaroundLibaryLoader {

    /* renamed from: a */
    static final /* synthetic */ boolean f24668a = (!MapWorkaroundLibaryLoader.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final String f24669b = "lib";

    /* renamed from: c */
    private static boolean f24670c = false;

    public static boolean loadNativeLibrariesUsingWorkaroundForTesting(Context context) {
        for (String a : MapLibaryLoader.LIB_NAMES) {
            if (!m17568a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    static boolean m17568a(Context context, String str) {
        if (f24668a || context != null) {
            File b = m17569b(context, str);
            if (!b.exists() && !m17570b(context)) {
                return false;
            }
            try {
                System.load(b.getAbsolutePath());
                return true;
            } catch (UnsatisfiedLinkError unused) {
                return false;
            }
        } else {
            throw new AssertionError();
        }
    }

    public static File getWorkaroundLibDir(Context context) {
        return context.getDir(f24669b, 0);
    }

    /* renamed from: b */
    private static File m17569b(Context context, String str) {
        return new File(getWorkaroundLibDir(context), System.mapLibraryName(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x009b A[SYNTHETIC, Splitter:B:50:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a8 A[Catch:{ all -> 0x009f, all -> 0x006e, IOException -> 0x00b2 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m17570b(android.content.Context r12) {
        /*
            boolean r0 = f24670c
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            f24670c = r0
            java.io.File r2 = getWorkaroundLibDir(r12)
            m17565a((java.io.File) r2)
            android.content.pm.ApplicationInfo r3 = r12.getApplicationInfo()     // Catch:{ IOException -> 0x00bb }
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00bb }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00bb }
            java.lang.String r3 = r3.sourceDir     // Catch:{ IOException -> 0x00bb }
            r5.<init>(r3)     // Catch:{ IOException -> 0x00bb }
            r4.<init>(r5, r0)     // Catch:{ IOException -> 0x00bb }
            java.lang.String[] r3 = com.didi.map.common.lib.MapLibaryLoader.LIB_NAMES     // Catch:{ IOException -> 0x00bb }
            int r5 = r3.length     // Catch:{ IOException -> 0x00bb }
            r6 = 0
        L_0x0024:
            if (r6 >= r5) goto L_0x00b7
            r7 = r3[r6]     // Catch:{ IOException -> 0x00bb }
            java.util.zip.ZipEntry r8 = m17563a((java.util.zip.ZipFile) r4, (java.lang.String) r7)     // Catch:{ IOException -> 0x00bb }
            if (r8 != 0) goto L_0x0035
            r4.close()     // Catch:{ IOException -> 0x00bb }
            m17565a((java.io.File) r2)     // Catch:{ IOException -> 0x00bb }
            return r1
        L_0x0035:
            java.io.File r7 = m17569b(r12, r7)     // Catch:{ IOException -> 0x00bb }
            boolean r9 = f24668a     // Catch:{ IOException -> 0x00bb }
            if (r9 != 0) goto L_0x004a
            boolean r9 = r7.exists()     // Catch:{ IOException -> 0x00bb }
            if (r9 != 0) goto L_0x0044
            goto L_0x004a
        L_0x0044:
            java.lang.AssertionError r12 = new java.lang.AssertionError     // Catch:{ IOException -> 0x00bb }
            r12.<init>()     // Catch:{ IOException -> 0x00bb }
            throw r12     // Catch:{ IOException -> 0x00bb }
        L_0x004a:
            boolean r9 = r7.createNewFile()     // Catch:{ IOException -> 0x00b2 }
            if (r9 == 0) goto L_0x00ac
            r9 = 0
            java.io.InputStream r8 = r4.getInputStream(r8)     // Catch:{ all -> 0x0097 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x0093 }
            r10.<init>(r7)     // Catch:{ all -> 0x0093 }
            r9 = 16384(0x4000, float:2.2959E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x0091 }
        L_0x005e:
            int r11 = r8.read(r9)     // Catch:{ all -> 0x0091 }
            if (r11 <= 0) goto L_0x0068
            r10.write(r9, r1, r11)     // Catch:{ all -> 0x0091 }
            goto L_0x005e
        L_0x0068:
            if (r8 == 0) goto L_0x0073
            r8.close()     // Catch:{ all -> 0x006e }
            goto L_0x0073
        L_0x006e:
            r12 = move-exception
            r10.close()     // Catch:{ IOException -> 0x00b2 }
            throw r12     // Catch:{ IOException -> 0x00b2 }
        L_0x0073:
            r10.close()     // Catch:{ IOException -> 0x00b2 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x00b2 }
            r9 = 9
            if (r8 < r9) goto L_0x008e
            java.lang.String r8 = "setReadable"
            m17567a(r7, r8, r0, r1)     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r8 = "setExecutable"
            m17567a(r7, r8, r0, r1)     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r8 = "setWritable"
            m17566a(r7, r8, r0)     // Catch:{ IOException -> 0x00b2 }
        L_0x008e:
            int r6 = r6 + 1
            goto L_0x0024
        L_0x0091:
            r12 = move-exception
            goto L_0x0095
        L_0x0093:
            r12 = move-exception
            r10 = r9
        L_0x0095:
            r9 = r8
            goto L_0x0099
        L_0x0097:
            r12 = move-exception
            r10 = r9
        L_0x0099:
            if (r9 == 0) goto L_0x00a6
            r9.close()     // Catch:{ all -> 0x009f }
            goto L_0x00a6
        L_0x009f:
            r12 = move-exception
            if (r10 == 0) goto L_0x00a5
            r10.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x00a5:
            throw r12     // Catch:{ IOException -> 0x00b2 }
        L_0x00a6:
            if (r10 == 0) goto L_0x00ab
            r10.close()     // Catch:{ IOException -> 0x00b2 }
        L_0x00ab:
            throw r12     // Catch:{ IOException -> 0x00b2 }
        L_0x00ac:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ IOException -> 0x00b2 }
            r12.<init>()     // Catch:{ IOException -> 0x00b2 }
            throw r12     // Catch:{ IOException -> 0x00b2 }
        L_0x00b2:
            r12 = move-exception
            r4.close()     // Catch:{ IOException -> 0x00bb }
            throw r12     // Catch:{ IOException -> 0x00bb }
        L_0x00b7:
            r4.close()     // Catch:{ IOException -> 0x00bb }
            return r0
        L_0x00bb:
            m17565a((java.io.File) r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.common.lib.MapWorkaroundLibaryLoader.m17570b(android.content.Context):boolean");
    }

    /* renamed from: a */
    private static void m17566a(File file, String str, boolean z) {
        if (file != null) {
            Method method = null;
            Class<File> cls = File.class;
            try {
                method = cls.getMethod(str, new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (method != null) {
                try {
                    method.invoke(file, new Object[]{Boolean.valueOf(z)});
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static void m17567a(File file, String str, boolean z, boolean z2) {
        if (file != null) {
            Method method = null;
            Class<File> cls = File.class;
            try {
                method = cls.getMethod(str, new Class[]{Boolean.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            if (method != null) {
                try {
                    method.invoke(file, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    private static ZipEntry m17563a(ZipFile zipFile, String str) {
        ZipEntry entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
        if (entry != null) {
            return entry;
        }
        return zipFile.getEntry("lib/" + Build.CPU_ABI2 + "/" + System.mapLibraryName(str));
    }

    /* renamed from: a */
    private static String m17562a() {
        Field field;
        try {
            Class<?> cls = Class.forName("android.os.Build");
            if (cls == null) {
                return null;
            }
            try {
                field = cls.getField("CPU_ABI2");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                field = null;
            }
            if (field == null) {
                return null;
            }
            try {
                return field.get(cls).toString();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    static void m17564a(final Context context) {
        new Thread() {
            public void run() {
                MapWorkaroundLibaryLoader.deleteWorkaroundLibrariesSynchronously(context);
            }
        }.start();
    }

    public static void deleteWorkaroundLibrariesSynchronously(Context context) {
        m17565a(getWorkaroundLibDir(context));
    }

    /* renamed from: a */
    private static void m17565a(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.getName();
                    file2.delete();
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }
}
