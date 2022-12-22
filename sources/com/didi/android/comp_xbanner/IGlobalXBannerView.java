package com.didi.android.comp_xbanner;

import com.didi.component.core.IView;
import com.didi.global.xbanner.view.base.XBannerView;

public interface IGlobalXBannerView extends IView<AbsGlobalXBannerPresenter> {
    XBannerView getXBannerView();

    void setTranslationY(int i);
}
