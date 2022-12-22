package com.sdk.poibase.model.reverse;

import android.content.Context;
import com.didi.component.common.net.CarServerParam;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.HttpParamBase;
import java.io.Serializable;
import java.util.HashMap;

public class ReverseGeoParam extends HttpParamBase implements Serializable {
    public CallFrom callFrom = CallFrom.UNKNOWN;

    public HashMap<String, Object> getParamMap(Context context) {
        HashMap<String, Object> baseParamMap = getBaseParamMap(context);
        baseParamMap.put("lat", Double.valueOf(this.select_lat));
        baseParamMap.put("lng", Double.valueOf(this.select_lng));
        baseParamMap.put("platform", "android");
        baseParamMap.put(CarServerParam.PARAM_CALL_FROM, this.callFrom.toString());
        return baseParamMap;
    }
}
