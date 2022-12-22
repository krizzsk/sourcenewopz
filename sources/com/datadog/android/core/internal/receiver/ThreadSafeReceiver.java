package com.datadog.android.core.internal.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000e"}, mo175978d2 = {"Lcom/datadog/android/core/internal/receiver/ThreadSafeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "isRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "filter", "Landroid/content/IntentFilter;", "unregisterReceiver", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreadSafeReceiver.kt */
public abstract class ThreadSafeReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final AtomicBoolean f3580a = new AtomicBoolean(false);

    public final AtomicBoolean isRegistered() {
        return this.f3580a;
    }

    public final Intent registerReceiver(Context context, IntentFilter intentFilter) {
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "filter");
        try {
            intent = context.registerReceiver(this, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
            intent = null;
        }
        this.f3580a.set(true);
        return intent;
    }

    public final void unregisterReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f3580a.compareAndSet(true, false)) {
            try {
                context.unregisterReceiver(this);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
        }
    }
}
