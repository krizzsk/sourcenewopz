package com.didiglobal.common.common.mew.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class EMewCompData implements Serializable {
    @SerializedName("id")
    public String eId;
    @SerializedName("extension")
    public EMewCompExt eMewCompExt;
    @SerializedName("normal")
    public EMewCompNormal eMewCompNormal;
    @SerializedName("list")
    public List<EMewCompData> eMewComponentList;
    @SerializedName("template")
    public String eTemplate;
}
