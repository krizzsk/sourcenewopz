package com.didi.soda.search.repo;

import com.didi.app.nova.skeleton.repo.Repo;

public class SearchWordRepo extends Repo<SearchWordModel> {
    public boolean mIsResultViewVisible;

    public SearchWordModel getValue() {
        SearchWordModel searchWordModel = (SearchWordModel) super.getValue();
        return searchWordModel == null ? new SearchWordModel("") : searchWordModel;
    }
}
