package com.didi.sdk.signkylib;

public class SignKey {
    public native String getPhoneSignKey();

    static {
        System.loadLibrary("signkey");
    }
}
