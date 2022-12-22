package com.datadog.android.rum.internal.tracking;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
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

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BO\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0002H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/tracking/AndroidXFragmentLifecycleCallbacks;", "Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "argumentsProvider", "Lkotlin/Function1;", "Landroidx/fragment/app/Fragment;", "", "", "", "componentPredicate", "Lcom/datadog/android/rum/tracking/ComponentPredicate;", "viewLoadingTimer", "Lcom/datadog/android/rum/internal/tracking/ViewLoadingTimer;", "rumMonitor", "Lcom/datadog/android/rum/RumMonitor;", "advancedRumMonitor", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "(Lkotlin/jvm/functions/Function1;Lcom/datadog/android/rum/tracking/ComponentPredicate;Lcom/datadog/android/rum/internal/tracking/ViewLoadingTimer;Lcom/datadog/android/rum/RumMonitor;Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;)V", "getArgumentsProvider$dd_sdk_android_release", "()Lkotlin/jvm/functions/Function1;", "onFragmentActivityCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentAttached", "context", "Landroid/content/Context;", "onFragmentDestroyed", "onFragmentPaused", "onFragmentResumed", "onFragmentStarted", "register", "activity", "resolveKey", "fragment", "resolveLoadingType", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "firstTimeLoading", "", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AndroidXFragmentLifecycleCallbacks.kt */
public class AndroidXFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks implements FragmentLifecycleCallbacks<FragmentActivity> {
    private final AdvancedRumMonitor advancedRumMonitor;
    private final Function1<Fragment, Map<String, Object>> argumentsProvider;
    private final ComponentPredicate<Fragment> componentPredicate;
    private final RumMonitor rumMonitor;
    private final ViewLoadingTimer viewLoadingTimer;

    public Object resolveKey(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return fragment;
    }

    public final Function1<Fragment, Map<String, Object>> getArgumentsProvider$dd_sdk_android_release() {
        return this.argumentsProvider;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidXFragmentLifecycleCallbacks(Function1 function1, ComponentPredicate componentPredicate2, ViewLoadingTimer viewLoadingTimer2, RumMonitor rumMonitor2, AdvancedRumMonitor advancedRumMonitor2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, componentPredicate2, (i & 4) != 0 ? new ViewLoadingTimer() : viewLoadingTimer2, rumMonitor2, advancedRumMonitor2);
    }

    public AndroidXFragmentLifecycleCallbacks(Function1<? super Fragment, ? extends Map<String, ? extends Object>> function1, ComponentPredicate<Fragment> componentPredicate2, ViewLoadingTimer viewLoadingTimer2, RumMonitor rumMonitor2, AdvancedRumMonitor advancedRumMonitor2) {
        Intrinsics.checkNotNullParameter(function1, "argumentsProvider");
        Intrinsics.checkNotNullParameter(componentPredicate2, "componentPredicate");
        Intrinsics.checkNotNullParameter(viewLoadingTimer2, "viewLoadingTimer");
        Intrinsics.checkNotNullParameter(rumMonitor2, "rumMonitor");
        Intrinsics.checkNotNullParameter(advancedRumMonitor2, "advancedRumMonitor");
        this.argumentsProvider = function1;
        this.componentPredicate = componentPredicate2;
        this.viewLoadingTimer = viewLoadingTimer2;
        this.rumMonitor = rumMonitor2;
        this.advancedRumMonitor = advancedRumMonitor2;
    }

    public void register(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
    }

    public void unregister(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        fragmentActivity.getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(context, "context");
        super.onFragmentAttached(fragmentManager, fragment, context);
        if (this.componentPredicate.accept(fragment)) {
            this.viewLoadingTimer.onCreated(resolveKey(fragment));
        }
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentStarted(fragmentManager, fragment);
        if (this.componentPredicate.accept(fragment)) {
            this.viewLoadingTimer.onStartLoading(resolveKey(fragment));
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

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentResumed(fragmentManager, fragment);
        if (this.componentPredicate.accept(fragment)) {
            Object resolveKey = resolveKey(fragment);
            this.viewLoadingTimer.onFinishedLoading(resolveKey);
            String viewName = this.componentPredicate.getViewName(fragment);
            CharSequence charSequence = viewName;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                viewName = ViewUtilsKt.resolveViewUrl((Object) fragment);
            }
            this.rumMonitor.startView(resolveKey, viewName, getArgumentsProvider$dd_sdk_android_release().invoke(fragment));
            Long loadingTime = this.viewLoadingTimer.getLoadingTime(resolveKey);
            if (loadingTime != null) {
                this.advancedRumMonitor.updateViewLoadingTime(resolveKey, loadingTime.longValue(), resolveLoadingType(this.viewLoadingTimer.isFirstTimeLoading(resolveKey)));
            }
        }
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentPaused(fragmentManager, fragment);
        if (this.componentPredicate.accept(fragment)) {
            Object resolveKey = resolveKey(fragment);
            RumMonitor.DefaultImpls.stopView$default(this.rumMonitor, resolveKey, (Map) null, 2, (Object) null);
            this.viewLoadingTimer.onPaused(resolveKey);
        }
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        super.onFragmentDestroyed(fragmentManager, fragment);
        if (this.componentPredicate.accept(fragment)) {
            this.viewLoadingTimer.onDestroyed(resolveKey(fragment));
        }
    }

    private final ViewEvent.LoadingType resolveLoadingType(boolean z) {
        if (z) {
            return ViewEvent.LoadingType.FRAGMENT_DISPLAY;
        }
        return ViewEvent.LoadingType.FRAGMENT_REDISPLAY;
    }
}
