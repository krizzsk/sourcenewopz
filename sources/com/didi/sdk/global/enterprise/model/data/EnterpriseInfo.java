package com.didi.sdk.global.enterprise.model.data;

import android.text.TextUtils;
import com.didi.sdk.global.enterprise.model.bean.CommentBean;
import com.didi.sdk.global.enterprise.model.bean.CompanyBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectBean;
import java.io.Serializable;

@Deprecated
public class EnterpriseInfo implements Serializable {
    private String carLevel;
    private CommentBean comment = new CommentBean();
    private CompanyBean company = new CompanyBean();
    private CostCenterBean costCenter = new CostCenterBean();
    private String memberId;
    private String phone;
    private ProjectBean project = new ProjectBean();

    public boolean isSigned() {
        CompanyBean companyBean = this.company;
        if (companyBean == null || TextUtils.isEmpty(companyBean.f36156id)) {
            return false;
        }
        ProjectBean projectBean = this.project;
        if (projectBean != null && projectBean.isRequired && TextUtils.isEmpty(this.project.f36158id)) {
            return false;
        }
        CostCenterBean costCenterBean = this.costCenter;
        if (costCenterBean != null && costCenterBean.isRequired && TextUtils.isEmpty(this.costCenter.f36157id)) {
            return false;
        }
        CommentBean commentBean = this.comment;
        if (commentBean == null || !commentBean.required) {
            return true;
        }
        if (TextUtils.isEmpty(this.comment.comment) || this.comment.comment.length() < this.comment.minSize) {
            return false;
        }
        return true;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getCarLevel() {
        return this.carLevel;
    }

    public void setCarLevel(String str) {
        this.carLevel = str;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public CompanyBean getCompany() {
        return this.company;
    }

    public void setCompany(CompanyBean companyBean) {
        this.company = companyBean;
    }

    public CostCenterBean getCostCenter() {
        return this.costCenter;
    }

    public void setCostCenter(CostCenterBean costCenterBean) {
        this.costCenter = costCenterBean;
    }

    public ProjectBean getProject() {
        return this.project;
    }

    public void setProject(ProjectBean projectBean) {
        this.project = projectBean;
    }

    public CommentBean getComment() {
        return this.comment;
    }

    public void setComment(CommentBean commentBean) {
        this.comment = commentBean;
    }
}
