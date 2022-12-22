package com.didi.beatles.p099im.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMRichInfoMsgBody */
public class IMRichInfoMsgBody extends IMRichInfo implements Serializable {
    @SerializedName("link_info")
    public LinkInfo linkInfo;
    @SerializedName("title")
    public String title;
    @SerializedName("tcolor")
    public String titleColor;

    /* renamed from: com.didi.beatles.im.api.entity.IMRichInfoMsgBody$LinkInfo */
    public static class LinkInfo implements Serializable {
        @SerializedName("anchor")
        public String anchor;
        @SerializedName("acolor")
        public String anchorColor;
        @SerializedName("uri")
        public String uri;
    }
}
