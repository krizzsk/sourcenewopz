package com.didi.map.sdk.sharetrack.external.round;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.sharetrack.entity.OrderInfo;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0012H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/map/sdk/sharetrack/external/round/IBaseStrategy;", "", "initComplete", "", "offRoute", "setEndPoint", "latLng", "Lcom/didi/common/map/model/LatLng;", "setOrderInfo", "orderInfo", "Lcom/didi/map/sdk/sharetrack/entity/OrderInfo;", "setStatusChangeListener", "listener", "Lcom/didi/map/sdk/sharetrack/external/round/IRoundStatusChangeListener;", "trackWhenRouteInvisibleDirectly", "tryTrackWhenRouteInvisible", "updateEDA", "eda", "", "updateETA", "eta", "updateMatchLocation", "loc", "Lcom/didi/common/map/model/GpsLocation;", "updateParkingStatus", "parkingStatus", "updateRouteId", "routeId", "", "CommonShareTrack_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: IBaseStrategy.kt */
public interface IBaseStrategy {
    void initComplete();

    void offRoute();

    void setEndPoint(LatLng latLng);

    void setOrderInfo(OrderInfo orderInfo);

    void setStatusChangeListener(IRoundStatusChangeListener iRoundStatusChangeListener);

    void trackWhenRouteInvisibleDirectly();

    void tryTrackWhenRouteInvisible();

    void updateEDA(int i);

    void updateETA(int i);

    void updateMatchLocation(GpsLocation gpsLocation);

    void updateParkingStatus(int i);

    void updateRouteId(String str);
}
