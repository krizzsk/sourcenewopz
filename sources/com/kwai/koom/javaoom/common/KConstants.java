package com.kwai.koom.javaoom.common;

public class KConstants {

    public static class ArrayThreshold {
        public static final int DEFAULT_BIG_OBJECT_ARRAY = 262144;
        public static final int DEFAULT_BIG_PRIMITIVE_ARRAY = 262144;
    }

    public static class BitmapThreshold {
        public static final int DEFAULT_BIG_BITMAP = 1049088;
        public static final int DEFAULT_BIG_HEIGHT = 1366;
        public static final int DEFAULT_BIG_WIDTH = 768;
    }

    public static class Debug {
        public static boolean VERBOSE_LOG = true;
    }

    public static class Disk {
        public static float ENOUGH_SPACE_IN_GB = 5.0f;
    }

    public static class EnableCheck {
        public static int MAX_TIME_WINDOW_IN_DAYS = 15;
        public static int TRIGGER_MAX_TIMES = 3;
    }

    public static class KOOMVersion {
        public static int CODE = 1;
        public static String NAME = "1.0";
    }

    public static class Perf {
        public static final int START_DELAY = 10000;
    }

    public static class ReAnalysis {
        public static int MAX_TIMES = 2;
    }

    /* renamed from: com.kwai.koom.javaoom.common.KConstants$SP */
    public static class C20314SP {
        public static String FIRST_LAUNCH_TIME_NAME = "_koom_first_launch_time";
        public static String TRIGGER_TIMES_NAME = "_koom_trigger_times";
    }

    public static class ServiceIntent {
        public static final String HEAP_FILE = "heap_file";
        public static final String RECEIVER = "receiver";
    }

    public static class Time {
        public static long DAY_IN_MILLS = 86400000;
    }

    public static class Bytes {

        /* renamed from: GB */
        public static int f55584GB = 0;

        /* renamed from: KB */
        public static int f55585KB = 1024;

        /* renamed from: MB */
        public static int f55586MB;

        static {
            int i = 1024 * 1024;
            f55586MB = i;
            f55584GB = i * 1024;
        }
    }

    public static class HeapThreshold {
        public static int OVER_TIMES = 3;
        public static float PERCENT_MAX_RATIO = 95.0f;
        public static float PERCENT_RATIO_IN_128_DEVICE = 90.0f;
        public static float PERCENT_RATIO_IN_256_DEVICE = 85.0f;
        public static float PERCENT_RATIO_IN_512_DEVICE = 80.0f;
        public static int POLL_INTERVAL = 5000;
        public static int VM_128_DEVICE = 128;
        public static int VM_256_DEVICE = 250;
        public static int VM_512_DEVICE = 510;

        public static float getDefaultPercentRation() {
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / ((long) Bytes.f55586MB));
            if (Debug.VERBOSE_LOG) {
                KLog.m40102i("koom", "max mem " + maxMemory);
            }
            if (maxMemory >= VM_512_DEVICE) {
                return PERCENT_RATIO_IN_512_DEVICE;
            }
            if (maxMemory >= VM_256_DEVICE) {
                return PERCENT_RATIO_IN_256_DEVICE;
            }
            if (maxMemory >= VM_128_DEVICE) {
                return PERCENT_RATIO_IN_128_DEVICE;
            }
            return PERCENT_RATIO_IN_512_DEVICE;
        }

        public static float getDefaultMaxPercentRation() {
            return PERCENT_MAX_RATIO;
        }
    }
}
