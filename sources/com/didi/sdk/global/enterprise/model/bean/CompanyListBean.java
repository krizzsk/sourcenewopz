package com.didi.sdk.global.enterprise.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@Deprecated
public class CompanyListBean implements Serializable {
    @SerializedName("company_list")
    public List<CompanyBean> companyList;
}
