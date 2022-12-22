package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class IMOrNOSecurity extends BaseObject {
    public boolean allowContactDriver;
    public String imSecret;
    public String mDriverPhone;
    public JSONObject mNumberProduct;
    public String mPhone;
    public int mVirtual;
    public String numberProtectSecret = "";

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.imSecret = jSONObject.optString("im_key");
        JSONObject optJSONObject = jSONObject.optJSONObject("product_key");
        this.mNumberProduct = optJSONObject;
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("is_virtual");
            this.mVirtual = optInt;
            boolean z = true;
            if (optInt == 1) {
                this.numberProtectSecret = this.mNumberProduct.optString("cusBindData");
            } else {
                this.mPhone = this.mNumberProduct.optString("phone");
                this.mDriverPhone = this.mNumberProduct.optString("driver_phone");
            }
            if (this.mNumberProduct.optInt("allow_contact_driver", 0) != 1) {
                z = false;
            }
            this.allowContactDriver = z;
        }
    }
}
