package com.didi.component.safetoolkit.views;

import com.didi.component.core.IView;
import com.didi.component.safetoolkit.presenter.AbsJarvisPresenter;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;

public interface IJarvisView extends IView<AbsJarvisPresenter> {
    void closeSafePanel();

    void onBackHome();

    void onLeaveHome();

    void onRemove();

    void setBubbleData(SfBubbleData sfBubbleData);

    void setJarvisData(SfJarvisData sfJarvisData);

    void setJarvisDismissedByAlpha(boolean z);

    void setJarvisVisible(int i);

    void setTranslationY(int i);
}
