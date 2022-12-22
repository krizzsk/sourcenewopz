package com.didi.sdk.onehotpatch.loader.crash;

public class NotDefInterceptor implements CrashInterceptor {
    public boolean intercept(Throwable th) {
        String name = th.getClass().getName();
        if (name.equals(NoClassDefFoundError.class.getName()) || name.equals(NoSuchMethodError.class.getName()) || name.equals(NoSuchFieldError.class.getName())) {
            return true;
        }
        String message = th.getMessage();
        if (message == null) {
            return false;
        }
        if (message.contains(NoClassDefFoundError.class.getName()) || message.contains(NoSuchMethodError.class.getName()) || message.contains(NoSuchFieldError.class.getName())) {
            return true;
        }
        return false;
    }
}
