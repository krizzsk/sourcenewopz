package com.didi.component.evaluate;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluate.presenter.AbsEvaluatePresenter;
import com.didi.component.evaluate.view.EvaluateView;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.NewEvaluateView;

public abstract class AbsEvaluateComponent extends BaseComponent<IEvaluateView, AbsEvaluatePresenter> {
    /* access modifiers changed from: protected */
    public abstract AbsEvaluatePresenter onCreatePresenter(ComponentParams componentParams);

    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, IEvaluateView iEvaluateView, AbsEvaluatePresenter absEvaluatePresenter) {
        iEvaluateView.setEvaluateListener(absEvaluatePresenter);
        iEvaluateView.setOnCancelListener(absEvaluatePresenter);
        iEvaluateView.setOnCloseListener(absEvaluatePresenter);
        iEvaluateView.setOnRetryListener(absEvaluatePresenter);
    }

    /* access modifiers changed from: protected */
    public IEvaluateView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (GlobalApolloUtil.isNewEvaluate()) {
            return new NewEvaluateView(componentParams.bizCtx.getContext(), 0);
        }
        return new EvaluateView(componentParams.getActivity());
    }
}
