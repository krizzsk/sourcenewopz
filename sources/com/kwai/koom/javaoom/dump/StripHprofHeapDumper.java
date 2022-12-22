package com.kwai.koom.javaoom.dump;

import android.os.Debug;
import com.kwai.koom.javaoom.KOOMEnableChecker;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import java.io.IOException;

public class StripHprofHeapDumper implements HeapDumper {

    /* renamed from: a */
    private static final String f55615a = "StripHprofHeapDumper";

    /* renamed from: b */
    private boolean f55616b;

    public native void hprofName(String str);

    public native void initStripDump();

    public native boolean isStripSuccess();

    public StripHprofHeapDumper() {
        boolean loadLib = KGlobalConfig.getSoLoader().loadLib("koom-java");
        this.f55616b = loadLib;
        if (loadLib) {
            initStripDump();
        }
    }

    public boolean dump(String str) {
        KLog.m40102i(f55615a, "dump " + str);
        if (!this.f55616b) {
            KLog.m40101e(f55615a, "dump failed caused by so not loaded!");
            return false;
        } else if (!KOOMEnableChecker.get().isVersionPermit()) {
            KLog.m40101e(f55615a, "dump failed caused by version net permitted!");
            return false;
        } else {
            try {
                hprofName(str);
                Debug.dumpHprofData(str);
                return isStripSuccess();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
