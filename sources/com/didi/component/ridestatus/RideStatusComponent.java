package com.didi.component.ridestatus;

import android.view.ViewGroup;
import com.didi.component.business.xpanel.sdk.component.SelfControlComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.ridestatus.view.OptimizeRideStatusView;

@ComponentRegister(product = "ride", type = "ride_status")
public class RideStatusComponent extends SelfControlComponent<IRideStatusView, AbsRideStatusPresenter<? extends IRideStatusView>, RideStatusController> {
    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        super.init(componentParams, viewGroup);
    }

    /* access modifiers changed from: protected */
    public AbsRideStatusPresenter<? extends IRideStatusView> onCreatePresenter(ComponentParams componentParams) {
        if (componentParams.pageID == 1045) {
            return new LockScreenRideStatusPresenter(componentParams);
        }
        return new OnServiceRideStatusPresenter(componentParams);
    }

    /* access modifiers changed from: protected */
    public IRideStatusView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        if (componentParams.pageID == 1045) {
            return new OptimizeRideStatusView(componentParams.bizCtx.getContext());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public RideStatusController createInflateController() {
        return new RideStatusController();
    }
}
