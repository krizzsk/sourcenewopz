package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class ProjectBean implements Serializable {
    @SerializedName("project_id")

    /* renamed from: id */
    public String f36158id;
    public boolean isRequired;
    @SerializedName("name")
    public String name;
}
