package com.didiglobal.xpanelnew.sdk;

import android.view.View;
import com.didiglobal.xpanelnew.base.IXpLife;
import com.didiglobal.xpanelnew.base.XpCardProperty;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.base.XpOmegaConfig;
import com.didiglobal.xpanelnew.message.IXpMessageContainer;
import java.util.List;

public interface IXpanelNew extends IXpLife {
    void addCard(XpCardProperty xpCardProperty, int i);

    void cardHeightChange(int i, int i2);

    void firstCardHeightWillChangeTo(XpConfig xpConfig);

    void fistCardHeightChange(int i);

    int getFirstCardHeight();

    IXpMessageContainer getMessageContainer();

    int getMessageRealHeight();

    View getView();

    void refreshMsgHeight();

    void removeCard(int i);

    void setConfig(XpConfig xpConfig);

    void setData(List<XpCardProperty> list);

    void setOmegaConfig(XpOmegaConfig xpOmegaConfig);

    void setShowOneCard();

    void setTitle(String str);
}
