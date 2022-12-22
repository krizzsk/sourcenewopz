package com.didi.component.evaluateentrance.evaluate.view;

import com.didi.component.core.IView;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionModel;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsEvaluateQuestionPresenter;

public interface IEvaluateQuestionView extends IView<AbsEvaluateQuestionPresenter> {
    void hideError();

    void hideLoading();

    void initData(EvaluateQuestionModel evaluateQuestionModel);

    void showAfterEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel);

    void showBeforeEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel);

    void showError();

    void showLoading();
}
