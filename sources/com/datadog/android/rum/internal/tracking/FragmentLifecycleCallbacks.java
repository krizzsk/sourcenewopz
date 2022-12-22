package com.datadog.android.rum.internal.tracking;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/tracking/FragmentLifecycleCallbacks;", "T", "Landroid/app/Activity;", "", "register", "", "activity", "(Landroid/app/Activity;)V", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FragmentLifecycleCallbacks.kt */
public interface FragmentLifecycleCallbacks<T extends Activity> {
    void register(T t);

    void unregister(T t);
}
