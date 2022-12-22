package com.didiglobal.p205sa.biz.component.ridecard;

import android.app.Activity;
import android.view.ViewGroup;
import com.didi.component.never.base.BaseComponent;
import com.didi.component.never.core.ComponentParams;
import com.didi.component_processor.annonation.ComponentName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/ridecard/RideCardComponent;", "Lcom/didi/component/never/base/BaseComponent;", "Lcom/didiglobal/sa/biz/component/ridecard/RideCardView;", "Lcom/didiglobal/sa/biz/component/ridecard/RideCardPresenter;", "()V", "onCreatePresenter", "params", "Lcom/didi/component/never/core/ComponentParams;", "onCreateView", "container", "Landroid/view/ViewGroup;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@ComponentName(category = 2, type = "sa_panel_address")
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardComponent */
/* compiled from: RideCardComponent.kt */
public final class RideCardComponent extends BaseComponent<RideCardView, RideCardPresenter> {
    /* access modifiers changed from: protected */
    public RideCardPresenter onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return new RideCardPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public RideCardView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Activity activity = componentParams.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "params.activity");
        return new RideCardView(activity);
    }
}
