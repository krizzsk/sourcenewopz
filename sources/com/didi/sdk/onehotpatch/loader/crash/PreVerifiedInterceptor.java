package com.didi.sdk.onehotpatch.loader.crash;

public class PreVerifiedInterceptor implements CrashInterceptor {
    public boolean intercept(Throwable th) {
        String message = th.getMessage();
        if (message == null || "".equals(message.trim()) || !th.getClass().getName().equals(IllegalAccessError.class.getName()) || !message.contains("pre-verified")) {
            return false;
        }
        return true;
    }
}
