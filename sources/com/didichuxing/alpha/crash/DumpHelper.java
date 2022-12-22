package com.didichuxing.alpha.crash;

import android.content.Context;
import android.os.Debug;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.dimina.container.util.TraceUtil;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class DumpHelper {
    public static String SPECIAL_EXCEPTIONS = "OutOfMemoryError";
    private static List<String> specialList = new ArrayList();

    public static File getDumpFileDirectory(Context context) {
        File file = new File(context.getCacheDir(), "hprof");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File getDumpFile(Context context, String str) {
        File dumpFileDirectory = getDumpFileDirectory(context);
        return new File(dumpFileDirectory, str + ".hprof");
    }

    public static boolean isNeedDump(Throwable th) {
        if (OmegaConfig.SWITCH_UPLOAD_OOM_DUMP && th != null && specialList.size() > 0) {
            int size = specialList.size();
            for (int i = 0; i < size; i++) {
                if (isSpecialException(th, specialList.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSpecialException(Throwable th, String str) {
        while (th != null) {
            if (th.getClass().getName().contains(str)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void uploadHprofIfNeeded(Context context) {
        String[] list;
        if (OmegaConfig.SWITCH_UPLOAD_OOM_DUMP) {
            File dumpFileDirectory = getDumpFileDirectory(context);
            if (!dumpFileDirectory.isDirectory() || ((list = dumpFileDirectory.list()) != null && list.length >= 1)) {
                UploadDumpService.startUploadService(context, OmegaConfig.VALIDITY_PERIOD_DUMP_FILE, OmegaConfig.SIZE_DIVIDE_DUMP_FILE, OmegaConfig.SWITCH_UPLOAD_HPROF);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zipFile(java.io.File r8, java.io.File r9) throws java.io.IOException {
        /*
            if (r9 == 0) goto L_0x0095
            if (r8 == 0) goto L_0x0095
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x000d
            r9.delete()
        L_0x000d:
            boolean r0 = r9.exists()
            if (r0 != 0) goto L_0x0016
            r9.createNewFile()
        L_0x0016:
            r0 = 0
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0088 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x0088 }
            r3.<init>(r8)     // Catch:{ all -> 0x0088 }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0084 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0084 }
            r5.<init>(r9)     // Catch:{ all -> 0x0084 }
            r4.<init>(r5)     // Catch:{ all -> 0x0084 }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0082 }
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0082 }
            java.lang.String r6 = r8.getName()     // Catch:{ all -> 0x0082 }
            r5.<init>(r6)     // Catch:{ all -> 0x0082 }
            r4.putNextEntry(r5)     // Catch:{ all -> 0x0082 }
        L_0x003a:
            int r5 = r3.read(r0)     // Catch:{ all -> 0x0082 }
            r6 = -1
            if (r5 == r6) goto L_0x0049
            r6 = 0
            r4.write(r0, r6, r5)     // Catch:{ all -> 0x0082 }
            r4.flush()     // Catch:{ all -> 0x0082 }
            goto L_0x003a
        L_0x0049:
            com.didichuxing.omega.sdk.common.record.Event r0 = new com.didichuxing.omega.sdk.common.record.Event     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "OMGUploadHprof"
            r0.<init>(r5)     // Catch:{ all -> 0x0082 }
            java.lang.String r5 = "tl"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0082 }
            long r6 = r6 - r1
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0082 }
            r0.putAttr(r5, r1)     // Catch:{ all -> 0x0082 }
            java.lang.String r1 = "bsz"
            long r5 = r8.length()     // Catch:{ all -> 0x0082 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0082 }
            r0.putAttr(r1, r8)     // Catch:{ all -> 0x0082 }
            java.lang.String r8 = "asz"
            long r1 = r9.length()     // Catch:{ all -> 0x0082 }
            java.lang.String r9 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0082 }
            r0.putAttr(r8, r9)     // Catch:{ all -> 0x0082 }
            com.didichuxing.omega.sdk.analysis.Tracker.trackEvent((com.didichuxing.omega.sdk.common.record.Event) r0)     // Catch:{ all -> 0x0082 }
            r3.close()
            r4.close()
            return
        L_0x0082:
            r8 = move-exception
            goto L_0x0086
        L_0x0084:
            r8 = move-exception
            r4 = r0
        L_0x0086:
            r0 = r3
            goto L_0x008a
        L_0x0088:
            r8 = move-exception
            r4 = r0
        L_0x008a:
            if (r0 == 0) goto L_0x008f
            r0.close()
        L_0x008f:
            if (r4 == 0) goto L_0x0094
            r4.close()
        L_0x0094:
            throw r8
        L_0x0095:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "zipFile or srcFile is null!"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.alpha.crash.DumpHelper.zipFile(java.io.File, java.io.File):void");
    }

    public static String[] divideBigFile(File file, long j) throws Exception {
        if (!file.exists() || !file.isFile()) {
            throw new Exception("dump file not exists!");
        }
        File parentFile = file.getParentFile();
        long length = file.length();
        long j2 = j <= 0 ? OmegaConfig.DEFAULT_SIZE_DIVIDE_HPROF : j;
        int ceil = (int) Math.ceil((((double) length) * 1.0d) / ((double) j2));
        String str = file.getName().split(PmFileConstant.ZIP_SUFFIX)[0];
        String[] strArr = new String[ceil];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[8192];
        RandomAccessFile randomAccessFile2 = null;
        int i = 0;
        while (i < ceil) {
            int i2 = i + 1;
            String[] strArr2 = strArr;
            long min = Math.min(((long) i2) * j2, length);
            long j3 = length;
            String absolutePath = parentFile.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            File file2 = parentFile;
            sb.append("--");
            sb.append(i2);
            sb.append("_");
            sb.append(ceil);
            sb.append(".temp");
            File file3 = new File(absolutePath, sb.toString());
            RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
            randomAccessFile.seek(((long) i) * j2);
            while (true) {
                int read = randomAccessFile.read(bArr);
                if (read == -1 || randomAccessFile.getFilePointer() > min) {
                    strArr2[i] = file3.getAbsolutePath();
                    strArr = strArr2;
                    i = i2;
                    length = j3;
                    randomAccessFile2 = randomAccessFile3;
                    parentFile = file2;
                } else {
                    randomAccessFile3.write(bArr, 0, read);
                }
            }
            strArr2[i] = file3.getAbsolutePath();
            strArr = strArr2;
            i = i2;
            length = j3;
            randomAccessFile2 = randomAccessFile3;
            parentFile = file2;
        }
        String[] strArr3 = strArr;
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
        randomAccessFile.close();
        return strArr3;
    }

    public static void addSpecialList(String str) {
        specialList.add(str);
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static boolean deleteDirectory(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                z = deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = deleteDirectory(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        if (!z) {
            return false;
        }
        return file.delete();
    }

    public static void dumpHprofFile(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Event event = new Event("OMGDumpHprof");
        event.putAttr("msgid", str);
        event.putAttr("tl", Integer.valueOf(TraceUtil.MINA_INDEX_UN_KNOW));
        Tracker.trackEvent(event);
        try {
            Debug.dumpHprofData(getDumpFile(context, str).getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Event event2 = new Event("OMGDumpHprof");
        event2.putAttr("msgid", str);
        event2.putAttr("tl", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        Tracker.trackEvent(event2);
    }
}
