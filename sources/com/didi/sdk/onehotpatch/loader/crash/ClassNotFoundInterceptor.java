package com.didi.sdk.onehotpatch.loader.crash;

import com.didi.sdk.onehotpatch.BuildConfig;

public class ClassNotFoundInterceptor implements CrashInterceptor {
    public boolean intercept(Throwable th) {
        String message = th.getMessage();
        if (message == null || "".equals(message.trim()) || !th.getClass().getName().equals(ClassNotFoundException.class.getName()) || !message.contains(BuildConfig.LIBRARY_PACKAGE_NAME)) {
            return false;
        }
        return true;
    }
}
