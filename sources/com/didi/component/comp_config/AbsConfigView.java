package com.didi.component.comp_config;

import android.content.Context;
import android.view.View;

public abstract class AbsConfigView implements IConfigView {
    protected Context mContext;
    protected View mRootView;
    protected AbsConfigPresenter mXPanelPresenter;

    public AbsConfigView(Context context) {
        this.mContext = context;
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsConfigPresenter absConfigPresenter) {
        this.mXPanelPresenter = absConfigPresenter;
    }
}
