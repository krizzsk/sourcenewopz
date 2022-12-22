package com.didi.soda.search.repo;

import com.didi.soda.home.component.feed.listener.HomeSortClickListener;

public class SearchWordModel {
    public int mIndex = 0;
    public String mQueryCkJson;
    public String mRecommendRecId = null;
    public SearchFrom mSearchFrom = SearchFrom.EDIT;
    public String mSearchTag;
    public String mSessionID;
    public int mSessionIter;
    public HomeSortClickListener.Type mSortType;
    public String mSugCkJson;
    public String mSugId;
    public String mTraceId;
    public int type = 1;
    public String url;

    public enum SearchFrom {
        EDIT,
        HISTORY,
        RECOMMEND,
        SUGGESTION,
        HOT_WORD
    }

    public SearchWordModel(String str) {
        this.mSearchTag = str;
        this.mSortType = HomeSortClickListener.Type.RECOMMEND;
    }

    public SearchWordModel(String str, HomeSortClickListener.Type type2) {
        this.mSearchTag = str;
        this.mSortType = type2;
    }

    public String toString() {
        return "SearchWordModel{mSearchTag='" + this.mSearchTag + '\'' + ", mSortType=" + this.mSortType + ", mSearchFrom=" + this.mSearchFrom + ", mIndex=" + this.mIndex + ", mRecommendRecId='" + this.mRecommendRecId + '\'' + '}';
    }
}
