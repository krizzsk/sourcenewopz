package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SignInByWhatsAppKeyParam extends BaseParam implements Serializable {
    @SerializedName("whatsapp_key")
    private String whatsAppKey;

    public SignInByWhatsAppKeyParam(Context context, int i) {
        super(context, i);
    }

    public void setWhatsAppKey(String str) {
        this.whatsAppKey = str;
    }

    public String getWhatsAppKey() {
        return this.whatsAppKey;
    }
}
