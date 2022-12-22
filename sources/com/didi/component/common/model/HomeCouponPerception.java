package com.didi.component.common.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONException;
import org.json.JSONObject;
import rui.config.RConfigConstants;

public class HomeCouponPerception extends BaseObject {
    private static final int CORNERS = 13;
    private String backgroundColor;
    public int couponCount;
    public String couponText;
    private String detailText;
    private String expireTime;
    public boolean showCoupon;
    private String textColor;
    public String tipText;
    public String titleText;
    public String topText;
    public String validTimeText;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            this.backgroundColor = jSONObject2.optString("color_bar");
            this.textColor = jSONObject2.optString("color_text");
            this.detailText = jSONObject2.optString("coupon_detail_text");
            this.expireTime = jSONObject2.optString("expiration_time");
            this.couponText = jSONObject2.optString("coupon_text");
            this.titleText = jSONObject2.optString("title_text");
            this.topText = jSONObject2.optString("top_text");
            this.tipText = jSONObject2.optString("tip_text");
            this.validTimeText = jSONObject2.optString("valid_time_text");
            this.couponCount = jSONObject2.optInt("coupon_count");
            int optInt = jSONObject2.optInt("show_coupon");
            boolean z = true;
            if (optInt != 1) {
                z = false;
            }
            this.showCoupon = z;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getDetailText() {
        return this.detailText;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public int getBackgroundColor() {
        try {
            if (!this.backgroundColor.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                this.backgroundColor = RConfigConstants.KEYWORD_COLOR_SIGN + this.backgroundColor;
            }
            return Color.parseColor(this.backgroundColor);
        } catch (Exception unused) {
            return Color.parseColor("#FF62B360");
        }
    }

    public int getTextColor() {
        try {
            if (!this.textColor.startsWith(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                this.textColor = RConfigConstants.KEYWORD_COLOR_SIGN + this.textColor;
            }
            return Color.parseColor(this.textColor);
        } catch (Exception unused) {
            return -1;
        }
    }

    public GradientDrawable getBackgroundDrawable(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getBackgroundColor());
        float dip2px = UIUtils.dip2px(context, 13.0f);
        gradientDrawable.setCornerRadii(new float[]{dip2px, dip2px, dip2px, dip2px, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }
}
