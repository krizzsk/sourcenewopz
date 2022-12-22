package com.didi.sdk.app;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/sdk/app/SuperAppBroadcastSender;", "", "()V", "initBroadcastSender", "", "context", "Landroid/content/Context;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuperAppBroadcastSender.kt */
public final class SuperAppBroadcastSender {
    public static final SuperAppBroadcastSender INSTANCE = new SuperAppBroadcastSender();

    private SuperAppBroadcastSender() {
    }

    public final void initBroadcastSender(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IBroadcastSender instance = BroadcastSender.getInstance(context);
        if (instance != null) {
            ((BroadcastSender) instance).mo90563a();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.app.BroadcastSender");
    }
}
