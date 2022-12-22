package com.didi.app.nova.skeleton.image.performance;

public class ImagePerformance {
    public static final String IMAGE_TYPE_FILE = "file";
    public static final String IMAGE_TYPE_NETWORK = "network";
    public static final String IMAGE_TYPE_RESOURCE = "resource";
    public static final String IMAGE_TYPE_UNKNOWN = "unknown";
    public long endTime;
    public boolean isFromMemoryCache;
    public long startTime;
    public long totalTime;
    public String type = "unknown";
    public String url = "";
}
