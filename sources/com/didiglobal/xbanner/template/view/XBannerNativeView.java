package com.didiglobal.xbanner.template.view;

import com.didi.global.xbanner.basemodel.XBCardView;
import com.didiglobal.xbanner.template.mdel.XBannerNativeModel;

public interface XBannerNativeView extends XBCardView<XBannerNativeModel> {
    XBannerNativeModel getNativeModel();
}
