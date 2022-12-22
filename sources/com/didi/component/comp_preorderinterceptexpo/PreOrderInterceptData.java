package com.didi.component.comp_preorderinterceptexpo;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: PreOrderInterceptExpo */
class PreOrderInterceptData implements BffGsonStruct {
    @SerializedName("data")
    public List<PreOrderInterceptListItemModel> interceptList;

    PreOrderInterceptData() {
    }
}
