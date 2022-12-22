package com.didi.soda.customer.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.service.IToolsService;

public class CustomerSimpleTitleRvModel implements RecyclerModel {
    public IToolsService.FontType mFontType;
    public int mIconId;
    public int mPaddingTopDp = -1;
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

    public CustomerSimpleTitleRvModel(String str, String str2, String str3, String str4) {
        this.mTitle = str;
        this.mTitleSizeDp = Integer.parseInt(str2);
        this.mPaddingTopDp = Integer.parseInt(str4);
        this.mFontType = (IToolsService.FontType) Enum.valueOf(IToolsService.FontType.class, str3);
    }
}
