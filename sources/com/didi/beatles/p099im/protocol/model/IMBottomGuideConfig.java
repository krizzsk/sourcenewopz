package com.didi.beatles.p099im.protocol.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.protocol.model.IMBottomGuideConfig */
public class IMBottomGuideConfig implements Serializable {
    @SerializedName("count")
    public int count;
    @SerializedName("plugin_id")
    public int pluginId;
    @SerializedName("text")
    public String tip;

    public String toString() {
        return "IMBottomGuideConfig{pluginId=" + this.pluginId + ", count=" + this.count + ", tip='" + this.tip + '\'' + '}';
    }
}
