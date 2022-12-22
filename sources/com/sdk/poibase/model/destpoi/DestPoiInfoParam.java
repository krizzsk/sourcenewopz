package com.sdk.poibase.model.destpoi;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.common.net.CarServerParam;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.HttpParamBase;
import java.util.HashMap;

public class DestPoiInfoParam extends HttpParamBase {
    public CallFrom callFrom = CallFrom.UNKNOWN;
    public String chooseDestPoiInfo;
    public String userOperationType;

    public HashMap<String, Object> getParamMap(Context context) {
        HashMap<String, Object> baseParamMap = getBaseParamMap(context);
        baseParamMap.put(CarServerParam.PARAM_CALL_FROM, this.callFrom);
        baseParamMap.put("user_operation_type", this.userOperationType);
        return baseParamMap;
    }

    public HashMap<String, Object> getBodyMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(this.chooseDestPoiInfo)) {
            hashMap.put("choose_dest_poiinfo", this.chooseDestPoiInfo);
        }
        return hashMap;
    }

    public String toString() {
        return "DestPoiInfoParam{callFrom='" + this.callFrom + '\'' + ", userOperationType='" + this.userOperationType + '\'' + ", chooseDestPoiInfo='" + this.chooseDestPoiInfo + '\'' + ", productId='" + this.productId + '\'' + ", appVersion='" + this.appVersion + '\'' + ", mapType='" + this.mapType + '\'' + ", coordinateType='" + this.coordinate_type + '\'' + ", requesterType='" + this.requester_type + '\'' + ", select_lng=" + this.select_lng + ", select_lat=" + this.select_lat + ", user_loc_lng=" + this.user_loc_lng + ", user_loc_lat=" + this.user_loc_lat + ", phone='" + this.phone + '\'' + ", token='" + this.token + '\'' + ", passengerId='" + this.uid + '\'' + ", lang='" + this.lang + '\'' + '}';
    }
}
