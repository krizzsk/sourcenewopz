package com.didi.soda.business.component.detail;

import com.didi.soda.business.model.BusinessDetailModel;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;

public interface Contract {

    public static abstract class AbsBusinessDetailPresenter extends ICustomerPresenter<AbsBusinessDetailView> {
        public abstract void onBuyAgentClick();

        public abstract void onCouponReduceShow();

        public abstract void onPageClose();

        public abstract void openBusinessDisclaimerPage(String str);

        public abstract void openBusinessPositionMapPage();

        public abstract void openCouponExclusivePage(RuleDescEntity ruleDescEntity);
    }

    public static abstract class AbsBusinessDetailView extends ICustomerView<AbsBusinessDetailPresenter> {
        public abstract void updateBusinessDetail(BusinessDetailModel businessDetailModel);
    }
}
