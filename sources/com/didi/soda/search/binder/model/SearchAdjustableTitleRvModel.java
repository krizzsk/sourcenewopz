package com.didi.soda.search.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class SearchAdjustableTitleRvModel implements RecyclerModel {
    public String title;
    public String type;

    public SearchAdjustableTitleRvModel(String str, String str2) {
        this.title = str;
        this.type = str2;
    }
}
