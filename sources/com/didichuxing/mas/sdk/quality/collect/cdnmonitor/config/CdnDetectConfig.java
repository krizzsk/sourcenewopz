package com.didichuxing.mas.sdk.quality.collect.cdnmonitor.config;

public class CdnDetectConfig {
    public static long DEFAULT_CND_DETECT_INTERVAL = 86400000;
    public static int DEFAULT_MAX_CDN_DETECT_COUNT_PER_DAY = 10;
    public static int DEFAULT_SAMPLE_COUNT_CDN_DETECT = 1;
    public static final int PINT_COUNT = 5;
    public static final int PINT_TIMEOUT = 10;
    public static boolean SWITCH_CDN_MONITOR = false;
    public static long cdnDetectInterval = 86400000;
    public static boolean detectCdnOnlyFirstStartPerDay = true;
    public static int maxCdnDetectCount = 10;
    public static int sampleCountCdnDetect = 1;
}
