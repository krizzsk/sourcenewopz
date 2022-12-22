package com.didi.global.xbanner.basemodel;

import android.content.Context;
import android.view.View;
import com.didi.global.xbanner.basemodel.XBCardViewData;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;

public interface XBCardView<T extends XBCardViewData> {
    View createView(Context context, T t, int i);

    void setReloadListener(XbCardReloadListener xbCardReloadListener);
}
