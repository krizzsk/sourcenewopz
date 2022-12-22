package com.didi.map.sdk.departure.internal.data;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.departure.internal.special.SPoi;
import com.didi.map.sdk.departure.internal.special.SpecialPois;
import com.didi.map.sdk.departure.internal.util.LatLngUtil;
import com.google.gson.Gson;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DepartureDataUtils {
    public static List<RpcPoi> getSpecialRpcPois(ReverseStationsInfo reverseStationsInfo) {
        if (!(reverseStationsInfo == null || reverseStationsInfo.specialPoiList == null)) {
            try {
                SpecialPois specialPois = (SpecialPois) new Gson().fromJson(reverseStationsInfo.specialPoiList, SpecialPois.class);
                if (specialPois != null && !CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
                    ArrayList arrayList = new ArrayList();
                    for (SPoi sPoi : specialPois.pois) {
                        arrayList.addAll(sPoi.list);
                    }
                    return arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
                DLog.m7384d("DepartureDataUtils Exception:", e.toString(), new Object[0]);
            }
        }
        return null;
    }

    public static SpecialPois getSpecialPois(ReverseStationsInfo reverseStationsInfo) {
        if (!(reverseStationsInfo == null || reverseStationsInfo.specialPoiList == null)) {
            try {
                return (SpecialPois) new Gson().fromJson(reverseStationsInfo.specialPoiList, SpecialPois.class);
            } catch (Exception e) {
                e.printStackTrace();
                DLog.m7384d("DepartureDataUtils Exception:", e.toString(), new Object[0]);
            }
        }
        return null;
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

    public static FenceInfo getFenceInfo(ReverseStationsInfo reverseStationsInfo) {
        if (reverseStationsInfo == null || reverseStationsInfo.startFenceInfo == null || TextUtils.isEmpty(reverseStationsInfo.startFenceInfo.fenceId)) {
            return null;
        }
        return reverseStationsInfo.startFenceInfo;
    }

    public static RpcPoi findRecommendAdsorbPoint(List<RpcPoi> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (RpcPoi next : list) {
            if (1 == next.base_info.is_recommend_absorb) {
                return next;
            }
        }
        return null;
    }

    public static RpcPoi findTargetRecommend(LatLng latLng, List<RpcPoi> list) {
        RpcPoi rpcPoi = null;
        if (latLng == null) {
            return null;
        }
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            double d = Double.MAX_VALUE;
            for (RpcPoi next : list) {
                if (next.base_info != null) {
                    double distance = LatLngUtil.getDistance(next.base_info.lng, next.base_info.lat, latLng.longitude, latLng.latitude);
                    if (d >= distance) {
                        rpcPoi = next;
                        d = distance;
                    }
                }
            }
        }
        return rpcPoi;
    }
}
