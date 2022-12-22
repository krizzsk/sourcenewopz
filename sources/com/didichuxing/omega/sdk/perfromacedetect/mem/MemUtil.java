package com.didichuxing.omega.sdk.perfromacedetect.mem;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MemUtil {
    public static String trans2FreeAndTotalMem(long[] jArr) {
        return (jArr[1] + jArr[2] + jArr[3]) + "M/" + jArr[0] + "M";
    }

    public static long[] getPrivDirty(Context context, int i) {
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{i});
            Debug.MemoryInfo memoryInfo = (processMemoryInfo == null || processMemoryInfo.length <= 0) ? null : processMemoryInfo[0];
            if (memoryInfo != null) {
                return new long[]{(long) memoryInfo.nativePrivateDirty, (long) memoryInfo.dalvikPrivateDirty, (long) memoryInfo.getTotalPrivateDirty()};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static long getCurrentProcessMemUsage(Context context, int i) {
        long[] privDirty = getPrivDirty(context, i);
        if (privDirty == null || privDirty.length <= 0) {
            return 0;
        }
        return privDirty[1] / 1024;
    }

    public static long[] getPSS(Context context, int i) {
        long[] jArr = new long[3];
        if (i >= 0) {
            Debug.MemoryInfo memoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{i})[0];
            jArr[0] = (long) memoryInfo.nativePss;
            jArr[1] = (long) memoryInfo.dalvikPss;
            jArr[2] = (long) memoryInfo.getTotalPss();
        } else {
            jArr[0] = 0;
            jArr[1] = 0;
            jArr[2] = 0;
        }
        return jArr;
    }

    public static long[] getHeapNative() {
        return new long[]{Debug.getNativeHeapSize() >> 10, Debug.getNativeHeapAllocatedSize() >> 10};
    }

    public static long[] getHeapDalvik() {
        long[] jArr = {Runtime.getRuntime().totalMemory() >> 10, (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 10};
        long[] heapNative = getHeapNative();
        return new long[]{jArr[0] - heapNative[0], jArr[1] - heapNative[1]};
    }

    public static long[] getVM() {
        return new long[]{(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 10, Runtime.getRuntime().totalMemory() >> 10, Debug.getNativeHeapAllocatedSize() >> 10, Debug.getNativeHeapSize() >> 10, (long) (Debug.getGlobalAllocSize() >> 10)};
    }

    public static int getAppProcessMaxMem(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        } catch (Exception e) {
            Tracker.trackGood("getAppProcessMaxMem error!", e);
            return -1;
        }
    }

    public static float getProccessMemUsage(Context context, int i) {
        try {
            return roundByDownMode(((float) getCurrentProcessMemUsage(context, i)) / ((float) getAppProcessMaxMem(context)), 2) * 100.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static float roundByDownMode(float f, int i) {
        if (Float.isNaN(f)) {
            f = 0.0f;
        }
        return roundByMode(f, i, RoundingMode.DOWN).floatValue();
    }

    public static BigDecimal roundByMode(float f, int i, RoundingMode roundingMode) {
        return new BigDecimal((double) f).setScale(i, roundingMode);
    }
}
