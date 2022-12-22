package com.didiglobal.xpanelnew.message;

import android.view.View;

public interface IXpMessageContainer {
    void addMessageItem(XpMessageItem xpMessageItem);

    View getView();
}
