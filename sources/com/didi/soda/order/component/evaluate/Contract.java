package com.didi.soda.order.component.evaluate;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import java.util.List;

public interface Contract {

    public static abstract class AbsOrderEvaluatingPresenter extends ICustomerPresenter<AbsOrderEvaluatingView> implements UploadImagePresenter {
        public abstract void closePage(boolean z, OrderEvaluationResultEntity orderEvaluationResultEntity);

        public abstract void retryRequest();

        public abstract void saveEvaluationInfo(ShopEvaluationEntity shopEvaluationEntity, RiderEvaluationEntity riderEvaluationEntity, List<OrderEvaluationItemsListEntity> list, int i);
    }

    public static abstract class AbsOrderEvaluatingView extends ICustomerView<AbsOrderEvaluatingPresenter> implements UploadImageLayout {
        public abstract List<OrderEvaluationItemsListEntity> getGoodsEvaluationEntity();

        public abstract RiderEvaluationEntity getRiderEvaluationEntity();

        public abstract ShopEvaluationEntity getShopEvaluationEntity();

        public abstract void hideAbnormalView();

        public abstract void initEvaluationView(int i, OrderEvaluationEntity orderEvaluationEntity);

        public abstract boolean isEditEvaluation();

        public abstract void showErrorNetView(String str);

        public abstract void submitError();

        public abstract void submitSuccess(OrderEvaluationResultEntity orderEvaluationResultEntity);
    }

    public interface UploadImageLayout {
        void addUploadImageView(String str, String str2);
    }

    public interface UploadImagePresenter {
        void onUploadAddBtnClk();
    }
}
