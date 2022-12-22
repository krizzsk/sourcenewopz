package com.didi.map.sdk.sharetrack.callback;

import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import java.util.ArrayList;

public interface ISearchOffRouteCallback {
    void onOffRoute();

    void onRetryFail();

    void onSuccess(ArrayList<NaviRoute> arrayList);
}
