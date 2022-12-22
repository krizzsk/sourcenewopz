package com.didi.beatles.p099im.utils;

/* renamed from: com.didi.beatles.im.utils.IMIdGenerator */
public class IMIdGenerator {
    public static IMIdGenerator sInstance;

    public static boolean isLocalId(long j) {
        return (j >> 62) == 3;
    }

    private IMIdGenerator() {
    }

    public static IMIdGenerator getInstance() {
        if (sInstance == null) {
            sInstance = new IMIdGenerator();
        }
        return sInstance;
    }

    public long getRandId() {
        return System.currentTimeMillis();
    }
}
