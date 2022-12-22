package com.didi.soda.order.component.evaluatedetail;

import android.widget.ImageView;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;

public interface Contract {

    public static abstract class AbsOrderEvaluateDetailPresenter extends ICustomerPresenter<AbsOrderEvaluateDetailView> {
        public abstract void closePage();

        public abstract void onImageItemClick(ImageView imageView, String str);

        public abstract void retryRequest();
    }

    public static abstract class AbsOrderEvaluateDetailView extends ICustomerView<AbsOrderEvaluateDetailPresenter> {
        public abstract void hideAbnormalView();

        public abstract void initEvaluationView(OrderEvaluationEntity orderEvaluationEntity);

        public abstract void showErrorNetView(String str);
    }
}
