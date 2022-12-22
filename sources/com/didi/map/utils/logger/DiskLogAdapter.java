package com.didi.map.utils.logger;

public class DiskLogAdapter implements LogAdapter {

    /* renamed from: a */
    private final FormatStrategy f29042a;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public DiskLogAdapter() {
        this.f29042a = CsvFormatStrategy.newBuilder().build();
    }

    public DiskLogAdapter(FormatStrategy formatStrategy) {
        this.f29042a = (FormatStrategy) C10238b.m20477b(formatStrategy);
    }

    public void log(int i, String str, String str2) {
        this.f29042a.log(i, str, str2);
    }
}
