package com.didi.component.phoneentrance.model;

import com.didi.component.business.bizconfig.store.BizConfigModel;
import com.didi.component.common.net.CarServerParam;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverOptionData extends BaseObject {
    public int allowContactDriver = 0;
    public int area = 0;
    public String avatar = "";
    public int businessId = 0;
    public String cusBindData = "";
    public String driverId = "";
    public String driverPhone = "";
    public int imBusinessId = 0;
    public String imKey = "";
    public int imMotionDuration = 0;
    public int imMotionStatus = 0;
    public int isAvailableMsg = 1;
    public int isVitual = 0;
    public String joinModel = "";
    public String name = "";
    public String oid = "";
    public String phone = "";
    public String servicePhone = "";
    public int status = 0;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.imBusinessId = jSONObject.optInt("im_business_id");
            this.imKey = jSONObject.optString("im_key");
            this.businessId = jSONObject.optInt("business_id");
            this.area = jSONObject.optInt("area");
            this.oid = jSONObject.optString("oid");
            this.driverId = jSONObject.optString(CarServerParam.PARAM_DRIVER_ID);
            this.name = jSONObject.optString("name");
            this.avatar = jSONObject.optString("avatar");
            this.status = jSONObject.optInt("status");
            this.servicePhone = jSONObject.optString(BizConfigModel.KEY_SERVICE_PHONE);
            this.cusBindData = jSONObject.optString("cusBindData");
            this.driverPhone = jSONObject.optString("driver_phone");
            this.isVitual = jSONObject.optInt("is_virtual");
            this.phone = jSONObject.optString("phone");
            this.allowContactDriver = jSONObject.optInt("allow_contact_driver");
            this.joinModel = jSONObject.optString("join_model");
            this.imMotionDuration = jSONObject.optInt("im_motion_duration", 0);
            this.imMotionStatus = jSONObject.optInt("im_motion_status", 0);
            if (jSONObject.has("is_available_msg")) {
                this.isAvailableMsg = jSONObject.optInt("is_available_msg");
            }
        }
    }
}
