package com.didi.android.comp_xbanner;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;

public abstract class AbsGlobalXBannerPresenter extends IPresenter<IGlobalXBannerView> {
    protected ComponentParams mComponentParams;

    public AbsGlobalXBannerPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.mComponentParams = componentParams;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }
}
