package com.didi.addressnew.framework;

import android.os.Bundle;
import com.didi.addressnew.framework.switcher.ISwitcher;
import com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl;
import com.didi.map.sdk.env.Page;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class SugMainFullScreenActivity extends SugMainBaseActivity {
    /* access modifiers changed from: protected */
    public int getActLayoutId() {
        return R.layout.sug_main_full_screen_layout;
    }

    public void setPageDragEnable(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (PaxEnvironment.getInstance().getPage() != Page.SETTING_PAGE) {
            PaxEnvironment.getInstance().setPage(Page.SETTING_PAGE);
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.mSugPageContainer.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        ISwitcher instance = SwitcherImpl.getInstance();
        if (instance != null && instance.onBackPressed()) {
            instance.closeSessionImediately();
            onCloseSugPage();
        }
    }
}
