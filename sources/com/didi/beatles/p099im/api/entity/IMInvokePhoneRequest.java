package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMInvokePhoneRequest */
public class IMInvokePhoneRequest extends IMBaseRequest {
    @SerializedName("body")
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMInvokePhoneRequest$Body */
    public static class Body implements Serializable {
        @SerializedName("peer_uid")
        public String peerUid;
        @SerializedName("sid")
        public String sid;
        @SerializedName("type")
        public String type;
    }

    public IMInvokePhoneRequest(int i, String str, String str2, String str3) {
        super(24, i);
        Body body2 = new Body();
        this.body = body2;
        body2.peerUid = str;
        this.body.sid = str2;
        this.body.type = str3;
    }
}
