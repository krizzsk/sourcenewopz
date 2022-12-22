package com.didi.travel.psnger.core.model.response;

import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarServerParam;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import org.json.JSONObject;

public class DTSDKDriverModel extends BaseObject {
    public String accreditationDesc;
    public String agreeDashcamUrl;
    public String avatarUrl;
    public String carId;
    public String carType;
    public String card = "";
    public String cardExt = "";
    public String cardPattern;
    public String company = "";
    public String companyIconUrl;
    public String complianceInfo;
    public String did = "";
    public String driverCarImage;
    public String driverSubInfo;
    public String drvierTagTitle;
    public String homePageUrl;
    public int isDashcam;
    public int joinModel;
    public String labelTitle;
    public int labelType;
    public float level = 1.0f;
    public String name = "";
    public int orderCount = 0;
    public String orderCountString;
    public float star;
    public int useNewCard;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.did = jSONObject.optString(CarServerParam.PARAM_DRIVER_ID);
            this.carId = jSONObject.optString("car_level");
            this.carType = jSONObject.optString("car_title");
            this.name = jSONObject.optString("name");
            this.card = jSONObject.optString("license_num");
            this.cardPattern = jSONObject.optString("license_num_pattern");
            this.cardExt = jSONObject.optString("license_num_ext");
            this.company = jSONObject.optString(ComponentType.COMPANY);
            this.avatarUrl = jSONObject.optString("avatar");
            if (jSONObject.has("order_cnt")) {
                this.orderCount = jSONObject.optInt("order_cnt");
            } else {
                this.orderCount = -1;
            }
            this.level = (float) jSONObject.optDouble("level");
            this.driverCarImage = jSONObject.optString("car_image");
            this.labelType = jSONObject.optInt("label_type");
            this.labelTitle = jSONObject.optString("label_left");
            this.drvierTagTitle = jSONObject.optString("label_right");
            this.companyIconUrl = jSONObject.optString("company_logo");
            this.accreditationDesc = jSONObject.optString("da_desc");
            this.complianceInfo = jSONObject.optString("compliance_info");
            this.isDashcam = jSONObject.optInt("is_dashcam", 0);
            this.agreeDashcamUrl = jSONObject.optString("agree_dashcam_url");
            this.driverSubInfo = jSONObject.optString("name_down");
            this.orderCountString = jSONObject.optString("order_cnt_str");
            this.useNewCard = jSONObject.optInt("is_new");
            this.star = (float) jSONObject.optDouble("star", 0.0d);
            this.homePageUrl = jSONObject.optString("homepage_url");
            this.joinModel = jSONObject.optInt("join_model");
        }
    }

    public String toString() {
        return "DriverModel [did=" + this.did + ", name=" + this.name + ", company=" + this.company + ", card=" + this.card + ", level=" + this.level + ", orderCount=" + this.orderCount + ", carType=" + this.carType + ", avatarUrl=" + this.avatarUrl + ", errno=" + this.errno + ", errmsg=" + this.errmsg + ", timeoffset=" + this.timeoffset + ", driverCarImage=" + this.driverCarImage + "agreeDashcamUrl=" + this.agreeDashcamUrl + Const.jaRight;
    }
}
