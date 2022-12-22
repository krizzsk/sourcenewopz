package com.didichuxing.mas.sdk.quality.report.utils;

import android.content.Context;
import android.net.LocalSocket;
import android.os.Build;
import android.os.Environment;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.record.FileRecord;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FileUtil {
    public static final String separator = "/";

    public static File getFileDir(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            if (Build.VERSION.SDK_INT <= 28) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                file = Environment.getExternalStoragePublicDirectory(str);
            } else if (context != null) {
                if (TextUtils.isEmpty(str)) {
                    str = null;
                }
                file = context.getExternalFilesDir(str);
            }
        } else if (context != null) {
            File filesDir = context.getFilesDir();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            file = new File(filesDir, str);
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean isPath(String str) {
        return str.contains("/") || str.contains("\\");
    }

    public static String getPath(String str) {
        return str.substring(0, str.lastIndexOf("/"));
    }

    public static boolean delFileOnExist(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        return file.delete();
    }

    public static void delExistFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void closeReader(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeFileChannel(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRandomAccessFile(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void colseSocket(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void colseLocalSocket(LocalSocket localSocket) {
        if (localSocket != null) {
            try {
                localSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return file.delete();
                }
                for (File deleteFile : listFiles) {
                    if (!deleteFile(deleteFile)) {
                        return false;
                    }
                }
                return file.delete();
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.nio.channels.FileChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyFile(java.io.File r9, java.io.File r10) {
        /*
            r0 = 0
            boolean r1 = r10.exists()     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
            if (r1 != 0) goto L_0x000a
            r10.createNewFile()     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
        L_0x000a:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            r9.<init>(r10)     // Catch:{ IOException -> 0x0050, all -> 0x004c }
            java.nio.channels.FileChannel r10 = r1.getChannel()     // Catch:{ IOException -> 0x0046, all -> 0x0040 }
            java.nio.channels.FileChannel r0 = r9.getChannel()     // Catch:{ IOException -> 0x003a, all -> 0x0034 }
            r3 = 0
            long r5 = r10.size()     // Catch:{ IOException -> 0x003a, all -> 0x0034 }
            r2 = r10
            r7 = r0
            r2.transferTo(r3, r5, r7)     // Catch:{ IOException -> 0x003a, all -> 0x0034 }
            closeOutputStream(r9)
            closeInputStream(r1)
            closeFileChannel(r10)
            closeFileChannel(r0)
            goto L_0x006c
        L_0x0034:
            r2 = move-exception
            r8 = r0
            r0 = r9
            r9 = r2
            r2 = r8
            goto L_0x006e
        L_0x003a:
            r2 = move-exception
            r8 = r0
            r0 = r9
            r9 = r2
            r2 = r8
            goto L_0x005d
        L_0x0040:
            r10 = move-exception
            r2 = r0
            r0 = r9
            r9 = r10
            r10 = r2
            goto L_0x006e
        L_0x0046:
            r10 = move-exception
            r2 = r0
            r0 = r9
            r9 = r10
            r10 = r2
            goto L_0x005d
        L_0x004c:
            r9 = move-exception
            r10 = r0
            r2 = r10
            goto L_0x006e
        L_0x0050:
            r9 = move-exception
            r10 = r0
            r2 = r10
            goto L_0x005d
        L_0x0054:
            r9 = move-exception
            r10 = r0
            r1 = r10
            r2 = r1
            goto L_0x006e
        L_0x0059:
            r9 = move-exception
            r10 = r0
            r1 = r10
            r2 = r1
        L_0x005d:
            r9.printStackTrace()     // Catch:{ all -> 0x006d }
            closeOutputStream(r0)
            closeInputStream(r1)
            closeFileChannel(r10)
            closeFileChannel(r2)
        L_0x006c:
            return
        L_0x006d:
            r9 = move-exception
        L_0x006e:
            closeOutputStream(r0)
            closeInputStream(r1)
            closeFileChannel(r10)
            closeFileChannel(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.utils.FileUtil.copyFile(java.io.File, java.io.File):void");
    }

    public static void copyInputToFile(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            byte[] bArr = new byte[10240];
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    closeOutputStream(fileOutputStream2);
                    closeInputStream(bufferedInputStream);
                    closeInputStream(inputStream);
                } catch (Throwable th) {
                    th = th;
                    closeOutputStream(fileOutputStream2);
                    closeInputStream(bufferedInputStream);
                    closeInputStream(inputStream);
                    throw th;
                }
            }
            try {
                for (int read = bufferedInputStream.read(bArr, 0, 10240); read != -1; read = bufferedInputStream.read(bArr, 0, 10240)) {
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                closeOutputStream(fileOutputStream);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                closeOutputStream(fileOutputStream2);
                closeInputStream(bufferedInputStream);
                closeInputStream(inputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                closeOutputStream(fileOutputStream2);
                closeInputStream(bufferedInputStream);
                closeInputStream(inputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
            e.printStackTrace();
            closeOutputStream(fileOutputStream2);
            closeInputStream(bufferedInputStream);
            closeInputStream(inputStream);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            closeOutputStream(fileOutputStream2);
            closeInputStream(bufferedInputStream);
            closeInputStream(inputStream);
            throw th;
        }
        closeInputStream(bufferedInputStream);
        closeInputStream(inputStream);
    }

    public static long sizeOf(File file) {
        long j = 0;
        try {
            if (!file.exists()) {
                file + " does not exist";
                return 0;
            } else if (!file.isDirectory()) {
                return file.length();
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.push(file);
                while (!linkedList.isEmpty()) {
                    File[] listFiles = ((File) linkedList.pop()).listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (!file2.isDirectory()) {
                                j += file2.length();
                            } else {
                                linkedList.push(file2);
                            }
                        }
                    }
                }
                return j;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<File, Long> listFilesWithLength(File file, int i) {
        List<File> list;
        File[] listFiles;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        File[] listFiles2 = file.listFiles();
        if (listFiles2 != null && listFiles2.length > 0) {
            arrayList.addAll(Arrays.asList(listFiles2));
            if (i > 0) {
                linkedList.push(arrayList);
            }
            int i2 = i;
            while (true) {
                i2--;
                if (i2 <= 0 || (list = (List) linkedList.peek()) == null) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList();
                for (File file2 : list) {
                    if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                        arrayList2.addAll(Arrays.asList(listFiles));
                    }
                }
                if (arrayList2.isEmpty()) {
                    break;
                }
                linkedList.push(arrayList2);
            }
            HashMap hashMap = new HashMap();
            int i3 = i;
            while (!linkedList.isEmpty()) {
                for (File file3 : (List) linkedList.pop()) {
                    long j = 0;
                    if (i3 == i) {
                        j = sizeOf(file3);
                    } else if (file3.isDirectory()) {
                        File[] listFiles3 = file3.listFiles();
                        if (listFiles3 != null) {
                            for (File file4 : listFiles3) {
                                j += ((Long) hashMap.get(file4)).longValue();
                            }
                        }
                    } else {
                        j = file3.length();
                    }
                    hashMap.put(file3, Long.valueOf(j));
                    linkedHashMap.put(file3, Long.valueOf(j));
                }
                i3--;
            }
        }
        return linkedHashMap;
    }

    public static FileRecord listFilesWithRecord(File file, int i) {
        List<FileRecord> list;
        if (!file.isDirectory()) {
            FileRecord fileRecord = new FileRecord(file, false);
            fileRecord.setSize(file.length());
            return fileRecord;
        }
        FileRecord fileRecord2 = new FileRecord(file, true);
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(fileRecord2);
        if (i > 0) {
            linkedList.push(arrayList);
        }
        int i2 = i;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0 || (list = (List) linkedList.peek()) == null) {
                break;
            }
            ArrayList arrayList2 = new ArrayList();
            for (FileRecord fileRecord3 : list) {
                File path = fileRecord3.getPath();
                if (path.isDirectory()) {
                    File[] listFiles = path.listFiles();
                    ArrayList arrayList3 = new ArrayList();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            FileRecord fileRecord4 = new FileRecord(file2, file2.isDirectory());
                            fileRecord4.setParent(fileRecord3);
                            arrayList3.add(fileRecord4);
                        }
                    }
                    fileRecord3.setChildren(arrayList3);
                    arrayList2.addAll(arrayList3);
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            linkedList.push(arrayList2);
            i2 = i3;
        }
        HashMap hashMap = new HashMap();
        int i4 = i;
        while (!linkedList.isEmpty()) {
            for (FileRecord fileRecord5 : (List) linkedList.pop()) {
                long j = 0;
                File path2 = fileRecord5.getPath();
                if (i4 == i) {
                    j = sizeOf(path2);
                } else if (path2.isDirectory()) {
                    File[] listFiles2 = path2.listFiles();
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            j += ((Long) hashMap.get(file3)).longValue();
                        }
                    }
                } else {
                    j = path2.length();
                }
                fileRecord5.setSize(j);
                hashMap.put(path2, Long.valueOf(j));
            }
            i4--;
        }
        return fileRecord2;
    }

    public static void cleanFiles(List<File> list) {
        File[] listFiles;
        if (list != null && !list.isEmpty()) {
            for (File next : list) {
                if (next.exists()) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    linkedList.push(next);
                    while (!linkedList.isEmpty()) {
                        File file = (File) linkedList.pop();
                        linkedList2.push(file);
                        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                            for (File push : listFiles) {
                                linkedList.push(push);
                            }
                        }
                    }
                    Iterator it = linkedList2.iterator();
                    while (it.hasNext()) {
                        ((File) it.next()).delete();
                        it.remove();
                    }
                }
            }
        }
    }

    public static void cleanFilesWithoutRecentUsed(List<File> list, long j) {
        File[] listFiles;
        if (list != null && !list.isEmpty()) {
            for (File next : list) {
                if (next.exists()) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    linkedList.push(next);
                    while (!linkedList.isEmpty()) {
                        File file = (File) linkedList.pop();
                        linkedList2.push(file);
                        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                            for (File push : listFiles) {
                                linkedList.push(push);
                            }
                        }
                    }
                    Iterator it = linkedList2.iterator();
                    while (it.hasNext()) {
                        deleteFileWithoutRecentUsed((File) it.next(), j);
                        it.remove();
                    }
                }
            }
        }
    }

    public static void cleanFilesRarelyUsed(List<File> list, long j) {
        File[] listFiles;
        if (list != null && !list.isEmpty()) {
            for (File next : list) {
                if (next.exists()) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    linkedList.push(next);
                    while (!linkedList.isEmpty()) {
                        File file = (File) linkedList.pop();
                        linkedList2.push(file);
                        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                            for (File push : listFiles) {
                                linkedList.push(push);
                            }
                        }
                    }
                    Iterator it = linkedList2.iterator();
                    while (it.hasNext()) {
                        deleteFileRarelyUsed((File) it.next(), j);
                        it.remove();
                    }
                }
            }
        }
    }

    public static void cleanFilesWithNameMatched(List<File> list) {
        if (list != null && !list.isEmpty()) {
            for (File next : list) {
                File parentFile = next.getParentFile();
                if (parentFile != null) {
                    final String name = next.getName();
                    File[] listFiles = parentFile.listFiles(new FileFilter() {
                        public boolean accept(File file) {
                            String name = file.getName();
                            return name.matches(name) || FilenameUtils.wildcardMatch(name, name);
                        }
                    });
                    if (listFiles != null && listFiles.length > 0) {
                        for (File deleteFile : listFiles) {
                            deleteFile(deleteFile);
                        }
                    }
                }
            }
        }
    }

    private static void deleteFileWithoutRecentUsed(File file, long j) {
        long lastModified = file.lastModified();
        if (lastModified > 0 && System.currentTimeMillis() - lastModified >= j) {
            file.delete();
        }
    }

    private static void deleteFileRarelyUsed(File file, long j) {
        long lastModified = file.lastModified();
        if (lastModified > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 21) {
                long atime = OsStat.atime(file.getAbsolutePath()) * 1000;
                if (atime <= 0) {
                    atime = lastModified;
                }
                long abs = Math.abs(currentTimeMillis - Math.max(lastModified, atime));
                if (abs >= j && abs <= TimeUnit.DAYS.toMillis(1095)) {
                    file.delete();
                }
            } else if (currentTimeMillis - lastModified >= j) {
                file.delete();
            }
        }
    }

    public static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (file == null) {
                file = new File(str);
            } else {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static class OsStat {
        private OsStat() {
        }

        static long atime(String str) {
            try {
                return Os.stat(str).st_atime;
            } catch (ErrnoException unused) {
                return -1;
            }
        }
    }
}
