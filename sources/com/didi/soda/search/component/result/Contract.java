package com.didi.soda.search.component.result;

import com.didi.soda.customer.foundation.rpc.entity.SearchResultEntity;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.datasource.page.dynamic.DynamicRecycleView;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.search.binder.SearchAdjustableTitleListener;
import java.util.List;

public interface Contract {

    public static abstract class AbsSearchResultPresenter extends DynamicRecyclePresenter<AbsSearchResultView, SearchResultPageParam, SearchResultEntity> implements SearchAdjustableTitleListener {
        /* access modifiers changed from: package-private */
        public abstract void notifyFilterItemClick(FilterModel filterModel);

        /* access modifiers changed from: package-private */
        public abstract void onRetryClick();
    }

    public static abstract class AbsSearchResultView extends DynamicRecycleView<AbsSearchResultPresenter> {
        /* access modifiers changed from: package-private */
        public abstract void hideAbnormalView();

        /* access modifiers changed from: package-private */
        public abstract void hideFilter();

        /* access modifiers changed from: package-private */
        public abstract void hideLoading();

        /* access modifiers changed from: package-private */
        public abstract void scrollToTop();

        /* access modifiers changed from: package-private */
        public abstract void setFilterData(FilterModel filterModel, List<FilterModel> list);

        /* access modifiers changed from: package-private */
        public abstract void setSearchResultLayoutVisibility(int i);

        /* access modifiers changed from: package-private */
        public abstract void showFilter();

        /* access modifiers changed from: package-private */
        public abstract void showLoading(boolean z);

        /* access modifiers changed from: package-private */
        public abstract void showNetErrorView();

        /* access modifiers changed from: package-private */
        public abstract void showNoResultView();
    }
}
