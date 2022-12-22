package com.didi.addressold.view;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.AddressParam;

public class SugDeparturePin {

    /* renamed from: a */
    private static final String f7920a = "SugDeparturePin";

    /* renamed from: b */
    private IDepartureCompContract f7921b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureCompParams f7922c;

    /* renamed from: d */
    private IDepartureCompContract.IDepartureComponentCallback f7923d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FetchStartPoiInfoCallback f7924e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7925f = false;

    public interface FetchStartPoiInfoCallback {
        void onFetchFailed(LatLng latLng);

        void onFetchStart();

        void onFetchSuccess(DepartureAddress departureAddress);
    }

    public void start(Context context, AddressParam addressParam, FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
        if (this.f7925f) {
            stop();
        }
        this.f7924e = fetchStartPoiInfoCallback;
        this.f7921b = new DepartureComponent();
        DepartureCompParams a = m5108a(addressParam);
        this.f7922c = a;
        if (a != null) {
            this.f7921b.setConfigParam(a);
            this.f7921b.create(context, (Map) null);
            this.f7921b.registerCallback(m5109a());
            this.f7921b.start();
        }
    }

    /* renamed from: a */
    private DepartureCompParams m5108a(AddressParam addressParam) {
        LatLng latLng = new LatLng(addressParam.currentAddress.latitude, addressParam.currentAddress.longitude);
        SystemUtils.log(3, f7920a, "fetchStartPoiInfo() latLng:" + latLng, (Throwable) null, "com.didi.addressold.view.SugDeparturePin", 59);
        try {
            return new DepartureCompParams.Builder().isWalkDropVisible(false).isFenceVisible(false).setEndPoint((Address) null).callFrom(CallFrom.SUG_PACKING_PROMPT).sceneType(0).isGuideLineVisible(false).fenceOptions((DepartureFenceOptions) null).requireByDrag(false).isConfirmPickupPointCardViewVisible(false).isTerminalViewVisible(false).cacheEnable(false).apiType(ApiType.DEPARTURE_POI_INFO).departureTime(0).hasWayPoint(false).isBubbleVisible(false).isPinVisible(false).isRecPointVisible(false).locationInfo(new DepartureLocationInfo(latLng, (Address) null, "wgs84")).pinStyle((PinStyle) null).recStyle((RecPointStyle) null).zoom(18.0f).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private IDepartureCompContract.IDepartureComponentCallback m5109a() {
        if (this.f7923d == null) {
            this.f7923d = new IDepartureCompContract.IDepartureComponentCallback() {
                public /* synthetic */ void onBroadOtherMapCallback(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onBroadOtherMapCallback(this, i);
                }

                public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
                }

                public /* synthetic */ void onClickBubble() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onClickBubble(this);
                }

                public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onConfirmPickup(this, departureAddress);
                }

                public /* synthetic */ void onDragging(int i) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onDragging(this, i);
                }

                public /* synthetic */ void onStartSugPage(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartSugPage(this, departureAddress);
                }

                public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
                }

                public /* synthetic */ void onUp() {
                    IDepartureCompContract.IDepartureComponentCallback.CC.$default$onUp(this);
                }

                public void onStartDragging() {
                    SystemUtils.log(3, SugDeparturePin.f7920a, "onStartDragging()", (Throwable) null, "com.didi.addressold.view.SugDeparturePin$1", 96);
                    boolean unused = SugDeparturePin.this.f7925f = true;
                    if (SugDeparturePin.this.f7924e != null) {
                        SugDeparturePin.this.f7924e.onFetchStart();
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    SystemUtils.log(3, SugDeparturePin.f7920a, "onDepartureLoading() latLng:" + latLng, (Throwable) null, "com.didi.addressold.view.SugDeparturePin$1", 105);
                    boolean unused = SugDeparturePin.this.f7925f = true;
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    SystemUtils.log(3, SugDeparturePin.f7920a, "onDepartureAddressChanged() departureAddress:" + departureAddress, (Throwable) null, "com.didi.addressold.view.SugDeparturePin$1", 111);
                    boolean unused = SugDeparturePin.this.f7925f = false;
                    if (SugDeparturePin.this.f7924e == null) {
                        return;
                    }
                    if (departureAddress == null || departureAddress.getAddress() == null) {
                        LatLng latLng = null;
                        if (!(SugDeparturePin.this.f7922c == null || SugDeparturePin.this.f7922c.getLocationInfo() == null)) {
                            latLng = SugDeparturePin.this.f7922c.getLocationInfo().latLng;
                        }
                        SugDeparturePin.this.f7924e.onFetchFailed(latLng);
                        return;
                    }
                    SugDeparturePin.this.f7924e.onFetchSuccess(departureAddress);
                }

                public void onFetchAddressFail(LatLng latLng) {
                    SystemUtils.log(6, SugDeparturePin.f7920a, "onFetchAddressFailed() latLng:" + latLng, (Throwable) null, "com.didi.addressold.view.SugDeparturePin$1", 125);
                    boolean unused = SugDeparturePin.this.f7925f = false;
                    if (SugDeparturePin.this.f7924e != null) {
                        SugDeparturePin.this.f7924e.onFetchFailed(latLng);
                    }
                }
            };
        }
        return this.f7923d;
    }

    public void stop() {
        this.f7924e = null;
        this.f7923d = null;
        this.f7922c = null;
        IDepartureCompContract iDepartureCompContract = this.f7921b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f7921b = null;
        }
    }
}
