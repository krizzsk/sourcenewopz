package com.didi.map.utils.logger;

public class AndroidLogAdapter implements LogAdapter {

    /* renamed from: a */
    private final FormatStrategy f29034a;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public AndroidLogAdapter() {
        this.f29034a = PrettyFormatStrategy.newBuilder().build();
    }

    public AndroidLogAdapter(FormatStrategy formatStrategy) {
        this.f29034a = (FormatStrategy) C10238b.m20477b(formatStrategy);
    }

    public void log(int i, String str, String str2) {
        this.f29034a.log(i, str, str2);
    }
}
