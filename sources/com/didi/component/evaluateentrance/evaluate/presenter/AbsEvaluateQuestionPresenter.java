package com.didi.component.evaluateentrance.evaluate.presenter;

import android.content.Context;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.core.ComponentParams;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionModel;
import com.didi.component.evaluateentrance.evaluate.view.AbsEvaluateQuestionView;

public abstract class AbsEvaluateQuestionPresenter extends AbsEvaluatePresenter<AbsEvaluateQuestionView> implements XpNewAdapter {
    public abstract void onEvaluatedClicked(int i, EvaluateQuestionModel evaluateQuestionModel);

    public abstract void showAfterEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel);

    public abstract void showBeforeEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel);

    public AbsEvaluateQuestionPresenter(Context context) {
        super(context);
    }

    public AbsEvaluateQuestionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
