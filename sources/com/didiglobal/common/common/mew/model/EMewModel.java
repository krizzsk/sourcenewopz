package com.didiglobal.common.common.mew.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class EMewModel implements Serializable {
    @SerializedName("list")
    public List<EMewCompData> eMewComponentList;
    @SerializedName("ui_config")
    public EMewUIConfig uiConfig;
}
