package com.didi.map.global.component.departure.data;

import android.content.Context;
import com.didi.common.map.Map;

public interface IDepartureHttpTask {
    void create(Context context, Map map);

    void destroy();

    void onMapVisible(boolean z);

    void setConfigParam(DepartureHttpTaskParam departureHttpTaskParam);

    void start();

    void stop();
}
