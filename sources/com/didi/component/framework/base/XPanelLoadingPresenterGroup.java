package com.didi.component.framework.base;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.common.loading.AbsLoadingPresenterGroup;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.global.loading.ILoadingable;

public class XPanelLoadingPresenterGroup<V extends IGroupView> extends AbsLoadingPresenterGroup<V> {
    public XPanelLoadingPresenterGroup(Context context, Bundle bundle) {
        super(context, bundle);
    }

    public XPanelLoadingPresenterGroup(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        m9489b();
        super.onAdd(bundle);
    }

    /* renamed from: b */
    private void m9489b() {
        XPanelLoadingWrapperImpl xPanelLoadingWrapperImpl = new XPanelLoadingWrapperImpl();
        if (this.mView instanceof XPanelLoadingNormalFragment) {
            xPanelLoadingWrapperImpl.setLoadingForwardBy((ILoadingable) this.mView);
        }
        attachLoadingWrapper(xPanelLoadingWrapperImpl);
    }
}
