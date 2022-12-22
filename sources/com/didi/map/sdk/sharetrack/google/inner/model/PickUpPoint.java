package com.didi.map.sdk.sharetrack.google.inner.model;

import com.didi.sdk.util.SidConverter;

public class PickUpPoint {
    public String acc_key = SidConverter.ACCKEY_GLOBAL_PUBLIC;
    public String app_id = "";
    public String app_version = "100.100.100";
    public String coordinate_type = "wgs84";
    public PointInfo data;
    public String lang = "en-US";
    public String map_type = "gmap";
    public int op_type = 1;
    public String order_id = "";
    public String platform = "2";
    public String product_id = "30008";
    public String requester_type = "2";
    public String token = "";

    public String toString() {
        return String.format("acc_key:%s,platform:%s,map_type:%s,coordinate_type:%s,requester_type:%s,app_version:%s,product_id:%s, app_id:%s, lang:%s,order_id:%s, token:%s, data:%s", new Object[]{this.acc_key, this.platform, this.map_type, this.coordinate_type, this.requester_type, this.app_version, this.product_id, this.app_id, this.lang, this.order_id, this.token, this.data.toString()});
    }
}
