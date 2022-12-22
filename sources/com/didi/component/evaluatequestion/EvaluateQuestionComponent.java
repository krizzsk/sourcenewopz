package com.didi.component.evaluatequestion;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluatequestion.impl.presenter.EndServiceEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.impl.view.EndServiceEvaluateQuestionView;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;

@ComponentRegister(product = "ride", type = "evaluate_question")
public class EvaluateQuestionComponent extends BaseComponent<IEvaluatedView, AbsEvaluateQuestionPresenter> {
    /* access modifiers changed from: protected */
    public AbsEvaluateQuestionPresenter onCreatePresenter(ComponentParams componentParams) {
        return new EndServiceEvaluateQuestionPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IEvaluatedView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EndServiceEvaluateQuestionView(componentParams.getActivity(), viewGroup);
    }
}
