package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import org.json.JSONObject;

public class CarPayShare extends BaseObject {
    public static final long serialVersionUID = 1;
    public String mIconUrl;
    public int mShareType;
    public int mShareTypeNew;
    public String mWbContent;
    public String mWxContent;
    public String mWxImageUrl;
    public String mWxJumpUrl;
    public String mWxShareIcon;
    public String mWxTitle;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.mWxTitle = jSONObject.optString("weixinShareTitle");
        this.mWbContent = jSONObject.optString("weiboShareTitle");
        this.mIconUrl = jSONObject.optString("weiboSharePic");
        this.mWxJumpUrl = jSONObject.optString("weixinShareUrl");
        this.mWxImageUrl = jSONObject.optString("weixinSharePic");
        this.mShareType = jSONObject.optInt(ParamKeys.PARAM_SHARE_TYPE);
        this.mWxShareIcon = jSONObject.optString("weixinShareIcon");
        this.mShareTypeNew = jSONObject.optInt("shareTypeNew");
        if (this.mShareType == 0) {
            this.mShareType = 3;
        }
    }

    public String toString() {
        return "CarPayShare [mWxTitle=" + this.mWxTitle + ", mWxContent=" + this.mWbContent + ", mWxShareIcon=" + this.mWxShareIcon + ", mShareTypeNew=" + this.mShareTypeNew + ", mIconUrl=" + this.mIconUrl + ", mWxJumpUrl=" + this.mWxJumpUrl + ", mWxImageUrl=" + this.mWxImageUrl + ", mShareType=" + this.mShareType + ", mWbContent=" + this.mWbContent + Const.jaRight;
    }
}
