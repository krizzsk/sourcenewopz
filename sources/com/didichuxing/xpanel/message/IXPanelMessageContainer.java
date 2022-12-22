package com.didichuxing.xpanel.message;

import android.view.View;

public interface IXPanelMessageContainer {
    void addMessageItem(XPanelMessageItem xPanelMessageItem);

    View getView();

    void removeMessageItem(XPanelMessageItem xPanelMessageItem);
}
