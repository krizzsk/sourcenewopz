package com.didi.sdk.global.common.com;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.Serializable;
import org.json.JSONObject;

public class EnterpriseInfo implements Serializable {
    public static final int FLAG_CHECKED = 3;
    public static final int FLAG_UNCHECKED = 2;
    public static final int FLAG_UNKNOW = 1;
    public String descDisable;
    public String descEnable;
    public int flag;
    public String innerTitle;
    public String logo;
    public String tip;

    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.descEnable = jSONObject.optString("enterprise_description_enable");
            this.descDisable = jSONObject.optString("enterprise_description_disable");
            this.innerTitle = jSONObject.optString("enterprise_inner_title");
            this.tip = jSONObject.optString("enterprise_tip");
            this.logo = jSONObject.optString("enterprise_logo");
            this.flag = jSONObject.optInt(ParamKeys.PARAM_ENTERPRISE_FLAG, 1);
        }
    }

    public boolean isChecked() {
        return this.flag == 3;
    }
}
