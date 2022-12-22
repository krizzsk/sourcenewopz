package com.didi.component.driverbar.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class DriverCarData extends BaseObject {
    public LEGORichInfo carColorInfo;
    public LEGORichInfo carTypeInfo;
    public String icon;
    public LEGORichInfo licenseNum;
    @Deprecated
    public LEGORichInfo licenseNumExtra;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        super.parse(jSONObject);
        if (jSONObject != null) {
            this.icon = jSONObject.optString("icon");
            if (jSONObject.has("license_num") && (optJSONObject4 = jSONObject.optJSONObject("license_num")) != null) {
                LEGORichInfo lEGORichInfo = new LEGORichInfo();
                this.licenseNum = lEGORichInfo;
                lEGORichInfo.setInfo(optJSONObject4.toString());
            }
            if (jSONObject.has("license_num_extra") && (optJSONObject3 = jSONObject.optJSONObject("license_num_extra")) != null) {
                LEGORichInfo lEGORichInfo2 = new LEGORichInfo();
                this.licenseNumExtra = lEGORichInfo2;
                lEGORichInfo2.setInfo(optJSONObject3.toString());
            }
            if (jSONObject.has("car_type_info_name") && (optJSONObject2 = jSONObject.optJSONObject("car_type_info_name")) != null) {
                LEGORichInfo lEGORichInfo3 = new LEGORichInfo();
                this.carTypeInfo = lEGORichInfo3;
                lEGORichInfo3.setInfo(optJSONObject2.toString());
            }
            if (jSONObject.has("car_type_info_color") && (optJSONObject = jSONObject.optJSONObject("car_type_info_color")) != null) {
                LEGORichInfo lEGORichInfo4 = new LEGORichInfo();
                this.carColorInfo = lEGORichInfo4;
                lEGORichInfo4.setInfo(optJSONObject.toString());
            }
        }
    }
}
