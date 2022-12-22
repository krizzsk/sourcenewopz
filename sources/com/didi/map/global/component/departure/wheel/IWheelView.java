package com.didi.map.global.component.departure.wheel;

import com.didi.map.global.component.departure.wheel.internal.BaseWheelAdapter;
import java.util.List;

public interface IWheelView<T> {
    public static final boolean CLICKABLE = false;
    public static final int WHEEL_SIZE = 3;

    void setWheelAdapter(BaseWheelAdapter<T> baseWheelAdapter);

    void setWheelClickable(boolean z);

    void setWheelData(List<T> list);

    void setWheelSize(int i);
}
