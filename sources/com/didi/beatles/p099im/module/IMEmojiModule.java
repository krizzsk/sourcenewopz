package com.didi.beatles.p099im.module;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.module.IMEmojiModule */
public class IMEmojiModule implements Serializable {
    public String desc;
    @SerializedName("emoji_id")
    public String emojiId;
    public String host;
    @SerializedName("pic_name")
    public String picName;
    @SerializedName("voice")
    public String voice;
}
