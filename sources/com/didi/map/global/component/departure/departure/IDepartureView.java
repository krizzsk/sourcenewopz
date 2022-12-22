package com.didi.map.global.component.departure.departure;

import android.view.View;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.controller.DepartureInterceptController;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;

public interface IDepartureView {

    /* renamed from: com.didi.map.global.component.departure.departure.IDepartureView$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addOrderInterceptListener(IDepartureView iDepartureView, DepartureInterceptController.IInterceptListener iInterceptListener) {
        }

        public static void $default$destroy(IDepartureView iDepartureView) {
        }

        public static DepartureAddress $default$getDepartureAddress(IDepartureView iDepartureView) {
            return null;
        }

        public static View $default$getDepartureCardView(IDepartureView iDepartureView) {
            return null;
        }

        public static DepartureLocationInfo $default$getLocationInfo(IDepartureView iDepartureView) {
            return null;
        }

        public static boolean $default$isShowTerminalViewOnSetPickupSpotAfter(IDepartureView iDepartureView) {
            return false;
        }

        public static void $default$onConfirmClickInBroadOther(IDepartureView iDepartureView) {
        }

        public static void $default$onMapVisible(IDepartureView iDepartureView, boolean z) {
        }

        public static void $default$registerCallback(IDepartureView iDepartureView, IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        }

        public static void $default$setFenceVisible(IDepartureView iDepartureView, boolean z) {
        }

        public static void $default$setPadding(IDepartureView iDepartureView, Padding padding) {
        }

        public static void $default$start(IDepartureView iDepartureView) {
        }

        public static void $default$startTerminalSelect(IDepartureView iDepartureView) {
        }

        public static void $default$stop(IDepartureView iDepartureView) {
        }

        public static void $default$updateDepartureLocation(IDepartureView iDepartureView, DepartureLocationInfo departureLocationInfo, boolean z) {
        }

        public static void $default$updatePositionWhenOutStation(IDepartureView iDepartureView, DepartureLocationInfo departureLocationInfo) {
        }
    }

    void addOrderInterceptListener(DepartureInterceptController.IInterceptListener iInterceptListener);

    void destroy();

    DepartureAddress getDepartureAddress();

    View getDepartureCardView();

    DepartureLocationInfo getLocationInfo();

    boolean isShowTerminalViewOnSetPickupSpotAfter();

    void onConfirmClickInBroadOther();

    void onMapVisible(boolean z);

    void registerCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback);

    void setFenceVisible(boolean z);

    void setPadding(Padding padding);

    void start();

    void startTerminalSelect();

    void stop();

    void updateDepartureLocation(DepartureLocationInfo departureLocationInfo, boolean z);

    void updatePositionWhenOutStation(DepartureLocationInfo departureLocationInfo);
}
