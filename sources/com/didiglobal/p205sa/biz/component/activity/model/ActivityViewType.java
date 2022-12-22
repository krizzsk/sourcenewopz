package com.didiglobal.p205sa.biz.component.activity.model;

import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.model.ActivityViewType */
public enum ActivityViewType {
    ongoing_title("sa_activity_ongoing_title_card", 1, R.layout.activity_ongoing_title),
    ongoing_card("sa_activity_ongoing_card", 2, R.layout.activity_ongoing_card),
    ongoing_empty_card("sa_activity_ongoing_empty_card", 7, R.layout.activity_ongoing_empty_card),
    ongoing_more_card("sa_activity_ongoing_viewmore_card", 6, R.layout.activity_ongoing_viewmore_card),
    recently_title("sa_activity_recently_title_card", 3, R.layout.activity_recently_title),
    recently_card("sa_activity_recently_card", 4, R.layout.activity_recently_card),
    recently_card_last("sa_activity_recently_card", 5, R.layout.activity_recently_card_last);
    
    int resId;
    String typeId;
    int viewType;

    private ActivityViewType(String str, int i, int i2) {
        this.typeId = str;
        this.viewType = i;
        this.resId = i2;
    }

    public String getTypeId() {
        return this.typeId;
    }

    public void setTypeId(String str) {
        this.typeId = str;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(int i) {
        this.resId = i;
    }
}
