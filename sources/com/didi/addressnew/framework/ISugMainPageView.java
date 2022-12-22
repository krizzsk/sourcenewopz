package com.didi.addressnew.framework;

import com.didi.address.GlobalSugCallback;

public interface ISugMainPageView {
    void onCloseSugPage();

    void postAsyncSessionCloseCallback(GlobalSugCallback globalSugCallback);

    void setPageDragEnable(boolean z);
}
