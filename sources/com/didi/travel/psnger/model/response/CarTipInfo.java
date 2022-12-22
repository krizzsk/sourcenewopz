package com.didi.travel.psnger.model.response;

import com.didi.app.SchemeDispatcherImpl;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.utils.TextUtil;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarTipInfo extends BaseObject {
    public String currency;
    public String entryIcon = "";
    public String entryText = "";
    public FeeItem[] feeItems;
    public int is_pay;
    public int is_show;
    public String[] list;
    public int max;
    public int min;
    public String msg;
    public String thankMsg;
    public String tipIcon = "";
    public int tipOther = 0;
    public String tipOtherText = "";
    public String tipSubTitle = "";
    public String title;

    public static class FeeItem implements Serializable {
        public String currency;
        public double tipNum;
        public String tipString;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            this.title = jSONObject2.optString("title");
            this.tipIcon = jSONObject2.optString("icon");
            this.tipSubTitle = jSONObject2.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.is_show = jSONObject2.optInt("is_show");
            JSONObject jSONObject3 = jSONObject2.getJSONObject(SchemeDispatcherImpl.HOST_PAY);
            this.is_pay = jSONObject3.optInt("is_pay");
            this.msg = jSONObject3.optString("msg");
            this.thankMsg = jSONObject3.optString("thank_msg");
            if (jSONObject2.has(ParamKeys.PARAM_COMPLAIN_ENTRY)) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject(ParamKeys.PARAM_COMPLAIN_ENTRY);
                this.entryIcon = jSONObject4.optString("icon");
                this.entryText = jSONObject4.optString("text");
            }
            JSONObject jSONObject5 = jSONObject2.getJSONObject("tip");
            JSONArray jSONArray = jSONObject5.getJSONArray("list");
            if (jSONArray != null) {
                int length = jSONArray.length();
                this.list = new String[length];
                for (int i = 0; i < length; i++) {
                    this.list[i] = jSONArray.optString(i);
                }
            }
            this.min = jSONObject5.optInt("min");
            this.max = jSONObject5.optInt("max");
            this.currency = jSONObject5.optString("currency");
            this.tipOther = jSONObject5.optInt("tip_other");
            this.tipOtherText = jSONObject5.optString("tip_other_text");
            JSONArray jSONArray2 = jSONObject5.getJSONArray("fee_list");
            if (jSONArray2 != null) {
                int length2 = jSONArray2.length();
                if (isShowCustomizeTip()) {
                    this.feeItems = new FeeItem[(length2 + 1)];
                } else {
                    this.feeItems = new FeeItem[length2];
                }
                for (int i2 = 0; i2 < length2; i2++) {
                    FeeItem feeItem = new FeeItem();
                    JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                    feeItem.currency = optJSONObject.optString("currency");
                    feeItem.tipString = optJSONObject.optString("tip_str");
                    feeItem.tipNum = optJSONObject.optDouble("tip_num");
                    this.feeItems[i2] = feeItem;
                }
                if (isShowCustomizeTip()) {
                    FeeItem feeItem2 = new FeeItem();
                    feeItem2.tipString = this.tipOtherText;
                    this.feeItems[length2] = feeItem2;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isShow() {
        return this.is_show == 1 && !TextUtil.isEmpty(this.msg);
    }

    public boolean isPay() {
        return this.is_pay == 1;
    }

    public boolean isShowCustomizeTip() {
        return this.tipOther == 1 && this.max > 0;
    }
}
