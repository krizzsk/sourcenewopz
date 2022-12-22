package com.didi.safetoolkit.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SfBaseObject implements ISfBaseObject, Serializable, Cloneable {
    @SerializedName(alternate = {"error"}, value = "errmsg")
    public String errmsg = "";
    @SerializedName(alternate = {"errcode"}, value = "errno")
    public int errno = -800;

    public boolean isAvailable() {
        return this.errno == 0;
    }
}
