package com.didi.travel.psnger.model.response;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;

public class StationModel {
    @SerializedName("display_name")
    public LEGORichInfo displayName;
    @SerializedName("guide_img")
    public String guideImg;
    @SerializedName("line_config")
    public LineConfig lineConfig;

    public static class LineConfig {
        @SerializedName("line_color")
        public String lineColor;
        @SerializedName("line_type")
        public int lineType;
        @SerializedName("lottie_url")
        public String lottieUrl;
        @SerializedName("line_mark_img")
        public String markImg;
        @SerializedName("line_mark_size")
        public MarkSize markSize;
    }

    public static class MarkSize implements BffGsonStruct {
        public int height;
        public int width;
    }
}
