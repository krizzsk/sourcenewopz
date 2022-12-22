package com.didi.map.sdk.sharetrack.callback;

import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import java.util.ArrayList;

public interface ISearchRouteCallback {
    void onBeginToSearch();

    void onFinishToSearch(ArrayList<NaviRoute> arrayList, String str);
}
