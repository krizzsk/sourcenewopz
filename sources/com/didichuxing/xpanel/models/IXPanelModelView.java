package com.didichuxing.xpanel.models;

import android.content.Context;
import com.didichuxing.xpanel.base.IXPanelChildView;

public interface IXPanelModelView<T> extends IXPanelChildView<T> {
    void hideCornMark();

    void init(Context context);

    void setRoundCorner(float f);

    void showCornMark();
}
