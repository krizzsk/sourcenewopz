package com.didi.sdk.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.INavigationListener;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.omega.sdk.init.OmegaSDK;

public abstract class BizEntranceFragment extends AbsLoadingFragment implements IComponent<BusinessContext>, INavigationListener {
    private static Logger log = LoggerFactory.getLogger("BizEntranceFragment");
    private BusinessContext mBusinessContext;
    private boolean mHasCreated;
    private boolean visible = false;

    public View getFallbackView() {
        return null;
    }

    public void onEntranceVisible(boolean z) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void preLeaveHome() {
    }

    public BusinessContext getBusinessContext() {
        return this.mBusinessContext;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.mBusinessContext = businessContext;
    }

    public void onCreate(Bundle bundle) {
        log.info("onCreate()\t%s", getClass().getCanonicalName());
        super.onCreate(bundle);
        this.mHasCreated = true;
    }

    public void onStart() {
        log.info("onStart()\t%s", getClass().getCanonicalName());
        super.onStart();
    }

    public void onResume() {
        log.info("onResume()\t%s", getClass().getCanonicalName());
        super.onResume();
        OmegaSDK.fireFragmentResumed(this);
    }

    public void onPause() {
        log.info("onPause()\t%s", getClass().getCanonicalName());
        super.onPause();
        OmegaSDK.fireFragmentPaused(this);
    }

    public void onStop() {
        log.info("onStop()\t%s", getClass().getCanonicalName());
        super.onStop();
    }

    public void onDestroy() {
        log.info("onDestroy()\t%s", getClass().getCanonicalName());
        super.onDestroy();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.mHasCreated) {
            boolean z2 = this.visible;
            if (z) {
                this.visible = true;
                onShow();
                return;
            }
            this.visible = false;
            if (z2) {
                onHide();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onShow() {
        log.info("onShow()\t%s", getClass().getCanonicalName());
        BusinessContext businessContext = this.mBusinessContext;
        if (businessContext != null) {
            businessContext.setActive(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onHide() {
        log.info("onHide()\t%s", getClass().getCanonicalName());
        BusinessContext businessContext = this.mBusinessContext;
        if (businessContext != null) {
            businessContext.setActive(false);
        }
    }

    public void onBackToHome() {
        log.info("onBackToHome()\t%s", getClass().getCanonicalName());
    }

    public void onLeaveHome() {
        log.info("onLeaveHome()\t%s", getClass().getCanonicalName());
    }
}
