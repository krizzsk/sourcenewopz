package com.didi.soda.home.component.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeEntity;
import com.didi.soda.customer.repo.CustomerResource;
import com.didi.soda.home.component.titlebar.HomeTitleBarManager;
import com.didi.soda.home.component.web.Contract;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerHomeManager;

public class WebHomePresenter extends Contract.AbsRecPresenter {

    /* renamed from: a */
    private boolean f42624a;

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).subscribeHomeData(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                WebHomePresenter.this.m30102a((CustomerResource) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30102a(CustomerResource customerResource) {
        if (customerResource.status == Resource.Status.ERROR) {
            Bundle bundle = customerResource.mExtension;
            String str = null;
            if (bundle != null) {
                str = bundle.getString("url");
            }
            if (customerResource.code > 0 && !TextUtils.isEmpty(str)) {
                if (customerResource.data == null || ((HomeEntity) customerResource.data).getMNativePageInfo() == null) {
                    m30104a(true);
                    m30103a(str);
                    return;
                }
                return;
            }
        }
        m30104a(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m30104a(boolean z) {
        if (this.f42624a != z) {
            this.f42624a = z;
            ((Contract.AbsWebRecView) getLogicView()).setWebVisible(z);
            if (this.f42624a) {
                HomeTitleBarManager.getManager().showTitleBar();
            } else {
                HomeTitleBarManager.getManager().hideTitleBar();
            }
        }
    }

    /* renamed from: a */
    private void m30103a(String str) {
        ((Contract.AbsWebRecView) getLogicView()).loadUrl(str);
    }
}
