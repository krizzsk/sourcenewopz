package com.didi.soda.customer.binder.business;

import com.didi.soda.customer.base.binder.CustomerMvpItemUnit;
import com.didi.soda.customer.base.binder.EmptyItemLogic;
import com.didi.soda.customer.binder.business.BusinessItemView;
import com.didi.soda.customer.binder.model.business.BusinessInfoRvModel;

public class BusinessItemUnit extends CustomerMvpItemUnit<BusinessItemView, BusinessItemPresenter, BusinessInfoRvModel, BusinessItemView.ViewHolder, EmptyItemLogic> {
    /* access modifiers changed from: protected */
    public BusinessItemPresenter onCreatePresenter() {
        return new BusinessItemPresenter();
    }

    /* access modifiers changed from: protected */
    public BusinessItemView onCreateView() {
        return new BusinessItemView();
    }
}
