package com.didi.soda.search.component.panel;

import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.rpc.entity.SearchShopsTagEntity;
import com.didi.soda.search.repo.SearchHotWordsModel;
import com.didi.soda.search.storage.HistoryTag;
import java.util.List;

public interface Contract {

    public static abstract class AbsSearchEntrancePanelPresenter extends ICustomerPresenter<AbsSearchEntrancePanelView> {
        public abstract void onDeleteHistoryClicked();

        public abstract void onHistoryTagsShow(int i, List<String> list);

        public abstract void onRecommendTagsShow(int i, List<SearchHotWordsModel> list);

        public abstract void onSearchHistoryTagClicked(String str, int i);

        public abstract void onSearchHotWordsClicked(SearchHotWordsModel searchHotWordsModel);

        public abstract void onSearchRecommendTagClicked(String str, int i);

        public abstract void onSearchShopTagClicked(String str, String str2, int i);

        public abstract void updateSearchHistory(HistoryTag historyTag);
    }

    public static abstract class AbsSearchEntrancePanelView extends ICustomerView<AbsSearchEntrancePanelPresenter> {
        public abstract void doFirstInAnimation();

        public abstract void setHistoryTags(List<String> list);

        public abstract void setPanelLayoutVisibility(int i);

        public abstract void setRecommendTags(List<SearchHotWordsModel> list);

        public abstract void setRecommendTagsRow(int i);

        public abstract void setShopTags(List<SearchShopsTagEntity> list);
    }
}
