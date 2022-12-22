package com.didi.entrega.customer.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.service.IToolsService;

public class CustomerSimpleTitleRvModel implements RecyclerModel {
    public IToolsService.FontType mFontType;
    public int mIconId;
    public int mPaddingBottomDp = -1;
    public int mPosition;
    public String mTitle;
    public int mTitleSizeDp;

    public CustomerSimpleTitleRvModel(String str) {
        this.mTitle = str;
    }

    public CustomerSimpleTitleRvModel(String str, int i) {
        this.mTitle = str;
        this.mIconId = i;
    }
}
