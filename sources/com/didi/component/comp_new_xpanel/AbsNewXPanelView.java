package com.didi.component.comp_new_xpanel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.didi.component.core.IViewContainer;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.sdk.XpanelNew;

public abstract class AbsNewXPanelView implements INewXPanelView {
    protected Context mContext;
    protected XpanelNew mXPanel;
    protected AbsNewXPanelPresenter mXPanelPresenter;

    /* access modifiers changed from: protected */
    public abstract void initXPanelView(Activity activity, XpConfig.Builder builder);

    public AbsNewXPanelView(Activity activity) {
        this.mContext = activity;
        initXPanelView(activity, new XpConfig.Builder());
    }

    public View getView() {
        return this.mXPanel.getView();
    }

    public void setPresenter(AbsNewXPanelPresenter absNewXPanelPresenter) {
        this.mXPanelPresenter = absNewXPanelPresenter;
    }

    public XpanelNew getXPanel() {
        return this.mXPanel;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mXPanelPresenter.setComponentCreator(iComponentCreator);
    }
}
