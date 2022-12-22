package com.kwai.koom.javaoom.dump;

import android.os.Build;
import android.os.Debug;
import com.kwai.koom.javaoom.KOOMEnableChecker;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import java.io.IOException;

public class ForkJvmHeapDumper implements HeapDumper {
    private static final String TAG = "ForkJvmHeapDumper";
    private boolean soLoaded;

    public static native boolean dumpHprofDataNative(String str);

    private native void exitProcess();

    private native void initForkDump();

    private native void resumeVM();

    private native int trySuspendVMThenFork();

    private native void waitPid(int i);

    public ForkJvmHeapDumper() {
        boolean loadLib = KGlobalConfig.getSoLoader().loadLib("koom-java");
        this.soLoaded = loadLib;
        if (loadLib) {
            initForkDump();
        }
    }

    public boolean dump(String str) {
        KLog.m40102i(TAG, "dump " + str);
        if (!this.soLoaded) {
            KLog.m40101e(TAG, "dump failed caused by so not loaded!");
            return false;
        } else if (!KOOMEnableChecker.get().isVersionPermit()) {
            KLog.m40101e(TAG, "dump failed caused by version not permitted!");
            return false;
        } else if (!KOOMEnableChecker.get().isSpaceEnough()) {
            KLog.m40101e(TAG, "dump failed caused by disk space not enough!");
            return false;
        } else if (Build.VERSION.SDK_INT > 29) {
            return dumpHprofDataNative(str);
        } else {
            try {
                int trySuspendVMThenFork = trySuspendVMThenFork();
                if (trySuspendVMThenFork == 0) {
                    Debug.dumpHprofData(str);
                    KLog.m40102i(TAG, "notifyDumped:" + false);
                    exitProcess();
                    return false;
                }
                resumeVM();
                boolean waitDumping = waitDumping(trySuspendVMThenFork);
                KLog.m40102i(TAG, "hprof pid:" + trySuspendVMThenFork + " dumped: " + str);
                return waitDumping;
            } catch (IOException e) {
                e.printStackTrace();
                KLog.m40101e(TAG, "dump failed caused by IOException!");
                return false;
            }
        }
    }

    private boolean waitDumping(int i) {
        waitPid(i);
        return true;
    }
}
