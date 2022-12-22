package com.didi.entrega.home.component.abnormal;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocalPermissionHelper;
import com.didi.entrega.home.manager.AddressAbnormalRepo;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;

public class HomeAddressAbnormalPresenter extends IPresenter<HomeAddressAbnormalView> {
    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        AddressAbnormalRepo.Companion.getRepo().subscribe(getScopeContext(), new Action1<Boolean>() {
            public void call(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    ((HomeAddressAbnormalView) HomeAddressAbnormalPresenter.this.getLogicView()).mo61647b();
                    return;
                }
                if (!LocalPermissionHelper.hasLocationPermission()) {
                    HomeOtherOmegaHelper.trackExceptionSW(3);
                } else if (CustomerSystemUtil.isGpsEnabled(HomeAddressAbnormalPresenter.this.getContext())) {
                    HomeOtherOmegaHelper.trackExceptionSW(4);
                }
                ((HomeAddressAbnormalView) HomeAddressAbnormalPresenter.this.getLogicView()).mo61646a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Boolean bool = (Boolean) AddressAbnormalRepo.Companion.getRepo().getValue();
        if (bool == null) {
            bool = false;
        }
        if (bool.booleanValue()) {
            ((HomeAddressAbnormalView) getLogicView()).mo61646a();
        }
    }
}
