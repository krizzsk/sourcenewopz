package com.didi.map.global.sctx.model;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.map.google.config.Config;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.google.util.JsonParseHelper;
import com.didi.map.sdk.proto.driver_gl.PickupPoint;
import com.didi.map.sdk.proto.driver_gl.Route;
import com.didi.map.sdk.proto.driver_gl.SecRouteInfo;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

public class SecRouteInfoEx {

    /* renamed from: a */
    private static final String f27690a = "main_title";

    /* renamed from: b */
    private static final String f27691b = "sub_title";
    public SecRouteInfo mInfo;

    public SecRouteInfoEx(SecRouteInfo secRouteInfo) {
        this.mInfo = secRouteInfo;
    }

    public SecRouteInfo getInfo() {
        return this.mInfo;
    }

    public PickupPoint getPickupPoint() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return null;
        }
        return secRouteInfo.point;
    }

    public String getMainTitle() {
        return m19839a(f27690a);
    }

    public String getSubTitle() {
        return m19839a("sub_title");
    }

    /* renamed from: a */
    private String m19839a(String str) {
        Object parse;
        try {
            if (this.mInfo.newPPMsg == null) {
                return null;
            }
            String string = this.mInfo.newPPMsg.string(StandardCharsets.UTF_8);
            if (TextUtils.isEmpty(string) || (parse = JsonParseHelper.parse(string, str, false)) == null) {
                return null;
            }
            return parse.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Route getRoute() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return null;
        }
        return secRouteInfo.route;
    }

    public int getRouteTerm() {
        if (Config.RecommendDuration > 0) {
            return Config.RecommendDuration;
        }
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return 0;
        }
        return secRouteInfo.routeTerm.intValue();
    }

    public String getBubMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.bubMsg;
    }

    public String getUseMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.useMsg;
    }

    public String getIgnMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.ignMsg;
    }

    public String getCurPPGrtMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.curPPGrtMsg;
    }

    public String getCantChgMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.cantChgMsg;
    }

    public String getChgSuccMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.chgSuccMsg;
    }

    public int getBubType() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return 0;
        }
        return secRouteInfo.bubType.intValue();
    }

    public String getBubNewPPMsg() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null) {
            return "";
        }
        return secRouteInfo.bubNewPPMsg;
    }

    public String getBubMsgV2() {
        try {
            if (this.mInfo.bubMsgV2 != null) {
                return this.mInfo.bubMsgV2.string(StandardCharsets.UTF_8);
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getSepIndex() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null || secRouteInfo.route == null || this.mInfo.route.sepIdx == null) {
            return -1;
        }
        return this.mInfo.route.sepIdx.intValue();
    }

    public LatLng getSepLatLng() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null || secRouteInfo.route == null) {
            return null;
        }
        List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(this.mInfo.route.routePoints);
        int intValue = this.mInfo.route.sepIdx == null ? -1 : this.mInfo.route.sepIdx.intValue();
        if (CollectionUtil.isEmpty((Collection<?>) latLngListFromDiffGeoPoints) || intValue == -1 || latLngListFromDiffGeoPoints.size() <= intValue) {
            return null;
        }
        return latLngListFromDiffGeoPoints.get(intValue);
    }

    public int getIncluded() {
        SecRouteInfo secRouteInfo = this.mInfo;
        if (secRouteInfo == null || secRouteInfo.route == null) {
            return -1;
        }
        return this.mInfo.route.included.intValue();
    }
}
