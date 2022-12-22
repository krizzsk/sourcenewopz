package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import com.didichuxing.diface.biz.guide.GuideHelper;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GuideShowInfoData extends BaseObject {
    public String affirmText;
    public int buttonStatus;
    public String buttonText;
    public String cancelButtonTitle;
    public String clickTitle;
    public String confirmButtonTitle;
    public int countDown;
    public GuideResult guideResult;
    public List<SeatNum> seatNums;
    public String showUrl;
    public String tip;
    public String title;
    public int type;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.title = jSONObject.optString("title");
        this.clickTitle = jSONObject.optString("click_title");
        this.buttonStatus = jSONObject.optInt("button_status");
        this.buttonText = jSONObject.optString("button_text");
        this.tip = jSONObject.optString("tip");
        this.affirmText = jSONObject.optString("affirm_text");
        this.cancelButtonTitle = jSONObject.optString("cancel_button_title");
        this.confirmButtonTitle = jSONObject.optString("confirm_button_title");
        this.type = jSONObject.optInt("type");
        this.countDown = jSONObject.optInt("count_down");
        JSONArray optJSONArray = jSONObject.optJSONArray("seat_nums");
        if (optJSONArray != null) {
            this.seatNums = new JsonUtil().parseJSONArray(optJSONArray, new SeatNum());
        }
        this.showUrl = jSONObject.optString("show_url");
        JSONObject optJSONObject = jSONObject.optJSONObject(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        if (optJSONObject != null) {
            GuideResult guideResult2 = new GuideResult();
            this.guideResult = guideResult2;
            guideResult2.parse(optJSONObject);
        }
    }

    public static final class SeatNum extends BaseObject {
        public int num;
        public String title;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.num = jSONObject.optInt("num");
            this.title = jSONObject.optString("title");
        }
    }
}
