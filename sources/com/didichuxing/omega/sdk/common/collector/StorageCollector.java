package com.didichuxing.omega.sdk.common.collector;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.didichuxing.omega.sdk.common.record.FileRecord;
import com.didichuxing.omega.sdk.common.utils.FileUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class StorageCollector {
    public static final long RESULT_ERROR = -1;
    private static Context mContext;
    public static File sExternalStorageDirectory;

    public static void init(Context context) {
        mContext = context;
        if (context != null) {
            sExternalStorageDirectory = context.getExternalFilesDir((String) null);
        }
    }

    public static long[] getExternalStorage() {
        long j;
        long j2;
        long j3;
        long[] jArr = {0, 0};
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && mContext != null) {
                StatFs statFs = new StatFs(mContext.getExternalFilesDir((String) null).getPath());
                if (Build.VERSION.SDK_INT >= 18) {
                    j2 = statFs.getBlockSizeLong();
                    j = statFs.getBlockCountLong();
                    j3 = statFs.getAvailableBlocksLong();
                } else {
                    j2 = (long) statFs.getBlockSize();
                    j = (long) statFs.getBlockCount();
                    j3 = (long) statFs.getAvailableBlocks();
                }
                jArr[0] = j * j2;
                jArr[1] = j2 * j3;
            }
        } catch (Throwable unused) {
        }
        return jArr;
    }

    public static long[] getDataBlockUsage() {
        long j;
        long j2;
        long j3;
        long[] jArr = {0, 0};
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                j2 = statFs.getBlockSizeLong();
                j = statFs.getBlockCountLong();
                j3 = statFs.getAvailableBlocksLong();
            } else {
                j2 = (long) statFs.getBlockSize();
                j = (long) statFs.getBlockCount();
                j3 = (long) statFs.getAvailableBlocks();
            }
            jArr[0] = j * j2;
            jArr[1] = j2 * j3;
        } catch (Throwable unused) {
        }
        return jArr;
    }

    public static long getAppInternalStorageSize(Context context) {
        File file;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                file = context.getDataDir();
            } else {
                String str = context.getApplicationInfo().dataDir;
                file = str != null ? new File(str) : null;
            }
            if (file == null) {
                file = context.getFilesDir().getParentFile();
            }
            if (file == null) {
                return -1;
            }
            if (file.exists()) {
                return FileUtil.sizeOf(file) + 0;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static long getAppExternalStorageSize(Context context) {
        File[] fileArr;
        long j = 0;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                fileArr = context.getExternalCacheDirs();
            } else {
                fileArr = new File[]{context.getExternalCacheDir()};
            }
            for (File file : fileArr) {
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && parentFile.exists()) {
                        j += FileUtil.sizeOf(parentFile);
                    }
                }
            }
            return j;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getAppSdCardStorageSize(Context context, String[] strArr) {
        if (strArr != null) {
            long j = 0;
            try {
                if (strArr.length != 0) {
                    if (!"mounted".equals(Environment.getExternalStorageState())) {
                        return -1;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        if (!(context.checkPermission(Permission.READ_EXTERNAL_STORAGE, Process.myPid(), Process.myUid()) == 0)) {
                            return -1;
                        }
                    }
                    for (String str : strArr) {
                        if (str != null) {
                            File ofFile = ofFile(context, str);
                            if (ofFile.exists()) {
                                j += FileUtil.sizeOf(ofFile);
                            }
                        }
                    }
                    return j;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static Map<String, Long> listAppFilesWithLength(final Context context, final int i, final String[] strArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
            ArrayList<FutureTask> arrayList = new ArrayList<>();
            FutureTask futureTask = new FutureTask(new Callable<Map<File, Long>>() {
                public Map<File, Long> call() throws Exception {
                    File file;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (Build.VERSION.SDK_INT >= 24) {
                        file = context.getDataDir();
                    } else {
                        String str = context.getApplicationInfo().dataDir;
                        file = str != null ? new File(str) : null;
                    }
                    if (file == null) {
                        file = context.getFilesDir().getParentFile();
                    }
                    if (file != null && file.exists()) {
                        linkedHashMap.putAll(FileUtil.listFilesWithLength(file, i));
                    }
                    return linkedHashMap;
                }
            });
            arrayList.add(futureTask);
            threadPoolExecutor.submit(futureTask);
            if ("mounted".equals(Environment.getExternalStorageState())) {
                FutureTask futureTask2 = new FutureTask(new Callable<Map<File, Long>>() {
                    public Map<File, Long> call() throws Exception {
                        File parentFile;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (File file : Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()}) {
                            if (!(file == null || (parentFile = file.getParentFile()) == null || !parentFile.exists())) {
                                linkedHashMap.putAll(FileUtil.listFilesWithLength(parentFile, i));
                            }
                        }
                        return linkedHashMap;
                    }
                });
                arrayList.add(futureTask2);
                threadPoolExecutor.submit(futureTask2);
                if (strArr != null && strArr.length > 0) {
                    FutureTask futureTask3 = new FutureTask(new Callable<Map<File, Long>>() {
                        public Map<File, Long> call() throws Exception {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (String str : strArr) {
                                if (str != null) {
                                    File ofFile = StorageCollector.ofFile(context, str);
                                    if (ofFile.exists()) {
                                        if (ofFile.isDirectory()) {
                                            linkedHashMap.putAll(FileUtil.listFilesWithLength(ofFile, i));
                                        } else {
                                            linkedHashMap.put(ofFile, Long.valueOf(ofFile.length()));
                                        }
                                    }
                                }
                            }
                            return linkedHashMap;
                        }
                    });
                    arrayList.add(futureTask3);
                    threadPoolExecutor.submit(futureTask3);
                }
            }
            for (FutureTask futureTask4 : arrayList) {
                try {
                    Map map = (Map) futureTask4.get();
                    if (map != null) {
                        linkedHashMap2.putAll(map);
                    }
                } catch (InterruptedException unused) {
                } catch (ExecutionException unused2) {
                    OLog.m34769w("StorageCollector listAppFilesWithLength failed!");
                }
            }
            for (File file : linkedHashMap2.keySet()) {
                linkedHashMap.put(getDisplayName(context, file), linkedHashMap2.get(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linkedHashMap;
    }

    public static String listAppFilesWithRecord(final Context context, final int i, final String[] strArr) {
        try {
            LinkedList linkedList = new LinkedList();
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) AsyncTask.THREAD_POOL_EXECUTOR;
            ArrayList<FutureTask> arrayList = new ArrayList<>();
            FutureTask futureTask = new FutureTask(new Callable<List<FileRecord>>() {
                public List<FileRecord> call() throws Exception {
                    File file;
                    LinkedList linkedList = new LinkedList();
                    if (Build.VERSION.SDK_INT >= 24) {
                        file = context.getDataDir();
                    } else {
                        String str = context.getApplicationInfo().dataDir;
                        file = str != null ? new File(str) : null;
                    }
                    if (file == null) {
                        file = context.getFilesDir().getParentFile();
                    }
                    if (file != null && file.exists()) {
                        linkedList.add(FileUtil.listFilesWithRecord(file, i));
                    }
                    return linkedList;
                }
            });
            arrayList.add(futureTask);
            threadPoolExecutor.submit(futureTask);
            if ("mounted".equals(Environment.getExternalStorageState())) {
                FutureTask futureTask2 = new FutureTask(new Callable<List<FileRecord>>() {
                    public List<FileRecord> call() throws Exception {
                        File parentFile;
                        LinkedList linkedList = new LinkedList();
                        for (File file : Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()}) {
                            if (!(file == null || (parentFile = file.getParentFile()) == null || !parentFile.exists())) {
                                linkedList.add(FileUtil.listFilesWithRecord(parentFile, i));
                            }
                        }
                        return linkedList;
                    }
                });
                arrayList.add(futureTask2);
                threadPoolExecutor.submit(futureTask2);
                if (strArr != null && strArr.length > 0) {
                    FutureTask futureTask3 = new FutureTask(new Callable<List<FileRecord>>() {
                        public List<FileRecord> call() throws Exception {
                            LinkedList linkedList = new LinkedList();
                            for (String str : strArr) {
                                if (str != null) {
                                    File ofFile = StorageCollector.ofFile(context, str);
                                    if (ofFile.exists()) {
                                        linkedList.add(FileUtil.listFilesWithRecord(ofFile, i));
                                    }
                                }
                            }
                            return linkedList;
                        }
                    });
                    arrayList.add(futureTask3);
                    threadPoolExecutor.submit(futureTask3);
                }
            }
            for (FutureTask futureTask4 : arrayList) {
                try {
                    List list = (List) futureTask4.get();
                    if (list != null) {
                        linkedList.addAll(list);
                    }
                } catch (InterruptedException unused) {
                } catch (ExecutionException unused2) {
                    OLog.m34769w("StorageCollector listAppFilesWithLength failed!");
                }
            }
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(linkedList);
            while (!linkedList2.isEmpty()) {
                FileRecord fileRecord = (FileRecord) linkedList2.pop();
                fileRecord.setDisplayPath(getDisplayName(context, fileRecord.getPath()));
                List<FileRecord> children = fileRecord.getChildren();
                if (children != null && !children.isEmpty()) {
                    linkedList2.addAll(children);
                }
            }
            return FileRecord.toJSONString(linkedList);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static long getAppTotalSize() {
        long j = 0;
        try {
            long appInternalStorageSize = getAppInternalStorageSize(mContext);
            long j2 = appInternalStorageSize >= 0 ? appInternalStorageSize + 0 : 0;
            try {
                long appExternalStorageSize = getAppExternalStorageSize(mContext);
                return appExternalStorageSize >= 0 ? j2 + appExternalStorageSize : j2;
            } catch (Exception unused) {
                j = j2;
                return j;
            }
        } catch (Exception unused2) {
            return j;
        }
    }

    public static String getDisplayName(Context context, File file) {
        String str;
        try {
            str = file.getAbsolutePath();
            try {
                String path = sExternalStorageDirectory.getPath();
                if (str.startsWith(path)) {
                    return str.replace(path, "/sdcard");
                }
                if (context == null) {
                    return str;
                }
                String parent = context.getFilesDir().getParentFile().getParent();
                if (str.startsWith(parent)) {
                    return str.replace(parent, "/data/data");
                }
                return str;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
            e.printStackTrace();
            return str;
        }
    }

    public static File ofFile(Context context, String str) {
        File file = new File("");
        try {
            String trim = str.trim();
            String path = sExternalStorageDirectory.getPath();
            if (trim.startsWith("/sdcard")) {
                trim = trim.replace("/sdcard", path);
            } else if (context != null) {
                if (trim.startsWith("/appexternal")) {
                    trim = trim.replace("/appexternal", FileUtil.buildPath(sExternalStorageDirectory, "Android", "data", context.getPackageName()).getPath());
                } else {
                    String parent = context.getFilesDir().getParent();
                    if (trim.startsWith("/appinternal")) {
                        trim = trim.replace("/appinternal", parent);
                    }
                }
            }
            return new File(trim);
        } catch (Exception e) {
            e.printStackTrace();
            return file;
        }
    }
}
