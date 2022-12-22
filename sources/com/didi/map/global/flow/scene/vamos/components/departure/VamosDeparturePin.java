package com.didi.map.global.flow.scene.vamos.components.departure;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.map.sdk.departure.DepartureFactory;
import com.didi.map.sdk.departure.IDepartureCompContract;
import com.didi.map.sdk.departure.internal.bubble.DepartureBubble;
import com.didi.map.sdk.departure.param.DepartureCompParam;
import com.didi.map.sdk.departure.param.DepartureLocationInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.sdk.poibase.model.RpcPoi;

public class VamosDeparturePin {

    /* renamed from: a */
    private static final String f27062a = "VamosDeparturePin";

    /* renamed from: b */
    private Context f27063b;

    /* renamed from: c */
    private Map f27064c;

    /* renamed from: d */
    private IDepartureCompContract f27065d;

    /* renamed from: e */
    private IDepartureCompContract.IDepartueCompCallback f27066e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f27067f;

    public VamosDeparturePin(Context context, Map map) {
        this.f27063b = context;
        this.f27064c = map;
    }

    public void start(DepartureCompParam departureCompParam) {
        if (departureCompParam != null) {
            departureCompParam.listener = m19124a(departureCompParam.listener);
            IDepartureCompContract createCoreManager = DepartureFactory.createCoreManager();
            this.f27065d = createCoreManager;
            createCoreManager.create(this.f27063b, this.f27064c);
            this.f27065d.setConfigParam(departureCompParam);
            this.f27065d.start();
        }
    }

    /* renamed from: a */
    private IDepartureCompContract.IDepartueCompCallback m19124a(final IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback) {
        if (this.f27066e == null) {
            this.f27066e = new IDepartureCompContract.IDepartueCompCallback() {
                public void onStartDragging() {
                    SystemUtils.log(3, VamosDeparturePin.f27062a, "onStartDragging", (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 60);
                    VamosDeparturePin.this.removeDepartureBubble(true);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onStartDragging();
                    }
                }

                public void onDepartureLoading(LatLng latLng) {
                    SystemUtils.log(3, VamosDeparturePin.f27062a, "onDepartureLoading latLng:" + latLng, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 69);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onDepartureLoading(latLng);
                    }
                }

                public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                    SystemUtils.log(3, VamosDeparturePin.f27062a, "onDepartureAddressChanged departureAddress:" + departureAddress, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 77);
                    boolean unused = VamosDeparturePin.this.f27067f = departureAddress != null && departureAddress.hasSpecialPois();
                    if (departureAddress != null) {
                        VamosDeparturePin.this.m19126a(departureAddress);
                    }
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onDepartureAddressChanged(departureAddress);
                    }
                }

                public void onFetchAddressFailed(LatLng latLng) {
                    SystemUtils.log(6, VamosDeparturePin.f27062a, "onFetchAddressFailed latLng:" + latLng, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin$1", 89);
                    IDepartureCompContract.IDepartueCompCallback iDepartueCompCallback = iDepartueCompCallback;
                    if (iDepartueCompCallback != null) {
                        iDepartueCompCallback.onFetchAddressFailed(latLng);
                    }
                }
            };
        }
        return this.f27066e;
    }

    public void updateLocation(DepartureLocationInfo departureLocationInfo, boolean z) {
        IDepartureCompContract iDepartureCompContract = this.f27065d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.updateDepartureLocation(departureLocationInfo, z);
        }
    }

    public <T extends DepartureBubble> T createDepartureBubble(Class<T> cls) {
        SystemUtils.log(3, f27062a, "createDepartureBubble() clazz: " + cls, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 106);
        IDepartureCompContract iDepartureCompContract = this.f27065d;
        if (iDepartureCompContract != null) {
            return iDepartureCompContract.createDepartureBubble(cls);
        }
        return null;
    }

    public void removeDepartureBubble(boolean z) {
        SystemUtils.log(3, f27062a, "removeDepartureBubble() animate: " + z, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 114);
        IDepartureCompContract iDepartureCompContract = this.f27065d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.removeDepartureBubble(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19126a(DepartureAddress departureAddress) {
        VamosSingleLineDepartureBubble vamosSingleLineDepartureBubble;
        if (!m19128b(departureAddress)) {
            SystemUtils.log(5, f27062a, "DepartureAddress bubbleDesc is empty", (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 122);
            return;
        }
        RpcPoi address = departureAddress.getAddress();
        boolean z = TextUtil.isEmpty(address.extend_info.startParkingProperty) || !address.extend_info.startParkingProperty.equals(DepartureConstants.PARKING_VIOLATION);
        SystemUtils.log(3, f27062a, "isRecommendPoi: " + departureAddress.isRecommendPoi() + ", isParking " + z + ", startParkingProperty: " + address.extend_info.startParkingProperty + ", bubbleDesc: " + address.extend_info.bubbleDesc, (Throwable) null, "com.didi.map.global.flow.scene.vamos.components.departure.VamosDeparturePin", 130);
        if (!z) {
            VamosPicSingleLineDepartureBubble vamosPicSingleLineDepartureBubble = (VamosPicSingleLineDepartureBubble) createDepartureBubble(VamosPicSingleLineDepartureBubble.class);
            if (vamosPicSingleLineDepartureBubble != null) {
                vamosPicSingleLineDepartureBubble.setText(address.extend_info.bubbleDesc).show();
            }
        } else if (departureAddress.isRecommendPoi() && (vamosSingleLineDepartureBubble = (VamosSingleLineDepartureBubble) createDepartureBubble(VamosSingleLineDepartureBubble.class)) != null) {
            vamosSingleLineDepartureBubble.setText(address.extend_info.bubbleDesc).show();
        }
    }

    public boolean isAirPortPickUpPoint() {
        return this.f27067f;
    }

    /* renamed from: b */
    private boolean m19128b(DepartureAddress departureAddress) {
        return (departureAddress == null || departureAddress.getAddress() == null || departureAddress.getAddress().extend_info == null || TextUtils.isEmpty(departureAddress.getAddress().extend_info.bubbleDesc)) ? false : true;
    }

    public void destroy() {
        this.f27066e = null;
        IDepartureCompContract iDepartureCompContract = this.f27065d;
        if (iDepartureCompContract != null) {
            iDepartureCompContract.destroy();
            this.f27065d = null;
        }
    }
}
