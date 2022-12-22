package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMGetConfigRequest */
public class IMGetConfigRequest extends IMBaseRequest {
    @SerializedName("body")
    public Body body = new Body();

    /* renamed from: com.didi.beatles.im.api.entity.IMGetConfigRequest$Body */
    public static class Body implements Serializable {
    }

    public IMGetConfigRequest() {
        super(261);
    }
}
