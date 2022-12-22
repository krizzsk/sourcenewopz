package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class FormOperationModels implements BffGsonStruct {
    @SerializedName("education_popup_count")
    public int mEducationPopupCount;
    @SerializedName("form_operation_type")
    public int mFormOperationType;
    @SerializedName("scheme")
    public String mScheme;
}
