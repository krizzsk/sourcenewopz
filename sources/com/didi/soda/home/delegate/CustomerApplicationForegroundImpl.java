package com.didi.soda.home.delegate;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.common.map.model.LatLng;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.NetDetectHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class CustomerApplicationForegroundImpl implements ApplicationForegroundListener {

    /* renamed from: d */
    private static final String f42631d = "CustomerApplicationForegroundImpl";

    /* renamed from: a */
    ScopeContext f42632a;

    /* renamed from: b */
    double f42633b;

    /* renamed from: c */
    double f42634c;

    public CustomerApplicationForegroundImpl(ScopeContext scopeContext) {
        this.f42632a = scopeContext;
    }

    public void onBecomeBackground(long j, long j2) {
        ConversionOmegaHelper.trackWithPageName(EventConst.Conversion.ENTER_BACKGROUND, ConversionOmegaHelper.getChannel(), false);
        OmegaTracker.Builder.create("sailing_c_x_system_enterBackground").build().track();
        NetDetectHelper.stop();
        this.f42633b = LocationUtil.getCurrentLng();
        this.f42634c = LocationUtil.getCurrentLat();
    }

    public void onBecomeForeground(long j, long j2) {
        ConversionOmegaHelper.trackWithPageName(EventConst.Conversion.ENTER_FOREGROUND, ConversionOmegaHelper.getChannel(), false);
        OmegaTracker.Builder.create("sailing_c_x_system_becomeActive").build().track();
        NetDetectHelper.resume();
        m30109a(j, j2);
    }

    /* renamed from: a */
    private void m30109a(long j, long j2) {
        boolean z = true;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        boolean z2 = i > 0 && j - j2 > ((long) (CustomerApolloUtil.getBackGorundRefreshLongTime() * 60));
        if (i <= 0 || j - j2 <= ((long) (CustomerApolloUtil.getBackGorundRefreshShortTime() * 60))) {
            z = false;
        }
        LogUtil.m29104i(f42631d, "isOverLongMin" + z2 + "/isOverShortMin" + z);
        if (z2) {
            m30108a();
        } else if (z) {
            LocationUtil.getCurrentLocationOnce(new LocationUtil.LocationCallback() {
                public void onLocationError() {
                    LogUtil.m29104i(CustomerApplicationForegroundImpl.f42631d, "onLocationError");
                }

                public void onLocationSuccess(LatLng latLng) {
                    if (latLng.latitude == CustomerApplicationForegroundImpl.this.f42634c && latLng.longitude == CustomerApplicationForegroundImpl.this.f42633b) {
                        LogUtil.m29104i(CustomerApplicationForegroundImpl.f42631d, "3min 位置相同");
                    } else if (!AddressUtil.checkAddressValid(((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress())) {
                        LogUtil.m29104i(CustomerApplicationForegroundImpl.f42631d, "3min 当前位置为空");
                    } else {
                        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).updateAddressTip(CustomerApplicationForegroundImpl.this.f42632a, CustomerApplicationForegroundImpl.this.f42634c, CustomerApplicationForegroundImpl.this.f42633b);
                    }
                }
            }, CustomerApolloUtil.getBackGpsTimeout());
        }
    }

    /* renamed from: a */
    private void m30108a() {
        if (this.f42632a != null) {
            LogUtil.m29104i(f42631d, "mScopeContext popToRoot");
            this.f42632a.getNavigator().popToRoot();
            GlobalContext.getPageInstrument().getDialogInstrument().dismissAll();
        }
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(4);
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshTab();
    }
}
