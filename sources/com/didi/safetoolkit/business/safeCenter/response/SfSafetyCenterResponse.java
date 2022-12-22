package com.didi.safetoolkit.business.safeCenter.response;

import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.model.ISfBaseObject;
import com.didi.safetoolkit.model.SfBaseObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SfSafetyCenterResponse extends SfBaseObject {
    public SfSafetyCenterData data;

    public static class SfSafetyCenterData implements ISfBaseObject {
        @SerializedName("safety_content")
        public List<SfCenterCardModel> safetyContent;
        @SerializedName("show_add")
        public int showAdd;
    }
}
