package com.didi.android.comp_xbanner;

import android.view.ViewGroup;
import com.didi.android.comp_xbanner.view.GlobalHomeXBannerView;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "global_xbanner")
public class GlobalXBannerComponent extends BaseComponent<IGlobalXBannerView, AbsGlobalXBannerPresenter> {
    private AbsGlobalXBannerPresenter mCurrentPresenter;

    /* access modifiers changed from: protected */
    public IGlobalXBannerView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.pageID != 1001) {
            return null;
        }
        return new GlobalHomeXBannerView(componentParams.getActivity());
    }

    /* access modifiers changed from: protected */
    public AbsGlobalXBannerPresenter onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID == 1001) {
            this.mCurrentPresenter = new HomeGlobalXBannerPresenter(componentParams);
        }
        return this.mCurrentPresenter;
    }
}
