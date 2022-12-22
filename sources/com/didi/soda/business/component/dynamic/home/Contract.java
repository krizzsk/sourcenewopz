package com.didi.soda.business.component.dynamic.home;

import android.os.Bundle;
import android.view.View;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.business.component.contract.dynamic.DynamicRecyclePresenter;
import com.didi.soda.business.component.contract.dynamic.DynamicRecycleView;
import com.didi.soda.business.listener.BusinessSelectedCallback;
import com.didi.soda.business.listener.BusinessViewBehaviorImpl;
import com.didi.soda.business.listener.GoodsItemClickListener;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.business.model.BusinessHeaderRvModel;
import com.didi.soda.business.widget.BusinessDyHomeHeaderView;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalViewModel;
import java.util.HashMap;
import java.util.Map;

public interface Contract {

    public static abstract class AbsBusinessPresenter extends DynamicRecyclePresenter<AbsBusinessView> implements GoodsItemClickListener, BusinessDyHomeHeaderView.OnBusinessTabItemListener, OnBackListener {
        public abstract int getCategoryRvIndex(int i);

        public abstract void goBusinessDetail();

        public abstract void goBusinessSearch();

        public abstract boolean hasDynamicNotice();

        public abstract boolean isDataLoadSuccess();

        public /* synthetic */ void onBack(int i) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, i);
        }

        public /* synthetic */ void onBack(Bundle bundle) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bundle);
        }

        public /* synthetic */ void onBack(Boolean bool) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bool);
        }

        public abstract void onBusinessFavor(boolean z);

        public abstract void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel);

        public abstract void onExpandOrFoldAction(BusinessExpandRvModel businessExpandRvModel, int i);

        public abstract void onExpandShow(BusinessExpandRvModel businessExpandRvModel);

        public abstract void onFavorLogin();

        public abstract void onGoodsItemExposure(BusinessGoodsItemRvModel businessGoodsItemRvModel);

        public abstract void onRvScrolled(int i);

        public abstract void onTabScrolled(int i);

        public abstract void showMoreCategory(BusinessSelectedCallback businessSelectedCallback);

        public abstract void updateAnchorData(BusinessGoodsItemRvModel businessGoodsItemRvModel);
    }

    public static abstract class AbsBusinessView extends DynamicRecycleView<AbsBusinessPresenter> implements BusinessViewBehaviorImpl, BusinessDyHomeHeaderView.OnBusinessTabItemListener, BusinessDyHomeHeaderView.OnHeaderClickListener, OnBackListener {
        public abstract void anchorView(int i, int i2, BusinessGoodsItemRvModel businessGoodsItemRvModel);

        public abstract void favorBusiness();

        public abstract void hideAbnormalView();

        public abstract void hideShimmerView();

        public /* synthetic */ void onBack(int i) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, i);
        }

        public /* synthetic */ void onBack(Bundle bundle) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bundle);
        }

        public /* synthetic */ void onBack(Boolean bool) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bool);
        }

        public abstract void playAdd2CartAnim();

        public abstract void setCurrentVirView(View view, String str);

        public abstract void showAbnormalView(TopGunAbnormalViewModel topGunAbnormalViewModel);

        public abstract void showBusinessHeader(boolean z);

        public abstract void showDeliveryFeeDescRule(HashMap<String, Object> hashMap, View view);

        public abstract void showShimmerView();

        public abstract void updateCategoryAmount(Map<String, BusinessCategoryRvModel> map);

        public abstract void updateHeaderView(BusinessHeaderRvModel businessHeaderRvModel, IBlockScope iBlockScope);
    }
}
