package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GateKeeperParam extends BaseParam implements Serializable {
    @SerializedName("auth_channel")
    public String authChannel;
    private String cell;
    private String email;
    @SerializedName("force_code_login")
    public boolean forceCodeLogin;
    @SerializedName("thirdparty_channels_available")
    public ThirdPartyChannel thirdPartyChannelsAvailable;

    public static class ThirdPartyChannel implements Serializable {
        @SerializedName("whats_app")
        public boolean whatsApp;
    }

    public GateKeeperParam(Context context, int i) {
        super(context, i);
    }

    public GateKeeperParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public String getCell() {
        return this.cell;
    }

    public String getEmail() {
        return this.email;
    }

    public GateKeeperParam setEmail(String str) {
        this.email = str;
        return this;
    }

    public GateKeeperParam setForceCodeLogin(boolean z) {
        this.forceCodeLogin = z;
        return this;
    }

    public GateKeeperParam setAuthChannel(String str) {
        this.authChannel = str;
        return this;
    }
}
