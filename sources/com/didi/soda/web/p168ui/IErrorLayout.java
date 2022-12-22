package com.didi.soda.web.p168ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didi.soda.web.widgets.WebPageTitleBar;

/* renamed from: com.didi.soda.web.ui.IErrorLayout */
public interface IErrorLayout {
    boolean backNeedHideIt();

    void inflateErrorLayout(Context context, ViewGroup viewGroup);

    void onHideEvent(boolean z, WebPageTitleBar webPageTitleBar, View view);

    void showCustomerErrorView(int i, boolean z, WebPageTitleBar webPageTitleBar, View view);
}
