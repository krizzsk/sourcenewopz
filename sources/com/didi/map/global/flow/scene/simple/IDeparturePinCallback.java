package com.didi.map.global.flow.scene.simple;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;

public interface IDeparturePinCallback {

    /* renamed from: com.didi.map.global.flow.scene.simple.IDeparturePinCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onBroadOtherMapCallback(IDeparturePinCallback iDeparturePinCallback, int i) {
        }

        public static void $default$onClickBroadOtherInStationCard(IDeparturePinCallback iDeparturePinCallback, DepartureAddress departureAddress) {
        }

        public static void $default$onClickBubble(IDeparturePinCallback iDeparturePinCallback) {
        }

        public static void $default$onConfirmPickup(IDeparturePinCallback iDeparturePinCallback, DepartureAddress departureAddress) {
        }

        public static void $default$onDepartureAddressChanged(IDeparturePinCallback iDeparturePinCallback, DepartureAddress departureAddress) {
        }

        public static void $default$onDepartureLoading(IDeparturePinCallback iDeparturePinCallback, LatLng latLng) {
        }

        public static void $default$onDragging(IDeparturePinCallback iDeparturePinCallback, int i) {
        }

        public static void $default$onFetchAddressFail(IDeparturePinCallback iDeparturePinCallback, LatLng latLng) {
        }

        public static void $default$onStartDragging(IDeparturePinCallback iDeparturePinCallback) {
        }

        public static void $default$onStartSugPage(IDeparturePinCallback iDeparturePinCallback, Address address) {
        }

        public static void $default$onStartTerminalWindow(IDeparturePinCallback iDeparturePinCallback, DepartureAddress departureAddress) {
        }
    }

    void onBroadOtherMapCallback(int i);

    void onClickBroadOtherInStationCard(DepartureAddress departureAddress);

    void onClickBubble();

    void onConfirmPickup(DepartureAddress departureAddress);

    void onDepartureAddressChanged(DepartureAddress departureAddress);

    void onDepartureLoading(LatLng latLng);

    void onDragging(int i);

    void onFetchAddressFail(LatLng latLng);

    void onStartDragging();

    void onStartSugPage(Address address);

    void onStartTerminalWindow(DepartureAddress departureAddress);
}
