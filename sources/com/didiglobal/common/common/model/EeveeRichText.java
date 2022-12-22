package com.didiglobal.common.common.model;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EeveeRichText implements Serializable {
    @SerializedName("default")
    public EeveeDefaultText defaultItem;
    @SerializedName("rich_text")
    public LEGORichInfo richInfo;

    public static class EeveeDefaultText {

        /* renamed from: id */
        public String f49740id;
    }
}
