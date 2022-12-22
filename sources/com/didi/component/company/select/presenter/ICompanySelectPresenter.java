package com.didi.component.company.select.presenter;

import android.os.Bundle;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.view.ICompanySelectView;

public interface ICompanySelectPresenter {
    void onAdd(Bundle bundle);

    void onCompanySelected(CompanyInfo companyInfo);

    void onRemove();

    void setView(ICompanySelectView iCompanySelectView);
}
