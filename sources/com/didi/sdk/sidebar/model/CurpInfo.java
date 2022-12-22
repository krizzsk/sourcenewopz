package com.didi.sdk.sidebar.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.annotations.SerializedName;

public class CurpInfo extends BffBaseObject implements BffGsonStruct {
    @SerializedName("id_no")
    public String idNumber;
    @SerializedName("status")
    public int status;
}
