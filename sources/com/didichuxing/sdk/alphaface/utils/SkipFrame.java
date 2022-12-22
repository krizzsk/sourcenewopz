package com.didichuxing.sdk.alphaface.utils;

public class SkipFrame {

    /* renamed from: a */
    private final long f48759a;

    /* renamed from: b */
    private long f48760b;

    /* renamed from: c */
    private int f48761c;

    public SkipFrame(long j) {
        this.f48759a = j;
    }

    public boolean skip() {
        if (System.currentTimeMillis() - this.f48760b <= this.f48759a) {
            return true;
        }
        this.f48760b = System.currentTimeMillis();
        this.f48761c++;
        return false;
    }

    public void reset() {
        this.f48760b = 0;
        this.f48761c = 0;
    }

    public int getFrame() {
        return this.f48761c;
    }
}
