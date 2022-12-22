package com.didichuxing.omega.sdk.common.record;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import java.io.File;

public class NativeCrashRecord extends CrashRecord {
    public NativeCrashRecord() {
        put("native", 1);
        put("native_sync_dmp", 0);
        if (OmegaConfig.PLUGIN_INFO != null) {
            put("dycplugin", OmegaConfig.PLUGIN_INFO);
        } else {
            put("dycplugin", "{}");
        }
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
