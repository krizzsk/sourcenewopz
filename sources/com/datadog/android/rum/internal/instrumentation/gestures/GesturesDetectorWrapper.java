package com.datadog.android.rum.internal.instrumentation.gestures;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesDetectorWrapper;", "", "context", "Landroid/content/Context;", "gestureListener", "Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;", "(Landroid/content/Context;Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;)V", "defaultGesturesDetector", "Landroidx/core/view/GestureDetectorCompat;", "(Lcom/datadog/android/rum/internal/instrumentation/gestures/GesturesListener;Landroidx/core/view/GestureDetectorCompat;)V", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GesturesDetectorWrapper.kt */
public final class GesturesDetectorWrapper {

    /* renamed from: a */
    private final GesturesListener f3841a;

    /* renamed from: b */
    private final GestureDetectorCompat f3842b;

    public GesturesDetectorWrapper(GesturesListener gesturesListener, GestureDetectorCompat gestureDetectorCompat) {
        Intrinsics.checkNotNullParameter(gesturesListener, "gestureListener");
        Intrinsics.checkNotNullParameter(gestureDetectorCompat, "defaultGesturesDetector");
        this.f3841a = gesturesListener;
        this.f3842b = gestureDetectorCompat;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GesturesDetectorWrapper(Context context, GesturesListener gesturesListener) {
        this(gesturesListener, new GestureDetectorCompat(context, gesturesListener));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gesturesListener, "gestureListener");
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.f3842b.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.f3841a.onUp(motionEvent);
        }
    }
}
