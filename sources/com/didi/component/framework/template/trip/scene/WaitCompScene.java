package com.didi.component.framework.template.trip.scene;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IViewContainer;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class WaitCompScene extends AbsCompScene {
    public WaitCompScene(Context context, IViewContainer.IComponentCreator iComponentCreator) {
        super(context, iComponentCreator);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        inflateViewlessComponent("service", (Bundle) null);
        inflateViewlessComponent("map_flow", (Bundle) null);
        m9761a(this.mContext, relativeLayout);
        m9762b(this.mContext, relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.common_padding);
        layoutParams.setMargins(dimension, dimension, UIUtils.dip2pxInt(this.mContext, 65.0f), dimension);
        layoutParams.addRule(9);
        inflateComponent(ComponentType.SAFE_JARVIS, relativeLayout, layoutParams);
    }

    /* renamed from: a */
    private void m9761a(Context context, ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = UIUtils.dip2pxInt(context, 8.0f);
        layoutParams.rightMargin = UIUtils.dip2pxInt(context, 8.0f);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, UiUtils.dip2px(context, -5.0f), UiUtils.dip2px(context, -10.0f));
        inflateComponent(ComponentType.RESET_LOCATION, viewGroup, layoutParams);
    }

    /* renamed from: b */
    private void m9762b(Context context, ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, AppUtils.getStatusBarHeight(this.mContext), 0, 0);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.SAVING_CENTER, viewGroup, layoutParams);
    }
}
