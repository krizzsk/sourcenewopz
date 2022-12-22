package com.didi.global.globalgenerickit.model;

import com.android.didi.bfflib.business.BffBaseObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ComponentConfigPopModel extends BffBaseObject {
    @SerializedName("passenger_popup")
    public List<ComponentConfigDialogModel> popUps;
}
