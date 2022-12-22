package com.didi.component.comp_xpanel.view;

import android.content.Context;
import com.didi.component.common.animator.GlobalXPanelAnimatorImpl;
import com.didi.component.common.animator.GlobalXPanelAnimatorWithAlphaImpl;
import com.didi.component.common.cache.CacheApolloUtils;
import com.didi.component.comp_xpanel.AbsGlobalXPanelView;
import com.didichuxing.xpanel.channel.global.GlobalXPanel;
import com.didichuxing.xpanel.channel.global.GlobalXPanelView;

public class GlobalConfirmXPanelView extends AbsGlobalXPanelView {
    public GlobalConfirmXPanelView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void initXPanelView(Context context, GlobalXPanelView.XPanelConfig xPanelConfig) {
        xPanelConfig.max_show_height = 1.0f;
        xPanelConfig.move_show_bg_length = 1.0f;
        xPanelConfig.enable_divider = false;
        xPanelConfig.support_scroll = false;
        xPanelConfig.enable_min_height = false;
        this.mXPanel = new GlobalXPanel(context, xPanelConfig);
        this.mXPanel.disableXPanelDownBtn();
        this.mPanelAnimator.initPrepare(this.mXPanel.getView());
    }

    public void switchXPanelAnimation(boolean z) {
        if (!CacheApolloUtils.openWaitRspOptimization()) {
            return;
        }
        if (z) {
            this.mPanelAnimator = new GlobalXPanelAnimatorWithAlphaImpl();
        } else {
            this.mPanelAnimator = new GlobalXPanelAnimatorImpl();
        }
    }

    public long getAnimateDuration() {
        if (CacheApolloUtils.openWaitRspOptimization()) {
            return 720;
        }
        return super.getAnimateDuration();
    }
}
