package com.didi.soda.goods.component.purchase;

import android.os.Bundle;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.listener.OnLoadingListener;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import com.didi.soda.customer.widget.goods.GoodsQuantityListener;
import com.didi.soda.goods.component.AbsCommonGoodsPresenter;
import com.didi.soda.goods.component.AbsCommonGoodsView;
import com.didi.soda.goods.contract.GoodsAmountModel;
import com.didi.soda.goods.contract.GoodsSubItemStateChangeListener;

public interface Contract {

    public static abstract class AbsGoodsPurchasePresenter extends AbsCommonGoodsPresenter<AbsGoodsPurchaseView> implements OnBackListener, GoodsQuantityListener, GoodsAmountModel.GoodsAmountListener, GoodsSubItemStateChangeListener {
        public /* synthetic */ void onBack(int i) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, i);
        }

        public /* synthetic */ void onBack(Bundle bundle) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bundle);
        }

        public /* synthetic */ void onBack(Boolean bool) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bool);
        }
    }

    public static abstract class AbsGoodsPurchaseView extends AbsCommonGoodsView<AbsGoodsPurchasePresenter> implements OnLoadingListener, GoodsAmountModel.GoodsAmountListener {
        public abstract void hideAbnormalView();

        public abstract void hideBottomButton();

        public abstract void hideGoodsContent();

        public abstract void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel);

        public abstract void showBottomButton();

        public abstract void showGoodsContent();

        public abstract void updateHeadImage(boolean z);
    }
}
