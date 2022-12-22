package com.didi.component.homedestination.abs;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.Animations;
import com.didi.component.core.ComponentParams;
import com.didi.component.homedestination.abs.AbsHomeDestinationView;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public abstract class AbsHomeDestinationPresenter<V extends AbsHomeDestinationView> extends BaseExpressPresenter<V> {
    public AbsHomeDestinationPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onPageResume() {
        super.onPageResume();
        EventBus.getDefault().register(this);
    }

    /* access modifiers changed from: protected */
    public void onPagePause() {
        super.onPagePause();
        EventBus.getDefault().unregister(this);
    }

    /* access modifiers changed from: protected */
    public Animations getAnimations() {
        return new Animations(R.anim.animate_enter, 0, R.anim.animate_enter, 0);
    }

    /* access modifiers changed from: protected */
    public Address getStartAddress(Context context) {
        DIDILocation lastKnownLocation = LocationController.getInstance().getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return null;
        }
        Address address = new Address();
        address.setLatitude(lastKnownLocation.getLatitude());
        address.setLongitude(lastKnownLocation.getLongitude());
        try {
            address.setCityId(Integer.parseInt(NationComponentDataUtil.getLocCityId()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(FormStore.getInstance().getDisplayName())) {
            address.setDisplayName(FormStore.getInstance().getDisplayName());
        }
        address.setCityName(NationComponentDataUtil.getLocCityName());
        return address;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", 2);
        hashMap.put("app_id", this.mContext.getApplicationInfo().packageName);
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("user_loc_lng", Double.valueOf(lastKnownLocation.getLongitude()));
            hashMap.put("user_loc_lat", Double.valueOf(lastKnownLocation.getLatitude()));
        }
        hashMap.put("requester_type", 1);
        if (GlobalApolloUtil.isBffMaptypeParamFix()) {
            hashMap.put("coordinate_type", MapType.MAPTYPE_WGS84.getMapTypeString());
        } else {
            hashMap.put("coordinate_type", NationComponentDataUtil.getMapTypeString());
        }
        hashMap.put("map_type", "gmap");
        hashMap.put("networky_type", SystemUtil.getNetworkType());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public boolean isGotoConfirmPage(Address address, int i) {
        if (address == null) {
            return true;
        }
        double d = 0.0d;
        DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
        if (lastLocation != null) {
            d = lastLocation.distanceTo(address.longitude, address.latitude);
        }
        if ((i == 0 || d < ((double) i)) && ((Integer) GlobalApolloUtil.getParam("Direct_Call_Test_Pid", "action", 2)).intValue() != 2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void clearOpenRideCarOrder() {
        if (DDTravelOrderStore.getOrder() != null && FormStore.getInstance().isFromOpenRide()) {
            DDTravelOrderStore.setOrder((ICarOrder) null);
        }
    }
}
