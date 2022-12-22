package com.didi.safetoolkit.business.toolkit.model;

import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import org.json.JSONObject;

public class SfViewMonitorMenuModel extends SfViewMenuModel {
    public String alertTile;
    public String btnJumpText;
    public String btnOkText;
    public boolean canMonitor;
    public DriverData driverData;
    public String imgUrl;
    public boolean isMonitoring;
    public String monitorDesc;
    public String monitorStateText;
    public String pageTitle;
    public String pushId;

    public static class DriverData implements Serializable {
        public String orderId;
        public int thumbId = -1;
        public int trackId = -1;
        public String tripId;
    }

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            super.parse(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("extra_data");
            if (optJSONObject != null) {
                boolean z = false;
                this.canMonitor = optJSONObject.optInt("enable_notice") == 1;
                if (optJSONObject.optInt("monitor_type") == 2) {
                    z = true;
                }
                this.isMonitoring = z;
                this.pushId = optJSONObject.optString("push_id");
                this.alertTile = optJSONObject.optString("alert_title");
                this.btnOkText = optJSONObject.optString("button_ok");
                this.btnJumpText = optJSONObject.optString("button_to_safety");
                this.pageTitle = optJSONObject.optString("detail_page_title");
                this.imgUrl = optJSONObject.optString("detail_page_imgurl");
                this.monitorDesc = optJSONObject.optString("detail_page_content");
                this.monitorStateText = optJSONObject.optString("detail_page_monitor_state_text");
                this.icon = getIconResId();
            }
        }
    }

    public int getIconResId() {
        SystemUtils.log(3, "SfViewMonitorMenuModel", "isMonitoring:" + this.isMonitoring, (Throwable) null, "com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel", 61);
        return this.isMonitoring ? R.drawable.sf_icon_monitor_start : R.drawable.sf_icon_monitor_pre_start;
    }
}
