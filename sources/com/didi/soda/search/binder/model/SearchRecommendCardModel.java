package com.didi.soda.search.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.SearchWordsEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import java.util.ArrayList;
import java.util.List;

public final class SearchRecommendCardModel extends ModuleModel implements RecyclerModel {
    public String mCardTitle;
    public List<SearchWordsEntity.SearchWordItem> mCardWordList;
    public String mComponentType;
    public String mSessionId;
    public int mSessionIter;

    public static SearchRecommendCardModel convertSearchRecommendEntity(SearchWordsEntity searchWordsEntity) {
        SearchRecommendCardModel searchRecommendCardModel = new SearchRecommendCardModel();
        searchRecommendCardModel.mCardTitle = searchWordsEntity.title;
        searchRecommendCardModel.mCardWordList = new ArrayList();
        if (!CollectionsUtil.isEmpty(searchWordsEntity.words)) {
            for (SearchWordsEntity.SearchWordItem next : searchWordsEntity.words) {
                SearchWordsEntity.SearchWordItem searchWordItem = new SearchWordsEntity.SearchWordItem();
                searchWordItem.word = next.word;
                searchWordItem.queryRecStr = next.queryRecStr;
                searchRecommendCardModel.mCardWordList.add(searchWordItem);
            }
        }
        searchRecommendCardModel.mSessionId = searchWordsEntity.sessionID;
        searchRecommendCardModel.mSessionIter = searchWordsEntity.sessionIter;
        return searchRecommendCardModel;
    }
}
