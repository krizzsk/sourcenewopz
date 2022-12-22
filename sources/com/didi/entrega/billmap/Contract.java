package com.didi.entrega.billmap;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.base.ICustomerPresenter;
import com.didi.entrega.customer.base.ICustomerView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/billmap/Contract;", "", "AbsBillMapPresenter", "AbsBillMapView", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/billmap/Contract$AbsBillMapPresenter;", "Lcom/didi/entrega/customer/base/ICustomerPresenter;", "Lcom/didi/entrega/billmap/Contract$AbsBillMapView;", "()V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillMapPresenter extends ICustomerPresenter<AbsBillMapView> {
    }

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J0\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/billmap/Contract$AbsBillMapView;", "Lcom/didi/entrega/customer/base/ICustomerView;", "Lcom/didi/entrega/billmap/Contract$AbsBillMapPresenter;", "()V", "cleanSendAndRecMarker", "", "showSendAndRecMarkInfo", "senderLatLng", "Lcom/didi/common/map/model/LatLng;", "receiverLatLng", "sendTip", "", "receiveTip", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsBillMapView extends ICustomerView<AbsBillMapPresenter> {
        public abstract void cleanSendAndRecMarker();

        public abstract void showSendAndRecMarkInfo(LatLng latLng, LatLng latLng2, String str, String str2);
    }
}
