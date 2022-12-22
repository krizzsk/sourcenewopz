package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;

public class SetEmailParam extends BaseParam {
    @SerializedName("close_marketing_notify")
    boolean closeMarketingNotify;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    @SerializedName("new_email")
    String newEmail;
    @SerializedName("promo_code")
    String promoCode;
    @SerializedName("push_app_type")
    int pushAppType;
    @SerializedName("session_id")
    String sessionId;
    String ticket;

    public SetEmailParam(Context context, int i) {
        super(context, i);
    }

    public SetEmailParam setNewEmail(String str) {
        this.newEmail = str;
        return this;
    }

    public SetEmailParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public SetEmailParam setFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public SetEmailParam setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public SetEmailParam setPromoCode(String str) {
        this.promoCode = str;
        return this;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public int getPushAppType() {
        return this.pushAppType;
    }

    public void setPushAppType(int i) {
        this.pushAppType = i;
    }

    public boolean isCloseMarketingNotify() {
        return this.closeMarketingNotify;
    }

    public void setCloseMarketingNotify(boolean z) {
        this.closeMarketingNotify = z;
    }
}
