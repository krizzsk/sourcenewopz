package com.didi.component.framework.template.trip.scene;

import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IViewContainer;
import com.didi.component.mapflow.MapFlowComponent;
import com.taxis99.R;

public class OnServiceCompScene extends AbsCompScene {
    public OnServiceCompScene(Context context, IViewContainer.IComponentCreator iComponentCreator) {
        super(context, iComponentCreator);
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapFlowComponent.SUG_PAGE_CONTAINER_ID, R.id.rl_global_common_sug_container);
        inflateViewlessComponent("map_flow", bundle);
        inflateViewlessComponent("service", (Bundle) null);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.common_padding);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, dimension, dimension);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, UiUtils.dip2px(this.mContext, -5.0f), UiUtils.dip2px(this.mContext, -10.0f));
        inflateComponent(ComponentType.RESET_LOCATION, relativeLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, dimension, dimension);
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        inflateComponent(ComponentType.NON_TALKING, relativeLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.setMargins(dimension, dimension, UIUtils.dip2pxInt(this.mContext, 65.0f), dimension);
        layoutParams3.addRule(9);
        inflateComponent(ComponentType.SAFE_JARVIS, relativeLayout, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(11);
        layoutParams4.setMargins(0, UIUtils.dip2pxInt(this.mContext, 42.0f), UIUtils.dip2pxInt(this.mContext, 10.0f), 0);
        inflateComponent(ComponentType.FLOAT_BAR, relativeLayout, layoutParams4);
    }
}
