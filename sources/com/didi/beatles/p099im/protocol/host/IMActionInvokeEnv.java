package com.didi.beatles.p099im.protocol.host;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* renamed from: com.didi.beatles.im.protocol.host.IMActionInvokeEnv */
public abstract class IMActionInvokeEnv extends IMBaseInvokeEnv {
    public static final int OPEN_ON_BOARD_CLICK = 3;
    public static final int OPEN_ON_BOARD_ENTER = 4;
    public static final int OPEN_ON_MORE_CLICK = 1;
    public static final int OPEN_ON_MORE_ENTER = 2;
    public static final int OPEN_ON_TAB_CLICK = 5;
    public static final int OPEN_ON_TAB_ENTER = 6;
    public final Context context;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.protocol.host.IMActionInvokeEnv$ActionSource */
    public @interface ActionSource {
    }

    public abstract int getActionSource();

    public abstract int getBusinessId();

    public abstract Map<String, String> getBusinessTraceParam();

    public abstract int getContentHeight();

    public abstract String getOrderId();

    public int getPluginTheme() {
        return 0;
    }

    public String getRobotGuideId() {
        return "";
    }

    public abstract long getSessionId();

    public IMActionInvokeEnv(Context context2) {
        this.context = context2;
    }
}
