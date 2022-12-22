package com.didi.component.common.spiimpl;

import android.app.Activity;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.AddressUtil;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didiglobal.common.common.spi.AddressParamsGetter;
import com.sdk.poibase.model.AddressParam;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

@ServiceProvider({AddressParamsGetter.class})
public class AddressParamsGetterImpl implements AddressParamsGetter {
    public SugParams getAddressParams() {
        return showNewSugOrRouterPage();
    }

    /* access modifiers changed from: protected */
    public SugParams showNewSugOrRouterPage() {
        Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
        Address a = m7943a();
        if (a == null) {
            a = new Address();
            a.latitude = 0.0d;
            a.longitude = 0.0d;
            a.displayName = currentActivity.getResources().getString(R.string.GRider_Sug_2020_placeholder_pickup);
        }
        SugParams createSugPageAddressParam = AddressUtil.createSugPageAddressParam(currentActivity, 2, a);
        createSugPageAddressParam.fromType = FromType.HOME;
        AddressParam addressParam = createSugPageAddressParam.addressParam;
        addressParam.departure_time = FormStore.getInstance().getTransportTime() + "";
        createSugPageAddressParam.is_start_address_new_select = false;
        createSugPageAddressParam.map_select_oper = FormStore.getInstance().getMapSelectOper();
        createSugPageAddressParam.wayPointParam.setWayPointTypes(m7944b());
        createSugPageAddressParam.wayPointParam.setWayPoints(m7945c());
        createSugPageAddressParam.wayPointParam.setAddDefaultWayPoint(true);
        return createSugPageAddressParam;
    }

    /* renamed from: a */
    private Address m7943a() {
        if (!FormStore.getInstance().isFromOpenRide() || FormStore.getInstance().getDriverInfo() == null) {
            Address startAddress = FormStore.getInstance().getStartAddress();
            if (startAddress != null) {
                return startAddress;
            }
            DIDILocation lastKnownLocation = NationComponentDataUtil.getLastKnownLocation();
            if (lastKnownLocation == null) {
                return null;
            }
            Address address = new Address();
            address.setLatitude(lastKnownLocation.getLatitude());
            address.setLongitude(lastKnownLocation.getLongitude());
            return address;
        }
        Address address2 = new Address();
        PinCodeInfoResult driverInfo = FormStore.getInstance().getDriverInfo();
        try {
            address2.setLatitude(Double.parseDouble(driverInfo.driverLat));
            address2.setLongitude(Double.parseDouble(driverInfo.driverLng));
        } catch (Exception unused) {
            address2.setLatitude(0.0d);
            address2.setLongitude(0.0d);
        }
        return address2;
    }

    /* renamed from: b */
    private List<Integer> m7944b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        return arrayList;
    }

    /* renamed from: c */
    private List<WayPoint> m7945c() {
        List<WayPoint> wayPoints = FormStore.getInstance().getWayPoints();
        WayPoint wayPoint = null;
        WayPoint wayPoint2 = null;
        for (WayPoint next : wayPoints) {
            if (next.getWayPointType() == 1) {
                wayPoint = next;
            } else if (next.getWayPointType() == 3) {
                wayPoint2 = next;
            }
        }
        if (wayPoint == null) {
            wayPoints.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint2 == null) {
            wayPoints.add(wayPoints.size(), new WayPoint(3, (Address) null));
        }
        return wayPoints;
    }
}
