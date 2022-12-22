package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class SearchWordsEntity implements IEntity {
    private static final long serialVersionUID = 1774483992379032565L;
    public String sessionID;
    public int sessionIter;
    public String title;
    public List<SearchWordItem> words;

    public static class SearchWordItem implements IEntity {
        private static final long serialVersionUID = 1239009751459881813L;
        public String queryRecStr;
        public String word;
    }
}
