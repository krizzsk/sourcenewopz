package com.didi.soda.search.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;

public class PaddingRvModel implements RecyclerModel {
    public int mPadding;

    public PaddingRvModel() {
    }

    public PaddingRvModel(int i) {
        this.mPadding = i;
    }
}
