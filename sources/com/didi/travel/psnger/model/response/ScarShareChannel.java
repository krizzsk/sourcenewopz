package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class ScarShareChannel extends BaseObject {
    public static final String EMAIL = "email";
    public static final String FACE_BOOK = "facebook";
    public static final String LINE = "line";
    public static final String MESSENGER = "messenger";
    public static final String OTHER = "other";
    public static final String TWITTER = "twitter";
    public static final String WHATS_APP = "whatsapp";
    public boolean openAlipayCircle = false;
    public boolean openAlipayFriend = false;
    public boolean openEmail = false;
    public boolean openFacebook = false;
    public boolean openLine = false;
    public boolean openMessenger = false;
    public boolean openOther = false;
    public boolean openSinaWeibo = false;
    public boolean openTwitter = false;
    public boolean openWXCircle = false;
    public boolean openWXFriend = false;
    public boolean openWhatsapp = false;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.openWXFriend = TextUtils.equals("1", jSONObject.optString("weixin_friend"));
        this.openWXCircle = TextUtils.equals("1", jSONObject.optString("weixin_moments"));
        this.openAlipayFriend = TextUtils.equals("1", jSONObject.optString("alipay_friend"));
        this.openAlipayCircle = TextUtils.equals("1", jSONObject.optString("alipay_life_circle"));
        this.openSinaWeibo = TextUtils.equals("1", jSONObject.optString("weibo"));
        this.openOther = TextUtils.equals("1", jSONObject.optString("other"));
        this.openWhatsapp = TextUtils.equals("1", jSONObject.optString(WHATS_APP));
        this.openFacebook = TextUtils.equals("1", jSONObject.optString("facebook"));
        this.openTwitter = TextUtils.equals("1", jSONObject.optString(TWITTER));
        this.openMessenger = TextUtils.equals("1", jSONObject.optString(MESSENGER));
        this.openEmail = TextUtils.equals("1", jSONObject.optString("email"));
        this.openLine = TextUtils.equals("1", jSONObject.optString(LINE));
    }
}
