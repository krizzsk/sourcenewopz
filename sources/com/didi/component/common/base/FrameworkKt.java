package com.didi.component.common.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.lifecycle.LifecycleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"#\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"'\u0010\u0006\u001a\u00020\u0001\"\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo175978d2 = {"hostLifecycle", "Landroidx/lifecycle/Lifecycle;", "T", "Lcom/didi/component/common/base/BaseExpressPresenter;", "getHostLifecycle", "(Lcom/didi/component/common/base/BaseExpressPresenter;)Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lcom/didi/component/base/BaseComponent;", "getLifecycle", "(Lcom/didi/component/base/BaseComponent;)Landroidx/lifecycle/Lifecycle;", "common_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Framework.kt */
public final class FrameworkKt {
    public static final <T extends BaseExpressPresenter<?>> Lifecycle getHostLifecycle(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Fragment fragment = t.mComponentParams.getFragment();
        Lifecycle lifecycle = fragment == null ? null : fragment.getLifecycle();
        return lifecycle == null ? LifecycleKt.getDeadLifecycle() : lifecycle;
    }

    public static final <T extends BaseComponent<?, ?>> Lifecycle getLifecycle(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Fragment fragment = t.getParams().getFragment();
        Lifecycle lifecycle = fragment == null ? null : fragment.getLifecycle();
        return lifecycle == null ? LifecycleKt.getDeadLifecycle() : lifecycle;
    }
}
