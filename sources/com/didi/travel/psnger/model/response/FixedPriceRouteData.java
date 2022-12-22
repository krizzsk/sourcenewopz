package com.didi.travel.psnger.model.response;

import com.didi.common.map.model.LatLng;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FixedPriceRouteData extends BaseObject {
    public double endLat;
    public double endLng;
    public Map<Integer, FixedPriceRouteInfo> routeMap;
    public double startLat;
    public double startLng;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.routeMap = new HashMap();
            JSONArray optJSONArray = optJSONObject.optJSONArray("rb_packs");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                try {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(0).optJSONObject("rb_resp");
                    if (optJSONObject2 != null) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("routes");
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("geo");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray3 != null) {
                            for (int i = 0; i < optJSONArray2.length(); i++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                                if (jSONObject2 != null) {
                                    long optLong = jSONObject2.optLong("routeid", 0);
                                    if (optLong > 0) {
                                        FixedPriceRouteInfo fixedPriceRouteInfo = new FixedPriceRouteInfo();
                                        fixedPriceRouteInfo.f44219id = optLong;
                                        fixedPriceRouteInfo.tag = jSONObject2.optInt("feature");
                                        fixedPriceRouteInfo.points = JsonUtil.jsonToList(optJSONArray3.getJSONArray(i).toString(), LatLng.class);
                                        JSONObject optJSONObject3 = jSONObject2.optJSONObject("toll_charge_result");
                                        if (optJSONObject3 != null) {
                                            TollChargeResult tollChargeResult = new TollChargeResult();
                                            tollChargeResult.isExist = optJSONObject3.optBoolean("is_exist");
                                            tollChargeResult.tollFee = optJSONObject3.optInt("toll_fee");
                                            tollChargeResult.tollStationNode = optJSONObject3.optString("toll_station_node");
                                            tollChargeResult.timestamp = optJSONObject3.optLong("timestamp");
                                            fixedPriceRouteInfo.tollChargeResult = tollChargeResult;
                                        }
                                        if (fixedPriceRouteInfo.tag == 0) {
                                            fixedPriceRouteInfo.type = 2000;
                                            this.routeMap.put(Integer.valueOf(fixedPriceRouteInfo.type), fixedPriceRouteInfo);
                                        } else if (fixedPriceRouteInfo.tag == 2) {
                                            fixedPriceRouteInfo.type = 2001;
                                            this.routeMap.put(Integer.valueOf(fixedPriceRouteInfo.type), fixedPriceRouteInfo);
                                        } else if (fixedPriceRouteInfo.tag == 1) {
                                            fixedPriceRouteInfo.type = 2002;
                                            this.routeMap.put(Integer.valueOf(fixedPriceRouteInfo.type), fixedPriceRouteInfo);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.routeMap;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRoadAvailable() {
        /*
            r1 = this;
            int r0 = r1.errno
            if (r0 != 0) goto L_0x0010
            java.util.Map<java.lang.Integer, com.didi.travel.psnger.model.response.FixedPriceRouteData$FixedPriceRouteInfo> r0 = r1.routeMap
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.model.response.FixedPriceRouteData.isRoadAvailable():boolean");
    }

    public boolean isSameStartAddress(Address address) {
        return address != null && this.startLat == address.latitude && this.startLng == address.longitude;
    }

    public boolean isSameEndAddress(Address address) {
        return address != null && this.endLat == address.latitude && this.endLng == address.longitude;
    }

    public FixedPriceRouteInfo getInfoByTag(int i) {
        Map<Integer, FixedPriceRouteInfo> map = this.routeMap;
        if (map != null) {
            return map.get(Integer.valueOf(i));
        }
        return null;
    }

    public class FixedPriceRouteInfo implements Serializable, Cloneable {
        public static final int ROUTE_TAG_DEFAULT = 0;
        public static final int ROUTE_TAG_MIN_DIS = 2;
        public static final int ROUTE_TAG_MIN_TIME = 1;

        /* renamed from: id */
        public long f44219id;
        public JSONArray pointArray;
        public List<LatLng> points;
        public int tag;
        public TollChargeResult tollChargeResult;
        public int type;

        public FixedPriceRouteInfo() {
        }

        public String toString() {
            return "FixedPriceRouteInfo{id=" + this.f44219id + ", tag=" + this.tag + ", type=" + this.type + ", points=" + this.points + ", pointArray=" + this.pointArray + '}';
        }
    }

    public class TollChargeResult implements Serializable, Cloneable {
        public double confidenceLevel;
        public boolean isExist;
        public long timestamp;
        public int tollFee;
        public String tollStationNode;

        public TollChargeResult() {
        }

        public int isViaHighway() {
            return this.isExist ? 1 : 0;
        }
    }

    public String toString() {
        return "FixedPriceRouteData{routeMap=" + this.routeMap + ", startLat=" + this.startLat + ", startLng=" + this.startLng + ", endLat=" + this.endLat + ", endLng=" + this.endLng + '}';
    }
}
