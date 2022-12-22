package com.didi.map.global.component.dropoff.core;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.sdk.poibase.model.RpcPoi;
import java.util.List;

public interface DropOffContract {

    public interface Presenter {
        void destroy();

        RpcPoi getAdsorptionPoi();

        void getDiscountData();

        DropOffAddress getDropOffAddress(RpcPoi rpcPoi);

        RpcPoi getNeareatReconmmendPoi(LatLng latLng);

        List<RpcPoi> getReconmmendRpcPois();

        void setContext(Context context, Map map);

        void startDataTask(DropOffLocationInfo dropOffLocationInfo, boolean z);
    }

    public interface View {
        void getDropOffData(DropOffLocationInfo dropOffLocationInfo, boolean z);

        void onAddressFetchResult(boolean z, DropOffAddress dropOffAddress);

        void onDataLoading();

        void refreshPinView(DropOffAddress dropOffAddress);

        void showCardView(DropOffAddress dropOffAddress);

        void showReconmmnedMarkers(List<RecPoint> list, RecPoint recPoint);
    }
}
