package com.didi.sdk.misconfig.event;

public class CarInfoUpdateEvent {
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_SUCCESS_CACHE = 2;
    public static final int RESULT_SUCCESS_NET = 1;
    public int result;
    public int seqId;
    public String tag;
    public boolean versionChanged;
}
