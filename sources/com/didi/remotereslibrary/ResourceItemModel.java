package com.didi.remotereslibrary;

import com.didi.remotereslibrary.response.BaseResponse;
import org.json.JSONObject;

public class ResourceItemModel extends BaseResponse {
    public boolean HideNoticationView = true;
    public boolean OnlyWifiType = true;
    public String dir;
    public String file;
    public String key = "";
    public String md5 = "";
    public String url;

    public void parser(JSONObject jSONObject) {
        super.parser(jSONObject);
        this.url = jSONObject.optString("url");
        this.md5 = jSONObject.optString("md5");
        boolean z = true;
        if (jSONObject.optInt("network", 1) != 1) {
            z = false;
        }
        this.OnlyWifiType = z;
        this.dir = jSONObject.optString("dir", "");
        this.file = jSONObject.optString("file", "");
        this.key = this.dir + "/" + this.file;
    }
}
