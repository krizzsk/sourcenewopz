package com.didi.component.company;

import com.didi.component.company.model.CompanyInfo;
import com.didi.component.core.IView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;

public interface ICompanyView extends IView<AbsCompanyPresenter> {
    void bindRichInfo(GlobalRichInfo globalRichInfo);

    void clearTips();

    void setCompany(CompanyInfo companyInfo);

    void setEnable(boolean z);

    void setIcon(String str);

    void setLabel(String str);
}
