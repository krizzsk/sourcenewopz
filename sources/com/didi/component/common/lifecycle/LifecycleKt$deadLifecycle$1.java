package com.didi.component.common.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.didi.component.common.util.GLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/component/common/lifecycle/LifecycleKt$deadLifecycle$1", "Landroidx/lifecycle/Lifecycle;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "getCurrentState", "Landroidx/lifecycle/Lifecycle$State;", "removeObserver", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Lifecycle.kt */
public final class LifecycleKt$deadLifecycle$1 extends Lifecycle {
    public void removeObserver(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
    }

    LifecycleKt$deadLifecycle$1() {
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        Intrinsics.checkNotNullParameter(lifecycleObserver, "observer");
        GLog.m7973w(Intrinsics.stringPlus("Lifecycle dead, observer invalid: ", lifecycleObserver));
    }

    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.DESTROYED;
    }
}
