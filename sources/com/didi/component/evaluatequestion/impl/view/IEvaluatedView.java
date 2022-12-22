package com.didi.component.evaluatequestion.impl.view;

import com.didi.component.core.IView;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;

public interface IEvaluatedView extends IView<AbsEvaluateQuestionPresenter> {
    void close();

    void hideError();

    void hideLoading();

    void onEvaluateDialogClosed();

    void showError();

    void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel);

    void showLoading();

    void showUnevaluated();

    void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel);
}
