package com.didi.map.global.component.departure.util;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.SPoi;
import com.didi.map.global.component.departure.model.SpecialPois;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.google.gson.Gson;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TerminalUtils {
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

    public static List<RpcPoi> getWholeSpecialRpcPoiList(ReverseStationsInfo reverseStationsInfo) {
        SpecialPois specialPois;
        ArrayList arrayList = null;
        if (!(reverseStationsInfo == null || reverseStationsInfo.geofenceTags == null || reverseStationsInfo.geofenceTags.isEmpty() || !reverseStationsInfo.geofenceTags.contains("airport") || (specialPois = getSpecialPois(reverseStationsInfo)) == null || specialPois.area == null || CollectionUtil.isEmpty((Collection<?>) specialPois.pois))) {
            arrayList = new ArrayList();
            for (SPoi next : specialPois.pois) {
                if (next != null && !CollectionUtil.isEmpty((Collection<?>) next.list)) {
                    arrayList.addAll(next.list);
                }
            }
        }
        return arrayList;
    }

    public static List<RpcPoi> getSelectedSpecialRpcPoiList(ReverseStationsInfo reverseStationsInfo) {
        SpecialPois specialPois;
        SPoi adsorbTerminalArea;
        if (reverseStationsInfo == null || reverseStationsInfo.geofenceTags == null || reverseStationsInfo.geofenceTags.isEmpty() || !reverseStationsInfo.geofenceTags.contains("airport") || (specialPois = getSpecialPois(reverseStationsInfo)) == null || specialPois.area == null || specialPois.area.point_first == 0 || CollectionUtil.isEmpty((Collection<?>) specialPois.pois) || (adsorbTerminalArea = getAdsorbTerminalArea(specialPois)) == null || CollectionUtil.isEmpty((Collection<?>) adsorbTerminalArea.list)) {
            return null;
        }
        return new ArrayList(adsorbTerminalArea.list);
    }

    public static SPoi getNearestSpoi(LatLng latLng, ReverseStationsInfo reverseStationsInfo) {
        SpecialPois specialPois;
        SPoi sPoi = null;
        if (!(latLng == null || reverseStationsInfo == null || reverseStationsInfo.geofenceTags == null || reverseStationsInfo.geofenceTags.isEmpty() || !reverseStationsInfo.geofenceTags.contains("airport") || (specialPois = getSpecialPois(reverseStationsInfo)) == null || specialPois.area == null || specialPois.area.point_first == 0 || CollectionUtil.isEmpty((Collection<?>) specialPois.pois))) {
            sPoi = specialPois.pois.get(0);
            double d = Double.MAX_VALUE;
            for (SPoi next : specialPois.pois) {
                if (!(next.area == null || next.area.centre_point == null || CollectionUtil.isEmpty((Collection<?>) next.list))) {
                    double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(new LatLng(next.area.centre_point.lat, next.area.centre_point.lng), latLng);
                    if (computeDistanceBetween < d) {
                        sPoi = next;
                        d = computeDistanceBetween;
                    }
                }
            }
        }
        return sPoi;
    }

    public static List<RecPoint> getTerminalRecPointListWithoutPointFirst(SpecialPois specialPois) {
        if (specialPois == null || specialPois.area == null || specialPois.area.point_first != 0) {
            return null;
        }
        return getTerminalRecPointList(specialPois);
    }

    public static List<RecPoint> getTerminalRecPointList(SpecialPois specialPois) {
        if (specialPois == null || specialPois.area == null || CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SPoi next : specialPois.pois) {
            if (!(next == null || next.area == null || TextUtils.isEmpty(next.area.name) || next.area.centre_point == null)) {
                RecPoint recPoint = new RecPoint();
                recPoint.addrName = next.area.name;
                recPoint.location = new LatLng(next.area.centre_point.lat, next.area.centre_point.lng);
                arrayList.add(recPoint);
            }
        }
        return arrayList;
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

    public static SPoi getAdsorbTerminalArea(SpecialPois specialPois) {
        if (specialPois == null || specialPois.area == null || CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
            return null;
        }
        SPoi sPoi = specialPois.pois.get(0);
        for (SPoi next : specialPois.pois) {
            if (!(next == null || next.area == null || TextUtils.isEmpty(next.area.name) || next.area.centre_point == null || next.area.is_nearest != 1)) {
                sPoi = next;
            }
        }
        return sPoi;
    }

    public static SPoi getAdsorbTerminalAreaByName(SpecialPois specialPois, String str) {
        SPoi sPoi = null;
        if (specialPois != null && !CollectionUtil.isEmpty((Collection<?>) specialPois.pois)) {
            for (SPoi next : specialPois.pois) {
                if (next != null && next.area != null && !TextUtils.isEmpty(next.area.name) && next.area.name.equals(str)) {
                    sPoi = next;
                }
            }
        }
        return sPoi;
    }
}
