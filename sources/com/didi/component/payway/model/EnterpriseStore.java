package com.didi.component.payway.model;

import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.sdk.global.enterprise.bridger.IEnterpriseBridge;
import com.didi.sdk.global.enterprise.model.bean.CommentBean;
import com.didi.sdk.global.enterprise.model.bean.CompanyBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectBean;
import com.didi.sdk.global.enterprise.model.data.EnterpriseInfo;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.model.response.PayEnterpriseSelectModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IEnterpriseBridge.class})
public class EnterpriseStore implements IEnterpriseBridge {
    public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
        PayEnterpriseInfo payEnterpriseInfo = new PayEnterpriseInfo();
        payEnterpriseInfo.setMemberId(enterpriseInfo.getMemberId());
        CompanyBean company = enterpriseInfo.getCompany();
        CostCenterBean costCenter = enterpriseInfo.getCostCenter();
        ProjectBean project = enterpriseInfo.getProject();
        CommentBean comment = enterpriseInfo.getComment();
        PayEnterpriseSelectModel.PayEnterpriseSelectItem payEnterpriseSelectItem = new PayEnterpriseSelectModel.PayEnterpriseSelectItem(company.f36156id, company.name, 0);
        payEnterpriseSelectItem.setRequiredCostCenter(costCenter.isRequired);
        payEnterpriseSelectItem.setRequiredProject(project.isRequired);
        payEnterpriseSelectItem.setRequiredComment(comment.required);
        payEnterpriseSelectItem.setMinSizeComment(comment.minSize);
        payEnterpriseSelectItem.setMaxSizeComment(comment.maxSize);
        payEnterpriseInfo.setCompanyItem(payEnterpriseSelectItem);
        payEnterpriseInfo.setCostCenterItem(new PayEnterpriseSelectModel.PayEnterpriseSelectItem(costCenter.f36157id, costCenter.name, 1));
        payEnterpriseInfo.setProjectItem(new PayEnterpriseSelectModel.PayEnterpriseSelectItem(project.f36158id, project.name, 2));
        payEnterpriseInfo.setComment(comment.comment);
        payEnterpriseInfo.setMinSizeComment(comment.minSize);
        payEnterpriseInfo.setMaxSizeComment(comment.maxSize);
        FormStore.getInstance().setData(FormStore.KEY_PAY_ENTERPRISE, payEnterpriseInfo);
    }

    public EnterpriseInfo getEnterpriseInfo() {
        PayEnterpriseInfo payEnterpriseInfo = (PayEnterpriseInfo) FormStore.getInstance().getDataSilence(FormStore.KEY_PAY_ENTERPRISE);
        if (payEnterpriseInfo == null) {
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener == null || !confirmListener.getIsAnyCar()) {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (estimateItem != null) {
                    payEnterpriseInfo = estimateItem.payEnterpriseInfo;
                }
            } else {
                AnyCarPayModel anycarPayModel = confirmListener.getAnycarPayModel();
                if (anycarPayModel != null) {
                    payEnterpriseInfo = anycarPayModel.payEnterpriseInfo;
                }
            }
        }
        if (payEnterpriseInfo == null) {
            return null;
        }
        CompanyBean companyBean = new CompanyBean();
        PayEnterpriseSelectModel.PayEnterpriseSelectItem companyItem = payEnterpriseInfo.getCompanyItem();
        if (companyItem != null) {
            companyBean.f36156id = companyItem.getId();
            companyBean.name = companyItem.getContent();
        }
        CostCenterBean costCenterBean = new CostCenterBean();
        if (payEnterpriseInfo.getCostCenterItem() != null) {
            costCenterBean.f36157id = payEnterpriseInfo.getCostCenterItem().getId();
            costCenterBean.name = payEnterpriseInfo.getCostCenterItem().getContent();
            costCenterBean.isRequired = payEnterpriseInfo.isRequiredCostCenter();
        }
        ProjectBean projectBean = new ProjectBean();
        if (payEnterpriseInfo.getProjectItem() != null) {
            projectBean.f36158id = payEnterpriseInfo.getProjectItem().getId();
            projectBean.name = payEnterpriseInfo.getProjectItem().getContent();
            projectBean.isRequired = payEnterpriseInfo.isRequiredProject();
        }
        CommentBean commentBean = new CommentBean();
        commentBean.comment = payEnterpriseInfo.getComment();
        commentBean.minSize = payEnterpriseInfo.getMinSizeComment();
        commentBean.maxSize = payEnterpriseInfo.getMaxSizeComment();
        commentBean.required = payEnterpriseInfo.isRequiredComment();
        EnterpriseInfo enterpriseInfo = new EnterpriseInfo();
        enterpriseInfo.setCarLevel(String.valueOf(FormStore.getInstance().getCarLevel()));
        enterpriseInfo.setMemberId(payEnterpriseInfo.getMemberId());
        enterpriseInfo.setCompany(companyBean);
        enterpriseInfo.setCostCenter(costCenterBean);
        enterpriseInfo.setProject(projectBean);
        enterpriseInfo.setComment(commentBean);
        if (NationComponentDataUtil.isLoginNow()) {
            enterpriseInfo.setPhone(NationComponentDataUtil.getPhoneCountryCode() + NationComponentDataUtil.getPhone());
        } else {
            enterpriseInfo.setPhone(CountryManager.getIns().getCurrentCountryCode() + LoginStore.getInstance().getPhone());
        }
        return enterpriseInfo;
    }
}
