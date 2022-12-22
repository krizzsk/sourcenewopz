package com.datadog.android.rum.internal.tracking;

import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.tracking.TrackingStrategy;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "getGesturesTracker", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UserActionTrackingStrategy.kt */
public interface UserActionTrackingStrategy extends TrackingStrategy {
    GesturesTracker getGesturesTracker();
}
