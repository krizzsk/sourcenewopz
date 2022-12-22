package com.didi.safetoolkit.business.bubble.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SfJarvisData extends BffBaseObject {
    public JsonArray banner;
    public List<SfBubbleData> bubbles;
    @SerializedName("data_version")
    public String dataVer;
    public JsonArray menus;
    public JsonObject setting;
    public JsonObject timeline;
}
