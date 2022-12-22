package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.tracking.ActivityLifecycleTrackingStrategy;
import com.datadog.android.rum.tracking.TrackingStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/tracking/ViewTreeChangeTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "()V", "getViewTreeObserver", "Landroid/view/ViewTreeObserver;", "activity", "Landroid/app/Activity;", "onActivityStarted", "", "onActivityStopped", "onGlobalLayout", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewTreeChangeTrackingStrategy.kt */
public final class ViewTreeChangeTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTreeObserver.OnGlobalLayoutListener, TrackingStrategy {
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStarted(activity);
        ViewTreeObserver a = m2518a(activity);
        if (a != null) {
            a.addOnGlobalLayoutListener(this);
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStopped(activity);
        ViewTreeObserver a = m2518a(activity);
        if (a != null) {
            a.removeOnGlobalLayoutListener(this);
        }
    }

    public void onGlobalLayout() {
        Time time = new Time(0, 0, 3, (DefaultConstructorMarker) null);
        RumMonitor rumMonitor = GlobalRum.get();
        AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
        if (advancedRumMonitor != null) {
            advancedRumMonitor.viewTreeChanged(time);
        }
    }

    /* renamed from: a */
    private final ViewTreeObserver m2518a(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        return window.getDecorView().getViewTreeObserver();
    }
}
