package com.didiglobal.common.common.mew.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EMewCompExt implements Serializable {
    @SerializedName("log_data")
    public JsonObject jsonObjectLogData;
}
