package com.didi.component.openride;

import com.didi.component.core.IView;

public interface INewOpenRideView extends IView<AbsNewOpenRidePresenter> {
    boolean isShowTips();

    boolean isVisible();

    void setTranslationY(int i);

    void setVisible(boolean z);
}
