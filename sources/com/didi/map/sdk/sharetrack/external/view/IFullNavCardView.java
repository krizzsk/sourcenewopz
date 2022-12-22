package com.didi.map.sdk.sharetrack.external.view;

import android.graphics.Bitmap;

public interface IFullNavCardView extends ISkin {
    void finishLoadingRoute();

    void onGpsStatusChanged(int i);

    void onLaneEvent(Bitmap bitmap, int i);

    void onLoadingRoute();

    void setIntersection(int i, int i2);

    void setLeftDistance(int i);

    void setRoadName(String str);
}
