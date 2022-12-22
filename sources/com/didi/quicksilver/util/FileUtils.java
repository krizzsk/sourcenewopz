package com.didi.quicksilver.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class FileUtils {
    public static final boolean DEBUG = false;
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;

    /* renamed from: a */
    static Object f33077a = null;

    /* renamed from: b */
    static Class f33078b = null;

    /* renamed from: c */
    private static final String f33079c = "FileUtils";

    /* renamed from: d */
    private static final Pattern f33080d = Pattern.compile("[\\w%+,./=_-]+");

    /* renamed from: a */
    private static boolean m23267a(char c) {
        return (c == 0 || c == '/') ? false : true;
    }

    /* renamed from: b */
    private static boolean m23268b(char c) {
        return ((c >= 0 && c <= 31) || c == '\"' || c == '*' || c == '/' || c == ':' || c == '<' || c == '\\' || c == '|' || c == 127 || c == '>' || c == '?') ? false : true;
    }

    public static int setPermissions(File file, int i, int i2, int i3) {
        return setPermissions(file.getAbsolutePath(), i, i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0112, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        android.util.Log.w(f33079c, "Failed to Libcore.os.chown(" + r14 + "): " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x012d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x014a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014b, code lost:
        android.util.Log.w(f33079c, "Failed to find Libcore.os " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x015d, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x015e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x015f, code lost:
        android.util.Log.w(f33079c, "Failed to find Libcore.os " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0171, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0172, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0173, code lost:
        android.util.Log.w(f33079c, "Failed to find Libcore.os " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0185, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0186, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0187, code lost:
        android.util.Log.w(f33079c, "Failed to find class Libcore: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x019b, code lost:
        return -1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x015e A[ExcHandler: IllegalAccessException (r0v5 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:21:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0172 A[ExcHandler: NoSuchFieldException (r0v3 'e' java.lang.NoSuchFieldException A[CUSTOM_DECLARE]), Splitter:B:17:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0186 A[ExcHandler: ClassNotFoundException (r0v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:17:0x00a7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int setPermissions(java.lang.String r14, int r15, int r16, int r17) {
        /*
            r1 = r14
            java.lang.String r2 = "Failed to find Libcore.os "
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "chown"
            r4 = 0
            java.lang.String r5 = "chmod"
            r6 = 3
            java.lang.String r7 = "): "
            r8 = 1
            r9 = 2
            r10 = -1
            java.lang.String r11 = "FileUtils"
            r12 = 0
            r13 = 21
            if (r0 < r13) goto L_0x00a7
            java.lang.Class r0 = f33078b     // Catch:{ Exception -> 0x008b }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "android.system.Os"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x008b }
            f33078b = r0     // Catch:{ Exception -> 0x008b }
        L_0x0023:
            java.lang.Class r0 = f33078b     // Catch:{ Exception -> 0x008b }
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x008b }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r2[r12] = r13     // Catch:{ Exception -> 0x008b }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x008b }
            r2[r8] = r13     // Catch:{ Exception -> 0x008b }
            java.lang.reflect.Method r0 = r0.getMethod(r5, r2)     // Catch:{ Exception -> 0x008b }
            java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x008b }
            r2[r12] = r1     // Catch:{ Exception -> 0x008b }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x008b }
            r2[r8] = r5     // Catch:{ Exception -> 0x008b }
            r0.invoke(r4, r2)     // Catch:{ Exception -> 0x008b }
            if (r16 >= 0) goto L_0x0044
            if (r17 < 0) goto L_0x0111
        L_0x0044:
            java.lang.Class r0 = f33078b     // Catch:{ Exception -> 0x006f }
            java.lang.Class[] r2 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x006f }
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            r2[r12] = r4     // Catch:{ Exception -> 0x006f }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006f }
            r2[r8] = r4     // Catch:{ Exception -> 0x006f }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006f }
            r2[r9] = r4     // Catch:{ Exception -> 0x006f }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r2)     // Catch:{ Exception -> 0x006f }
            java.lang.Class r2 = f33078b     // Catch:{ Exception -> 0x006f }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x006f }
            r3[r12] = r1     // Catch:{ Exception -> 0x006f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x006f }
            r3[r8] = r4     // Catch:{ Exception -> 0x006f }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x006f }
            r3[r9] = r4     // Catch:{ Exception -> 0x006f }
            r0.invoke(r2, r3)     // Catch:{ Exception -> 0x006f }
            goto L_0x0111
        L_0x006f:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to Os.chown("
            r2.append(r3)
            r2.append(r14)
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.w(r11, r0)
            return r10
        L_0x008b:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to Os.chmod("
            r2.append(r3)
            r2.append(r14)
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.w(r11, r0)
            return r10
        L_0x00a7:
            java.lang.Object r0 = f33077a     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            if (r0 != 0) goto L_0x00bd
            java.lang.String r0 = "libcore.io.Libcore"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.String r13 = "os"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r13)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            f33077a = r0     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
        L_0x00bd:
            java.lang.Object r0 = f33077a     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class[] r4 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r4[r12] = r13     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class r13 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r8] = r13     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.reflect.Method r0 = r0.getMethod(r5, r4)     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Object r4 = f33077a     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Object[] r5 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r5[r12] = r1     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r5[r8] = r13     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r0.invoke(r4, r5)     // Catch:{ Exception -> 0x012e, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            if (r16 >= 0) goto L_0x00e4
            if (r17 < 0) goto L_0x0111
        L_0x00e4:
            java.lang.Object r0 = f33077a     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class[] r4 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r12] = r5     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r8] = r5     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r9] = r5     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.reflect.Method r0 = r0.getMethod(r3, r4)     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Object r3 = f33077a     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r12] = r1     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r8] = r5     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r17)     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r4[r9] = r5     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
            r0.invoke(r3, r4)     // Catch:{ Exception -> 0x0112, ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e }
        L_0x0111:
            return r12
        L_0x0112:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.String r4 = "Failed to Libcore.os.chown("
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r14)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r7)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.String r0 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            android.util.Log.w(r11, r0)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            return r10
        L_0x012e:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.String r4 = "Failed to Libcore.os.chmod("
            r3.append(r4)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r14)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r7)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            java.lang.String r0 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            android.util.Log.w(r11, r0)     // Catch:{ ClassNotFoundException -> 0x0186, NoSuchFieldException -> 0x0172, IllegalAccessException -> 0x015e, Exception -> 0x014a }
            return r10
        L_0x014a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r11, r0)
            return r10
        L_0x015e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r11, r0)
            return r10
        L_0x0172:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r11, r0)
            return r10
        L_0x0186:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to find class Libcore: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.util.FileUtils.setPermissions(java.lang.String, int, int, int):int");
    }

    public static boolean sync(FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return true;
        }
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean copyFile(File file, File file2) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            boolean copyToFile = copyToFile(fileInputStream, file2);
            fileInputStream.close();
            return copyToFile;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th) {
            fileInputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:1|2|(1:4)|5|6|7|8|(2:9|(1:11)(1:12))|13|14|15|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:19|20|21|22|23|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0037 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0027=Splitter:B:16:0x0027, B:23:0x0037=Splitter:B:23:0x0037} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(java.io.InputStream r3, java.io.File r4) {
        /*
            r0 = 0
            boolean r1 = r4.exists()     // Catch:{ IOException -> 0x003b }
            if (r1 == 0) goto L_0x000a
            r4.delete()     // Catch:{ IOException -> 0x003b }
        L_0x000a:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x003b }
            r1.<init>(r4)     // Catch:{ IOException -> 0x003b }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x002c }
        L_0x0013:
            int r2 = r3.read(r4)     // Catch:{ all -> 0x002c }
            if (r2 < 0) goto L_0x001d
            r1.write(r4, r0, r2)     // Catch:{ all -> 0x002c }
            goto L_0x0013
        L_0x001d:
            r1.flush()     // Catch:{ IOException -> 0x003b }
            java.io.FileDescriptor r3 = r1.getFD()     // Catch:{ IOException -> 0x0027 }
            r3.sync()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            r1.close()     // Catch:{ IOException -> 0x003b }
            r3 = 1
            return r3
        L_0x002c:
            r3 = move-exception
            r1.flush()     // Catch:{ IOException -> 0x003b }
            java.io.FileDescriptor r4 = r1.getFD()     // Catch:{ IOException -> 0x0037 }
            r4.sync()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x003b }
            throw r3     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.util.FileUtils.copyToFile(java.io.InputStream, java.io.File):boolean");
    }

    public static boolean isFilenameSafe(File file) {
        return f33080d.matcher(file.getPath()).matches();
    }

    public static String readTextFile(File file, int i, String str) throws IOException {
        int read;
        boolean z;
        int read2;
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try {
            long length = file.length();
            String str2 = "";
            if (i > 0 || (length > 0 && i == 0)) {
                if (length > 0 && (i == 0 || length < ((long) i))) {
                    i = (int) length;
                }
                byte[] bArr = new byte[(i + 1)];
                int read3 = bufferedInputStream.read(bArr);
                if (read3 > 0) {
                    if (read3 <= i) {
                        str2 = new String(bArr, 0, read3);
                    } else if (str == null) {
                        str2 = new String(bArr, 0, i);
                    } else {
                        str2 = new String(bArr, 0, i) + str;
                    }
                }
            } else if (i < 0) {
                byte[] bArr2 = null;
                byte[] bArr3 = null;
                boolean z2 = false;
                while (true) {
                    z = true;
                    if (bArr2 != null) {
                        z2 = true;
                    }
                    if (bArr2 == null) {
                        bArr2 = new byte[(-i)];
                    }
                    read2 = bufferedInputStream.read(bArr2);
                    if (read2 != bArr2.length) {
                        break;
                    }
                    byte[] bArr4 = bArr3;
                    bArr3 = bArr2;
                    bArr2 = bArr4;
                }
                if (bArr3 != null || read2 > 0) {
                    if (bArr3 == null) {
                        str2 = new String(bArr2, 0, read2);
                    } else {
                        if (read2 > 0) {
                            System.arraycopy(bArr3, read2, bArr3, 0, bArr3.length - read2);
                            System.arraycopy(bArr2, 0, bArr3, bArr3.length - read2, read2);
                        } else {
                            z = z2;
                        }
                        if (str != null) {
                            if (z) {
                                str2 = str + new String(bArr3);
                            }
                        }
                        str2 = new String(bArr3);
                    }
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr5 = new byte[1024];
                do {
                    read = bufferedInputStream.read(bArr5);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr5, 0, read);
                        continue;
                    }
                } while (read == 1024);
                str2 = byteArrayOutputStream.toString();
            }
            return str2;
        } finally {
            bufferedInputStream.close();
            fileInputStream.close();
        }
    }

    public static void stringToFile(String str, String str2) throws IOException {
        FileWriter fileWriter = new FileWriter(str);
        try {
            fileWriter.write(str2);
        } finally {
            fileWriter.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[SYNTHETIC, Splitter:B:18:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long checksumCrc32(java.io.File r4) throws java.io.FileNotFoundException, java.io.IOException {
        /*
            java.util.zip.CRC32 r0 = new java.util.zip.CRC32
            r0.<init>()
            r1 = 0
            java.util.zip.CheckedInputStream r2 = new java.util.zip.CheckedInputStream     // Catch:{ all -> 0x0026 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0026 }
            r3.<init>(r4)     // Catch:{ all -> 0x0026 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0026 }
            r4 = 128(0x80, float:1.794E-43)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0023 }
        L_0x0014:
            int r1 = r2.read(r4)     // Catch:{ all -> 0x0023 }
            if (r1 < 0) goto L_0x001b
            goto L_0x0014
        L_0x001b:
            long r0 = r0.getValue()     // Catch:{ all -> 0x0023 }
            r2.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            return r0
        L_0x0023:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.quicksilver.util.FileUtils.checksumCrc32(java.io.File):long");
    }

    public static boolean deleteOlderFiles(File file, int i, long j) {
        if (i < 0 || j < 0) {
            throw new IllegalArgumentException("Constraints must be positive or 0");
        }
        File[] listFiles = file.listFiles();
        boolean z = false;
        if (listFiles == null) {
            return false;
        }
        Arrays.sort(listFiles, new Comparator<File>() {
            public int compare(File file, File file2) {
                return (int) (file2.lastModified() - file.lastModified());
            }
        });
        while (i < listFiles.length) {
            File file2 = listFiles[i];
            if (System.currentTimeMillis() - file2.lastModified() > j && file2.delete()) {
                Log.d(f33079c, "Deleted old file " + file2);
                z = true;
            }
            i++;
        }
        return z;
    }

    public static boolean contains(File file, File file2) {
        if (file2 == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        if (absolutePath.equals(absolutePath2)) {
            return true;
        }
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        return absolutePath2.startsWith(absolutePath);
    }

    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w(f33079c, "Failed to delete " + file2);
                    z = false;
                }
            }
        }
        return z;
    }

    public static boolean isValidExtFilename(String str) {
        return str != null && str.equals(buildValidExtFilename(str));
    }

    public static String buildValidExtFilename(String str) {
        if (TextUtils.isEmpty(str) || ".".equals(str) || "..".equals(str)) {
            return "(invalid)";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (m23267a(charAt)) {
                sb.append(charAt);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public static boolean isValidFatFilename(String str) {
        return str != null && str.equals(buildValidFatFilename(str));
    }

    public static String buildValidFatFilename(String str) {
        if (TextUtils.isEmpty(str) || ".".equals(str) || "..".equals(str)) {
            return "(invalid)";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (m23268b(charAt)) {
                sb.append(charAt);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    public static String rewriteAfterRename(File file, File file2, String str) {
        File rewriteAfterRename;
        if (str == null || (rewriteAfterRename = rewriteAfterRename(file, file2, new File(str))) == null) {
            return null;
        }
        return rewriteAfterRename.getAbsolutePath();
    }

    public static String[] rewriteAfterRename(File file, File file2, String[] strArr) {
        if (strArr == null) {
            return null;
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = rewriteAfterRename(file, file2, strArr[i]);
        }
        return strArr2;
    }

    public static File rewriteAfterRename(File file, File file2, File file3) {
        if (file3 != null && contains(file, file3)) {
            return new File(file2, file3.getAbsolutePath().substring(file.getAbsolutePath().length()));
        }
        return null;
    }

    public static void setFilePermissionsFromMode(String str, int i, int i2) {
        int i3 = i2 | 432;
        if ((i & 1) != 0) {
            i3 |= 4;
        }
        if ((i & 2) != 0) {
            i3 |= 2;
        }
        setPermissions(str, i3, -1, -1);
    }
}
