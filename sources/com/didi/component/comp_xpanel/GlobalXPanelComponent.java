package com.didi.component.comp_xpanel;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.comp_xpanel.presenter.GlobalXPanelConfirmPresenter;
import com.didi.component.comp_xpanel.presenter.GlobalXPanelHomePresenter;
import com.didi.component.comp_xpanel.view.GlobalConfirmXPanelView;
import com.didi.component.comp_xpanel.view.GlobalHomeXPanelView;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "xpanel")
public class GlobalXPanelComponent extends BaseComponent<AbsGlobalXPanelView, AbsGlobalXPanelPresenter> {
    private AbsGlobalXPanelPresenter mCurrentPresenter;

    /* access modifiers changed from: protected */
    public void bind(ComponentParams componentParams, AbsGlobalXPanelView absGlobalXPanelView, AbsGlobalXPanelPresenter absGlobalXPanelPresenter) {
        super.bind(componentParams, absGlobalXPanelView, absGlobalXPanelPresenter);
        if (absGlobalXPanelView != null) {
            absGlobalXPanelPresenter.bind(componentParams.bizCtx.getContext(), absGlobalXPanelView.getXPanel());
        }
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXPanelView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        int i = componentParams.pageID;
        if (i == 1001) {
            return new GlobalHomeXPanelView(componentParams.bizCtx.getContext());
        }
        if (i != 1035) {
            return null;
        }
        return new GlobalConfirmXPanelView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXPanelPresenter onCreatePresenter(ComponentParams componentParams) {
        this.mCurrentPresenter = null;
        int i = componentParams.pageID;
        if (i == 1001) {
            this.mCurrentPresenter = new GlobalXPanelHomePresenter(componentParams);
        } else if (i == 1035) {
            this.mCurrentPresenter = new GlobalXPanelConfirmPresenter(componentParams);
        }
        return this.mCurrentPresenter;
    }

    public boolean isXpanelEyeable() {
        AbsGlobalXPanelPresenter absGlobalXPanelPresenter = (AbsGlobalXPanelPresenter) getPresenter();
        this.mCurrentPresenter = absGlobalXPanelPresenter;
        if (absGlobalXPanelPresenter == null || absGlobalXPanelPresenter.getComponentView() == null) {
            return false;
        }
        return this.mCurrentPresenter.hasCardInXpanel();
    }
}
