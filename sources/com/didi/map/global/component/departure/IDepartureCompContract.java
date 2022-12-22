package com.didi.map.global.component.departure;

import android.view.View;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IDataComponent;

public interface IDepartureCompContract extends IBaseComponent<DepartureCompParams>, IDataComponent {

    public interface IDepartureComponentCallback {

        /* renamed from: com.didi.map.global.component.departure.IDepartureCompContract$IDepartureComponentCallback$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onBroadOtherMapCallback(IDepartureComponentCallback iDepartureComponentCallback, int i) {
            }

            public static void $default$onClickBroadOtherInStationCard(IDepartureComponentCallback iDepartureComponentCallback, DepartureAddress departureAddress) {
            }

            public static void $default$onClickBubble(IDepartureComponentCallback iDepartureComponentCallback) {
            }

            public static void $default$onConfirmPickup(IDepartureComponentCallback iDepartureComponentCallback, DepartureAddress departureAddress) {
            }

            public static void $default$onDepartureAddressChanged(IDepartureComponentCallback iDepartureComponentCallback, DepartureAddress departureAddress) {
            }

            public static void $default$onDepartureLoading(IDepartureComponentCallback iDepartureComponentCallback, LatLng latLng) {
            }

            public static void $default$onDragging(IDepartureComponentCallback iDepartureComponentCallback, int i) {
            }

            public static void $default$onFetchAddressFail(IDepartureComponentCallback iDepartureComponentCallback, LatLng latLng) {
            }

            public static void $default$onStartDragging(IDepartureComponentCallback iDepartureComponentCallback) {
            }

            public static void $default$onStartSugPage(IDepartureComponentCallback iDepartureComponentCallback, DepartureAddress departureAddress) {
            }

            public static void $default$onStartTerminalWindow(IDepartureComponentCallback iDepartureComponentCallback, DepartureAddress departureAddress) {
            }

            public static void $default$onUp(IDepartureComponentCallback iDepartureComponentCallback) {
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

        void onStartSugPage(DepartureAddress departureAddress);

        void onStartTerminalWindow(DepartureAddress departureAddress);

        void onUp();
    }

    void addOrderInterceptListener(DepartureInterceptController.IInterceptListener iInterceptListener);

    DepartureAddress getDepartureAddress();

    View getDepartureCardView();

    DepartureLocationInfo getLocationInfo();

    boolean isShowTerminalViewOnSetPickupSpotAfter();

    void onConfirmClickInBroadOther();

    void registerCallback(IDepartureComponentCallback iDepartureComponentCallback);

    void setFenceVisible(boolean z);

    void setPadding(Padding padding);

    void startTerminalSelect();

    void updateDepartureLocation(DepartureLocationInfo departureLocationInfo);

    void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo);
}
