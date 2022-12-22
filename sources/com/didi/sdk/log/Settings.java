package com.didi.sdk.log;

public final class Settings {

    /* renamed from: a */
    private int f36442a = 2;

    /* renamed from: b */
    private boolean f36443b = true;

    /* renamed from: c */
    private int f36444c = 0;

    /* renamed from: d */
    private LogLevel f36445d = LogLevel.FULL;

    public Settings hideThreadInfo() {
        this.f36443b = false;
        return this;
    }

    public Settings setMethodCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f36442a = i;
        return this;
    }

    public Settings setLogLevel(LogLevel logLevel) {
        this.f36445d = logLevel;
        return this;
    }

    public Settings setMethodOffset(int i) {
        this.f36444c = i;
        return this;
    }

    public int getMethodCount() {
        return this.f36442a;
    }

    public boolean isShowThreadInfo() {
        return this.f36443b;
    }

    public LogLevel getLogLevel() {
        return this.f36445d;
    }

    public int getMethodOffset() {
        return this.f36444c;
    }
}
