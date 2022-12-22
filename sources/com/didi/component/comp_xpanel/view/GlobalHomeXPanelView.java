package com.didi.component.comp_xpanel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.comp_xpanel.AbsGlobalXPanelView;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didichuxing.xpanel.channel.global.GlobalXPanel;
import com.didichuxing.xpanel.channel.global.GlobalXPanelView;
import com.taxis99.R;

public class GlobalHomeXPanelView extends AbsGlobalXPanelView {
    public GlobalHomeXPanelView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void initXPanelView(Context context, GlobalXPanelView.XPanelConfig xPanelConfig) {
        xPanelConfig.max_show_height = 0.5f;
        xPanelConfig.enable_min_height = true;
        xPanelConfig.support_scroll = false;
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(R.layout.oc_x_panel_view);
        if (viewByResId == null) {
            viewByResId = LayoutInflater.from(context).inflate(R.layout.oc_x_panel_view, (ViewGroup) null);
        }
        this.mXPanel = new GlobalXPanel(context, xPanelConfig, viewByResId);
        this.mXPanel.disableXPanelDownBtn();
        this.mPanelAnimator.initPrepare(this.mXPanel.getView());
    }

    public View getView() {
        View view = this.mXPanel.getView();
        view.setTag(GlobalHomeXPanelView.class.getName());
        return view;
    }
}
