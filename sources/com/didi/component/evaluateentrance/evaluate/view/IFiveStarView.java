package com.didi.component.evaluateentrance.evaluate.view;

import com.didi.component.core.IView;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;

public interface IFiveStarView extends IView<AbsFiveStarPresenter> {
    void initData(FiveStarModel fiveStarModel);

    void showEvaluated(int i);
}
