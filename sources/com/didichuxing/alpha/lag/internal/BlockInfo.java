package com.didichuxing.alpha.lag.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.alpha.lag.BlockCanaryInternals;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class BlockInfo {
    public static final String KEY_API = "api-level";
    public static final String KEY_CPU_BUSY = "cpu-busy";
    public static final String KEY_CPU_CORE = "cpu-core";
    public static final String KEY_CPU_RATE = "cpu-rate";
    public static final String KEY_FREE_MEMORY = "freeMemory";
    public static final String KEY_MODEL = "model";
    public static final String KEY_NETWORK = "network";
    public static final String KEY_PROCESS = "process";
    public static final String KEY_QUA = "qua";
    public static final String KEY_STACK = "stack";
    public static final String KEY_THREAD_TIME_COST = "thread-time";
    public static final String KEY_TIME_COST = "time";
    public static final String KEY_TIME_COST_END = "time-end";
    public static final String KEY_TIME_COST_START = "time-start";
    public static final String KEY_TOTAL_MEMORY = "totalMemory";
    public static final String KEY_UID = "uid";
    public static final String KEY_VERSION_CODE = "versionCode";
    public static final String KEY_VERSION_NAME = "versionName";

    /* renamed from: KV */
    public static final String f45572KV = " = ";
    public static final String NEW_INSTANCE_METHOD = "newInstance: ";
    public static final String SEPARATOR = "\r\n";
    private static final String TAG = "BlockInfo";
    public static final SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String sApiLevel;
    public static int sCpuCoreNum;
    public static String sModel = Build.MODEL;
    public static String sQualifier = BlockCanaryInternals.getContext().provideQualifier();
    public String apiLevel = "";
    private StringBuilder basicSb = new StringBuilder();
    public boolean cpuBusy;
    public int cpuCoreNum = -1;
    public String cpuRateInfo;
    private StringBuilder cpuSb = new StringBuilder();
    public String freeMemory;
    public String model;
    public String network;
    public String processName;
    public String qualifier;
    private StringBuilder stackSb = new StringBuilder();
    public ArrayList<String> threadStackEntries = new ArrayList<>();
    public long threadTimeCost;
    public long timeCost;
    public String timeEnd;
    private StringBuilder timeSb = new StringBuilder();
    public String timeStart;
    public String totalMemory;
    public String uid;
    public int versionCode;
    public String versionName = "";

    static {
        sApiLevel = "";
        sCpuCoreNum = -1;
        sCpuCoreNum = PerformanceUtils.getNumCores();
        sApiLevel = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static BlockInfo newInstance() {
        BlockInfo blockInfo = new BlockInfo();
        Context provideContext = BlockCanaryInternals.getContext().provideContext();
        String str = blockInfo.versionName;
        if (str == null || str.length() == 0) {
            try {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(provideContext.getPackageManager(), provideContext.getPackageName(), 0);
                blockInfo.versionCode = packageInfo.versionCode;
                blockInfo.versionName = packageInfo.versionName;
            } catch (Throwable th) {
                SystemUtils.log(6, TAG, "newInstance: ", th, "com.didichuxing.alpha.lag.internal.BlockInfo", 133);
            }
        }
        blockInfo.cpuCoreNum = sCpuCoreNum;
        blockInfo.model = sModel;
        blockInfo.apiLevel = sApiLevel;
        blockInfo.qualifier = sQualifier;
        blockInfo.uid = BlockCanaryInternals.getContext().provideUid();
        blockInfo.processName = ProcessUtils.myProcessName();
        blockInfo.network = BlockCanaryInternals.getContext().provideNetworkType();
        blockInfo.freeMemory = String.valueOf(PerformanceUtils.getFreeMemory());
        blockInfo.totalMemory = String.valueOf(PerformanceUtils.getTotalMemory());
        return blockInfo;
    }

    public BlockInfo setCpuBusyFlag(boolean z) {
        this.cpuBusy = z;
        return this;
    }

    public BlockInfo setRecentCpuRate(String str) {
        this.cpuRateInfo = str;
        return this;
    }

    public BlockInfo setThreadStackEntries(ArrayList<String> arrayList) {
        this.threadStackEntries = arrayList;
        return this;
    }

    public BlockInfo setMainThreadTimeCost(long j, long j2, long j3, long j4) {
        this.timeCost = j2 - j;
        this.threadTimeCost = j4 - j3;
        this.timeStart = TIME_FORMATTER.format(Long.valueOf(j));
        this.timeEnd = TIME_FORMATTER.format(Long.valueOf(j2));
        return this;
    }

    public BlockInfo flushString() {
        StringBuilder sb = this.basicSb;
        sb.append("qua");
        sb.append(" = ");
        sb.append(this.qualifier);
        sb.append("\r\n");
        StringBuilder sb2 = this.basicSb;
        sb2.append("versionName");
        sb2.append(" = ");
        sb2.append(this.versionName);
        sb2.append("\r\n");
        StringBuilder sb3 = this.basicSb;
        sb3.append("versionCode");
        sb3.append(" = ");
        sb3.append(this.versionCode);
        sb3.append("\r\n");
        StringBuilder sb4 = this.basicSb;
        sb4.append("uid");
        sb4.append(" = ");
        sb4.append(this.uid);
        sb4.append("\r\n");
        StringBuilder sb5 = this.basicSb;
        sb5.append("network");
        sb5.append(" = ");
        sb5.append(this.network);
        sb5.append("\r\n");
        StringBuilder sb6 = this.basicSb;
        sb6.append("model");
        sb6.append(" = ");
        sb6.append(this.model);
        sb6.append("\r\n");
        StringBuilder sb7 = this.basicSb;
        sb7.append("api-level");
        sb7.append(" = ");
        sb7.append(this.apiLevel);
        sb7.append("\r\n");
        StringBuilder sb8 = this.basicSb;
        sb8.append("cpu-core");
        sb8.append(" = ");
        sb8.append(this.cpuCoreNum);
        sb8.append("\r\n");
        StringBuilder sb9 = this.basicSb;
        sb9.append("process");
        sb9.append(" = ");
        sb9.append(this.processName);
        sb9.append("\r\n");
        StringBuilder sb10 = this.basicSb;
        sb10.append("freeMemory");
        sb10.append(" = ");
        sb10.append(this.freeMemory);
        sb10.append("\r\n");
        StringBuilder sb11 = this.basicSb;
        sb11.append("totalMemory");
        sb11.append(" = ");
        sb11.append(this.totalMemory);
        sb11.append("\r\n");
        StringBuilder sb12 = this.timeSb;
        sb12.append("time");
        sb12.append(" = ");
        sb12.append(this.timeCost);
        sb12.append("\r\n");
        StringBuilder sb13 = this.timeSb;
        sb13.append("thread-time");
        sb13.append(" = ");
        sb13.append(this.threadTimeCost);
        sb13.append("\r\n");
        StringBuilder sb14 = this.timeSb;
        sb14.append("time-start");
        sb14.append(" = ");
        sb14.append(this.timeStart);
        sb14.append("\r\n");
        StringBuilder sb15 = this.timeSb;
        sb15.append("time-end");
        sb15.append(" = ");
        sb15.append(this.timeEnd);
        sb15.append("\r\n");
        StringBuilder sb16 = this.cpuSb;
        sb16.append("cpu-busy");
        sb16.append(" = ");
        sb16.append(this.cpuBusy);
        sb16.append("\r\n");
        StringBuilder sb17 = this.cpuSb;
        sb17.append("cpu-rate");
        sb17.append(" = ");
        sb17.append(this.cpuRateInfo);
        sb17.append("\r\n");
        ArrayList<String> arrayList = this.threadStackEntries;
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb18 = new StringBuilder();
            Iterator<String> it = this.threadStackEntries.iterator();
            while (it.hasNext()) {
                sb18.append(it.next());
                sb18.append("\r\n");
            }
            StringBuilder sb19 = this.stackSb;
            sb19.append("stack");
            sb19.append(" = ");
            sb19.append(sb18.toString());
            sb19.append("\r\n");
        }
        return this;
    }

    public String getBasicString() {
        return this.basicSb.toString();
    }

    public String getCpuString() {
        return this.cpuSb.toString();
    }

    public String getTimeString() {
        return this.timeSb.toString();
    }

    public String toString() {
        return String.valueOf(this.basicSb) + this.timeSb + this.cpuSb + this.stackSb;
    }
}
