package com.map.sdk.nav.libc.common;

public enum DMKMatchErrorCode {
    kDMKMatchErrorCode_NoRoute(1),
    kDMKMatchErrorCode_Filter(2),
    kDMKMatchErrorCode_Out(3);
    
    public final int errorCode;

    private DMKMatchErrorCode(int i) {
        this.errorCode = i;
    }
}
