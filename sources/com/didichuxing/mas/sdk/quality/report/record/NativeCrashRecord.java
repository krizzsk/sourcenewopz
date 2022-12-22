package com.didichuxing.mas.sdk.quality.report.record;

import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.utils.FileType;
import java.io.File;

public class NativeCrashRecord extends CrashRecord {
    public NativeCrashRecord() {
        put("native", 1);
        put("native_sync_dmp", 0);
        setFileType(FileType.NATIVE_CRASH);
        put("dycplugin", CustomCollector.getPluginInfo());
    }

    public void setDumpFile(File file) {
        addFile(file);
    }

    public void markDumpAsSync() {
        put("native_sync_dmp", 1);
    }

    public void setLogFile(File file) {
        if (file != null && file.exists()) {
            put("log_from_native", 1);
            addFile(file);
        }
    }
}
