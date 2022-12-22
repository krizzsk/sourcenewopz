package com.datadog.android.rum.internal.instrumentation;

import android.app.Activity;
import android.os.Bundle;
import com.datadog.android.rum.internal.instrumentation.gestures.GesturesTracker;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/UserActionTrackingStrategyApi29;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "gesturesTracker", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "(Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;)V", "getGesturesTracker$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "equals", "", "other", "", "getGesturesTracker", "hashCode", "", "onActivityPreCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UserActionTrackingStrategyApi29.kt */
public final class UserActionTrackingStrategyApi29 extends ActivityLifecycleTrackingStrategy implements UserActionTrackingStrategy {

    /* renamed from: a */
    private final GesturesTracker f3837a;

    public final GesturesTracker getGesturesTracker$dd_sdk_android_release() {
        return this.f3837a;
    }

    public UserActionTrackingStrategyApi29(GesturesTracker gesturesTracker) {
        Intrinsics.checkNotNullParameter(gesturesTracker, "gesturesTracker");
        this.f3837a = gesturesTracker;
    }

    public GesturesTracker getGesturesTracker() {
        return this.f3837a;
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f3837a.startTracking(activity.getWindow(), activity);
        super.onActivityPreCreated(activity, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            return Intrinsics.areEqual((Object) this.f3837a, (Object) ((UserActionTrackingStrategyApi29) obj).f3837a);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.UserActionTrackingStrategyApi29");
    }

    public int hashCode() {
        return this.f3837a.hashCode();
    }

    public String toString() {
        return "UserActionTrackingStrategyApi29(" + this.f3837a + VersionRange.RIGHT_OPEN;
    }
}
