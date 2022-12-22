package com.didi.soda.search.component.header;

import android.os.Bundle;
import android.view.View;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.listener.OnBackListener;
import com.didi.soda.home.component.feed.listener.HomeSortClickListener;

public interface Contract {

    public static abstract class AbsSearchHeaderPresenter extends ICustomerPresenter<AbsSearchHeaderView> implements OnBackListener {
        public abstract HomeSortClickListener.Type getCurrentSortType();

        public abstract void handleBack();

        public /* synthetic */ void onBack(int i) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, i);
        }

        public /* synthetic */ void onBack(Bundle bundle) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bundle);
        }

        public /* synthetic */ void onBack(Boolean bool) {
            OnBackListener.CC.$default$onBack((OnBackListener) this, bool);
        }

        public abstract void onSearchClicked(String str);

        public abstract void onSearchEditViewClick();

        public abstract void onSearchSuggestion(String str);

        public abstract void onSearchTagClear();

        public abstract void refreshSuggestion();
    }

    public static abstract class AbsSearchHeaderView extends ICustomerView<AbsSearchHeaderPresenter> {
        public abstract View getLoadingView();

        public abstract void goneAllSearchRightView();

        public abstract void hideSoftInput();

        public abstract void resetIsFirstInputShow();

        public abstract void setFilterIvVisibility(int i);

        public abstract void setResultViewVisible(int i);

        public abstract void setSearchHint(String str);

        public abstract void setSearchTag(String str);

        public abstract void setSortViewVisible(int i);

        public abstract void showOrHideSuggestionLoading(boolean z);

        public abstract void showSoftInput();
    }
}
