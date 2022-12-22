package com.didi.map.global.component.dropoff.pin;

import android.content.Context;
import android.view.View;
import com.didi.common.map.Map;

public interface IDropOffPinView {
    void add();

    void create(Context context, Map map);

    void destroy();

    boolean isVisible();

    void onMapVisible(boolean z);

    void remove();

    void setConfigParam(PinStyle pinStyle);

    void showText(String str);

    void showView(View view, int i, int i2, int i3);

    void startDragging();

    void startDragging_Ex();

    void startLoading(boolean z);

    void stopAnimation();

    void toNoParking();

    void visible(boolean z);
}
