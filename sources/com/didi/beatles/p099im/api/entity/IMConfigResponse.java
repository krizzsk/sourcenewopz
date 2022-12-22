package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMConfigResponse */
public class IMConfigResponse extends IMBaseResponse {
    @SerializedName("body")
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMConfigResponse$Body */
    public static class Body implements Serializable {
        @SerializedName("business")
        public List<IMConfig> bizConfigList;
        @SerializedName("config")
        public Config config;
        @SerializedName("common")
        public IMConfig globalConfig;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMConfigResponse$Config */
    public static class Config implements Serializable {
        @SerializedName("emoji_url_prefix")
        public String emojiUrlPrefix;
    }
}
