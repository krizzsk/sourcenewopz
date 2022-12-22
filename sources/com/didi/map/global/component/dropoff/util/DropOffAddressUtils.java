package com.didi.map.global.component.dropoff.util;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffAddressExtendInfo;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DropOffAddressUtils {
    public static RpcPoi findNearestPoi(LatLng latLng, List<RpcPoi> list) {
        RpcPoi rpcPoi = null;
        if (latLng != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            double d = Double.MAX_VALUE;
            for (RpcPoi next : list) {
                if (next.base_info != null) {
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(new LatLng(next.base_info.lat, next.base_info.lng), latLng);
                    if (d >= computeDistanceBetween) {
                        rpcPoi = next;
                        d = computeDistanceBetween;
                    }
                }
            }
        }
        return rpcPoi;
    }

    public static List<RecPoint> getRecPointList(List<RpcPoi> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (RpcPoi next : list) {
            if (next.base_info != null) {
                RecPoint recPoint = new RecPoint();
                recPoint.addrName = next.base_info.displayname;
                recPoint.location = new LatLng(next.base_info.lat, next.base_info.lng);
                recPoint.srctag = next.base_info.srctag;
                arrayList.add(recPoint);
            }
        }
        return arrayList;
    }

    public static List<LatLng> getRecLatLngList(List<RpcPoi> list) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (RpcPoi next : list) {
                if (next.base_info != null) {
                    arrayList.add(new LatLng(next.base_info.lat, next.base_info.lng));
                }
            }
        }
        return arrayList;
    }

    public static RpcPoi findRecAbsorbPoi(List<RpcPoi> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (RpcPoi next : list) {
            if (next.base_info != null && 1 == next.base_info.is_recommend_absorb) {
                return next;
            }
        }
        return null;
    }

    public static DropOffAddress createDropOffAddress(RpcPoi rpcPoi, boolean z, int i, String str, int i2) {
        DropOffAddress dropOffAddress = new DropOffAddress();
        dropOffAddress.setRecommmend(z);
        dropOffAddress.setAddress(m18282a(rpcPoi, z, str, i2));
        if (!(rpcPoi == null || rpcPoi.extend_info == null)) {
            DropOffAddressExtendInfo dropOffAddressExtendInfo = new DropOffAddressExtendInfo();
            dropOffAddressExtendInfo.setBubbleText(rpcPoi.extend_info.bubbleDescV2);
            dropOffAddressExtendInfo.setMainTitle(rpcPoi.extend_info.mainTitleDesc);
            dropOffAddressExtendInfo.setSubTitle(rpcPoi.extend_info.subTitleDesc);
            dropOffAddress.setExtendInfo(dropOffAddressExtendInfo);
        }
        dropOffAddress.setRecPointSize(i);
        return dropOffAddress;
    }

    /* renamed from: a */
    private static Address m18282a(RpcPoi rpcPoi, boolean z, String str, int i) {
        if (rpcPoi.base_info == null) {
            return null;
        }
        Address address = new Address();
        address.uid = rpcPoi.base_info.poi_id;
        address.poiId = rpcPoi.base_info.poi_id;
        address.displayName = rpcPoi.base_info.displayname;
        address.address = rpcPoi.base_info.address;
        address.fullName = rpcPoi.base_info.addressAll;
        address.latitude = rpcPoi.base_info.lat;
        address.longitude = rpcPoi.base_info.lng;
        address.srcTag = rpcPoi.base_info.srctag;
        address.isRecommendTag = z ? 1 : 0;
        address.cotype = convert2Cotype(rpcPoi.base_info.coordinate_type);
        address.weight = rpcPoi.base_info.weight;
        address.cityId = rpcPoi.base_info.city_id;
        address.cityName = rpcPoi.base_info.city_name;
        address.language = str;
        address.airportStr = rpcPoi.specialPoiList;
        address.searchId = rpcPoi.searchId;
        address.operationType = i;
        address.hideAddress = rpcPoi.base_info.hide_address;
        if (rpcPoi.extend_info != null) {
            RpcPoiExtendInfo rpcPoiExtendInfo = rpcPoi.extend_info;
            address.setMainTitleDesc(rpcPoiExtendInfo.mainTitleDesc);
            address.setSubTitleDesc(rpcPoiExtendInfo.subTitleDesc);
            address.setPickupPointOrderStatus(rpcPoi.extend_info.has_pickup_point_order);
        }
        String[] strArr = rpcPoi.geofence;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr2[i2] = strArr[i2];
            }
            address.geofence = strArr2;
        }
        return address;
    }

    public static int convert2Cotype(String str) {
        if (str == null) {
            return 2;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3017163) {
            if (hashCode != 98175376) {
                if (hashCode == 113079775 && str.equals("wgs84")) {
                    c = 2;
                }
            } else if (str.equals("gcj02")) {
                c = 1;
            }
        } else if (str.equals("bd09")) {
            c = 0;
        }
        if (c != 0) {
            return (c == 1 || c != 2) ? 2 : 3;
        }
        return 1;
    }
}
