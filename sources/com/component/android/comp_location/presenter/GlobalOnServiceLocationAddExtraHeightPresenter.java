package com.component.android.comp_location.presenter;

import com.didi.component.business.event.OpenRideVisibilityEvent;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;

public class GlobalOnServiceLocationAddExtraHeightPresenter extends GlobalOnServiceLocationPresenter {
    /* access modifiers changed from: protected */
    public int getExtraHeightToShowBestView() {
        return 0;
    }

    public GlobalOnServiceLocationAddExtraHeightPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public boolean needAddExtraHeightToShowBestView() {
        GLog.m7965d("GlobalOnServiceLocationAddExtraHeightPresenter", "最佳view添加safeTookit高度" + this.mSafeToolkitHeight);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onOpenRideVisibilityChanged(OpenRideVisibilityEvent openRideVisibilityEvent) {
        super.onOpenRideVisibilityChanged(new OpenRideVisibilityEvent(0, false));
    }
}
