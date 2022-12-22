package com.didi.map.sdk.component;

import android.content.Context;
import com.didi.common.map.Map;

public interface IBaseComponent<T> {
    void create(Context context, Map map);

    void destroy();

    void onMapVisible(boolean z);

    void setConfigParam(T t);
}
