package com.sdk.poibase.model.guideentrance;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.sdk.poibase.model.HttpParamBase;
import com.sdk.poibase.util.UrlParseUtils;
import java.util.HashMap;

public class StreetCheckParam extends HttpParamBase {

    /* renamed from: a */
    private String f56001a;

    /* renamed from: b */
    private String f56002b;

    public HashMap<String, Object> getParamMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, String> urlParams = UrlParseUtils.getUrlParams(this.f56002b);
        if (urlParams != null) {
            hashMap.put("size", urlParams.get("size"));
            hashMap.put("location", urlParams.get("location"));
            hashMap.put("heading", urlParams.get("heading"));
        }
        hashMap.put("tirpid", TextUtils.isEmpty(this.f56001a) ? "" : this.f56001a);
        hashMap.put("passenger_id", PaxEnvironment.getInstance().getUid());
        hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
        hashMap.put("countrycode", PaxEnvironment.getInstance().getCountryCode());
        DLog.m7384d("StreetCheckParam", hashMap.toString(), new Object[0]);
        return hashMap;
    }

    public void setTirpid(String str) {
        this.f56001a = str;
    }

    public void setStreetViewUrl(String str) {
        this.f56002b = str;
    }
}
