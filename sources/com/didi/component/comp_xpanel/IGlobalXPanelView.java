package com.didi.component.comp_xpanel;

import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.didi.component.common.loading.ILoadingView;
import com.didi.component.core.IViewContainer;
import com.didichuxing.xpanel.channel.global.GlobalXPanel;

public interface IGlobalXPanelView extends ILoadingView<AbsGlobalXPanelPresenter>, IViewContainer {
    long getAnimateDuration();

    GlobalXPanel getXPanel();

    void hide();

    void hide(long j);

    void hide(long j, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener);

    boolean isShown();

    void resetHalfCardHeight(int i);

    void resetHeight(int i);

    void setVisibilityChangedListener(IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener);

    void show();

    void show(long j);

    void show(long j, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener);
}
