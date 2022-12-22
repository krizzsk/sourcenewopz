package com.didi.component.estimate;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.estimate.newui.view.IV2EstimateView;
import com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.component.estimate.presenter.EstimatePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ComponentRegister(product = "ride", type = "estimate")
@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/component/estimate/EstimateComponent;", "Lcom/didi/component/base/BaseComponent;", "Lcom/didi/component/estimate/newui/view/IV2EstimateView;", "Lcom/didi/component/estimate/presenter/AbsEstimatePresenter;", "()V", "onCreatePresenter", "params", "Lcom/didi/component/core/ComponentParams;", "onCreateView", "container", "Landroid/view/ViewGroup;", "comp-estimate_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EstimateComponent.kt */
public final class EstimateComponent extends BaseComponent<IV2EstimateView, AbsEstimatePresenter<IV2EstimateView>> {
    /* access modifiers changed from: protected */
    public AbsEstimatePresenter<IV2EstimateView> onCreatePresenter(ComponentParams componentParams) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        return new EstimatePresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IV2EstimateView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(componentParams, "params");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        return new NewVerticalEstimateView(componentParams.bizCtx.getContext(), viewGroup);
    }
}
