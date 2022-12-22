package com.didi.component.framework.base.constructor.interfaces.view;

import android.os.Bundle;

public interface IEvaluateControlView {
    boolean hideEvaluateQuestionView();

    boolean hideEvaluateView();

    void showEvaluateQuestionView(Bundle bundle);

    void showEvaluateView(Bundle bundle);
}
