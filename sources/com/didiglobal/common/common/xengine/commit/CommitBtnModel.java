package com.didiglobal.common.common.xengine.commit;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CommitBtnModel implements BffGsonStruct {
    @SerializedName("action_id")
    public String actionId;
    public String button_type;

    /* renamed from: id */
    public String f49751id;
    public String link;
    public String text;
}
