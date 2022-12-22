package com.didichuxing.dfbasesdk.sensor;

import java.util.List;

public class SensorData {
    public static final int ERRORCODE_NORMAL = 0;
    public static final int ERRORCODE_NO_SENSOR = 1;
    public static final int ERRORCODE_REGISTER_FAIL = 2;
    public static final int ERRORCODE_UNKNOWN = 9;
    public static final int[] types = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 20, 28, 29, 30, 34, 35};
    public List<Sample> data;
    public int delay = 200;
    public int errCode = 9;
    public int limit = 20;
    public String name;
    public int reportingMode;
    public float resolution;
    public int type;

    public static class Sample {
        public transient Sample next = null;
        public long time = 0;
        public float[] values = null;
    }
}
