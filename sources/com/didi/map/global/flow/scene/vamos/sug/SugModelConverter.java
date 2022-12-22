package com.didi.map.global.flow.scene.vamos.sug;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.departure.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.taxis99.R;

public class SugModelConverter {

    /* renamed from: a */
    private static final int f27183a = 200;

    public static Address convert2Address(Context context, DepartureAddress departureAddress) {
        Address address = new Address();
        if (!(departureAddress == null || departureAddress.getAddress() == null || departureAddress.getAddress().base_info == null || context == null)) {
            address.displayName = departureAddress.getAddress().base_info.displayname;
            address.poiId = departureAddress.getAddress().base_info.poi_id;
            address.uid = departureAddress.getAddress().base_info.poi_id;
            address.address = departureAddress.getAddress().base_info.address;
            address.fullName = departureAddress.getAddress().base_info.addressAll;
            address.latitude = departureAddress.getAddress().base_info.lat;
            address.longitude = departureAddress.getAddress().base_info.lng;
            address.srcTag = departureAddress.getAddress().base_info.srctag;
            address.isRecommendTag = departureAddress.isRecommendPoi() ? 1 : 0;
            address.cotype = 3;
            address.weight = departureAddress.getAddress().base_info.weight;
            address.cityId = departureAddress.getAddress().base_info.city_id;
            address.cityName = departureAddress.getAddress().base_info.city_name;
            address.language = departureAddress.getLanguage();
            address.airportStr = departureAddress.getAddress().specialPoiList;
            address.searchId = departureAddress.getAddress().searchId;
            String[] strArr = departureAddress.getAddress().geofence;
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                String[] strArr2 = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr2[i] = strArr[i];
                }
                address.geofence = strArr2;
            }
        }
        return address;
    }

    public static Address convert2Address(Context context, LatLng latLng) {
        String string = context.getResources().getString(R.string.global_sug_current_location);
        Address address = new Address();
        address.displayName = string;
        address.address = string;
        address.fullName = string;
        address.uid = "rgeo_default";
        address.latitude = latLng.latitude;
        address.longitude = latLng.longitude;
        address.language = LocaleCodeHolder.getInstance().getCurrentLang();
        address.isRecommendTag = 0;
        return address;
    }
}
