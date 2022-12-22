package com.didi.component.evaluatequestion;

import android.os.Bundle;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;

public abstract class AbsEvaluateQuestionPresenter extends BaseExpressPresenter<IEvaluatedView> {
    public abstract void close();

    public abstract void onEvaluatedClicked(int i);

    public AbsEvaluateQuestionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel) {
        ((IEvaluatedView) this.mView).showUnevaluated(unevaluatedViewModel);
    }

    /* access modifiers changed from: protected */
    public void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel) {
        ((IEvaluatedView) this.mView).showEvaluated(i, unevaluatedViewModel);
    }

    /* access modifiers changed from: protected */
    public void showUnevaluated() {
        ((IEvaluatedView) this.mView).showUnevaluated();
    }
}
