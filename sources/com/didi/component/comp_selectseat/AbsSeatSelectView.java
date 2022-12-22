package com.didi.component.comp_selectseat;

import android.content.Context;
import android.view.View;

public abstract class AbsSeatSelectView implements ISeatSelectView {
    protected Context mContext;
    protected AbsSeatSelectPresenter mPresenter;
    protected View mRootView;

    public AbsSeatSelectView(Context context) {
        this.mContext = context;
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsSeatSelectPresenter absSeatSelectPresenter) {
        this.mPresenter = absSeatSelectPresenter;
    }
}
