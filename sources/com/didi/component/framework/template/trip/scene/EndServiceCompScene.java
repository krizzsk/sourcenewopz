package com.didi.component.framework.template.trip.scene;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IViewContainer;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class EndServiceCompScene extends AbsCompScene {
    public EndServiceCompScene(Context context, IViewContainer.IComponentCreator iComponentCreator) {
        super(context, iComponentCreator);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        inflateViewlessComponent("service", (Bundle) null);
        inflateViewlessComponent("map_flow", (Bundle) null);
        m9758a(this.mContext, relativeLayout);
        m9759b(this.mContext, relativeLayout);
        m9760c(this.mContext, relativeLayout);
    }

    /* renamed from: a */
    private void m9758a(Context context, ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = UIUtils.dip2pxInt(context, 8.0f);
        layoutParams.rightMargin = UIUtils.dip2pxInt(context, 8.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.RESET_LOCATION, viewGroup, layoutParams);
    }

    /* renamed from: b */
    private void m9759b(Context context, ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.common_padding);
        layoutParams.setMargins(dimension, 0, UIUtils.dip2pxInt(this.mContext, 65.0f), dimension);
        layoutParams.addRule(9);
        inflateComponent(ComponentType.SAFE_JARVIS, viewGroup, layoutParams);
    }

    /* renamed from: c */
    private void m9760c(Context context, ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, AppUtils.getStatusBarHeight(this.mContext), 0, 0);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.SAVING_CENTER, viewGroup, layoutParams);
    }
}
