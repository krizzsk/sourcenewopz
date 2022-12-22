package com.didi.beatles.p099im.push;

import com.didi.beatles.p099im.api.entity.IMBaseResponse;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.push.IMParseMsg */
public class IMParseMsg extends IMBaseResponse implements Serializable {
    @SerializedName("mid")
    public long mid;
    @SerializedName("oid")
    public long oid;
    @SerializedName("prod")
    public int product;
    @SerializedName("tx")
    public String push_text;
    @SerializedName("sid")
    public long sid;
    @SerializedName("sty")
    public int sty;
    @SerializedName("ty")

    /* renamed from: ty */
    public int f9582ty;
    @SerializedName("uid")
    public long uid;

    public IMParseMsg parseFromOutJsonString(String str) {
        return (IMParseMsg) new Gson().fromJson(str, IMParseMsg.class);
    }
}
