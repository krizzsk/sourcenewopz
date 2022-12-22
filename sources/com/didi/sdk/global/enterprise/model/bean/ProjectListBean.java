package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@Deprecated
public class ProjectListBean implements Serializable {
    @SerializedName("project_list")
    public List<ProjectBean> projectList;
}
