package com.didi.component.safetoolkit;

import android.view.View;
import com.didi.component.common.model.SafeToolkitBean;
import com.didi.component.core.IView;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;

public interface ISafeToolkitView extends IView<AbsSafeToolkitPresenter> {
    void dismissBubble(Runnable runnable);

    void dismissWelcome(Runnable runnable);

    boolean isBubbleShown();

    boolean isVisibility();

    boolean isWelcomeShown();

    void resetBreathAnim();

    void setDismissedByAlpha(boolean z);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setSafeToolkitStatusAndShow(SafeToolkitBean.SafeToolkitData safeToolkitData);

    void setTranslationY(int i);

    void setVisibility(boolean z);
}
