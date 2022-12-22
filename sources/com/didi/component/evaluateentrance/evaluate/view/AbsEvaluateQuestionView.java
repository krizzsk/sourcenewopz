package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsEvaluateQuestionPresenter;

public abstract class AbsEvaluateQuestionView implements IEvaluateQuestionView {
    protected final Context context;
    protected ViewGroup parentView;
    protected AbsEvaluateQuestionPresenter presenter;

    public AbsEvaluateQuestionView(Context context2) {
        this.context = context2;
    }

    public View getView() {
        return this.parentView;
    }

    public void setPresenter(AbsEvaluateQuestionPresenter absEvaluateQuestionPresenter) {
        this.presenter = absEvaluateQuestionPresenter;
    }
}
