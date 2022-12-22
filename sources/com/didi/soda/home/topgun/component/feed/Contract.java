package com.didi.soda.home.topgun.component.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.soda.address.manager.AddressTipInfo;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.datasource.page.dynamic.DynamicRecycleView;
import com.didi.soda.home.bub.TaskBubModel;
import com.didi.soda.home.component.feed.HomeTypeContract;
import com.didi.soda.home.topgun.manager.HomeFeedParam;
import com.didi.soda.home.topgun.model.FilterModel;

interface Contract {

    public static abstract class AbsHomeFeedPresenter extends DynamicRecyclePresenter<AbsHomeFeedView, HomeFeedParam, HomeEntity> {
        public abstract void notifyFilterItemClick(FilterModel filterModel, boolean z);
    }

    public static abstract class AbsHomeFeedView extends DynamicRecycleView<AbsHomeFeedPresenter> {
        public abstract int calculateAbnormalViewHeight(boolean z);

        public abstract void changeHeaderStyle(boolean z);

        public abstract void dismissLoadingDialog();

        public abstract void dismissShimmer();

        public abstract void fillRecyclerViewContentHeight(boolean z);

        public abstract RecyclerView getRecycleView();

        public abstract void intoFloating();

        public abstract void resetHeaderView(boolean z);

        public abstract void scrollToFloatingState(int i, boolean z);

        public abstract void setFilterShowOrHide(boolean z);

        public abstract void showBubOrNot(TaskBubModel taskBubModel);

        public abstract void showLoadingByType(HomeTypeContract.HomeLoadingType homeLoadingType);

        public abstract void showNetErrorToast();

        public abstract void showShimmer();

        public abstract void updateAddressTip(AddressTipInfo addressTipInfo);
    }
}
