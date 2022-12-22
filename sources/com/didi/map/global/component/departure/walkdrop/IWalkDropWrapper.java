package com.didi.map.global.component.departure.walkdrop;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\u0012\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0003H&J\u0012\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0003H&¨\u0006$"}, mo175978d2 = {"Lcom/didi/map/global/component/departure/walkdrop/IWalkDropWrapper;", "", "isRecMarkerVisible", "", "onCameraChange", "", "latLng", "Lcom/didi/common/map/model/LatLng;", "onCreate", "onDestroy", "onMapDragEnd", "onMapDragStart", "onNormalAdsorbedFail", "start", "onNormalAdsorbedOk", "dptAddress", "Lcom/didi/map/global/component/departure/model/DepartureAddress;", "onNormalReverseGeo", "onReceiveLocationUpdate", "location", "Lcom/didichuxing/bigdata/dp/locsdk/DIDILocation;", "onRequestFail", "onRequestStart", "onRspAirport", "setDepartureCallback", "callback", "Lcom/didi/map/global/component/departure/IDepartureCompContract$IDepartureComponentCallback;", "setDestPoint", "address", "Lcom/didi/sdk/address/address/entity/Address;", "setGuideLineEnable", "enable", "setSceneType", "sceneType", "", "setWalkDropEnable", "compDeparture_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalkDropWrapper.kt */
public interface IWalkDropWrapper {
    boolean isRecMarkerVisible();

    void onCameraChange(LatLng latLng);

    void onCreate();

    void onDestroy();

    void onMapDragEnd();

    void onMapDragStart();

    void onNormalAdsorbedFail(LatLng latLng);

    void onNormalAdsorbedOk(LatLng latLng, DepartureAddress departureAddress);

    void onNormalReverseGeo();

    void onReceiveLocationUpdate(DIDILocation dIDILocation);

    void onRequestFail();

    void onRequestStart();

    void onRspAirport();

    void setDepartureCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback);

    void setDestPoint(Address address);

    void setGuideLineEnable(boolean z);

    void setSceneType(int i);

    void setWalkDropEnable(boolean z);

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IWalkDropWrapper.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void setSceneType$default(IWalkDropWrapper iWalkDropWrapper, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                iWalkDropWrapper.setSceneType(i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSceneType");
        }
    }
}
