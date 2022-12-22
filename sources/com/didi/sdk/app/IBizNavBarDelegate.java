package com.didi.sdk.app;

public interface IBizNavBarDelegate {
    int getBizBarHeight();

    void hideBizBar();

    void hideBizBarDivider();

    void setBizBarBackgroundColor(int i);

    void showBizBar();

    void showBizBarDivider();
}
