package com.didi.addressnew.framework.fragmentmarket.map;

import android.content.Context;
import com.didi.address.model.WayPoint;

public interface ISugWayPointPageView {
    boolean addWayPoint(WayPoint wayPoint);

    Context getPageContext();

    void onWayPointsUpdated();

    boolean removeWayPoint(WayPoint wayPoint);

    void resetWayPointList();

    void setSubmitEnable(boolean z);

    void updateAddStopEnterVisible(WayPoint wayPoint, boolean z);

    void updatePageContent();

    boolean updateWayPoint(WayPoint wayPoint);
}
