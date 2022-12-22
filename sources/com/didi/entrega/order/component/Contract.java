package com.didi.entrega.order.component;

import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.base.ICustomerPresenter;
import com.didi.entrega.customer.base.ICustomerView;
import com.didi.entrega.customer.foundation.rpc.entity.order.Tip;
import com.didi.entrega.customer.map.model.BestViewModel;
import com.didi.entrega.order.widgets.SpreadView;
import com.didi.global.map.animation.SodaAnimLatLng;

public interface Contract {

    public static abstract class AbsMapPresenter extends ICustomerPresenter<AbsMapView> {
        /* access modifiers changed from: package-private */
        public abstract int getAnimIntervalTime();

        /* access modifiers changed from: package-private */
        public abstract LatLng getReceiverLatLng();

        /* access modifiers changed from: package-private */
        public abstract LatLng getRiderLatLng();

        /* access modifiers changed from: package-private */
        public abstract LatLng getSenderLatLng();

        /* access modifiers changed from: package-private */
        public abstract void setDraggedMap(boolean z);
    }

    public static abstract class AbsMapView extends ICustomerView<AbsMapPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void centerBestView(BestViewModel bestViewModel, BestViewer.IBestViewListener iBestViewListener);

        /* access modifiers changed from: package-private */
        public abstract void clearAllMapElement();

        /* access modifiers changed from: package-private */
        public abstract void clearMapExceptRider();

        /* access modifiers changed from: package-private */
        public abstract void doSlidingRiderAnim(SodaAnimLatLng sodaAnimLatLng);

        /* access modifiers changed from: package-private */
        public abstract void hideInfoWindow(boolean z);

        /* access modifiers changed from: package-private */
        public abstract void hideSpreadView();

        /* access modifiers changed from: package-private */
        public abstract void showInfoWindow(boolean z, Tip tip, LatLng latLng, boolean z2, int i, boolean z3);

        /* access modifiers changed from: package-private */
        public abstract void showMapWithRiderArriveReceiver();

        /* access modifiers changed from: package-private */
        public abstract void showMapWithRiderArrivedSender();

        /* access modifiers changed from: package-private */
        public abstract void showMapWithRiderComing();

        /* access modifiers changed from: package-private */
        public abstract void showMapWithRiderToDelivering(boolean z);

        /* access modifiers changed from: package-private */
        public abstract void showSpreadView(LatLng latLng, SpreadView.SpreadViewType spreadViewType);
    }
}
