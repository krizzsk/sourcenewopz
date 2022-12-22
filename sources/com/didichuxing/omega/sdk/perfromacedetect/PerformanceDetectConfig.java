package com.didichuxing.omega.sdk.perfromacedetect;

import java.util.concurrent.TimeUnit;

public class PerformanceDetectConfig {
    public static int DEFAULT_CPU_OVERLOAD_COUNT = 2;
    public static long DEFAULT_DETECT_INTERVAL = 300000;
    public static final long DEFAULT_DISK_CLEAN_EXPIRE = TimeUnit.DAYS.toSeconds(30);
    public static final long DEFAULT_DISK_CLEAN_LIMIT = 500;
    public static final int DEFAULT_DISK_LIMIT_PERCENT = 95;
    public static final long DEFAULT_DISK_LIMIT_THRESHOLD = 500;
    public static final int DEFAULT_DISK_PATH_DEPTH = 2;
    public static int DEFAULT_FD_MAX_COUNT = 20000;
    public static int DEFAULT_LIMIT = 10;
    public static int DEFAULT_MAX_CPU_USAGE = 10;
    public static int DEFAULT_MAX_MEM_USAGE = 80;
    public static int DEFAULT_THREAD_MAX_COUNT = 200;
    public boolean cpuMonitorEnable = false;
    public int cpuOverloadCount = DEFAULT_CPU_OVERLOAD_COUNT;
    public long diskCleanExpire = DEFAULT_DISK_CLEAN_EXPIRE;
    public long diskCleanLimit = 500;
    public String[] diskCleanPath = null;
    public String[] diskCleanPath_P2 = null;
    public int diskDataLimitPercent = 95;
    public int diskLimitPercent = 95;
    public long diskLimitThreshold = 500;
    public boolean diskMonitorEnable = false;
    public int diskPathDepth = 2;
    public String[] diskPathList = null;
    public int limit = DEFAULT_LIMIT;
    public int maxCpuUsage = DEFAULT_MAX_CPU_USAGE;
    public int maxFDCount = DEFAULT_FD_MAX_COUNT;
    public int maxMemUsage = DEFAULT_MAX_MEM_USAGE;
    public int maxThreadCount = DEFAULT_THREAD_MAX_COUNT;
    public boolean memMonitorEnable = false;
    public boolean threadDetailEnable = false;
    public boolean threadMonitorEnable = false;
    public long trackInterval = DEFAULT_DETECT_INTERVAL;
}
