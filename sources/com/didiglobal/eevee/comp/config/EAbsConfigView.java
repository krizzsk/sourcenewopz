package com.didiglobal.eevee.comp.config;

import android.content.Context;
import android.view.View;

public abstract class EAbsConfigView implements EIConfigView {
    protected EAbsConfigPresenter mConfigPresenter;
    protected Context mContext;
    protected View mRootView;

    public EAbsConfigView(Context context) {
        this.mContext = context;
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(EAbsConfigPresenter eAbsConfigPresenter) {
        this.mConfigPresenter = eAbsConfigPresenter;
    }
}
