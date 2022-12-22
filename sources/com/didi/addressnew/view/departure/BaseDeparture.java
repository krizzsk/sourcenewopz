package com.didi.addressnew.view.departure;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;

public abstract class BaseDeparture {

    public interface FetchStartPoiInfoCallback {

        /* renamed from: com.didi.addressnew.view.departure.BaseDeparture$FetchStartPoiInfoCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onFetchFailed(FetchStartPoiInfoCallback fetchStartPoiInfoCallback, LatLng latLng) {
            }

            public static void $default$onFetchStart(FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
            }

            public static void $default$onFetchSuccess(FetchStartPoiInfoCallback fetchStartPoiInfoCallback, DepartureAddress departureAddress) {
            }
        }

        void onFetchFailed(LatLng latLng);

        void onFetchStart();

        void onFetchSuccess(DepartureAddress departureAddress);
    }

    public abstract void start(Context context, AddressParam addressParam, FetchStartPoiInfoCallback fetchStartPoiInfoCallback);

    public abstract void startVerifyStationAddress(Context context, AddressParam addressParam, FetchStartPoiInfoCallback fetchStartPoiInfoCallback, RpcPoi rpcPoi);

    public abstract void stop();
}
