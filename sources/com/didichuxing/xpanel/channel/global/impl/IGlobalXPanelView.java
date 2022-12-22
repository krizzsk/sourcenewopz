package com.didichuxing.xpanel.channel.global.impl;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.didichuxing.xpanel.base.IStateChangeListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.channel.global.widget.XPanelHeaderBarView;
import com.didichuxing.xpanel.message.IXPanelMessageContainer;

public interface IGlobalXPanelView {
    void addStateChangeListener(IStateChangeListener iStateChangeListener);

    @Deprecated
    void changeXPanelShowHeight(boolean z);

    @Deprecated
    void disableXPanelDownBtn();

    @Deprecated
    void enableXPanelDownBtn();

    View findViewByXPanelCardData(XPanelCardData xPanelCardData);

    @Deprecated
    XPanelHeaderBarView getHeaderBarView();

    IXPanelMessageContainer getMessageContainer();

    @Deprecated
    TextView getMessageTip();

    @Deprecated
    void hideMessageTip();

    boolean isListEmpty();

    void moveToResetPosition();

    void resetPosition();

    void scrollLength(int i);

    void setBottomMaxShowHeight(boolean z);

    void setLoadingView(View view);

    void setNavigationText(CharSequence charSequence);

    void setTopOffset(int i);

    void setXPanelCallBack(IXPanelCallBack iXPanelCallBack);

    @Deprecated
    void setXPanelShadowBg(int i);

    @Deprecated
    void setXPanelShadowBg(Drawable drawable);

    @Deprecated
    void showMessageTip(String str);
}
