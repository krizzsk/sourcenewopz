package com.sdk.poibase;

import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.util.BizUtil;

public class ModelConverter {
    public static Address convertToAddress(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
            return null;
        }
        Address address = new Address();
        address.poiId = rpcPoi.base_info.poi_id;
        address.uid = rpcPoi.base_info.poi_id;
        address.displayName = rpcPoi.base_info.displayname;
        address.address = rpcPoi.base_info.address;
        address.fullName = rpcPoi.base_info.addressAll;
        address.latitude = rpcPoi.base_info.lat;
        address.longitude = rpcPoi.base_info.lng;
        address.srcTag = rpcPoi.base_info.srctag;
        address.coordinate_type = rpcPoi.base_info.coordinate_type;
        address.cotype = BizUtil.convert2Cotype(rpcPoi.base_info.coordinate_type);
        address.weight = rpcPoi.base_info.weight;
        address.cityId = rpcPoi.base_info.city_id;
        address.cityName = rpcPoi.base_info.city_name;
        address.isRecommendTag = rpcPoi.base_info.is_recommend_absorb;
        address.searchId = rpcPoi.base_info.searchId;
        address.countryID = rpcPoi.base_info.countryId;
        address.countryCode = rpcPoi.base_info.countryCode;
        address.geofence = rpcPoi.geofence;
        address.hideAddress = rpcPoi.base_info.hide_address;
        if (rpcPoi.extend_info != null) {
            boolean z = true;
            if (rpcPoi.extend_info.enable_confirm_dropoff != 1) {
                z = false;
            }
            address.enableConfirmDropoff = z;
            address.xpanelDesc = rpcPoi.extend_info.xpanelDesc;
            address.subTitleDesc = rpcPoi.extend_info.subTitleDesc;
        }
        address.isDiscountPoi = rpcPoi.isDiscountPoi;
        return address;
    }

    public static RpcPoi convertToRpcPoi(Address address) {
        if (address == null) {
            return null;
        }
        RpcPoiBaseInfo rpcPoiBaseInfo = new RpcPoiBaseInfo();
        rpcPoiBaseInfo.poi_id = address.uid;
        rpcPoiBaseInfo.displayname = address.displayName;
        rpcPoiBaseInfo.address = address.address;
        rpcPoiBaseInfo.addressAll = address.fullName;
        rpcPoiBaseInfo.lng = address.longitude;
        rpcPoiBaseInfo.lat = address.latitude;
        rpcPoiBaseInfo.srctag = address.srcTag;
        rpcPoiBaseInfo.coordinate_type = address.coordinate_type;
        rpcPoiBaseInfo.weight = address.weight;
        rpcPoiBaseInfo.city_id = address.cityId;
        rpcPoiBaseInfo.city_name = address.cityName;
        rpcPoiBaseInfo.is_recommend_absorb = address.isRecommendTag;
        rpcPoiBaseInfo.searchId = address.searchId;
        rpcPoiBaseInfo.countryId = address.countryID;
        rpcPoiBaseInfo.countryCode = address.countryCode;
        rpcPoiBaseInfo.hide_address = address.hideAddress;
        RpcPoi rpcPoi = new RpcPoi();
        rpcPoi.geofence = address.geofence;
        rpcPoi.base_info = rpcPoiBaseInfo;
        rpcPoi.isDiscountPoi = address.isDiscountPoi;
        return rpcPoi;
    }
}
