package com.didichuxing.afanty.common.collector;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.afanty.common.utils.CommonUtil;
import java.io.BufferedReader;
import java.io.FileReader;

public class MemoryCollector {

    /* renamed from: a */
    private static ActivityManager f45552a;

    public static void init(Context context) {
        f45552a = (ActivityManager) context.getSystemService("activity");
    }

    public static String getSysMemInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
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
        }
        return sb.toString();
    }

    public static String getMemInfo() {
        StringBuilder sb = new StringBuilder();
        if (f45552a == null) {
            return sb.toString();
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        f45552a.getMemoryInfo(memoryInfo);
        sb.append("isLowMem: ");
        sb.append(memoryInfo.lowMemory ? "yes" : LoginOmegaUtil.NO_EMAIL);
        sb.append("\n");
        sb.append("availMem: ");
        sb.append(CommonUtil.bytes4Human(memoryInfo.availMem));
        sb.append("\n");
        sb.append("threshold: ");
        sb.append(CommonUtil.bytes4Human(memoryInfo.threshold));
        sb.append("\n");
        if (CommonUtil.getAPILevel() >= 5) {
            Debug.MemoryInfo memoryInfo2 = f45552a.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
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
}
