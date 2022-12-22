package com.didi.component.evaluateentrance.evaluate.model;

import com.didi.app.SchemeDispatcherImpl;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GXPCarTipInfo implements Serializable {
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
        try {
            this.title = jSONObject.optString("title");
            this.tipIcon = jSONObject.optString("icon");
            this.tipSubTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
            this.is_show = jSONObject.optInt("is_show");
            JSONObject jSONObject2 = jSONObject.getJSONObject(SchemeDispatcherImpl.HOST_PAY);
            this.is_pay = jSONObject2.optInt("is_pay");
            this.msg = jSONObject2.optString("msg");
            this.thankMsg = jSONObject2.optString("thank_msg");
            if (jSONObject.has(ParamKeys.PARAM_COMPLAIN_ENTRY)) {
                JSONObject jSONObject3 = jSONObject.getJSONObject(ParamKeys.PARAM_COMPLAIN_ENTRY);
                this.entryIcon = jSONObject3.optString("icon");
                this.entryText = jSONObject3.optString("text");
            }
            JSONObject jSONObject4 = jSONObject.getJSONObject("tip");
            JSONArray jSONArray = jSONObject4.getJSONArray("list");
            if (jSONArray != null) {
                int length = jSONArray.length();
                this.list = new String[length];
                for (int i = 0; i < length; i++) {
                    this.list[i] = jSONArray.optString(i);
                }
            }
            this.min = jSONObject4.optInt("min");
            this.max = jSONObject4.optInt("max");
            this.currency = jSONObject4.optString("currency");
            this.tipOther = jSONObject4.optInt("tip_other");
            this.tipOtherText = jSONObject4.optString("tip_other_text");
            JSONArray jSONArray2 = jSONObject4.getJSONArray("fee_list");
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
        return this.is_show == 1;
    }

    public boolean isPay() {
        return this.is_pay == 1;
    }

    public boolean isShowCustomizeTip() {
        return this.tipOther == 1 && this.max > 0;
    }
}
