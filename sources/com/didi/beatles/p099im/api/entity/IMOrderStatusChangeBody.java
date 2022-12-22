package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.resource.IMResource;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.entity.IMOrderStatusChangeBody */
public class IMOrderStatusChangeBody implements Serializable {
    @SerializedName("align_style")
    public int alignStyle;
    @SerializedName("anchor_icon")
    public String anchorIcon;
    public String anchor_text;
    public Block block = new Block();
    @SerializedName("btn_group")
    public List<IMRichInfo> btnGroup;
    @SerializedName("click_type")
    public int clickType;
    @SerializedName("extend")
    public ExtendInfo extend;
    public int format_type;
    public String icon;
    public String link;
    public int link_type;
    public long oid;
    public long peer_uid;
    public int status;
    @SerializedName("image")
    public StreetImage streetImage;
    public String subtitle;
    public String tcolor;
    public String title;
    public long to_uid;
    public int to_user_role;

    /* renamed from: com.didi.beatles.im.api.entity.IMOrderStatusChangeBody$Block */
    public static class Block implements Serializable {
        public String ext_text;
        public String from;
        public String text;

        /* renamed from: to */
        public String f9127to;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMOrderStatusChangeBody$ExtendInfo */
    public static class ExtendInfo implements Serializable {
        @SerializedName("anal_txt")
        public String analTxt;
        @SerializedName("msg_data")
        public IMRichInfoMsgBody msgData;
        @SerializedName("msg_type")
        public int msgType;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMOrderStatusChangeBody$StreetImage */
    public static class StreetImage implements Serializable {
        @SerializedName("expires_at")
        public long expiresAt;
        public int height;
        @SerializedName("image_url")
        public String imageUrl;
        public int width;
    }

    public IMOrderStatusChangeBody getDefaultBody() {
        IMOrderStatusChangeBody iMOrderStatusChangeBody = new IMOrderStatusChangeBody();
        iMOrderStatusChangeBody.format_type = 1;
        Block block2 = new Block();
        block2.text = IMResource.getString(R.string.im_cannot_support_this_type);
        iMOrderStatusChangeBody.block = block2;
        iMOrderStatusChangeBody.link_type = -1;
        return iMOrderStatusChangeBody;
    }
}
