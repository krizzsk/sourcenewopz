package com.didichuxing.dfbasesdk.logupload;

public class LogRecord {
    public static final String LOG_TAG = "LogUpload";
    public static final int UPLOAD_STATUS_ING = 1;
    public static final int UPLOAD_STATUS_INIT = 0;
    public final String content;
    public long ctime;
    public String extras;
    public final long failCount;

    /* renamed from: id */
    public final Object f46590id;
    public final long uploadStatus;
    public String url;
    public long utime;

    public LogRecord(Object obj, String str, long j, long j2) {
        this.f46590id = obj;
        this.content = str;
        this.uploadStatus = j;
        this.failCount = j2;
    }

    public boolean isNeedUpload() {
        return this.uploadStatus == 0;
    }
}
