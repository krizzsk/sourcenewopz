package com.didi.sdk.onehotpatch.loader.crash;

public interface CrashInterceptor {
    boolean intercept(Throwable th);
}
