package com.didi.component.comp_new_xpanel.view;

import android.app.Activity;
import com.didi.component.comp_new_xpanel.AbsNewXPanelView;
import com.didiglobal.xpanelnew.base.XpConfig;
import com.didiglobal.xpanelnew.sdk.XpanelNew;

public class NewXpanelTripView extends AbsNewXPanelView {
    public NewXpanelTripView(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public void initXPanelView(Activity activity, XpConfig.Builder builder) {
        this.mXPanel = new XpanelNew(activity, builder.setDefaultDpSecondCardShowHeight(70.0f).build());
    }
}
