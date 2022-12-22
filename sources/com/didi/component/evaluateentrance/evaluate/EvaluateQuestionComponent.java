package com.didi.component.evaluateentrance.evaluate;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluateentrance.evaluate.presenter.EvaluateQuestionPresenter;
import com.didi.component.evaluateentrance.evaluate.view.AbsEvaluateQuestionView;
import com.didi.component.evaluateentrance.evaluate.view.EvaluateQuestionView;

@ComponentRegister(product = "ride", type = "evaluate_question_entrance")
public class EvaluateQuestionComponent extends BaseComponent<AbsEvaluateQuestionView, AbsEvaluateQuestionPresenter> {
    /* access modifiers changed from: protected */
    public AbsEvaluateQuestionView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new EvaluateQuestionView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsEvaluateQuestionPresenter onCreatePresenter(ComponentParams componentParams) {
        return new EvaluateQuestionPresenter(componentParams);
    }
}
