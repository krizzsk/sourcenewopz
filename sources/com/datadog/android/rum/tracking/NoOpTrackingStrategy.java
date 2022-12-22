package com.datadog.android.rum.tracking;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/NoOpTrackingStrategy;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "()V", "register", "", "context", "Landroid/content/Context;", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NoOpTrackingStrategy.kt */
public final class NoOpTrackingStrategy implements TrackingStrategy {
    public void register(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void unregister(Context context) {
    }
}
