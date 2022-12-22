package com.didi.sdk.connectivity;

public class Connectivity {
    private static Connectivity sInstance;

    public native Object TCPConnect(String str, int i, int i2);

    static {
        System.loadLibrary("connectivity");
    }

    public static Connectivity getInstance() {
        if (sInstance == null) {
            synchronized (Connectivity.class) {
                if (sInstance == null) {
                    sInstance = new Connectivity();
                }
            }
        }
        return sInstance;
    }
}
