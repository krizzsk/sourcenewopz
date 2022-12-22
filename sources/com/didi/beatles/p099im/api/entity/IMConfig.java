package com.didi.beatles.p099im.api.entity;

import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.protocol.model.IMBottomGuideConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* renamed from: com.didi.beatles.im.api.entity.IMConfig */
public class IMConfig implements Serializable {
    @SerializedName("guide_tips")
    public List<IMBottomGuideConfig> btmGuideConfigList;
    @SerializedName("business_id")
    public int businessId;
    @SerializedName("sendmsg_eggs")
    public EggsConfig eggsConfig;
    @SerializedName("emoji_list")
    public Map<String, List<IMEmojiModule>> emojiList;

    /* renamed from: com.didi.beatles.im.api.entity.IMConfig$EggsConfig */
    public static class EggsConfig implements Serializable {
        @SerializedName("eggs")
        public List<EggsInfo> eggsInfoList;
        @SerializedName("enable")
        public int enable;
    }

    /* renamed from: com.didi.beatles.im.api.entity.IMConfig$EggsInfo */
    public static class EggsInfo implements Serializable {
        public static final int STYLE_FALL = 0;
        @SerializedName("count")
        public int count;
        @SerializedName("style")
        public int displayStyle;
        @SerializedName("height")
        public int height;
        @SerializedName("eid")

        /* renamed from: id */
        public int f9125id;
        @SerializedName("image")
        public String image;
        @SerializedName("msg")
        public String patternMsg;
        @SerializedName("width")
        public int width;

        public String toString() {
            return "EggsInfo{id=" + this.f9125id + ", msg='" + this.patternMsg + '\'' + ", displayStyle=" + this.displayStyle + ", image='" + this.image + '\'' + ", width=" + this.width + ", height=" + this.height + ", count=" + this.count + '}';
        }
    }
}
