package com.didi.beatles.p099im.protocol.host;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.protocol.host.IMBaseInvokeEnv */
public abstract class IMBaseInvokeEnv {
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_HELPER = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.protocol.host.IMBaseInvokeEnv$EnvTheme */
    public @interface EnvTheme {
    }

    public abstract int getPluginTheme();
}
