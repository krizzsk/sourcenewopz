package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.Window;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/DatadogGesturesTracker;", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesTracker;", "targetAttributesProviders", "", "Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "interactionPredicate", "Lcom/datadog/android/rum/tracking/InteractionPredicate;", "([Lcom/datadog/android/rum/tracking/ViewAttributesProvider;Lcom/datadog/android/rum/tracking/InteractionPredicate;)V", "getInteractionPredicate$dd_sdk_android_release", "()Lcom/datadog/android/rum/tracking/InteractionPredicate;", "getTargetAttributesProviders$dd_sdk_android_release", "()[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "[Lcom/datadog/android/rum/tracking/ViewAttributesProvider;", "equals", "", "other", "", "generateGestureDetector", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "generateGestureDetector$dd_sdk_android_release", "hashCode", "", "startTracking", "", "stopTracking", "toString", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogGesturesTracker.kt */
public final class DatadogGesturesTracker implements GesturesTracker {

    /* renamed from: a */
    private final ViewAttributesProvider[] f3839a;

    /* renamed from: b */
    private final InteractionPredicate f3840b;

    public DatadogGesturesTracker(ViewAttributesProvider[] viewAttributesProviderArr, InteractionPredicate interactionPredicate) {
        Intrinsics.checkNotNullParameter(viewAttributesProviderArr, "targetAttributesProviders");
        Intrinsics.checkNotNullParameter(interactionPredicate, "interactionPredicate");
        this.f3839a = viewAttributesProviderArr;
        this.f3840b = interactionPredicate;
    }

    public final ViewAttributesProvider[] getTargetAttributesProviders$dd_sdk_android_release() {
        return this.f3839a;
    }

    public final InteractionPredicate getInteractionPredicate$dd_sdk_android_release() {
        return this.f3840b;
    }

    public void startTracking(Window window, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (window != null) {
            Window.Callback callback = window.getCallback();
            if (callback == null) {
                callback = new NoOpWindowCallback();
            }
            window.setCallback(new WindowCallbackWrapper(callback, generateGestureDetector$dd_sdk_android_release(context, window), this.f3840b, (Function1) null, 8, (DefaultConstructorMarker) null));
        }
    }

    public void stopTracking(Window window, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (window != null) {
            Window.Callback callback = window.getCallback();
            if (callback instanceof WindowCallbackWrapper) {
                WindowCallbackWrapper windowCallbackWrapper = (WindowCallbackWrapper) callback;
                if (!(windowCallbackWrapper.getWrappedCallback() instanceof NoOpWindowCallback)) {
                    window.setCallback(windowCallbackWrapper.getWrappedCallback());
                } else {
                    window.setCallback((Window.Callback) null);
                }
            }
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
            DatadogGesturesTracker datadogGesturesTracker = (DatadogGesturesTracker) obj;
            return Arrays.equals(this.f3839a, datadogGesturesTracker.f3839a) && Intrinsics.areEqual((Object) this.f3840b.getClass(), (Object) datadogGesturesTracker.f3840b.getClass());
        }
        throw new NullPointerException("null cannot be cast to non-null type com.datadog.android.rum.internal.instrumentation.gestures.DatadogGesturesTracker");
    }

    public int hashCode() {
        int hashCode = 527 + Arrays.hashCode(this.f3839a) + 17;
        return hashCode + (hashCode * 31) + this.f3840b.getClass().hashCode();
    }

    public String toString() {
        return "DatadogGesturesTracker(" + ArraysKt.joinToString$default((Object[]) this.f3839a, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + VersionRange.RIGHT_OPEN;
    }

    public final GesturesDetectorWrapper generateGestureDetector$dd_sdk_android_release(Context context, Window window) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(window, "window");
        return new GesturesDetectorWrapper(context, new GesturesListener(new WeakReference(window), this.f3839a, this.f3840b));
    }
}
