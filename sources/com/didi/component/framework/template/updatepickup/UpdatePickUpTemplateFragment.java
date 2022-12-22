package com.didi.component.framework.template.updatepickup;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.base.ComponentType;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.mapflow.MapFlowComponent;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class UpdatePickUpTemplateFragment extends CommonTemplateFragment {
    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1035;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_confirm_new;
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        Bundle bundle = new Bundle();
        bundle.putInt(MapFlowComponent.SUG_PAGE_CONTAINER_ID, R.id.rl_global_common_sug_container);
        inflateViewlessComponent("map_flow", bundle);
        inflateViewlessComponents("service");
        inflateComponent(ComponentType.RESET_LOCATION, relativeLayout, new RelativeLayout.LayoutParams(-2, -2));
        inflateComponent(ComponentType.XPANEL, relativeLayout, new RelativeLayout.LayoutParams(-1, -2));
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.global_title_btn_back && this.mTopPresenter != null) {
            ((CommonTemplatePresenter) this.mTopPresenter).onBackViewClicked();
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        ViewGroup.LayoutParams layoutParams = this.mTitleBackBtn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
            this.mTitleBackBtn.setLayoutParams(layoutParams);
        }
    }
}
