package com.didichuxing.alpha.crash;

import android.os.Debug;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didichuxing.omega.sdk.common.record.CrashRecord;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.utils.Constants;
import com.didichuxing.omega.sdk.common.utils.ZipUtil;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class OutOfMemoryDumper {
    public static void handleException(Thread thread, Throwable th, CrashRecord crashRecord) {
        if (checkIfOOM(th)) {
            File file = new File(RecordStorage.getRecordCacheDir(), "oom_" + crashRecord.getRecordId() + ".hprof");
            String absolutePath = file.getAbsolutePath();
            String str = absolutePath + PmFileConstant.ZIP_SUFFIX;
            try {
                long nanoTime = System.nanoTime();
                Debug.dumpHprofData(absolutePath);
                long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
                long nanoTime3 = System.nanoTime();
                ZipUtil.zip(new String[]{absolutePath}, str);
                long nanoTime4 = (System.nanoTime() - nanoTime3) / 1000000;
                new File(str).renameTo(new File(RecordStorage.getRecordCacheDir(), Constants.FILE_OOM_HPROF_PREFIX + System.currentTimeMillis() + "_" + crashRecord.getRecordId() + "_" + crashRecord.getSeq()));
                if (!file.exists()) {
                    return;
                }
            } catch (Throwable th2) {
                if (file.exists()) {
                    file.delete();
                }
                throw th2;
            }
            file.delete();
        }
    }

    private static boolean checkIfOOM(Throwable th) {
        while (th != null) {
            if (th.getClass().equals(OutOfMemoryError.class)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static List<File> getOomHprofList() {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = RecordStorage.getRecordCacheDir().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().startsWith(Constants.FILE_OOM_HPROF_PREFIX)) {
                    linkedList.add(file);
                }
            }
        }
        return linkedList;
    }
}
