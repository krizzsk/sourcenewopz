package com.didi.soda.customer.foundation.push.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OutsideMessageModel implements Serializable {
    private static final long serialVersionUID = -8612880059873457249L;
    @SerializedName("content")
    public String content;
    @SerializedName("linkContent")
    public LinkContent linkContent;
    @SerializedName("linkType")
    public String linkType;
    @SerializedName("p_id")
    public String pId;
    @SerializedName("title")
    public String title;
    @SerializedName("version")
    public String version;

    public static class LinkContent implements Serializable {
        private static final long serialVersionUID = -1085949053806359700L;
        @SerializedName("type")
        public String type;
        @SerializedName("url")
        public String url;
    }

    public String getLinkUrl() {
        LinkContent linkContent2 = this.linkContent;
        return linkContent2 != null ? linkContent2.url : "";
    }

    public String toString() {
        return "content = " + this.content + " ,title = " + this.title + " ,version = " + this.version + " ,linkContent = " + this.linkContent;
    }
}
