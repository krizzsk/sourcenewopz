package com.didi.hawaii.utils;

import android.os.Environment;
import android.os.StatFs;
import com.didi.hawaii.log.HWLog;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class FileUtil {

    public interface DestFileExistHandler {
        boolean needCopy(File file, File file2);
    }

    public interface FilePathFilter {
        boolean accept(String str);
    }

    public static long getAvailStorage(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long getTotalStorge(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.File} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.io.File} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeObject(java.io.File r2, java.lang.Object r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x002e, all -> 0x002b }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0034, IOException -> 0x002e, all -> 0x002b }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ FileNotFoundException -> 0x0027, IOException -> 0x0023, all -> 0x001f }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0027, IOException -> 0x0023, all -> 0x001f }
            r2.writeObject(r3)     // Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x001b, all -> 0x0019 }
            r2.flush()     // Catch:{ FileNotFoundException -> 0x001d, IOException -> 0x001b, all -> 0x0019 }
            r3 = 1
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
            com.didi.hawaii.utils.C9266IO.safeClose(r2)
            return r3
        L_0x0019:
            r3 = move-exception
            goto L_0x0021
        L_0x001b:
            r3 = move-exception
            goto L_0x0025
        L_0x001d:
            r3 = move-exception
            goto L_0x0029
        L_0x001f:
            r3 = move-exception
            r2 = r0
        L_0x0021:
            r0 = r1
            goto L_0x0042
        L_0x0023:
            r3 = move-exception
            r2 = r0
        L_0x0025:
            r0 = r1
            goto L_0x0030
        L_0x0027:
            r3 = move-exception
            r2 = r0
        L_0x0029:
            r0 = r1
            goto L_0x0036
        L_0x002b:
            r3 = move-exception
            r2 = r0
            goto L_0x0042
        L_0x002e:
            r3 = move-exception
            r2 = r0
        L_0x0030:
            r3.printStackTrace()     // Catch:{ all -> 0x0041 }
            goto L_0x0039
        L_0x0034:
            r3 = move-exception
            r2 = r0
        L_0x0036:
            r3.printStackTrace()     // Catch:{ all -> 0x0041 }
        L_0x0039:
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            com.didi.hawaii.utils.C9266IO.safeClose(r2)
            r2 = 0
            return r2
        L_0x0041:
            r3 = move-exception
        L_0x0042:
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            com.didi.hawaii.utils.C9266IO.safeClose(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.FileUtil.writeObject(java.io.File, java.lang.Object):boolean");
    }

    public static Object readObject(File file) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (Exception e) {
                e = e;
                objectInputStream = null;
                try {
                    HWLog.m16760e(1, com.didi.dimina.container.util.FileUtil.TAG, "e:" + e.getMessage());
                    C9266IO.safeClose(fileInputStream);
                    C9266IO.safeClose(objectInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    C9266IO.safeClose(fileInputStream);
                    C9266IO.safeClose(objectInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(objectInputStream);
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(objectInputStream);
                return readObject;
            } catch (Exception e2) {
                e = e2;
                HWLog.m16760e(1, com.didi.dimina.container.util.FileUtil.TAG, "e:" + e.getMessage());
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(objectInputStream);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            objectInputStream = null;
            fileInputStream = null;
            HWLog.m16760e(1, com.didi.dimina.container.util.FileUtil.TAG, "e:" + e.getMessage());
            C9266IO.safeClose(fileInputStream);
            C9266IO.safeClose(objectInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            objectInputStream = null;
            C9266IO.safeClose(fileInputStream);
            C9266IO.safeClose(objectInputStream);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return r1.toByteArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFull(java.io.InputStream r4) throws java.io.IOException {
        /*
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
        L_0x0009:
            int r2 = r4.read(r0)     // Catch:{ EOFException -> 0x001f }
            r3 = -1
            if (r2 == r3) goto L_0x0015
            r3 = 0
            r1.write(r0, r3, r2)     // Catch:{ EOFException -> 0x001f }
            goto L_0x0009
        L_0x0015:
            r1.close()
            byte[] r4 = r1.toByteArray()
            return r4
        L_0x001d:
            r4 = move-exception
            goto L_0x0027
        L_0x001f:
            byte[] r4 = r1.toByteArray()     // Catch:{ all -> 0x001d }
            r1.close()
            return r4
        L_0x0027:
            r1.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.FileUtil.readFull(java.io.InputStream):byte[]");
    }

    public static long deleteFiles(String str) {
        File file = new File(str);
        File file2 = new File(str + System.currentTimeMillis() + File.separator);
        file.renameTo(file2);
        return deleteFiles(file2);
    }

    public static long deleteFiles(File file) {
        long j = 0;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File deleteFiles : listFiles) {
                        j += deleteFiles(deleteFiles);
                    }
                }
            } else {
                j = file.length();
            }
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(file2);
            file2.delete();
        }
        return j;
    }

    public static long deleteFilesByExtension(String str, String str2) {
        return deleteFilesByExtension(new File(str), str2);
    }

    public static long deleteFilesByExtension(File file, String str) {
        File[] listFiles;
        long j = 0;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().endsWith(str)) {
                    j = file2.length();
                    file2.delete();
                }
            }
        }
        return j;
    }

    public static long deleteFilesByPrefix(String str, String str2) {
        return deleteFilesByPrefix(new File(str), str2);
    }

    public static long deleteFilesByPrefix(File file, String str) {
        File[] listFiles;
        long j = 0;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().startsWith(str)) {
                    j = file2.length();
                    file2.delete();
                }
            }
        }
        return j;
    }

    public static long moveFile(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0;
        }
        String name = file.getName();
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        long length = file.length();
        if (new File(file2 + "/" + name).exists()) {
            deleteFiles(file);
            return length;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2 + "/" + name);
                try {
                    byte[] bArr = new byte[20480];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            C9266IO.safeClose(fileInputStream2);
                            C9266IO.safeClose(fileOutputStream);
                            deleteFiles(file);
                            return length;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    C9266IO.safeClose(fileInputStream);
                    C9266IO.safeClose(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C9266IO.safeClose(fileInputStream);
            C9266IO.safeClose(fileOutputStream);
            throw th;
        }
    }

    public static long mergeFile(String str, String str2, boolean z, DestFileExistHandler destFileExistHandler) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0;
        }
        String name = file.getName();
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        long length = file.length();
        File file3 = new File(file2 + "/" + name);
        if (file3.exists() && destFileExistHandler != null) {
            if (!destFileExistHandler.needCopy(file, file3)) {
                if (z) {
                    deleteFiles(file);
                }
                return length;
            }
            deleteFiles(file3);
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2 + "/" + name);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[20480];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                C9266IO.safeClose(fileInputStream2);
                C9266IO.safeClose(fileOutputStream);
                if (z) {
                    deleteFiles(file);
                }
                return length;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C9266IO.safeClose(fileInputStream);
                C9266IO.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C9266IO.safeClose(fileInputStream);
            C9266IO.safeClose(fileOutputStream);
            throw th;
        }
    }

    public static long getFileLen(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        if (file.getName().equalsIgnoreCase("sat")) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                j = (long) listFiles.length;
            }
            return j * 25600;
        }
        File[] listFiles2 = file.listFiles();
        if (listFiles2 != null && listFiles2.length > 0) {
            for (File fileLen : listFiles2) {
                j += getFileLen(fileLen);
            }
        }
        return j;
    }

    public static boolean reName(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists()) {
            deleteFiles(file2);
        }
        return file.renameTo(new File(str2));
    }

    public static void copyFiles(String str, String str2) {
        copyFiles(str, str2, (FilePathFilter) null);
    }

    public static void copyFolder(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            for (String str : file.list()) {
                copyFolder(new File(file, str), new File(file2, str));
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileInputStream.close();
                fileOutputStream.close();
                return;
            }
        }
    }

    public static void copyFiles(String str, String str2, FilePathFilter filePathFilter) {
        if (!m17261a(str) && !m17261a(str2)) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isFile()) {
                    m17260a(str, str2, filePathFilter);
                    return;
                }
                String[] list = file.list();
                if (list != null) {
                    for (String str3 : list) {
                        copyFiles(str3, str2 + File.separator + m17262b(str3), filePathFilter);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m17260a(java.lang.String r9, java.lang.String r10, com.didi.hawaii.utils.FileUtil.FilePathFilter r11) {
        /*
            boolean r0 = m17261a(r9)
            if (r0 != 0) goto L_0x00ce
            boolean r0 = m17261a(r10)
            if (r0 == 0) goto L_0x000e
            goto L_0x00ce
        L_0x000e:
            if (r11 == 0) goto L_0x0017
            boolean r11 = r11.accept(r9)
            if (r11 != 0) goto L_0x0017
            return
        L_0x0017:
            r11 = 0
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x00a9 }
            r0.<init>(r9)     // Catch:{ all -> 0x00a9 }
            boolean r1 = r0.exists()     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x0041
            boolean r1 = r0.isFile()     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x002a
            goto L_0x0041
        L_0x002a:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x00a9 }
            r1.<init>(r10)     // Catch:{ all -> 0x00a9 }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x00a9 }
            if (r2 == 0) goto L_0x0051
            long r2 = r0.length()     // Catch:{ all -> 0x00a9 }
            long r4 = r1.length()     // Catch:{ all -> 0x00a9 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x004e
        L_0x0041:
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            return
        L_0x004e:
            delete((java.io.File) r1)     // Catch:{ all -> 0x00a9 }
        L_0x0051:
            java.io.File r0 = r1.getParentFile()     // Catch:{ all -> 0x00a9 }
            boolean r1 = r0.isFile()     // Catch:{ all -> 0x00a9 }
            if (r1 == 0) goto L_0x005e
            delete((java.io.File) r0)     // Catch:{ all -> 0x00a9 }
        L_0x005e:
            boolean r1 = r0.exists()     // Catch:{ all -> 0x00a9 }
            if (r1 != 0) goto L_0x006b
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x006b
            goto L_0x0041
        L_0x006b:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x00a9 }
            r0.<init>(r9)     // Catch:{ all -> 0x00a9 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a3 }
            r9.<init>(r10)     // Catch:{ all -> 0x00a3 }
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch:{ all -> 0x009c }
            java.nio.channels.FileChannel r11 = r9.getChannel()     // Catch:{ all -> 0x0095 }
            r3 = 0
            long r5 = r7.size()     // Catch:{ all -> 0x0095 }
            r1 = r11
            r2 = r7
            r1.transferFrom(r2, r3, r5)     // Catch:{ all -> 0x0095 }
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            com.didi.hawaii.utils.C9266IO.safeClose(r9)
            com.didi.hawaii.utils.C9266IO.safeClose(r7)
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            goto L_0x00bf
        L_0x0095:
            r1 = move-exception
            r8 = r0
            r0 = r9
            r9 = r1
            r1 = r11
            r11 = r8
            goto L_0x00ad
        L_0x009c:
            r1 = move-exception
            r7 = r11
            r11 = r0
            r0 = r9
            r9 = r1
            r1 = r7
            goto L_0x00ad
        L_0x00a3:
            r9 = move-exception
            r1 = r11
            r7 = r1
            r11 = r0
            r0 = r7
            goto L_0x00ad
        L_0x00a9:
            r9 = move-exception
            r0 = r11
            r1 = r0
            r7 = r1
        L_0x00ad:
            r9.printStackTrace()     // Catch:{ all -> 0x00c0 }
            delete((java.lang.String) r10)     // Catch:{ all -> 0x00c0 }
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            com.didi.hawaii.utils.C9266IO.safeClose(r7)
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
        L_0x00bf:
            return
        L_0x00c0:
            r9 = move-exception
            com.didi.hawaii.utils.C9266IO.safeClose(r11)
            com.didi.hawaii.utils.C9266IO.safeClose(r0)
            com.didi.hawaii.utils.C9266IO.safeClose(r7)
            com.didi.hawaii.utils.C9266IO.safeClose(r1)
            throw r9
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.FileUtil.m17260a(java.lang.String, java.lang.String, com.didi.hawaii.utils.FileUtil$FilePathFilter):void");
    }

    public static void delete(String str) {
        delete(str, false);
    }

    public static void delete(String str, boolean z) {
        if (!m17261a(str)) {
            delete(new File(str), z);
        }
    }

    public static void delete(File file) {
        delete(file, false);
    }

    public static void delete(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete(delete, z);
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m17261a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    private static String m17262b(String str) {
        if (m17261a(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1, str.length());
    }

    public static boolean createDir(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return file.mkdirs();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean delAllFile(String str) {
        File file;
        File file2 = new File(str);
        if (!file2.exists() || !file2.isDirectory()) {
            return false;
        }
        String[] list = file2.list();
        if (list.length == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < list.length; i++) {
            if (str.endsWith(File.separator)) {
                file = new File(str + list[i]);
            } else {
                file = new File(str + File.separator + list[i]);
            }
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                delAllFile(str + File.separator + list[i]);
                delDir(str + File.separator + list[i], true);
            }
            z = true;
        }
        return z;
    }

    public static void delFile(String str) {
        try {
            new File(str).delete();
        } catch (Exception unused) {
        }
    }

    public static void delDir(String str, boolean z) {
        try {
            delAllFile(str);
            if (z) {
                new File(str.toString()).delete();
            }
        } catch (Exception unused) {
        }
    }

    public static boolean fileIsExist(String str) {
        return new File(str).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0047 A[SYNTHETIC, Splitter:B:37:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0055 A[SYNTHETIC, Splitter:B:48:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            boolean r2 = r2.exists()     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            if (r2 == 0) goto L_0x0034
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x002d }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0031, all -> 0x002d }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0032, all -> 0x002b }
        L_0x001b:
            int r1 = r2.read(r5)     // Catch:{ Exception -> 0x0032, all -> 0x002b }
            r3 = -1
            if (r1 == r3) goto L_0x0026
            r4.write(r5, r0, r1)     // Catch:{ Exception -> 0x0032, all -> 0x002b }
            goto L_0x001b
        L_0x0026:
            r2.close()     // Catch:{ Exception -> 0x0032, all -> 0x002b }
            r1 = r2
            goto L_0x0035
        L_0x002b:
            r5 = move-exception
            goto L_0x002f
        L_0x002d:
            r5 = move-exception
            r4 = r1
        L_0x002f:
            r1 = r2
            goto L_0x0045
        L_0x0031:
            r4 = r1
        L_0x0032:
            r1 = r2
            goto L_0x0053
        L_0x0034:
            r4 = r1
        L_0x0035:
            r5 = 1
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x003d
        L_0x003c:
        L_0x003d:
            if (r4 == 0) goto L_0x0042
            r4.close()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            return r5
        L_0x0043:
            r5 = move-exception
            r4 = r1
        L_0x0045:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Exception -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r4 == 0) goto L_0x0051
            r4.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            throw r5
        L_0x0052:
            r4 = r1
        L_0x0053:
            if (r1 == 0) goto L_0x005f
            r1.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            r4.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.FileUtil.copyFile(java.lang.String, java.lang.String):boolean");
    }

    public static File getSDCardFileDir(String str) {
        String intSDCardRootPath = getIntSDCardRootPath();
        if (intSDCardRootPath == null) {
            return null;
        }
        File file = new File(intSDCardRootPath + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getIntSDCardRootPath() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState == null || !externalStorageState.equals("mounted")) {
                return null;
            }
            return StorageUtils.getSDRootPath();
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] readLongStringToBytes(DataInputStream dataInputStream) throws Exception {
        int readInt = dataInputStream.readInt();
        if (readInt <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[readInt];
        dataInputStream.read(bArr, 0, readInt);
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a A[SYNTHETIC, Splitter:B:19:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055 A[SYNTHETIC, Splitter:B:24:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeJsonToFile(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x0044 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0044 }
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = "/"
            r2.append(r3)     // Catch:{ Exception -> 0x0044 }
            r2.append(r4)     // Catch:{ Exception -> 0x0044 }
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x0044 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0044 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0044 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0044 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            byte[] r5 = r5.getBytes()     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x003f, all -> 0x003c }
        L_0x002c:
            int r0 = r4.read(r5)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            r1 = -1
            if (r0 == r1) goto L_0x0038
            r1 = 0
            r3.write(r5, r1, r0)     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            goto L_0x002c
        L_0x0038:
            r3.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x003c:
            r4 = move-exception
            r0 = r3
            goto L_0x0053
        L_0x003f:
            r4 = move-exception
            r0 = r3
            goto L_0x0045
        L_0x0042:
            r4 = move-exception
            goto L_0x0053
        L_0x0044:
            r4 = move-exception
        L_0x0045:
            r4.printStackTrace()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0052:
            return
        L_0x0053:
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.utils.FileUtil.writeJsonToFile(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static String readFromFile(File file) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        if (file == null) {
            return null;
        }
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file));
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[1024];
                while (inputStreamReader.read(cArr) != -1) {
                    sb.append(cArr);
                }
                String sb2 = sb.toString();
                C9266IO.safeClose(inputStreamReader);
                return sb2;
            } catch (FileNotFoundException unused) {
                C9266IO.safeClose(inputStreamReader);
                return null;
            } catch (IOException e) {
                e = e;
                try {
                    e.printStackTrace();
                    C9266IO.safeClose(inputStreamReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    C9266IO.safeClose(inputStreamReader2);
                    throw th;
                }
            }
        } catch (FileNotFoundException unused2) {
            inputStreamReader = null;
            C9266IO.safeClose(inputStreamReader);
            return null;
        } catch (IOException e2) {
            e = e2;
            inputStreamReader = null;
            e.printStackTrace();
            C9266IO.safeClose(inputStreamReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C9266IO.safeClose(inputStreamReader2);
            throw th;
        }
    }

    public static void addSuffix(String str) {
        File file;
        File file2 = new File(str);
        if (file2.exists()) {
            String[] list = file2.list();
            for (int i = 0; i < list.length; i++) {
                if (str.endsWith(File.separator)) {
                    file = new File(str + list[i]);
                } else {
                    file = new File(str + File.separator + list[i]);
                }
                if (file.isFile()) {
                    file.renameTo(new File(file.getAbsolutePath() + ".holiday"));
                }
            }
        }
    }

    public static String getAbsolutePath(String str, String str2) {
        return str + File.separator + str2;
    }
}
