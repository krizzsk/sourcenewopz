package com.didi.soda.home.topgun.component.filter;

import android.view.View;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.home.topgun.model.FilterModel;
import java.util.List;

public interface Contract {

    public static abstract class AbsHomeFilterPresent extends ICustomerPresenter<AbsHomeFilterView> {
        public abstract void confirmFilter(boolean z);

        public abstract void filterModelChanged(FilterModel filterModel);

        public abstract List<FilterModel> getFilterModelListForItem();
    }

    public static abstract class AbsHomeFilterView extends ICustomerView<AbsHomeFilterPresent> {
        public abstract void closeCurrentFilterPanel();

        public abstract void fillHeaderView(View view, int i);

        public abstract void hideFilterView(View view, int i);

        public abstract void showFilterDialog(FilterModel filterModel);

        public abstract void showOrHideShimmer(boolean z);

        public abstract void updateFilterPanelBackground(List<FilterModel> list);
    }
}
