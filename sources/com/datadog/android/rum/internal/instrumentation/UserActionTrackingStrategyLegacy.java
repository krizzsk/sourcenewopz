package com.datadog.android.rum.internal.instrumentation;

import android.app.Activity;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/UserActionTrackingStrategyLegacy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "gesturesTracker", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "(Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;)V", "getGesturesTracker$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "equals", "", "other", "", "getGesturesTracker", "hashCode", "", "onActivityPaused", "", "activity", "Landroid/app/Activity;", "onActivityResumed", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UserActionTrackingStrategyLegacy.kt */
public final class UserActionTrackingStrategyLegacy extends ActivityLifecycleTrackingStrategy implements UserActionTrackingStrategy {

    /* renamed from: a */
    private final GesturesTracker f3838a;

    public final GesturesTracker getGesturesTracker$dd_sdk_android_release() {
        return this.f3838a;
    }

    public UserActionTrackingStrategyLegacy(GesturesTracker gesturesTracker) {
        Intrinsics.checkNotNullParameter(gesturesTracker, "gesturesTracker");
        this.f3838a = gesturesTracker;
    }

    public GesturesTracker getGesturesTracker() {
        return this.f3838a;
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        this.f3838a.startTracking(activity.getWindow(), activity);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        this.f3838a.stopTracking(activity.getWindow(), activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            return Intrinsics.areEqual((Object) this.f3838a, (Object) ((UserActionTrackingStrategyLegacy) obj).f3838a);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyLegacy");
    }

    public int hashCode() {
        return this.f3838a.hashCode();
    }

    public String toString() {
        return "UserActionTrackingStrategyLegacy(" + this.f3838a + VersionRange.RIGHT_OPEN;
    }
}
