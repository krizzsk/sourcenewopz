package com.didiglobal.p205sa.biz.component.xengine;

import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/xengine/SAXEngineLoggerUtils;", "", "()V", "logger", "Lcom/didi/sdk/logging/Logger;", "getLogger", "()Lcom/didi/sdk/logging/Logger;", "info", "", "log", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.SAXEngineLoggerUtils */
/* compiled from: SAXEngineLoggerUtils.kt */
public final class SAXEngineLoggerUtils {
    public static final SAXEngineLoggerUtils INSTANCE = new SAXEngineLoggerUtils();

    /* renamed from: a */
    private static final Logger f51204a;

    private SAXEngineLoggerUtils() {
    }

    static {
        Logger logger = LoggerFactory.getLogger("SAXEngine_flow");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(\"SAXEngine_flow\")");
        f51204a = logger;
    }

    public final Logger getLogger() {
        return f51204a;
    }

    public final void info(String str) {
        Intrinsics.checkNotNullParameter(str, "log");
        f51204a.info(InvitationTrackFragment.INVITE_DATE, str);
    }
}
