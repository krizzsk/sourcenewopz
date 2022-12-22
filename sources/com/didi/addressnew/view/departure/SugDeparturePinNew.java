package com.didi.addressnew.view.departure;

import android.content.Context;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.view.departure.BaseDeparture;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.DepartureCompParams;
import com.didi.map.global.component.departure.DepartureComponent;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;

public class SugDeparturePinNew extends BaseDeparture {

    /* renamed from: a */
    private static final String f7583a = "SugDeparturePin";

    /* renamed from: b */
    private IDepartureCompContract f7584b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DepartureCompParams f7585c;

    /* renamed from: d */
    private IDepartureCompContract.IDepartureComponentCallback f7586d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BaseDeparture.FetchStartPoiInfoCallback f7587e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f7588f = false;

    public void start(Context context, AddressParam addressParam, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
        if (this.f7588f) {
            stop();
        }
        this.f7587e = fetchStartPoiInfoCallback;
        this.f7584b = new DepartureComponent();
        DepartureCompParams a = m4805a(addressParam.currentAddress, addressParam.targetAddress);
        this.f7585c = a;
        if (a != null) {
            this.f7584b.setConfigParam(a);
            this.f7584b.create(context, (Map) null);
            this.f7584b.registerCallback(m4806a());
            this.f7584b.start();
        }
    }

    /* renamed from: a */
    private void m4807a(Context context, DepartureCompParams departureCompParams, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback) {
        if (this.f7588f) {
            stop();
        }
        this.f7587e = fetchStartPoiInfoCallback;
        DepartureComponent departureComponent = new DepartureComponent();
        this.f7584b = departureComponent;
        if (departureCompParams == null) {
            departureCompParams = this.f7585c;
        }
        departureComponent.setConfigParam(departureCompParams);
        this.f7584b.create(context, (Map) null);
        this.f7584b.registerCallback(m4806a());
        this.f7584b.start();
    }

    public void startVerifyStationAddress(Context context, AddressParam addressParam, BaseDeparture.FetchStartPoiInfoCallback fetchStartPoiInfoCallback, RpcPoi rpcPoi) {
        DepartureCompParams a = m4805a(addressParam.currentAddress, addressParam.targetAddress);
        this.f7585c = a;
        if (a != null) {
            m4807a(context, a, fetchStartPoiInfoCallback);
        }
    }

    /* renamed from: a */
    private DepartureCompParams m4805a(Address address, Address address2) {
        if (address == null) {
            return null;
        }
        return new DepartureCompParams.Builder().callFrom(CallFrom.SUG_PACKING_PROMPT).departureTime(0).isPinVisible(false).isRecPointVisible(false).isFenceVisible(false).locationInfo(new DepartureLocationInfo(new LatLng(address.latitude, address.longitude), (Address) null, "wgs84")).pinStyle((PinStyle) null).recStyle((RecPointStyle) null).requireByDrag(false).zoom(18.0f).apiType(ApiType.DEPARTURE_POI_INFO).setNlpRegisterParam(ApolloUtil.sugStartPoiUseNLP(PaxEnvironment.getInstance().getCountryCode()) ? new NLPRegisterParam(CallFrom.SUG_PACKING_PROMPT.toString(), ApolloUtil.getNLPTimeOut(PaxEnvironment.getInstance().getCountryCode()), 0) : null).build();
    }

    /* renamed from: a */
    private IDepartureCompContract.IDepartureComponentCallback m4806a() {
        if (this.f7586d == null) {
            this.f7586d = new IDepartureCompContract.IDepartureComponentCallback() {
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
                    SystemUtils.log(3, SugDeparturePinNew.f7583a, "onStartDragging()", (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 120);
                    boolean unused = SugDeparturePinNew.this.f7588f = true;
                    if (SugDeparturePinNew.this.f7587e != null) {
                        SugDeparturePinNew.this.f7587e.onFetchStart();
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    SystemUtils.log(3, SugDeparturePinNew.f7583a, "onDepartureLoading() latLng:" + latLng, (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 129);
                    boolean unused = SugDeparturePinNew.this.f7588f = true;
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    SystemUtils.log(3, SugDeparturePinNew.f7583a, "onDepartureAddressChanged() departureAddress:" + departureAddress, (Throwable) null, "com.didi.addressnew.view.departure.SugDeparturePinNew$1", 135);
                    boolean unused = SugDeparturePinNew.this.f7588f = false;
                    if (SugDeparturePinNew.this.f7587e == null) {
                        return;
                    }
                    if (departureAddress == null || departureAddress.getAddress() == null) {
                        LatLng latLng = null;
                        if (!(SugDeparturePinNew.this.f7585c == null || SugDeparturePinNew.this.f7585c.getLocationInfo() == null)) {
                            latLng = SugDeparturePinNew.this.f7585c.getLocationInfo().latLng;
                        }
                        SugDeparturePinNew.this.f7587e.onFetchFailed(latLng);
                        return;
                    }
                    SugDeparturePinNew.this.f7587e.onFetchSuccess(departureAddress);
                }

                public void onFetchAddressFail(LatLng latLng) {
                    boolean unused = SugDeparturePinNew.this.f7588f = false;
                    if (SugDeparturePinNew.this.f7587e != null) {
                        SugDeparturePinNew.this.f7587e.onFetchFailed(latLng);
                    }
                }
            };
        }
        return this.f7586d;
    }

    public void stop() {
        this.f7587e = null;
        this.f7586d = null;
        this.f7585c = null;
        IDepartureCompContract iDepartureCompContract = this.f7584b;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f7584b = null;
        }
    }
}
