package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.datadog.android.core.internal.utils.ViewUtilsKt;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.internal.RumFeature;
import com.datadog.android.rum.internal.monitor.AdvancedRumMonitor;
import com.datadog.android.rum.model.ViewEvent;
import com.datadog.android.rum.tracking.ComponentPredicate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BO\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u001a\u0010 \u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/datadog/android/rum/internal/tracking/OreoFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "Landroid/app/Activity;", "Landroid/app/FragmentManager$FragmentLifecycleCallbacks;", "argumentsProvider", "Lkotlin/Function1;", "Landroid/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "viewLoadingTimer", "Lcom/datadog/android/rum/internal/tracking/ViewLoadingTimer;", "rumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "advancedRumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/internal/tracking/ViewLoadingTimer;Lcom/datadog/android/rum/RumMonitor;Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;)V", "onFragmentActivityCreated", "", "fm", "Landroid/app/FragmentManager;", "f", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentAttached", "context", "Landroid/content/Context;", "onFragmentDestroyed", "onFragmentPaused", "onFragmentResumed", "onFragmentStarted", "register", "activity", "resolveLoadingType", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "firstTimeLoading", "", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OreoFragmentLifecycleCallbacks.kt */
public final class OreoFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks implements FragmentLifecycleCallbacks<Activity> {

    /* renamed from: a */
    private final Function1<Fragment, Map<String, Object>> f3889a;

    /* renamed from: b */
    private final ComponentPredicate<Fragment> f3890b;

    /* renamed from: c */
    private final ViewLoadingTimer f3891c;

    /* renamed from: d */
    private final RumMonitor f3892d;

    /* renamed from: e */
    private final AdvancedRumMonitor f3893e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OreoFragmentLifecycleCallbacks(Function1 function1, ComponentPredicate componentPredicate, ViewLoadingTimer viewLoadingTimer, RumMonitor rumMonitor, AdvancedRumMonitor advancedRumMonitor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, componentPredicate, (i & 4) != 0 ? new ViewLoadingTimer() : viewLoadingTimer, rumMonitor, advancedRumMonitor);
    }

    public OreoFragmentLifecycleCallbacks(Function1<? super Fragment, ? extends Map<String, ? extends Object>> function1, ComponentPredicate<Fragment> componentPredicate, ViewLoadingTimer viewLoadingTimer, RumMonitor rumMonitor, AdvancedRumMonitor advancedRumMonitor) {
        Intrinsics.checkNotNullParameter(function1, "argumentsProvider");
        Intrinsics.checkNotNullParameter(componentPredicate, "componentPredicate");
        Intrinsics.checkNotNullParameter(viewLoadingTimer, "viewLoadingTimer");
        Intrinsics.checkNotNullParameter(rumMonitor, "rumMonitor");
        Intrinsics.checkNotNullParameter(advancedRumMonitor, "advancedRumMonitor");
        this.f3889a = function1;
        this.f3890b = componentPredicate;
        this.f3891c = viewLoadingTimer;
        this.f3892d = rumMonitor;
        this.f3893e = advancedRumMonitor;
    }

    public void register(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 26) {
            activity.getFragmentManager().registerFragmentLifecycleCallbacks(this, true);
        }
    }

    public void unregister(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Build.VERSION.SDK_INT >= 26) {
            activity.getFragmentManager().unregisterFragmentLifecycleCallbacks(this);
        }
    }

    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
        Context context = fragment.getContext();
        if ((fragment instanceof DialogFragment) && context != null) {
            Dialog dialog = ((DialogFragment) fragment).getDialog();
            RumFeature.INSTANCE.getActionTrackingStrategy$dd_sdk_android_release().getGesturesTracker().startTracking(dialog == null ? null : dialog.getWindow(), context);
        }
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (this.f3890b.accept(fragment)) {
            this.f3891c.onCreated(fragment);
        }
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentStarted(fragmentManager, fragment);
        if (this.f3890b.accept(fragment)) {
            this.f3891c.onStartLoading(fragment);
        }
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentResumed(fragmentManager, fragment);
        if (this.f3890b.accept(fragment)) {
            String viewName = this.f3890b.getViewName(fragment);
            CharSequence charSequence = viewName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                viewName = ViewUtilsKt.resolveViewUrl((Object) fragment);
            }
            this.f3891c.onFinishedLoading(fragment);
            this.f3892d.startView(fragment, viewName, this.f3889a.invoke(fragment));
            Long loadingTime = this.f3891c.getLoadingTime(fragment);
            if (loadingTime != null) {
                this.f3893e.updateViewLoadingTime(fragment, loadingTime.longValue(), m2517a(this.f3891c.isFirstTimeLoading(fragment)));
            }
        }
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentPaused(fragmentManager, fragment);
        if (this.f3890b.accept(fragment)) {
            RumMonitor.DefaultImpls.stopView$default(this.f3892d, fragment, (Map) null, 2, (Object) null);
            this.f3891c.onPaused(fragment);
        }
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (this.f3890b.accept(fragment)) {
            this.f3891c.onDestroyed(fragment);
        }
    }

    /* renamed from: a */
    private final ViewEvent.LoadingType m2517a(boolean z) {
        if (z) {
            return ViewEvent.LoadingType.FRAGMENT_DISPLAY;
        }
        return ViewEvent.LoadingType.FRAGMENT_REDISPLAY;
    }
}
