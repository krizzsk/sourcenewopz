package com.didichuxing.publicservice.resourcecontrol.pojo;

import com.didichuxing.publicservice.general.ConstantUtils;
import java.util.HashMap;
import java.util.Map;

public class RCRequestParams {
    public ConstantUtils.AppId appId;
    public String appKey;
    public int cityId;
    public String country;
    public String groupType;
    public double lat;
    public double lng;
    public Map<String, String> params = new HashMap();
    public String token;

    public String toString() {
        return "RCRequestParams{appKey='" + this.appKey + '\'' + ", appId=" + this.appId + ", cityId=" + this.cityId + ", lng=" + this.lng + ", lat=" + this.lat + ", token='" + this.token + '\'' + ", country='" + this.country + '\'' + ", groupType='" + this.groupType + '\'' + '}';
    }
}
