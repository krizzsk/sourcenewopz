package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMInvokePhoneResponse */
public class IMInvokePhoneResponse extends IMBaseResponse {
    @SerializedName("body")
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMInvokePhoneResponse$Body */
    public static class Body implements Serializable {
        @SerializedName("link")
        public String link;
        @SerializedName("phone")
        public String phone;
        @SerializedName("text")
        public String text;
    }
}
