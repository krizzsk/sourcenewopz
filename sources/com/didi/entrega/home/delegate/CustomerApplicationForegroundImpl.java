package com.didi.entrega.home.delegate;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.ApplicationForegroundListener;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.NetDetectHelper;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;

public class CustomerApplicationForegroundImpl implements ApplicationForegroundListener {

    /* renamed from: d */
    private static final String f20700d = "CustomerApplicationForegroundImpl";

    /* renamed from: a */
    ScopeContext f20701a;

    /* renamed from: b */
    double f20702b;

    /* renamed from: c */
    double f20703c;

    public CustomerApplicationForegroundImpl(ScopeContext scopeContext) {
        this.f20701a = scopeContext;
    }

    public void onBecomeBackground(long j, long j2) {
        OmegaTracker.Builder.create("sailing_c_x_system_enterBackground").build().track();
        NetDetectHelper.stop();
        this.f20702b = LocationUtil.getCurrentLng();
        this.f20703c = LocationUtil.getCurrentLat();
    }

    public void onBecomeForeground(long j, long j2) {
        OmegaTracker.Builder.create("sailing_c_x_system_becomeActive").build().track();
        NetDetectHelper.resume();
        m15144a(j, j2);
    }

    /* renamed from: a */
    private void m15144a(long j, long j2) {
        boolean z = true;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        boolean z2 = i > 0 && j - j2 > ((long) (CustomerApolloUtil.getBackGorundRefreshLongTime() * 60));
        if (i <= 0 || j - j2 <= ((long) (CustomerApolloUtil.getBackGorundRefreshShortTime() * 60))) {
            z = false;
        }
        LogUtil.m14765i(f20700d, "isOverLongMin" + z2 + "/isOverShortMin" + z);
        if (z2) {
            m15143a();
        }
    }

    /* renamed from: a */
    private void m15143a() {
        if (this.f20701a != null) {
            LogUtil.m14765i(f20700d, "mScopeContext popToRoot");
            this.f20701a.getNavigator().popToRoot();
            GlobalContext.getPageInstrument().getDialogInstrument().dismissAll();
        }
    }
}
