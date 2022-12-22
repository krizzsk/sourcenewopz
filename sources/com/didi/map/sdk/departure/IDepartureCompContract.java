package com.didi.map.sdk.departure;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IDataComponent;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;

public interface IDepartureCompContract extends IBaseComponent<DepartureCompParam>, IDataComponent {

    public interface IDepartueCompCallback {
        void onDepartureAddressChanged(DepartureAddress departureAddress);

        void onDepartureLoading(LatLng latLng);

        void onFetchAddressFailed(LatLng latLng);

        void onStartDragging();
    }

    <T extends DepartureBubble> T createDepartureBubble(Class<T> cls);

    boolean isStarted();

    void removeDepartureBubble(boolean z);

    void updateDepartureLocation(DepartureLocationInfo departureLocationInfo, boolean z);
}
