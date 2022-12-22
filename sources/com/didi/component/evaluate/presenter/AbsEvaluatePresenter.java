package com.didi.component.evaluate.presenter;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluate.view.IEvaluateView;

public abstract class AbsEvaluatePresenter extends BaseExpressPresenter<IEvaluateView> implements OnRetryListener, IEvaluateView.EvaluateListener, IEvaluateView.OnCancelListener, IEvaluateView.OnCloseListener {
    public AbsEvaluatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
