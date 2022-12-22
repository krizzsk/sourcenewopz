package com.didi.component.notalk.view;

import com.didi.component.core.IView;
import com.didi.component.notalk.presenter.AbsNoTalkPresenter;

public interface INoTalkView extends IView<AbsNoTalkPresenter> {
    void clearTipsView();

    boolean isVisible();

    void setTranslationY(int i);

    void setVisible(boolean z);

    void showTipsView(String str, int i);
}
