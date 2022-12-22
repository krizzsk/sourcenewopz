package com.google.firebase.heartbeatinfo;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.firebase.heartbeatinfo.-$$Lambda$DefaultHeartBeatInfo$5h7e2emmKpAWwpxh05RIvrnsucg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$DefaultHeartBeatInfo$5h7e2emmKpAWwpxh05RIvrnsucg implements ThreadFactory {
    public static final /* synthetic */ $$Lambda$DefaultHeartBeatInfo$5h7e2emmKpAWwpxh05RIvrnsucg INSTANCE = new $$Lambda$DefaultHeartBeatInfo$5h7e2emmKpAWwpxh05RIvrnsucg();

    private /* synthetic */ $$Lambda$DefaultHeartBeatInfo$5h7e2emmKpAWwpxh05RIvrnsucg() {
    }

    public final Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}
