package com.didi.component.business.xengine.commit;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CommitBtnModel implements BffGsonStruct {
    @SerializedName("action_id")
    public String actionId;
    public String button_type;

    /* renamed from: id */
    public String f11410id;
    public String link;
    public String text;
}
