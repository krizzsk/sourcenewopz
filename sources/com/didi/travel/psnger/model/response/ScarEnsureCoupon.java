package com.didi.travel.psnger.model.response;

import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.json.JSONObject;

public class ScarEnsureCoupon extends BaseObject {
    public ScarActEnsure actEnsure;
    public String act_img;
    public int amount;
    public String cancelMsg;
    public String cancel_button;
    public String expire_time;
    public String msg;
    public String share_button;
    public String share_url;
    public String title;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(ParamConst.PARAM_COUPON_INFO);
        if (optJSONObject != null) {
            this.title = optJSONObject.optString("title");
            this.msg = optJSONObject.optString("msg");
            this.act_img = optJSONObject.optString("act_img");
            this.cancel_button = optJSONObject.optString("cancel_button");
            this.share_button = optJSONObject.optString("share_button");
            this.share_url = optJSONObject.optString("share_url");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("cancel_info");
            if (optJSONObject2 != null) {
                this.amount = optJSONObject2.optInt("amount");
                this.cancelMsg = optJSONObject2.optString("msg");
            }
            String optString = optJSONObject.optString("expire_time");
            this.expire_time = optString;
            setExpireTime(optString);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("slow_compensation_coupon_banner");
            if (optJSONObject3 != null) {
                ScarActEnsure scarActEnsure = new ScarActEnsure();
                this.actEnsure = scarActEnsure;
                scarActEnsure.pares(optJSONObject3);
            }
        }
    }

    private void setExpireTime(String str) {
        if (str != null || !"".equals(str)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.expire_time = simpleDateFormat.format(simpleDateFormat.parse(str));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return "ScarEnsureCoupon{title='" + this.title + '\'' + ", msg='" + this.msg + '\'' + ", act_img='" + this.act_img + '\'' + ", cancel_button='" + this.cancel_button + '\'' + ", share_button='" + this.share_button + '\'' + ", share_url='" + this.share_url + '\'' + ", amount=" + this.amount + ", cancelMsg='" + this.cancelMsg + '\'' + ", expire_time='" + this.expire_time + '\'' + ", actEnsure=" + this.actEnsure + '}';
    }
}
