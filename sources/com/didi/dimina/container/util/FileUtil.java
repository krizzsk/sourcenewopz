package com.didi.dimina.container.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMSandboxHelper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec2.digest.MessageDigestAlgorithms;

public class FileUtil {
    public static final int DIR = 2;
    public static final int FILE = 1;
    public static final String TAG = "FileUtil";

    /* renamed from: a */
    private static final Map<String, Long> f17940a = new HashMap();

    public interface Filter<T> {
        boolean doFilter(T t);
    }

    public static List<String> listAsset(String str, Filter<String> filter) {
        if (Dimina.getConfig().getApp() == null) {
            throw new AssertionError();
        } else if (TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (filter != null) {
            AssetManager assets = Dimina.getConfig().getApp().getResources().getAssets();
            String[] strArr = null;
            ArrayList arrayList = new ArrayList();
            try {
                strArr = assets.list(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (filter.doFilter(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
            return arrayList;
        } else {
            throw new AssertionError();
        }
    }

    public static boolean mkdirs(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    continue;
                } else if (!delete(str)) {
                    return false;
                }
            }
            if (!file.mkdirs()) {
                return false;
            }
        }
        return true;
    }

    public static boolean copyAsset(String str, String str2) {
        if (Dimina.getConfig().getApp() != null) {
            InputStream inputStream = null;
            try {
                inputStream = Dimina.getConfig().getApp().getResources().getAssets().open(str);
                return stream2file(inputStream, str2);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                closeStream(inputStream);
            }
        } else {
            throw new AssertionError();
        }
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                boolean stream2file = stream2file(fileInputStream2, str2);
                closeStream(fileInputStream2);
                return stream2file;
            } catch (IOException e) {
                e = e;
                fileInputStream = fileInputStream2;
                try {
                    e.printStackTrace();
                    closeStream(fileInputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeStream(fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                closeStream(fileInputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            closeStream(fileInputStream);
            return false;
        }
    }

    public static List<String> list(Filter<String> filter, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            File file = new File(str);
            if (exists(2, str)) {
                for (String str2 : file.list()) {
                    String str3 = str + File.separator + str2;
                    if (filter == null) {
                        arrayList.add(str3);
                    } else if (filter.doFilter(str3)) {
                        arrayList.add(str3);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean exists(int i, String... strArr) {
        if (i == 1 || i == 2) {
            if (i == 1) {
                for (String file : strArr) {
                    File file2 = new File(file);
                    if (!file2.exists() || !file2.isFile()) {
                        return false;
                    }
                }
            } else if (i == 2) {
                for (String file3 : strArr) {
                    File file4 = new File(file3);
                    if (!file4.exists() || !file4.isDirectory()) {
                        return false;
                    }
                }
            }
            return true;
        }
        throw new AssertionError();
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return m13386a(file);
        }
        return m13391b(file);
    }

    /* renamed from: a */
    private static boolean m13386a(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !m13386a(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: b */
    private static boolean m13391b(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0, file);
        while (arrayList2.size() > 0) {
            File file2 = (File) arrayList2.remove(0);
            for (File file3 : file2.listFiles()) {
                if (!file3.isFile()) {
                    arrayList2.add(file3);
                } else if (!file3.delete()) {
                    return false;
                }
            }
            arrayList.add(file2);
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (!((File) arrayList.get(size)).delete()) {
                return false;
            }
        }
        return true;
    }

    public static String md5(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!exists(1, str)) {
                return "";
            }
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    MappedByteBuffer map = fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
                    MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                    instance.update(map);
                    String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                    closeStream(fileInputStream2);
                    return bigInteger;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        closeStream(fileInputStream);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        closeStream(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeStream(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                closeStream(fileInputStream);
                return "";
            }
        } else {
            throw new AssertionError();
        }
    }

    public static String sha1(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!exists(1, str)) {
                return "";
            }
            FileInputStream fileInputStream = null;
            try {
                File file = new File(str);
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    MappedByteBuffer map = fileInputStream2.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(map);
                    String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                    closeStream(fileInputStream2);
                    return bigInteger;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        closeStream(fileInputStream);
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        closeStream(fileInputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeStream(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                closeStream(fileInputStream);
                return "";
            }
        } else {
            throw new AssertionError();
        }
    }

    public static long getFileSize(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (exists(1, str)) {
                return new File(str).length();
            }
            return 0;
        }
        throw new AssertionError();
    }

    public static long getFolderSize(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (exists(2, str)) {
                return getFolderSize(new File(str));
            }
            return 0;
        }
        throw new AssertionError();
    }

    public static long getFolderSize(File file) {
        long j;
        long j2 = 0;
        if (file != null && file.exists()) {
            try {
                File[] listFiles = file.listFiles();
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        j = getFolderSize(listFiles[i]);
                    } else {
                        j = listFiles[i].length();
                    }
                    j2 += j;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j2;
    }

    public static String md5FromAsset(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (Dimina.getConfig().getApp() != null) {
            InputStream inputStream = null;
            try {
                inputStream = Dimina.getConfig().getApp().getResources().getAssets().open(str);
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        return new BigInteger(1, instance.digest()).toString(16);
                    }
                    instance.update(bArr, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } finally {
                closeStream(inputStream);
            }
        } else {
            throw new AssertionError();
        }
    }

    public static boolean stream2file(InputStream inputStream, String str) {
        if (!m13388a(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read != -1) {
                        fileOutputStream2.write(bArr, 0, read);
                    } else {
                        closeStream(fileOutputStream2);
                        return true;
                    }
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    closeStream(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                closeStream(fileOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            closeStream(fileOutputStream);
            return false;
        }
    }

    public static String stream2String(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream3 = byteArrayOutputStream2.toString();
                        closeStream(byteArrayOutputStream2);
                        return byteArrayOutputStream3;
                    }
                }
            } catch (IOException e) {
                e = e;
                byteArrayOutputStream = byteArrayOutputStream2;
                e.printStackTrace();
                closeStream(byteArrayOutputStream);
                return "";
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            closeStream(byteArrayOutputStream);
            return "";
        }
    }

    public static void byte2File(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (m13388a(str)) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    try {
                        e.printStackTrace();
                        closeStream(bufferedOutputStream2);
                        closeStream(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        closeStream(bufferedOutputStream2);
                        closeStream(fileOutputStream);
                        throw th;
                    }
                }
                try {
                    bufferedOutputStream.write(bArr);
                    closeStream(bufferedOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    e.printStackTrace();
                    closeStream(bufferedOutputStream2);
                    closeStream(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    closeStream(bufferedOutputStream2);
                    closeStream(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                e.printStackTrace();
                closeStream(bufferedOutputStream2);
                closeStream(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeStream(bufferedOutputStream2);
                closeStream(fileOutputStream);
                throw th;
            }
            closeStream(fileOutputStream);
        }
    }

    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean rename(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new AssertionError();
        } else if (!TextUtils.isEmpty(str2)) {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    return true;
                }
                File file2 = new File(str2);
                if ((!file2.exists() || delete(str2)) && file.renameTo(file2)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String read(int r5, java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x007a
            logDottingReadFileStart(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0037 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0037 }
            int r2 = r1.available()     // Catch:{ all -> 0x002b }
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x002b }
            r1.read(r2)     // Catch:{ all -> 0x002b }
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x002b }
            java.lang.String r4 = "utf-8"
            r3.<init>(r2, r4)     // Catch:{ all -> 0x002b }
            r0.append(r3)     // Catch:{ all -> 0x002b }
            r1.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x006e
        L_0x002b:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002d }
        L_0x002d:
            r3 = move-exception
            r1.close()     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ Exception -> 0x0037 }
        L_0x0036:
            throw r3     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()
            r2 = 0
            int r3 = r0.length()
            r0.delete(r2, r3)
            java.lang.String r2 = m13385a(r5, r6)
            r0.append(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "读取文件发生Exception ="
            r2.append(r3)
            java.lang.String r3 = r1.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "FileUtil"
            com.didi.dimina.container.util.LogUtil.eRelease(r3, r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "1"
            com.didi.dimina.container.util.TraceUtil.traceReadFileError(r5, r2, r6, r1)
        L_0x006e:
            int r5 = r0.length()
            logDottingReadFileEnd(r6, r5)
            java.lang.String r5 = r0.toString()
            return r5
        L_0x007a:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.FileUtil.read(int, java.lang.String):java.lang.String");
    }

    public static boolean write(String str, String str2) {
        if (Dimina.getConfig().getApp() != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                return stream2file(byteArrayInputStream, str2);
            } finally {
                closeStream(byteArrayInputStream);
            }
        } else {
            throw new AssertionError();
        }
    }

    public static boolean isFileProtocolExists(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.startsWith("file://")) {
                return true;
            }
            return isFileExists(new URL(str).getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isParentFileDirProtocolExists(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.startsWith("file://")) {
                return true;
            }
            return new File(new URL(str).getPath()).getParentFile().exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m13388a(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            mkdirs(file.getParent());
            if (file.exists() && !delete(str)) {
                return false;
            }
            try {
                if (!file.createNewFile()) {
                    return false;
                }
                i++;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: mv */
    public static boolean m13394mv(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        File file2 = new File(str2);
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file2.exists() || !file2.isFile() || file2.delete()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static String readAssets2String(String str) {
        return readAssets2String(str, (String) null);
    }

    public static String readAssets2String(String str, String str2) {
        try {
            byte[] a = m13389a(Dimina.getConfig().getApp().getAssets().open(str));
            if (a == null) {
                return null;
            }
            if (m13387a(str2)) {
                return new String(a);
            }
            try {
                return new String(a, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String readFile2String(File file) {
        return readFile2String(file, (String) null);
    }

    public static String readFile2String(File file, String str) {
        try {
            byte[] a = m13389a((InputStream) new FileInputStream(file));
            if (a == null) {
                return null;
            }
            if (m13387a(str)) {
                return new String(a);
            }
            try {
                return new String(a, str);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m13387a(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0044 A[SYNTHETIC, Splitter:B:33:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0058 A[SYNTHETIC, Splitter:B:44:0x0058] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m13389a(java.io.InputStream r8) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0035, all -> 0x0030 }
            r1.<init>()     // Catch:{ IOException -> 0x0035, all -> 0x0030 }
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x002e }
        L_0x000d:
            r4 = 0
            int r5 = r8.read(r3, r4, r2)     // Catch:{ IOException -> 0x002e }
            r6 = -1
            if (r5 == r6) goto L_0x0019
            r1.write(r3, r4, r5)     // Catch:{ IOException -> 0x002e }
            goto L_0x000d
        L_0x0019:
            byte[] r0 = r1.toByteArray()     // Catch:{ IOException -> 0x002e }
            r8.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0025:
            r1.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r8 = move-exception
            r8.printStackTrace()
        L_0x002d:
            return r0
        L_0x002e:
            r2 = move-exception
            goto L_0x0037
        L_0x0030:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x004e
        L_0x0035:
            r2 = move-exception
            r1 = r0
        L_0x0037:
            r2.printStackTrace()     // Catch:{ all -> 0x004d }
            r8.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0042:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004c:
            return r0
        L_0x004d:
            r0 = move-exception
        L_0x004e:
            r8.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0056:
            if (r1 == 0) goto L_0x0060
            r1.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0060:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.util.FileUtil.m13389a(java.io.InputStream):byte[]");
    }

    /* renamed from: a */
    private static String m13385a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (file.exists()) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append("\n");
                        sb.append(readLine);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        try {
                            e.printStackTrace();
                            TraceUtil.traceReadFileError(i, "2", str, e.toString());
                            closeStream(bufferedReader);
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            closeStream(bufferedReader);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        closeStream(bufferedReader);
                        throw th;
                    }
                }
                closeStream(bufferedReader2);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                TraceUtil.traceReadFileError(i, "2", str, e.toString());
                closeStream(bufferedReader);
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void logDottingReadFileStart(String str) {
        f17940a.put(m13390b(str), Long.valueOf(System.currentTimeMillis()));
    }

    public static void logDottingReadFileEnd(String str, int i) {
        String b = m13390b(str);
        if (f17940a.containsKey(b)) {
            long currentTimeMillis = System.currentTimeMillis();
            long longValue = f17940a.put(b, Long.valueOf(currentTimeMillis)).longValue();
            LogUtil.iRelease("dotting readFile", " 耗时=" + (currentTimeMillis - longValue) + "\t url=" + b + "\t 文件大小=" + i);
            return;
        }
        LogUtil.eRelease("dotting readFile", "文件时间打点 错误=" + str + "\t" + i);
    }

    /* renamed from: b */
    private static String m13390b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "空文件";
        }
        if (str.contains("files")) {
            return str.substring(str.indexOf("files"));
        }
        if (str.contains("didi")) {
            return str.substring(str.indexOf("didi"));
        }
        if (str.contains("mait")) {
            return str.substring(str.indexOf("mait"));
        }
        return str.contains(DMSandboxHelper.DIMINA) ? str.substring(str.indexOf(DMSandboxHelper.DIMINA)) : str;
    }

    public static File getInternalFilesDirectory(Context context, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = context.getFilesDir();
        } else {
            file = new File(context.getFilesDir(), str);
        }
        if (!file.exists() && !file.mkdirs()) {
            LogUtil.eRelease(TAG, "getInternalDirectory fail ,the reason is make directory fail !");
        }
        return file;
    }

    public static String getDownloadDir() {
        if (isExistSdcard()) {
            return getExternalRootDir();
        }
        return getInternalRootDir();
    }

    public static boolean isExistSdcard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getExternalRootDir() {
        String absolutePath = Dimina.getConfig().getApp().getExternalFilesDir((String) null).getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        return absolutePath;
    }

    public static String getInternalRootDir() {
        File file = new File(Dimina.getConfig().getApp().getFilesDir().getAbsolutePath());
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String getFileName(String str) {
        return URLUtil.guessFileName(str, (String) null, (String) null);
    }

    /* renamed from: c */
    private static File m13392c(String str) {
        File fileByPath = getFileByPath(str.substring(0, str.lastIndexOf("/")));
        if (fileByPath != null) {
            fileByPath.mkdirs();
        }
        File fileByPath2 = getFileByPath(str);
        if (fileByPath2 != null && fileByPath2.exists()) {
            fileByPath2.delete();
        }
        return fileByPath2;
    }

    public static File getFileByPath(String str) {
        return new File(str.replaceAll("\\\\", "/"));
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return m13393d(str);
    }

    /* renamed from: d */
    private static boolean m13393d(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Dimina.getConfig().getApp().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean checkMd5Valid(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().equals(str2);
    }

    public static String[] listDirFiles(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return file.list();
    }
}
