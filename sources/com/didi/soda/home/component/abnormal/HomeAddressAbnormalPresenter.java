package com.didi.soda.home.component.abnormal;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.helper.CustomerLocationSettingHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class HomeAddressAbnormalPresenter extends IPresenter<HomeAddressAbnormalView> {
    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).subscribeAddressAbnormalMessage(getScopeContext(), new Action1<Boolean>() {
            public void call(Boolean bool) {
                if (bool == null || !bool.booleanValue()) {
                    ((HomeAddressAbnormalView) HomeAddressAbnormalPresenter.this.getLogicView()).hideAbnormal();
                } else {
                    ((HomeAddressAbnormalView) HomeAddressAbnormalPresenter.this.getLogicView()).showAbnormal(HomeAddressAbnormalPresenter.this.m29992a());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        CustomerLocationSettingHelper.Companion.getInstance().updateWindowShownStatus(getContext(), 4, new Function2() {
            public final Object invoke(Object obj, Object obj2) {
                return HomeAddressAbnormalPresenter.this.m29991a((Boolean) obj, (Boolean) obj2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ Unit m29991a(Boolean bool, Boolean bool2) {
        if (bool.booleanValue()) {
            ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).locateThenRefreshHome(6);
            return null;
        } else if (!((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).isShowAddressAbnormal()) {
            return null;
        } else {
            ((HomeAddressAbnormalView) getLogicView()).showAbnormal(m29992a());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m29992a() {
        if (getScopeContext().getObject(Const.BundleKey.NO_ADDRESS_FROM_SERVICE) != null) {
            return ((Boolean) getScopeContext().getObject(Const.BundleKey.NO_ADDRESS_FROM_SERVICE)).booleanValue();
        }
        return false;
    }
}
