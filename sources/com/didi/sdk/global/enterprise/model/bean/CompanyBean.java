package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@Deprecated
public class CompanyBean implements Serializable {
    @SerializedName("comments")
    public CommentBean comments;
    @SerializedName("comments_required")
    public boolean commentsRequired;
    public CompanyDefaultBean companyDefault;
    @SerializedName("cost_center_required")
    public boolean costCenterRequired;
    @SerializedName("company_id")

    /* renamed from: id */
    public String f36156id;
    @SerializedName("name")
    public String name;
    @SerializedName("project_required")
    public boolean projectRequired;

    public class CompanyDefaultBean implements Serializable {
        @SerializedName("cost_center")
        public CostCenterBean costCenter;
        @SerializedName("project")
        public ProjectBean project;

        public CompanyDefaultBean() {
        }
    }
}
