package com.didichuxing.xpanel.base;

import android.view.View;

public interface IXPanelChildView<T> {
    void bind(T t);

    boolean contain(float f, float f2);

    void destroy();

    int getMarginLeft();

    int getMarginRight();

    View getView();

    int halfHeight();

    void initData(XPanelCardData xPanelCardData);

    void setRoundCorner(float f);
}
