package com.datadog.android.rum.tracking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.datadog.android.core.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.internal.tracking.ViewLoadingTimer;
import com.datadog.android.rum.model.ViewEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0002R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/datadog/android/rum/tracking/ActivityViewTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ActivityLifecycleTrackingStrategy;", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "trackExtras", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "Landroid/app/Activity;", "(ZLcom/datadog/android/rum/tracking/ComponentPredicate;)V", "getComponentPredicate$dd_sdk_android_release", "()Lcom/datadog/android/rum/tracking/ComponentPredicate;", "getTrackExtras$dd_sdk_android_release", "()Z", "viewLoadingTimer", "Lcom/datadog/android/rum/internal/tracking/ViewLoadingTimer;", "equals", "other", "", "hashCode", "", "onActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPostResumed", "onActivityResumed", "onActivityStarted", "resolveLoadingType", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "firstTimeLoading", "updateLoadingTime", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ActivityViewTrackingStrategy.kt */
public final class ActivityViewTrackingStrategy extends ActivityLifecycleTrackingStrategy implements ViewTrackingStrategy {

    /* renamed from: a */
    private final boolean f4025a;

    /* renamed from: b */
    private final ComponentPredicate<Activity> f4026b;

    /* renamed from: c */
    private final ViewLoadingTimer f4027c;

    public ActivityViewTrackingStrategy(boolean z) {
        this(z, (ComponentPredicate) null, 2, (DefaultConstructorMarker) null);
    }

    public final boolean getTrackExtras$dd_sdk_android_release() {
        return this.f4025a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityViewTrackingStrategy(boolean z, ComponentPredicate componentPredicate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? new AcceptAllActivities() : componentPredicate);
    }

    public final ComponentPredicate<Activity> getComponentPredicate$dd_sdk_android_release() {
        return this.f4026b;
    }

    public ActivityViewTrackingStrategy(boolean z, ComponentPredicate<Activity> componentPredicate) {
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        this.f4025a = z;
        this.f4026b = componentPredicate;
        this.f4027c = new ViewLoadingTimer();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityCreated(activity, bundle);
        if (this.f4026b.accept(activity)) {
            this.f4027c.onCreated(activity);
        }
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityStarted(activity);
        if (this.f4026b.accept(activity)) {
            this.f4027c.onStartLoading(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        Map<String, Object> map;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityResumed(activity);
        if (this.f4026b.accept(activity)) {
            String viewName = getComponentPredicate$dd_sdk_android_release().getViewName(activity);
            CharSequence charSequence = viewName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                viewName = ViewUtilsKt.resolveViewUrl((Object) activity);
            }
            if (getTrackExtras$dd_sdk_android_release()) {
                Intent intent = activity.getIntent();
                map = convertToRumAttributes(intent == null ? null : intent.getExtras());
            } else {
                map = MapsKt.emptyMap();
            }
            GlobalRum.INSTANCE.getMonitor$dd_sdk_android_release().startView(activity, viewName, map);
            this.f4027c.onFinishedLoading(activity);
        }
    }

    public void onActivityPostResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f4026b.accept(activity)) {
            this.f4027c.onFinishedLoading(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityPaused(activity);
        if (this.f4026b.accept(activity)) {
            m2523a(activity);
            RumMonitor.DefaultImpls.stopView$default(GlobalRum.INSTANCE.getMonitor$dd_sdk_android_release(), activity, (Map) null, 2, (Object) null);
            this.f4027c.onPaused(activity);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onActivityDestroyed(activity);
        if (this.f4026b.accept(activity)) {
            this.f4027c.onDestroyed(activity);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            ActivityViewTrackingStrategy activityViewTrackingStrategy = (ActivityViewTrackingStrategy) obj;
            return this.f4025a == activityViewTrackingStrategy.f4025a && Intrinsics.areEqual((Object) this.f4026b, (Object) activityViewTrackingStrategy.f4026b);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.datadog.android.rum.tracking.ActivityViewTrackingStrategy");
    }

    public int hashCode() {
        return (C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.f4025a) * 31) + this.f4026b.hashCode();
    }

    /* renamed from: a */
    private final void m2523a(Activity activity) {
        Long loadingTime = this.f4027c.getLoadingTime(activity);
        if (loadingTime != null) {
            long longValue = loadingTime.longValue();
            RumMonitor rumMonitor = GlobalRum.get();
            AdvancedRumMonitor advancedRumMonitor = rumMonitor instanceof AdvancedRumMonitor ? (AdvancedRumMonitor) rumMonitor : null;
            if (advancedRumMonitor != null) {
                advancedRumMonitor.updateViewLoadingTime(activity, longValue, m2522a(this.f4027c.isFirstTimeLoading(activity)));
            }
        }
    }

    /* renamed from: a */
    private final ViewEvent.LoadingType m2522a(boolean z) {
        if (z) {
            return ViewEvent.LoadingType.ACTIVITY_DISPLAY;
        }
        return ViewEvent.LoadingType.ACTIVITY_REDISPLAY;
    }
}
