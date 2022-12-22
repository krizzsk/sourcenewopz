package com.didi.soda.customer.component.flutterordermap;

import com.didi.common.map.BestViewer;
import com.didi.common.map.model.LatLng;
import com.didi.global.map.animation.transition.SodaAnimLatLng;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.Bubble;
import com.didi.soda.customer.map.model.BestViewModel;

interface Contract {

    public static abstract class AbsMapPresenter extends ICustomerPresenter<AbsMapView> {
        /* access modifiers changed from: package-private */
        public abstract int getAnimIntervalTime();

        /* access modifiers changed from: package-private */
        public abstract BestViewModel getBestViewModel();

        /* access modifiers changed from: package-private */
        public abstract LatLng getBusinessLatLng();

        /* access modifiers changed from: package-private */
        public abstract LatLng getCustomerLatLng();

        /* access modifiers changed from: package-private */
        public abstract LatLng getDeliveryLatLng();

        /* access modifiers changed from: package-private */
        public abstract boolean isSelfDelivery();

        /* access modifiers changed from: package-private */
        public abstract boolean needShowRiderForBusinessPrepare();

        /* access modifiers changed from: package-private */
        public abstract void setDraggedMap(boolean z);
    }

    public static abstract class AbsMapView extends ICustomerView<AbsMapPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void centerBestView(BestViewer.IBestViewListener iBestViewListener);

        /* access modifiers changed from: package-private */
        public abstract void clearMapWithEmpty();

        /* access modifiers changed from: package-private */
        public abstract void clearMapWithRider();

        /* access modifiers changed from: package-private */
        public abstract void showBusinessAndUserMarker();

        /* access modifiers changed from: package-private */
        public abstract void showMapRiderArrive(Bubble bubble, boolean z);

        /* access modifiers changed from: package-private */
        public abstract void showMapRiderToken(boolean z, Bubble bubble, boolean z2);

        /* access modifiers changed from: package-private */
        public abstract void showMapWithBusinessDelivery(Bubble bubble);

        /* access modifiers changed from: package-private */
        public abstract void showMapWithBusinessPrepare();

        /* access modifiers changed from: package-private */
        public abstract void showRiderForBusinessPrepare(Bubble bubble);

        /* access modifiers changed from: package-private */
        public abstract void slidingRider(SodaAnimLatLng sodaAnimLatLng);

        /* access modifiers changed from: package-private */
        public abstract void updateBubbleContent(Bubble bubble, boolean z);
    }
}
