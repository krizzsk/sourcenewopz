package com.didi.soda.datasource.parser;

import java.io.Serializable;

public class FeedPayload implements Serializable {
    private static final long serialVersionUID = 9134653656423065438L;
    public String mCateId = "";
    public int mComponentIndex = 0;
    public String mFromPage = "";
    public int mIntentionType = 0;
    public String mPageFilter = "";
    public String mPageId = "";
    public int mPageIndex = 0;
    public String mRecId = "";
    public String mSearchWord = "";
    public int mSource = 0;
    public String mTraceId = "";
}
