package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class CarRedRecordInfo extends BaseObject {
    private static final long serialVersionUID = 1;
    public String dialogContent;
    public String dialogTitle;
    public int mActivityId;
    public String mDialogBtnTxt;
    public String mDialogCancleTxt;
    public String mDialogIconUrl;
    public int mIsRed;
    public String mPaidSendTxt;
    public String mRedContent;
    public String mRedPicUrl;
    public String mRedTitle;
    public String mRedUrl;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mIsRed = jSONObject.optInt("hongbaoenable");
        this.mRedUrl = jSONObject.optString("url");
        this.dialogTitle = jSONObject.optString("toasttitle");
        this.dialogContent = jSONObject.optString("toastcontent");
        this.mDialogIconUrl = jSONObject.optString("toastpic");
        this.mRedTitle = jSONObject.optString("sharetitle");
        this.mRedContent = jSONObject.optString("sharecontent");
        this.mRedPicUrl = jSONObject.optString("sharepic");
        this.mDialogBtnTxt = jSONObject.optString("sendtext");
        this.mDialogCancleTxt = jSONObject.optString("canceltext");
        this.mPaidSendTxt = jSONObject.optString("buttontitle");
        this.mActivityId = jSONObject.optInt("activityid");
    }
}
