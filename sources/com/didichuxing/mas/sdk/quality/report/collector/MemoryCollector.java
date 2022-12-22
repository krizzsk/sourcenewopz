package com.didichuxing.mas.sdk.quality.report.collector;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.BufferedReader;
import java.io.FileReader;

public class MemoryCollector {
    private static ActivityManager mActMgr;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        if (context != null) {
            mActMgr = (ActivityManager) context.getSystemService("activity");
        }
    }

    public static String getSysMemInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
                i = i2;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable unused) {
            OLog.m34424w("getSysMemInfo fail.");
        }
        return sb.toString();
    }

    public static String getMemInfo() {
        StringBuilder sb = new StringBuilder();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = mActMgr;
        if (activityManager == null) {
            return "";
        }
        activityManager.getMemoryInfo(memoryInfo);
        sb.append("isLowMem: ");
        sb.append(memoryInfo.lowMemory ? "yes" : LoginOmegaUtil.NO_EMAIL);
        sb.append("\n");
        sb.append("availMem: ");
        sb.append(CommonUtil.bytes4Human(memoryInfo.availMem));
        sb.append("\n");
        sb.append("threshold: ");
        sb.append(CommonUtil.bytes4Human(memoryInfo.threshold));
        sb.append("\n");
        sb.append("appMaxHeap: ");
        sb.append(getAppProcessMaxMem() + "M");
        sb.append("\n");
        if (CommonUtil.getAPILevel() >= 5) {
            Debug.MemoryInfo[] processMemoryInfo = mActMgr.getProcessMemoryInfo(new int[]{Process.myPid()});
            Debug.MemoryInfo memoryInfo2 = (processMemoryInfo == null || processMemoryInfo.length <= 0) ? null : processMemoryInfo[0];
            if (memoryInfo2 != null) {
                sb.append("totalPrivateDirty: ");
                sb.append(CommonUtil.bytes4Human(((long) memoryInfo2.getTotalPrivateDirty()) * 1024));
                sb.append("\n");
                sb.append("totalPss: ");
                sb.append(CommonUtil.bytes4Human(((long) memoryInfo2.getTotalPss()) * 1024));
                sb.append("\n");
                sb.append("totalSharedDirty: ");
                sb.append(CommonUtil.bytes4Human(((long) memoryInfo2.getTotalSharedDirty()) * 1024));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String getAppStatusInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            int myPid = Process.myPid();
            FileReader fileReader = new FileReader("/proc/" + myPid + "/status");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable unused) {
            OLog.m34424w("getSysMemInfo fail.");
        }
        return sb.toString();
    }

    public static int getAppProcessMaxMem() {
        try {
            return ((ActivityManager) mContext.getSystemService("activity")).getMemoryClass();
        } catch (Exception e) {
            Tracker.trackGood("getAppProcessMaxMem error!", e);
            return -1;
        }
    }
}
