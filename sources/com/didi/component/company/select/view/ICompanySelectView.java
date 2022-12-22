package com.didi.component.company.select.view;

import com.didi.component.company.model.CompanyInfo;
import java.util.List;

public interface ICompanySelectView {
    void hideLoading();

    void showCompanys(List<CompanyInfo> list, String str);

    void showDefault(boolean z);

    void showLoading();
}
