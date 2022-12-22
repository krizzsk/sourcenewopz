package com.didi.map.global.component.departure.util;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class DepartureUtils {
    public static String convert2Coordinatetype(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "gcg02" : "wgs84" : "gcj02" : "bd09";
    }

    public static LatLng getMapCenterPoint(Map map) {
        if (map == null || map.getCameraPosition() == null) {
            return null;
        }
        return map.getCameraPosition().target;
    }

    public static FenceInfo getFenceInfo(ReverseStationsInfo reverseStationsInfo) {
        if (reverseStationsInfo == null || reverseStationsInfo.startFenceInfo == null || TextUtils.isEmpty(reverseStationsInfo.startFenceInfo.fenceId)) {
            return null;
        }
        return reverseStationsInfo.startFenceInfo;
    }

    public static boolean isAllowShowCircles(ReverseStationsInfo reverseStationsInfo) {
        return reverseStationsInfo != null && reverseStationsInfo.recomRipple == 1;
    }

    public static int getRecommendPoiCount(ReverseStationsInfo reverseStationsInfo) {
        ArrayList<RpcPoi> recStartPoints;
        if (reverseStationsInfo == null || (recStartPoints = reverseStationsInfo.getRecStartPoints()) == null) {
            return 0;
        }
        return recStartPoints.size();
    }

    public static RpcPoi findRecommendAdsorbPoint(List<RpcPoi> list) {
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

    public static RpcPoi findTargetRecommend(LatLng latLng, List<RpcPoi> list) {
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

    public static RecPoint findTargetRecPoint(LatLng latLng, List<RecPoint> list) {
        RecPoint recPoint = null;
        if (latLng != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            double d = Double.MAX_VALUE;
            for (RecPoint next : list) {
                if (next.location != null) {
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(next.location, latLng);
                    if (d >= computeDistanceBetween) {
                        recPoint = next;
                        d = computeDistanceBetween;
                    }
                }
            }
        }
        return recPoint;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getRequesterType(android.content.Context r3) {
        /*
            java.lang.String r3 = r3.getPackageName()
            int r0 = r3.hashCode()
            r1 = -702898867(0xffffffffd61a9d4d, float:-4.2500098E13)
            r2 = 1
            if (r0 == r1) goto L_0x001e
            r1 = 1059424173(0x3f2587ad, float:0.6466015)
            if (r0 == r1) goto L_0x0014
            goto L_0x0028
        L_0x0014:
            java.lang.String r0 = "com.didi.es.psngr"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0028
            r3 = 0
            goto L_0x0029
        L_0x001e:
            java.lang.String r0 = "com.sdu.didi.gsui"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = -1
        L_0x0029:
            if (r3 == 0) goto L_0x0033
            if (r3 == r2) goto L_0x0030
            java.lang.String r3 = "1"
            goto L_0x0035
        L_0x0030:
            java.lang.String r3 = "2"
            goto L_0x0035
        L_0x0033:
            java.lang.String r3 = "3"
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.util.DepartureUtils.getRequesterType(android.content.Context):java.lang.String");
    }

    public static Address getRecDestAddressByRpcPoi(RpcPoi rpcPoi, String str) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
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
        address.cotype = convert2Cotype(rpcPoi.base_info.coordinate_type);
        address.weight = rpcPoi.base_info.weight;
        address.cityId = rpcPoi.base_info.city_id;
        address.cityName = rpcPoi.base_info.city_name;
        address.hideAddress = rpcPoi.base_info.hide_address;
        address.countryID = rpcPoi.base_info.countryId;
        address.language = str;
        address.isRecommendTag = 1;
        address.geofence = rpcPoi.geofence;
        address.searchId = rpcPoi.searchId;
        return null;
    }

    /* renamed from: com.didi.map.global.component.departure.util.DepartureUtils$1 */
    static /* synthetic */ class C94481 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$MapVendor;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.common.map.MapVendor[] r0 = com.didi.common.map.MapVendor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$MapVendor = r0
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.AMAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.DIDI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.TENCENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$MapVendor     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.MapVendor r1 = com.didi.common.map.MapVendor.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.util.DepartureUtils.C94481.<clinit>():void");
        }
    }

    public static String convert2MapType(MapVendor mapVendor) {
        int i = C94481.$SwitchMap$com$didi$common$map$MapVendor[mapVendor.ordinal()];
        if (i == 1) {
            return RpcPoiBaseInfo.MAP_TYPE_GAODE;
        }
        if (i == 2) {
            return RpcPoiBaseInfo.MAP_TYPE_DIDI;
        }
        if (i != 3) {
            return i != 4 ? "" : "gmap";
        }
        return RpcPoiBaseInfo.MAP_TYPE_TENCENT;
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

    public static Address getAddressByRpcPoi(RpcPoi rpcPoi, boolean z, String str, int i) {
        if (rpcPoi == null || rpcPoi.base_info == null) {
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
        address.coordinate_type = rpcPoi.base_info.coordinate_type;
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

    public static boolean isAirPortPickUpPoint(RpcPoi rpcPoi) {
        return (rpcPoi == null || rpcPoi.base_info == null || rpcPoi.base_info.isAirPortPickUpPoint != 1) ? false : true;
    }

    public static boolean hasWalkGuidePhoto(RpcPoi rpcPoi) {
        if (rpcPoi == null || rpcPoi.extend_info == null || TextUtils.isEmpty(rpcPoi.extend_info.walkGuidePhoto) || TextUtils.isEmpty(rpcPoi.extend_info.walk_guide_link) || rpcPoi.extend_info.pictureStyle != 1) {
            return false;
        }
        return true;
    }

    public static boolean isParkingProperty(RpcPoi rpcPoi) {
        return (rpcPoi == null || rpcPoi.extend_info == null || rpcPoi.extend_info.startParkingProperty == null || (!rpcPoi.extend_info.startParkingProperty.equals(DepartureConstants.PARKING_VIOLATION_POINT) && !rpcPoi.extend_info.startParkingProperty.equals(DepartureConstants.PARKING_VIOLATION_AREA))) ? false : true;
    }

    public static boolean hasStationBubbleDescription(RpcPoi rpcPoi) {
        return (rpcPoi == null || rpcPoi.extend_info == null || TextUtils.isEmpty(rpcPoi.extend_info.stationBubbleDescV2)) ? false : true;
    }

    public static String takeXpanelDescFromJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("text", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getMainTitleFromDepartureAddr(DepartureAddress departureAddress) {
        return (departureAddress == null || departureAddress.getExtendInfo() == null) ? "" : departureAddress.getExtendInfo().getMainNoticeTitle();
    }

    public static boolean inAirportByTag(ReverseStationsInfo reverseStationsInfo) {
        return getFenceInfo(reverseStationsInfo) != null;
    }

    public static boolean PointIsInRect(Rect rect, PointF pointF) {
        if (!(pointF == null || rect == null)) {
            DLog.m7384d("DepartureUtils", "PointIsInRect point:" + pointF.toString() + ",rect" + rect.toString(), new Object[0]);
            if (pointF.x <= ((float) rect.left) || pointF.x >= ((float) rect.right) || pointF.y <= ((float) rect.top) || pointF.y >= ((float) rect.bottom)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean LatLngIsInRect(Map map, Rect rect, LatLng latLng) {
        if (map == null || latLng == null || map.getProjection() == null) {
            return false;
        }
        return PointIsInRect(rect, map.getProjection().toScreenLocation(latLng));
    }
}
