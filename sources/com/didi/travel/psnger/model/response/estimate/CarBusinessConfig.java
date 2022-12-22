package com.didi.travel.psnger.model.response.estimate;

import com.google.gson.annotations.SerializedName;

public class CarBusinessConfig {
    @SerializedName("comments_max_size")
    public int commentsMaxSize;
    @SerializedName("comments_min_size")
    public int commentsMinSize;
    @SerializedName("comments_required")
    public boolean commentsRequired;
    @SerializedName("company_pay_title")
    public String companyPayTitle;
    @SerializedName("cost_center_required")
    public boolean costCenterRequired;
    @SerializedName("default_company_id")
    public String defaultCompanyId;
    @SerializedName("default_company_name")
    public String defaultCompanyName;
    @SerializedName("default_cost_center_id")
    public String defaultCostCenterId;
    @SerializedName("default_cost_center_name")
    public String defaultCostCenterName;
    @SerializedName("default_project_id")
    public String defaultProjectId;
    @SerializedName("default_project_name")
    public String defaultProjectName;
    @SerializedName("member_id")
    public String memberId;
    @SerializedName("project_required")
    public boolean projectRequired;
}
